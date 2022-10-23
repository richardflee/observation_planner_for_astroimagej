package com.github.richardflee.astroimagej.tab_viewer;

import javax.swing.JOptionPane;

import com.github.richardflee.astroimagej.catalogs.CatalogFactory;
import com.github.richardflee.astroimagej.catalogs.VspCatalog;
import com.github.richardflee.astroimagej.charts.VspChart;
import com.github.richardflee.astroimagej.collections.QueryResult;
import com.github.richardflee.astroimagej.data_objects.CatalogSettings;
import com.github.richardflee.astroimagej.data_objects.FieldObject;
import com.github.richardflee.astroimagej.fileio.CatalogTabPropertiesFile;
import com.github.richardflee.astroimagej.fileio.DssFitsWriter;
import com.github.richardflee.astroimagej.fileio.RaDecFileReader;
import com.github.richardflee.astroimagej.fileio.RaDecFileWriter;
import com.github.richardflee.astroimagej.fileio.TargetTabPropertiesFile;
import com.github.richardflee.astroimagej.listeners.CatalogTabListener;
import com.github.richardflee.astroimagej.listeners.TableModelListener;

public class CatalogHandler {
	
	private CatalogTabListener tabListener;
	private TableModelListener tableListener;
	
	private QueryResult result = null;
	private VspChart vspChart = null;

	
	public CatalogHandler() {
		this.result = new QueryResult();
		this.vspChart = new VspChart();
		
	}
	
	/**
	 * Configures local table listener field to broadcast updateTable message
	 * @param catalogTableListener
	 *     reference to CataTableListener interface
	 */
	public void setTableModelListener(TableModelListener listener) {
		this.tableListener = listener;
	}
	
	public void setCatalogTabListener(CatalogTabListener listener) {
		this.tabListener = listener;
	}
	

	/*
	 * 1. inputs: compile query from props file, import current target mag
	 * 1a. option to change catalog / filter
	 * 2. run query, compile field_objects list
	 * 3. combine data sets in result object
	 * 4. create table rows array 
	 *     - create target object -> tablerow(0)
	 *     - add field_objects, computing sep & diff values
	 * 5. update catalog_table with rows object list
	 */
	
	public void doRunCatalogQuery(CatalogSettings settings) {
		 var query = TargetTabPropertiesFile.readProperties();
		 
		 var catalog = CatalogFactory.createCatalog(query.getCatalogType());
		 var fieldObjects = catalog.runQuery(query);		 
		 this.result = new QueryResult(query, fieldObjects);
		 
		 if (settings.isSaveDssValue()) {
			 var message = DssFitsWriter.downloadDssFits(query);
			 JOptionPane.showMessageDialog(null, message);
		 }
		 updateCatalogTableRecords(settings);
	}
	
	public void doRunCatalogQuery(double nominalMag) {
		// assemble and run query
		var query = TargetTabPropertiesFile.readProperties();
		var catalog = CatalogFactory.createCatalog(query.getCatalogType());
		var fieldObjects = catalog.runQuery(query);
		
		// compile query result object
		this.result = new QueryResult(query, fieldObjects);
		//var settings = new CatalogSettings(nominalMag);
		
		updateCatalogTableRecords(new CatalogSettings(nominalMag));
	}
	
	
	public void doImportRaDecfile() {
		
		var fr = new RaDecFileReader();		
		if (! fr.isRaDecFileSelected()) {
			return;
		}
		
		this.result = fr.getRaDecResult();
		var nominalMag = fr.getRaDecNominalMag();
		CatalogTabPropertiesFile.writeProperties(nominalMag);
		
		var radecQuery = result.getQuery();
		TargetTabPropertiesFile.writeProperties(radecQuery);
		
		var isSortedByDistance = result.isSortedByDistance();
		CatalogTabPropertiesFile.writeProperties(isSortedByDistance);
		
		tabListener.importRaDecSettings(nominalMag);		
		updateCatalogTableRecords(new CatalogSettings(nominalMag));
	}
	
	public void doSaveRaDecFile(double nominalMag) {
		new RaDecFileWriter().writeRaDecFile(this.result, nominalMag);		
	}
	
	public void doUpdateTable(CatalogSettings settings) {
		updateCatalogTableRecords(settings);		
	}
	
	
	public void doClearTable() {
		this.result.clearFieldObjects();		
		this.tableListener.updateTable(null);		
		this.tabListener.updateCounts(result.getFieldObjectsCollection());
		this.vspChart.closeChart();
	}
	
	private void updateCatalogTableRecords(CatalogSettings settings) { 
		var tableRows = result.getTableRows(settings);
		this.tableListener.updateTable(tableRows);		
		this.tabListener.updateCounts(result.getFieldObjectsCollection());
		
		var chartUri = new VspCatalog().downloadChartUri(this.result.getQuery());
		this.result.setChartUri(chartUri);
		this.vspChart.showChart(result, settings);
	}
	
	public static void main(String[] args) {
		
	}

}
