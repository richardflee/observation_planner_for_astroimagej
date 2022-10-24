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
import com.github.richardflee.astroimagej.fileio.CatalogTabPropertiesFile;
import com.github.richardflee.astroimagej.fileio.TargetTabPropertiesFile;
import com.github.richardflee.astroimagej.listeners.CatalogTabListener;
import com.github.richardflee.astroimagej.models.TableModel;
import com.github.richardflee.astroimagej.utils.AstroCoords;

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
	
	private ViewerUi viewer = null;
	
	private boolean isTablePopulated;
	
	private final int TABLE_WIDTH = 1000;
	private final Integer[] COL_WIDTHS = {5, 22, 14, 14, 9, 9, 9, 9, 5, 4};
	
	
	public CatalogsTab(ViewerUi viewer) {
		
		this.viewer = viewer;
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
		
		var isSortByDistance = CatalogTabPropertiesFile.isSortByDistance();
		this.sortDistance.setSelected(isSortByDistance);
		this.sortDeltaMag.setSelected(! isSortByDistance);
		
		this.isTablePopulated = false;
		this.enableControls(this.isTablePopulated);	
		
		var nominalMag = CatalogTabPropertiesFile.readNominalMag();
		setSpinnerNominalMag(nominalMag);
		//this.nominal.setValue((double) nominalMag);
		
		// updateQueryPanel(viewer)
		setupActionListeners();				
	}
	
	@Override
	public void updateCounts(FieldObjectsCollection foCollection) {
		var totalCounts = foCollection.getTotalCount();
		this.totalLabel.setText(String.valueOf(totalCounts));
		this.filteredLabel.setText(String.valueOf(foCollection.getFilteredCount()));
		this.selectedLabel.setText(String.valueOf(foCollection.getSelectedCount()));
		this.isTablePopulated = (totalCounts != 0);
	}
	
	@Override
	public void importRaDecSettings(double nominalMag) {
		updateCatalogTabUi(new CatalogSettings(nominalMag));		
	}
	
	public void updateQueryPanel(ViewerUi viewer) { 
		var query = TargetTabPropertiesFile.readProperties();
		var objectId = query.getObjectId();
		var fov = query.getFovAmin();
		var strVal = String.format("ID: %s | FOV: %.1f", objectId, fov);
		viewer.getQueryIdLabel().setText(strVal);
		
		var raHms = AstroCoords.raHrToRaHms(query.getRaHr());
		var decDms = AstroCoords.decDegToDecDms(query.getDecDeg());
		strVal = String.format("RA: %s | Dec: %s", raHms, decDms);
		viewer.getQueryRaDecLabel().setText(strVal);
		
		String catalog = query.getCatalogType().toString();
		String filter = query.getMagBand();
		var magLimit = query.getMagLimit();
		strVal = String.format("Catalog: %s | Filter: %s | Mag: <%.1f", catalog, filter, magLimit);
		viewer.getQueryCatFilterLabel().setText(strVal);	
	}
	
	/*
	 * Copies catalog ui user filter and sort selections to CatalogSettings object values 
	 * 
	 * @return compiled CatalogSettings object
	 */
	public CatalogSettings getUiSettings() {
		CatalogSettings settings = new CatalogSettings();
		
		// target mag
		settings.setNominalMagValue(Double.valueOf(nominal.getValue().toString()));

		// mag limits
		settings.setApplyLimitsValue(applyLimits.isSelected());
		settings.setUpperLimitValue(Double.valueOf(upperLimit.getValue().toString()));
		settings.setLowerLimitValue(Double.valueOf(lowerLimit.getValue().toString()));

		// number of observations
		settings.setnObsValue((int) nObs.getValue());
		
		settings.setSaveDssValue(dssFits.isSelected());
		return settings;
	}
	
	
	public void updateCatalogTabUi(CatalogSettings settings) {		
		nominal.setValue(settings.getNominalMagValue());
		
		applyLimits.setSelected(settings.isApplyLimitsValue());
		upperLimit.setValue(settings.getUpperLimitValue());
		lowerLimit.setValue(settings.getLowerLimitValue());
		
		var isSortedByDistance = CatalogTabPropertiesFile.isSortByDistance();
		sortDistance.setSelected(isSortedByDistance);
		sortDeltaMag.setSelected(! isSortedByDistance);
		dssFits.setSelected(settings.isSaveDssValue());
		
		nObs.setValue(settings.getnObsValue());		
	}
	
	
	public void setupActionListeners() {
		
		runQuery.addActionListener(e -> {			
			double nominalMag = getSpinnerNominalMag();		// spinner
			CatalogTabPropertiesFile.writeProperties(nominalMag);			
			updateCatalogTabUi(new CatalogSettings(nominalMag));
			
			handler.doRunCatalogQuery(nominalMag);
			handler.doDssFitsQuery(dssFits.isSelected());
			this.enableControls(this.isTablePopulated);				
		});
		
		
		// import radec file data
		importRaDec.addActionListener(e ->{
			handler.doImportRaDecfile();			
			updateQueryPanel(this.viewer);			
			this.enableControls(this.isTablePopulated);
		});
		
		// saves table to radec file
		saveRaDec.addActionListener(e -> {
			double nominalMag = getSpinnerNominalMag();
			handler.doSaveRaDecFile(nominalMag);
		});
		
		// updates table with current filter settings
		update.addActionListener(e -> {
			var settings = getUiSettings();
			handler.doUpdateTable(settings);
			
		});
		
		// clears table, resets catalog ui reset default values
		// nominal mag & sort options are unchanged
		clear.addActionListener(e ->{
			var nominalMag = getSpinnerNominalMag();
			updateCatalogTabUi(new CatalogSettings(nominalMag));
			handler.doClearTable();
			this.enableControls(false);
		});
		
		this.upperLimit.addChangeListener(e -> updateLimits());
		this.nominal.addChangeListener(e -> updateLimits());
		this.lowerLimit.addChangeListener(e -> updateLimits());			
		
		this.applyLimits.addActionListener(e -> {
			var isSelected = applyLimits.isSelected();
			enableLimits(isSelected);
		});
		
		this.sortDistance.addActionListener(e -> updateTableSortOrder(true));		
		this.sortDeltaMag.addActionListener(e -> updateTableSortOrder(false));		
	}
		
	private void updateTableSortOrder(boolean isSortedByDistance) {
		CatalogTabPropertiesFile.writeProperties(isSortedByDistance);
		var settings = getUiSettings();
		handler.doUpdateTable(settings);		
	}
	
	
	private void enableControls(boolean isEnabled) {
		// buttons
		update.setEnabled(isEnabled);
		clear.setEnabled(isEnabled);
		saveRaDec.setEnabled(isEnabled);
		// sort options
		sortDistance.setEnabled(isEnabled);
		sortDeltaMag.setEnabled(isEnabled);
	}
	
	private void enableLimits(boolean isSelected) {
		upperLimit.setEnabled(isSelected);
		nominal.setEnabled(isSelected);
		lowerLimit.setEnabled(isSelected);
	}
	
	private void updateLimits() {
		var settings = getUiSettings();
		updateUpperLimit(settings);
		updateLowerLimit(settings);
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
	
	private double getSpinnerNominalMag() {
		return Double.valueOf(nominal.getValue().toString());
	}
	
	private void setSpinnerNominalMag(double nominalMag) {
		this.nominal.setValue((double) nominalMag);
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
