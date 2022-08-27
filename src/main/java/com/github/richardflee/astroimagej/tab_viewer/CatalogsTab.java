package com.github.richardflee.astroimagej.tab_viewer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.github.richardflee.astroimagej.collections.FieldObjectsCollection;
import com.github.richardflee.astroimagej.data_objects.CatalogSettings;
import com.github.richardflee.astroimagej.fileio.CatalogPropertiesFile;
import com.github.richardflee.astroimagej.listeners.CatalogTabListener;
import com.github.richardflee.astroimagej.models.TableModel;

public class CatalogsTab implements CatalogTabListener{
	
	private CatalogHandler handler = null;
	//private CatalogSettings settings = null;
	private TableModel tableModel= null; 
	
	private JTable catalogTable = null;
	private JScrollPane spane = null;
	
	private JSpinner upperLimit = null;
	private JSpinner nominal = null;
	private JSpinner lowerLimit = null;
	private JSpinner nObs = null;
	
	private JLabel upperLimitLabel = null;
	private JLabel lowerLimitLabel = null;
	
	private JRadioButton sortDistance = null;
	private JRadioButton sortDeltaMag = null;
	
	private JCheckBox applyLimits = null;
	private JCheckBox dssFits = null;
	
	private JTextField totalText = null;
	private JTextField filteredText = null;
	private JTextField selectedText = null;	
	
	private JButton runQuery = null;
	private JButton importRaDec = null;
	private JButton saveRaDec = null;
	private JButton update = null;
	private JButton clear = null;
	
	public CatalogsTab(ViewerUi viewer) {
		
		this.tableModel = new TableModel();		
		this.handler = new CatalogHandler();
		handler.setTableModelListener(tableModel);
		handler.setCatalogTabListener(this);
		
	//	this.settings = new CatalogSettings();
		
		this.catalogTable = new JTable(tableModel);	
		this.spane = viewer.getTableScrollPane();		
		spane.setViewportView(catalogTable);
		this.catalogTable.setFillsViewportHeight(true);
		
		this.upperLimit = viewer.getUpperLimitSpinner();
		this.nominal = viewer.getTargetMagSpinner();
		this.lowerLimit = viewer.getLowerLimitSpinner();
		
		this.upperLimitLabel = viewer.getUpperLabel();
		this.lowerLimitLabel = viewer.getLowerLabel();		
		
		this.sortDistance = viewer.getDistanceRadioButton();
		this.sortDeltaMag = viewer.getDeltaMagRadioButton();
		
		this.nObs = viewer.getNObsSpinner();
		
		this.applyLimits = viewer.getIsMagLimitsCheckBox();
		this.dssFits = viewer.getSaveDssCheckBox();
		
		this.totalText = viewer.getTotalRecordsField();
		this.filteredText = viewer.getFilteredRecordsField();
		this.selectedText = viewer.getSelectedRecordsField();
		
		this.runQuery = viewer.getCatalogQueryButton();
		this.importRaDec = viewer.getImportRaDecButton();
		this.saveRaDec = viewer.getSaveRaDecButton();
		this.update = viewer.getUpdateTableButton();
		this.clear = viewer.getClearButton();
		
		// import sort state from properties file
		var sortSettings = CatalogPropertiesFile.readProerties();
		this.sortDistance.setSelected(sortSettings.isSortDistanceValue());
		this.sortDeltaMag.setSelected(sortSettings.isSortDeltaMagValue());
		
		setupActionListeners();
		
	}
	
	@Override
	public void updateCounts(FieldObjectsCollection fo) {		
		this.totalText.setText(String.valueOf(fo.getTotalCount()));
		this.filteredText.setText(String.valueOf(fo.getFilteredCount()));
		this.selectedText.setText(String.valueOf(fo.getSelectedCount()));
	}
	
	/*
	 * Copies catalog ui user filter and sort selections to CatalogSettings object values 
	 * 
	 * @return compiled CatalogSettings object
	 */
	// @Override
	public CatalogSettings compileSettingsData() {
		CatalogSettings settings = new CatalogSettings();
		
		// target mag
		settings.setNominalMagValue(Double.valueOf(nominal.getValue().toString()));

		// mag limits
		settings.setApplyLimitsValue(applyLimits.isSelected());
		settings.setUpperLimitValue(Double.valueOf(upperLimit.getValue().toString()));
		settings.setLowerLimitValue(Double.valueOf(lowerLimit.getValue().toString()));

		// sort option
		settings.setSortDistanceValue(sortDistance.isSelected());
		settings.setSortDeltaMagValue(sortDeltaMag.isSelected());

		// number of observations
		settings.setnObsValue((int) nObs.getValue());
		
		// settings.setSaveDssCheckBoxValue(isDssFits.isSelected());

		return settings;
	}
	
	public CatalogSettings	compileApplyDefaultSettings() {
		var settings = compileSettingsData();
		settings.setDefaultSettings();
		updateCatalogTabUi(settings);
		enableLimits(true);
		return settings;
	}
	
	public void updateCatalogTabUi(CatalogSettings settings) {
		
		//nominal.setValue(settings.getNominalMagValue());
		
		applyLimits.setSelected(settings.isApplyLimitsValue());
		upperLimit.setValue(settings.getUpperLimitValue());
		lowerLimit.setValue(settings.getLowerLimitValue());
		
		sortDistance.setSelected(settings.isSortDistanceValue());
		sortDeltaMag.setSelected(settings.isSortDeltaMagValue());
		
		nObs.setValue(settings.getnObsValue());		
	}
	
//	private double getTargetMag() {
//		return (Double) nominal.getValue();
//	}
	
	
//	/**
//	 * Configures local catalog listener field to broadcast query & settings update messages
//	 * 
//	 * @param catalogDataListener reference to CatalogDataListener interface
//	 */
//	public void setCatalogDataListener(CatalogDataListener catalogDataListener) {
//		this.catalogDataListener = catalogDataListener;
//	}
	
	public void setupActionListeners() {
		
		// reset settings to default except tget mag
		runQuery.addActionListener(e -> {
			
			var settings = compileApplyDefaultSettings();
			handler.doCatalogQuery(settings);
		});
		
		
		importRaDec.addActionListener(e -> doSaveRaDecFile());
		saveRaDec.addActionListener(e -> handler.doImportRaDecfile());
		update.addActionListener(e -> doUpdateTable());
		clear.addActionListener(e -> doClearTable());
		
		this.upperLimit.addChangeListener(e -> updateLimits());
		this.nominal.addChangeListener(e -> updateLimits());
		this.lowerLimit.addChangeListener(e -> updateLimits());			
		
		this.applyLimits.addActionListener(e -> {
			var isSelected = applyLimits.isSelected();
			enableLimits(isSelected);
		});
		
		this.sortDistance.addActionListener(e -> {
			var settings = compileSettingsData();
			settings.setSortDistanceValue(true);
			settings.setSortDeltaMagValue(! settings.isSortDistanceValue());
			CatalogPropertiesFile.writeProperties(settings);
		});
		
		this.sortDeltaMag.addActionListener(e -> {
			var settings = compileSettingsData();
			settings.setSortDistanceValue(false);
			settings.setSortDeltaMagValue(! settings.isSortDistanceValue());
			CatalogPropertiesFile.writeProperties(settings);
		});	
	}
	
	private void enableLimits(boolean isSelected) {
		upperLimit.setEnabled(isSelected);
		nominal.setEnabled(isSelected);
		lowerLimit.setEnabled(isSelected);
	}
	
	private void updateLimits() {
		var settings = compileSettingsData();
		updateUpperLimit(settings);
		updateLowerLimit(settings);
		handler.updateNominalMag(settings.getNominalMagValue());		
	}
	
	private void updateUpperLimit(CatalogSettings settings) {
		var limit = settings.getUpperLimitValue();
		upperLimit.setValue(limit);
		var nominalMag = settings.getNominalMagValue();		
		var str = CatalogSettings.isUpperLimitDisabled(settings) ? "N/A" : String.format("%.1f", limit + nominalMag);
		this.upperLimitLabel.setText(str);		
	}
	
	private void updateLowerLimit(CatalogSettings settings) {
		var limit = settings.getLowerLimitValue();
		lowerLimit.setValue(limit);
		var nominalMag = settings.getNominalMagValue();		
		var str = CatalogSettings.isLowerLimitDisabled(settings) ? "N/A" : String.format("%.1f", limit + nominalMag);
		this.lowerLimitLabel.setText(str);		
	}
	

//	
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
		
	}


	
	

	
}
