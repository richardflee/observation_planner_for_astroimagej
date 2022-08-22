package com.github.richardflee.astroimagej.tab_viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.style.markers.SeriesMarkers;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.richardflee.astroimagej.catalogs.SimbadCatalog;
import com.github.richardflee.astroimagej.data_objects.BaseFieldObject;
import com.github.richardflee.astroimagej.data_objects.CatalogQuery;
import com.github.richardflee.astroimagej.data_objects.ObservationSite;
import com.github.richardflee.astroimagej.data_objects.SimbadResult;
import com.github.richardflee.astroimagej.data_objects.SolarTimes;
import com.github.richardflee.astroimagej.enums.CatalogsEnum;
import com.github.richardflee.astroimagej.exceptions.SimbadNotFoundException;
import com.github.richardflee.astroimagej.fileio.AijPropsReadWriter;
import com.github.richardflee.astroimagej.fileio.TargetPropertiesFile;
import com.github.richardflee.astroimagej.listeners.CatalogDataListener;
import com.github.richardflee.astroimagej.utils.AstroCoords;
import com.github.richardflee.astroimagej.utils.InputsVerifier;
import com.github.richardflee.astroimagej.visibility_plotter.ObjectTracker;
import com.github.richardflee.astroimagej.visibility_plotter.Solar;
import com.github.richardflee.astroimagej.visibility_plotter.TimesConverter;

public class TargetTab implements CatalogDataListener {
	
	private final static String ALTITUDE_SERIES = "Altitude";
	private final static DateTimeFormatter X_TICK_FORMATTER = DateTimeFormatter.ofPattern("HH");
	private final static int HINT_Y = 30;
	private final static int GREY = 225;
	private final static Color BGND_GREY = new Color(GREY, GREY, GREY);
	
	private Solar solar = null;

	private JTextField objectIdText;
	private JTextField raText;
	private JTextField decText;
	private JTextField fovText;
	private JTextField magLimitText;

	private JComboBox<String> catalogCombo;
	private JComboBox<String> filterCombo;
	private String selectedCatalog;
	
	private DatePicker datePicker = null; 

	private JButton save;
	private JButton runQuey;

	private ViewerUi viewer = null;
	private VerifyTextFields verifier = null;
	private ObjectTracker tracker = null;
	private XChartPanel<XYChart> chartPanel = null;

	public TargetTab(ViewerUi viewer, ObservationSite site) {

		this.viewer = viewer;
		
		
		this.tracker = new ObjectTracker(site);
		this.solar = new Solar(site);		
		setSolarTimes(solar.getCivilSunTimes(LocalDate.now()));
		
		var chart = configureXyChart(site);
		this.chartPanel = new XChartPanel<>(chart);
		viewer.getAltitudePlotPanel().add(chartPanel, BorderLayout.CENTER);
		
		this.verifier = new VerifyTextFields();

		// setup ref to query controls
		initialiseTextRefs(viewer);
		initialiseCatalogComboRefs(viewer);
		this.filterCombo = viewer.getFilterCombo();
		
		// populate target tab textbox and drop down controls
		setQueryData(TargetPropertiesFile.readProerties());
		populateFilterCombo(null);
		
		// restricts text date entry to day/month/year pickers
		configureDatePicker();		

		// buttons
		this.save = viewer.getSaveQueryButton();
		this.runQuey = viewer.getRunSimbadButton();

		setupActionListeners();
	}



	private void initialiseCatalogComboRefs(ViewerUi viewer) {
		this.catalogCombo = viewer.getCatalogCombo();
		this.catalogCombo.addItem(CatalogsEnum.APASS.toString());
		this.catalogCombo.addItem(CatalogsEnum.VSP.toString());
		this.selectedCatalog = CatalogsEnum.APASS.toString();
		this.catalogCombo.setSelectedItem(this.selectedCatalog);
	}



	private void initialiseTextRefs(ViewerUi viewer) {
		this.objectIdText = viewer.getObjectIdField();
		this.raText = viewer.getRaField();
		this.decText = viewer.getDecField();
		this.fovText = viewer.getFovField();
		this.magLimitText = viewer.getMagLimitField();
	}
	
	
	
	private void configureDatePicker() {
		var dps = new DatePickerSettings();
		dps.setAllowKeyboardEditing(false);
		
		this.datePicker = new DatePicker(dps);
		this.datePicker.setDate(LocalDate.now());
		
		viewer.getDatePickerPanel().add(this.datePicker);		
	}
	
	
	private XYChart configureXyChart(ObservationSite site) {
		var chart = new XYChartBuilder().title("pending..")
			.xAxisTitle("Local Site Time (hr)")
			.yAxisTitle("Altitude (deg)")
			.build();
	
		var styler = chart.getStyler();
		styler.setYAxisMin(0.0);
		styler.setYAxisMax(90.0);
		styler.setLegendVisible(false);
		styler.setYAxisTickMarkSpacingHint(HINT_Y);
		styler.setCursorEnabled(false);		
		styler.setChartBackgroundColor(BGND_GREY);
		
		var xData = IntStream.range(0, TimesConverter.MINS_IN_DAY).boxed().collect(Collectors.toList());
		var startDate = LocalDate.now();
		var fo = (BaseFieldObject) TargetPropertiesFile.readProerties();
		var yData = new ObjectTracker(site).computeAltitudeData(fo, startDate);	
		chart.addSeries(ALTITUDE_SERIES, xData, yData).setMarker(SeriesMarkers.NONE);
		chart.setTitle(getChartTitle(startDate));
		
		styler.setxAxisTickLabelsFormattingFunction(
			x -> TimesConverter.LOCAL_TIME_NOON.plusMinutes(x.longValue()).format(X_TICK_FORMATTER));
		
		return chart;		
	}
	

	private void setupActionListeners() {

		objectIdText.addActionListener(e -> verifier.verifyObjectId());
		raText.addActionListener(e -> verifier.verifyRaHms());
		decText.addActionListener(e -> verifier.verifyDecDms());

		fovText.addActionListener(e -> verifier.verifyFov());
		magLimitText.addActionListener(e -> verifier.verifyMagLimit());

		// handles change in selected catalog (VSP, APASS ..)
		catalogCombo.addItemListener(ie -> selectCatalog(ie));
		
		// user selects new date
		this.datePicker.addDateChangeListener(e -> {
			LocalDate startDate = e.getNewDate();
			if (startDate == null) {
				startDate = LocalDate.now();
				this.datePicker.setDate(startDate);
			}
			doChartUpdate(startDate);				
		});

		// save query data
		save.addActionListener(e -> {
			if (verifier.verifyAllTextInputs()) {
				doSaveQueryData();
				JOptionPane.showMessageDialog(null, AijPropsReadWriter.savedFileMessage());
			}
		});

		// run simbad query
		runQuey.addActionListener(e -> {
			System.out.println(verifier.verifyAllTextInputs());
			if (verifier.verifyAllTextInputs()) {
				var message = this.runSimbadQuery();				
				doSaveQueryData();
				JOptionPane.showMessageDialog(null, message);
			}
		});
		
//		// !! temp dss button
//		this.viewer.getDssButton().addActionListener(e -> {
//			if (this.viewer.getSaveDssCheckBox().isSelected() == true) {
//				var query = compileQuery();
//				var message = DssFitsWriter.downloadDssFits(query);
//				JOptionPane.showMessageDialog(null, message);
//			}
//		});
		
	}
	
	private void doSaveQueryData() {
		TargetPropertiesFile.writeProperties(this.compileQuery());
		doChartUpdate(datePicker.getDate());
	}
	
	
	private void doChartUpdate(LocalDate startDate) {
		var fo = (BaseFieldObject) compileQuery();
		updateChart(fo, startDate);				
		
		var solarTimes = solar.getCivilSunTimes(startDate);
		setSolarTimes(solarTimes);			
	}
	
	private void updateChart(BaseFieldObject fo, LocalDate startDate) {
		
		//var startDateTime = LocalDateTime.of(startDate,  TimesConverter.LOCAL_TIME_NOON);
		var yData = tracker.computeAltitudeData(fo, startDate);
		var xData = IntStream.range(0, yData.size()).boxed().collect(Collectors.toList());
		
		this.chartPanel.getChart().updateXYSeries(ALTITUDE_SERIES, xData, yData, null);
		this.chartPanel.revalidate();
		this.chartPanel.repaint();			
		this.chartPanel.getChart().setTitle(getChartTitle(startDate));
	}
	
	private String getChartTitle(LocalDate startDate) {
		return String.format("StarAlt Plot - Starting night: %s",
				DateTimeFormatter.ISO_LOCAL_DATE.format(startDate));
	}
	
	private String runSimbadQuery() {
		var query = this.compileQuery();
		var message = "";

		// run simbad query, raises SimbadNotFound exception if no match to user input
		// objectId
		SimbadResult simbadResult = null;
		try {
			simbadResult = new SimbadCatalog().runQuery(query);
			new SimbadPanelData(viewer).setSimbadData(simbadResult);
			
			message = String.format("Updated SIMBAD Data fields for ObjecId: %s\n", query.getObjectId());
			message += AijPropsReadWriter.savedFileMessage();
		} catch (SimbadNotFoundException se) {
			simbadResult = null;
			message = String.format("ObjectId field: %s\n not found in SIMBAD database", query.getObjectId());
		}				
		return message;
		
	}

	@Override
	public void setQueryData(CatalogQuery query) {
		this.objectIdText.setText(query.getObjectId());
		this.raText.setText(AstroCoords.raHrToRaHms(query.getRaHr()));
		this.decText.setText(AstroCoords.decDegToDecDms(query.getDecDeg()));

		this.fovText.setText(String.format("%.1f", query.getFovAmin()));
		this.magLimitText.setText(String.format("%.1f", query.getMagLimit()));

		// selected catalog
		CatalogsEnum en = query.getCatalogType();
		this.selectedCatalog = en.toString().toUpperCase();
		catalogCombo.setSelectedItem(selectedCatalog);

		// populate filterCombo
		populateFilterCombo(query.getMagBand());

	}

	public CatalogQuery compileQuery() {
		// copy text field data
		CatalogQuery query = new CatalogQuery();

		query.setObjectId(this.objectIdText.getText());
		query.setRaHr(AstroCoords.raHmsToRaHr(this.raText.getText()));
		query.setDecDeg(AstroCoords.decDmsToDecDeg(this.decText.getText()));

		query.setFovAmin(Double.valueOf(this.fovText.getText()));
		query.setMagLimit(Double.valueOf(this.magLimitText.getText()));

		// copy combo data
		query.setCatalogType(CatalogsEnum.getEnum(catalogCombo.getSelectedItem().toString()));
		query.setMagBand(filterCombo.getSelectedItem().toString());

		return query;
	}
	
	@Override
	public void setSolarTimes(SolarTimes solarTimes) {
		this.viewer.getSunSetField().setText(solarTimes.getCivilSunSetValue());
		this.viewer.getTwilightEndField().setText(solarTimes.getCivilTwilightEndsValue());
		this.viewer.getTwilightStartField().setText(solarTimes.getCivilTwilightStartsValue());
		this.viewer.getSunRiseField().setText(solarTimes.getCivilSunRiseValue());		
	}

	/*
	 * Clears current and imports new filter list in the filter selection combo
	 * @param selectedCatalog uppercase name of current catalog selected in catalog
	 * combo
	 * @param selectedFilter filter name of current filter selection in filter combo
	 */
	private void populateFilterCombo(String selectedFilter) {
		// clear filters list
		filterCombo.removeAllItems();

		// retrieve catalog from enum
		CatalogsEnum en = CatalogsEnum.valueOf(this.selectedCatalog);

		// import filter list for selected catalog & select specified filter
		en.getMagBands().forEach(item -> filterCombo.addItem(item));

		if (selectedFilter == null) {
			filterCombo.setSelectedIndex(0);
		} else {
			filterCombo.setSelectedItem(selectedFilter);
		}
	}

	/*
	 * Handles change in catalogCombo selection. Clears existing filterCombo list
	 * and loads a new list based on CatalogType enum
	 * @param ie event indicates an item was selected in the catalogCombo control
	 */
	private void selectCatalog(ItemEvent ie) {
		if (ie.getStateChange() == ItemEvent.SELECTED) {
			this.selectedCatalog = catalogCombo.getSelectedItem().toString();
			populateFilterCombo(null);
		}
	}

	private class VerifyTextFields {

		/*
		 * verifies user input objectId format
		 * @param input objectId in alphanumeric format
		 */
		private boolean verifyObjectId() {
			boolean isValid = InputsVerifier.isValidObjectId(objectIdText.getText());
			if (isValid) {
				objectIdText.setForeground(Color.BLACK);
				raText.requestFocus();
			} else {
				objectIdText.setForeground(Color.RED);
				objectIdText.requestFocus();
			}
			return isValid;
		}

		/*
		 * Verifies user input RA format and in range
		 * @param input RA in sexagesimal format
		 */
		private boolean verifyRaHms() {
			boolean isValid = InputsVerifier.isValidRaCoords(raText.getText());
			if (isValid) {
				raText.setForeground(Color.BLACK);
				decText.requestFocus();
			} else {
				raText.setForeground(Color.RED);
				raText.requestFocus();
			}
			return isValid;
		}

		/*
		 * Verifies user input dec format and in range
		 * @param input RA in sexagesimal format
		 */
		private boolean verifyDecDms() {
			boolean isValid = InputsVerifier.isValidDecCoords(decText.getText());
			if (isValid) {
				decText.setForeground(Color.BLACK);
				fovText.requestFocus();
			} else {
				decText.setForeground(Color.RED);
				decText.requestFocus();
			}
			return isValid;
		}

		/*
		 * Verifies user input FOV format and in range
		 * @param input FOV in numeric format
		 */
		private boolean verifyFov() {
			boolean isValid = InputsVerifier.isValidFov(fovText.getText());
			if (isValid) {
				fovText.setForeground(Color.BLACK);
				magLimitText.requestFocus();
			} else {
				fovText.setForeground(Color.RED);
				fovText.requestFocus();
			}
			return isValid;
		}

		/*
		 * Verifies user input magLimit format and in range
		 * @param input magLimit in numeric format
		 */
		private boolean verifyMagLimit() {
			boolean isValid = InputsVerifier.isValidMagLimit(magLimitText.getText());
			if (isValid) {
				magLimitText.setForeground(Color.BLACK);
				objectIdText.requestFocus();
			} else {
				magLimitText.setForeground(Color.RED);
				magLimitText.requestFocus();
			}
			return isValid;
		}

		private boolean verifyAllTextInputs() {
			var isValid = verifyObjectId() && verifyRaHms() && verifyFov() && verifyFov() && verifyMagLimit();
			if (!isValid) {
				var message = "At least one data entry is invalid";
				JOptionPane.showMessageDialog(null, message);
			}
			return isValid;
		}
	}

	public static void main(String[] args) {

		var viewer = new ViewerUi(null, null);
		// var dataTab = new TargetDataTab(viewer);
		var simbadTab = new SimbadPanelData(viewer);

		var simbad = new SimbadCatalog();
		SimbadResult simbadResult = null;
		var query = new CatalogQuery();
		// run simbad query, raises EimbadNotFound exception if no match to user input
		// objectId
		try {
			simbadResult = simbad.runQuery(query);
		} catch (SimbadNotFoundException se) {
			simbadResult = null;
		}

		simbadTab.setSimbadData(simbadResult);

		System.out.println("Simbad result for default catalog query:");
		System.out.println(simbadResult.toString());
	}

}
