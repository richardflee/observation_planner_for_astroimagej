package com.github.richardflee.astroimagej.tab_viewer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.github.richardflee.astroimagej.catalogs.AstroCatalog;
import com.github.richardflee.astroimagej.catalogs.CatalogFactory;
import com.github.richardflee.astroimagej.data_objects.CatalogSettings;
import com.github.richardflee.astroimagej.data_objects.FieldObject;
import com.github.richardflee.astroimagej.data_objects.QueryResult;
import com.github.richardflee.astroimagej.listeners.CatalogDataListener;
import com.github.richardflee.astroimagej.listeners.CatalogTableListener;
import com.github.richardflee.astroimagej.models.CatalogTableModel;

public class CatalogsTab implements CatalogTableListener {
	
	private CatalogDataListener catalogDataListener;
	
	/*
	 * result field: object compiled from database query parameters and query response data
	 *  or imported from radec file
	 */
	private QueryResult result = null;
	
	private JTable catalogTable = null;
	private JScrollPane spane = null;
	
	private JSpinner upperLimit = null;
	private JSpinner nominal = null;
	private JSpinner lowerLimit = null;
	private JSpinner nObs = null;
	
	private JLabel upperLimitValue = null;
	private JLabel lowerLimitValue = null;
	
	private JRadioButton isSortDistance = null;
	private JRadioButton isSortDelta = null;
	
	private JCheckBox isApplyLimits = null;
	private JCheckBox isDssFits = null;
	
	private JTextField totalText = null;
	private JTextField filteredText = null;
	private JTextField selectedText = null;	
	
	private JButton query = null;
	private JButton importRaDec = null;
	private JButton saveRaDec = null;
	private JButton update = null;
	private JButton clear = null;
	
	private static int x = 100;
	
	public CatalogsTab(ViewerUi viewer, CatalogTableModel tableModel) {
		
		this.catalogTable = new JTable(tableModel);	
		this.spane = viewer.getTableScrollPane();		
		spane.setViewportView(catalogTable);
		this.catalogTable.setFillsViewportHeight(true);
		
		this.upperLimit = viewer.getUpperLimitSpinner();
		this.nominal = viewer.getTargetMagSpinner();
		this.lowerLimit = viewer.getLowerLimitSpinner();
		
		this.upperLimitValue = viewer.getUpperLabel();
		this.lowerLimitValue = viewer.getLowerLabel();		
		
		this.isSortDistance = viewer.getDistanceRadioButton();
		this.isSortDelta = viewer.getDeltaMagRadioButton();
		
		this.nObs = viewer.getNObsSpinner();
		
		this.isApplyLimits = viewer.getIsMagLimitsCheckBox();
		this.isDssFits = viewer.getSaveDssCheckBox();
		
		this.totalText = viewer.getTotalRecordsField();
		this.filteredText = viewer.getFilteredRecordsField();
		this.selectedText = viewer.getSelectedRecordsField();
		
		this.query = viewer.getCatalogQueryButton();
		this.importRaDec = viewer.getImportRaDecButton();
		this.saveRaDec = viewer.getSaveRaDecButton();
		this.update = viewer.getUpdateTableButton();
		this.clear = viewer.getClearButton();
		
		setupActionListeners();
		viewer.addWindowListener(new WindowAdapter() {
			 @Override
	         public void windowClosing(WindowEvent e) {
				 System.out.println("WindowClosingDemo.windowClosing");
	             System.exit(0);
			}
		});
	}
	
	
	
	
	@Override
	public void updateTable(List<FieldObject> fieldObjects) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Configures local catalog listener field to broadcast query & settings update messages
	 * 
	 * @param catalogDataListener reference to CatalogDataListener interface
	 */
	public void setCatalogDataListener(CatalogDataListener catalogDataListener) {
		this.catalogDataListener = catalogDataListener;
	}
	
	public void setupActionListeners() {
		
		query.addActionListener(e -> doCatalogQuery());
		importRaDec.addActionListener(e -> doSaveRaDecFile());
		saveRaDec.addActionListener(e -> doImportRaDecfile());
		update.addActionListener(e -> doUpdateTable());
		clear.addActionListener(e -> doClearTable());
		
		this.upperLimit.addChangeListener(e -> {
			var limit = (double) this.upperLimit.getValue();
			var targetMag = (double) this.nominal.getValue();
			var str = (Math.abs(limit) < 0.01) ? "N/A" : String.format("%.1f", limit + targetMag);
			this.upperLimitValue.setText(str);
		});
		
		this.lowerLimit.addChangeListener(e -> {
			var limit = (double) this.lowerLimit.getValue();
			var targetMag = (double) this.nominal.getValue();
			var str = (Math.abs(limit) < 0.01) ? "N/A" : String.format("%.1f", limit + targetMag);
			this.lowerLimitValue.setText(str);
		});
		
		
		
	}
	
	public void doCatalogQuery() {
		 System.out.println("query");
		// compile CatalogQuery object from catalog ui Query Settings data
		var query = catalogDataListener.compileQuery();
		System.out.println(query.toString());
		
		// default settings with catalog ui target mag
		// assemble catalog result with default settings & targe mag
		var targetMag = getSettingsData().getNominalMagValue();
		System.out.println(targetMag);
		
		this.result = new QueryResult(query, new CatalogSettings(targetMag));
		System.out.println(result.toString());
		
		// runs query on selected on-line catalog, retruns list of field objects
		// append this list to CatalogResut object
		AstroCatalog catalog = CatalogFactory.createCatalog(query.getCatalogType());
		List<FieldObject> fieldObjects = catalog.runQuery(query);
		
		fieldObjects.stream().forEach(p -> System.out.println(p.toString()));
		
		
	}
	
	public void doSaveRaDecFile() {
		System.out.println("import");
	}
	
	public void doImportRaDecfile() {
		System.out.println("save");
	}

	public void doUpdateTable() {
		System.out.println("update");
	}
	
	public void doClearTable() {
		System.out.println("clear");
		var settings = getSettingsData();
		System.out.println(x);
		settings.setTotalRecordsValue(x++);
		System.out.println(settings.toString());
		
	}
	
	
	/*
	 * Copies catalog ui user filter and sort selections to CatalogSettings object values 
	 * 
	 * @return compiled CatalogSettings object
	 */
	public CatalogSettings getSettingsData() {
		CatalogSettings settings = new CatalogSettings(null);
		
		// target mag
		settings.setNominalMagValue((Double) nominal.getValue());

		// mag limits
		settings.setApplyLimitsValue(isApplyLimits.isSelected());
		settings.srtUpperLimitValue(Double.valueOf(upperLimit.getValue().toString()));
		settings.setLowerLimitValue(Double.valueOf(lowerLimit.getValue().toString()));

		// sort option
		settings.setSortDistanceValue(isSortDistance.isSelected());
		settings.setSortDeltaMagValue(isSortDelta.isSelected());

		// number of observations
		settings.setnObsValue((int) nObs.getValue());
		
		// settings.setSaveDssCheckBoxValue(isDssFits.isSelected());

		return settings;
	}
	

	

}
