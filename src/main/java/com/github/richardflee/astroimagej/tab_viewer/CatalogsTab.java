package com.github.richardflee.astroimagej.tab_viewer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import com.github.richardflee.astroimagej.collections.FieldObjectsCollection;
import com.github.richardflee.astroimagej.data_objects.CatalogSettings;
import com.github.richardflee.astroimagej.enums.ColumnsEnum;
import com.github.richardflee.astroimagej.fileio.CatalogPropertiesFile;
import com.github.richardflee.astroimagej.listeners.CatalogTabListener;
import com.github.richardflee.astroimagej.models.TableModel;

public class CatalogsTab implements CatalogTabListener{
	
	private CatalogHandler handler = null;
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
	
	private JLabel totalLabel = null;
	private JLabel filteredLabel = null;
	private JLabel selectedLabel = null;	
	
	private JButton runQuery = null;
	private JButton importRaDec = null;
	private JButton saveRaDec = null;
	private JButton update = null;
	private JButton clear = null;
	
	private boolean tablePopulated;
	
	private final int TABLE_WIDTH = 1000;
	private final Integer[] COL_WIDTHS = {5, 22, 14, 14, 9, 9, 9, 9, 5, 4};
	
	public CatalogsTab(ViewerUi viewer) {
		
		this.tableModel = new TableModel();		
		this.handler = new CatalogHandler();
		handler.setTableModelListener(tableModel);
		handler.setCatalogTabListener(this);
		
		this.catalogTable = new JTable(tableModel);	
		this.spane = viewer.getTableScrollPane();		
		spane.setViewportView(catalogTable);
		this.catalogTable.setFillsViewportHeight(true);
		tableCellsRenderer(catalogTable, COL_WIDTHS);
		
		
		this.upperLimit = viewer.getUpperLimitSpinner();
		this.nominal = viewer.getTargetMagSpinner();
		this.lowerLimit = viewer.getLowerLimitSpinner();
		
		this.upperLimitLabel = viewer.getUpperLabel();
		this.lowerLimitLabel = viewer.getLowerLabel();		
		
		this.nObs = viewer.getNObsSpinner();
		
		this.applyLimits = viewer.getIsMagLimitsCheckBox();
		this.dssFits = viewer.getSaveDssCheckBox();
		
		this.totalLabel = viewer.getTotalRecordsField();
		this.filteredLabel = viewer.getFilteredRecordsField();
		this.selectedLabel = viewer.getSelectedRecordsField();
		
		this.runQuery = viewer.getCatalogQueryButton();
		this.importRaDec = viewer.getImportRaDecButton();
		this.saveRaDec = viewer.getSaveRaDecButton();
		this.update = viewer.getUpdateButton();
		this.clear = viewer.getClearButton();
		
		// import sort state from properties file
		this.sortDistance = viewer.getDistanceRadioButton();
		this.sortDeltaMag = viewer.getDeltaMagRadioButton();
		
		var sortSettings = CatalogPropertiesFile.readProerties();
		this.sortDistance.setSelected(sortSettings.isSortDistanceValue());
		this.sortDeltaMag.setSelected(sortSettings.isSortDeltaMagValue());
		
		this.tablePopulated = false;
		this.enableButtons(this.tablePopulated);
		
		
		setupActionListeners();		
	}
	
	@Override
	public void updateCounts(FieldObjectsCollection foCollection) {
		var totalCounts = foCollection.getTotalCount();
		this.totalLabel.setText(String.valueOf(totalCounts));
		this.filteredLabel.setText(String.valueOf(foCollection.getFilteredCount()));
		this.selectedLabel.setText(String.valueOf(foCollection.getSelectedCount()));
		this.tablePopulated = (totalCounts != 0);
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
		
		settings.setSaveDssValue(dssFits.isSelected());

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
		dssFits.setSelected(settings.isSaveDssValue());
		
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
			this.enableButtons(this.tablePopulated);			
		});
		
		
		importRaDec.addActionListener(e -> doSaveRaDecFile());
		saveRaDec.addActionListener(e -> handler.doImportRaDecfile());
		
		update.addActionListener(e -> {
			var settings = compileSettingsData();
			handler.doUpdateTable(settings);
			
		});
		
		clear.addActionListener(e ->{
		//	handler.doClearTable();
			this.enableButtons(false);
		});
		
		this.upperLimit.addChangeListener(e -> updateLimits());
		this.nominal.addChangeListener(e -> updateLimits());
		this.lowerLimit.addChangeListener(e -> updateLimits());			
		
		this.applyLimits.addActionListener(e -> {
			var isSelected = applyLimits.isSelected();
			enableLimits(isSelected);
		});
		
		this.sortDistance.addActionListener(e -> updateSort());		
		this.sortDeltaMag.addActionListener(e -> updateSort());		
	}
		
	private void updateSort() {
		var settings = compileSettingsData();
		CatalogPropertiesFile.writeProperties(compileSettingsData());
		handler.doUpdateTable(settings);		
	}
	
	
	private void enableButtons(boolean isEnabled) {
		update.setEnabled(isEnabled);
		clear.setEnabled(isEnabled);
		saveRaDec.setEnabled(isEnabled);
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
	
	
	
	public void doSaveRaDecFile() {
		System.out.println("import");
	}
	
	public void doImportRaDecfile() {
		System.out.println("save");
	}
//
//	public void doUpdateTable() {
//		System.out.println("update");
//	}
	
	public void doClearTable() {
		
	}
	
	
	private void tableCellsRenderer(JTable table, Integer[] widths) {
		var cr0 = new DefaultTableCellRenderer();
		cr0.setHorizontalAlignment(SwingConstants.CENTER);
		
		var totalWidth = Arrays.asList(widths).stream().mapToInt(Integer::intValue).sum();		
		for (int idx = 0; idx < table.getColumnModel().getColumnCount(); idx++) {
			table.getColumnModel().getColumn(idx).setPreferredWidth(TABLE_WIDTH * widths[idx] / totalWidth);			
			if (idx != ColumnsEnum.USE_COL.getIndex()) {
				table.getColumnModel().getColumn(idx).setCellRenderer(cr0);
			}			
		}
		table.getColumnModel().getColumn(0).setCellRenderer(new ColumnRenderer());
	}
	
	private class ColumnRenderer extends DefaultTableCellRenderer {
		private static final long serialVersionUID = 1L;
		
		@Override
		public Component getTableCellRendererComponent(
				JTable table, Object value, 
				boolean isSelected, boolean hasFocus, 
				int row, int column) {
			Component cellComponent = super.getTableCellRendererComponent(
					table, value, isSelected, hasFocus, row, column);
			
			// sets top (target) ApId cell = green, other ApIds = red + horiz text align
			Color color = (row == 0) ? Color.GREEN : Color.RED;
			cellComponent.setForeground(color);
			cellComponent.setFont(cellComponent.getFont().deriveFont(Font.BOLD));
			setHorizontalAlignment(SwingConstants.CENTER);
			return cellComponent;
		}
	}
	
}
