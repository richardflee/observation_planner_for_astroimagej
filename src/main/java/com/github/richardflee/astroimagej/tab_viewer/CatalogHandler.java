package com.github.richardflee.astroimagej.tab_viewer;

import javax.swing.JOptionPane;

import com.github.richardflee.astroimagej.catalogs.CatalogFactory;
import com.github.richardflee.astroimagej.catalogs.VspCatalog;
import com.github.richardflee.astroimagej.charts.VspChart;
import com.github.richardflee.astroimagej.collections.QueryResult;
import com.github.richardflee.astroimagej.data_objects.CatalogSettings;
import com.github.richardflee.astroimagej.fileio.DssFitsWriter;
import com.github.richardflee.astroimagej.fileio.RaDecFileWriter;
import com.github.richardflee.astroimagej.fileio.TargetPropertiesFile;
import com.github.richardflee.astroimagej.listeners.CatalogTabListener;
import com.github.richardflee.astroimagej.listeners.TableModelListener;

public class CatalogHandler {
	
	private CatalogTabListener tabListener;
	private TableModelListener tableListener;
	
	private QueryResult result = null;
	private VspChart vspChart = null;
//	
//	private RaDecFileReader radecFileReader = null;
	private RaDecFileWriter fileWriter = null;
	
	
	public CatalogHandler() {
		this.result = new QueryResult();
		this.vspChart = new VspChart();
		this.fileWriter = new RaDecFileWriter();
		
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
	
	public void doCatalogQuery(CatalogSettings settings) {
		 var query = TargetPropertiesFile.readProerties();
		 this.result = new QueryResult();
		 this.result.setQuery(query);
		 
		 var catalog = CatalogFactory.createCatalog(query.getCatalogType());
		 var fosCatalog = catalog.runQuery(query);	 
		 this.result.addFieldObjects(fosCatalog);
		 
		 if (settings.isSaveDssValue()) {
			 var message = DssFitsWriter.downloadDssFits(query);
			 JOptionPane.showMessageDialog(null, message);
		 }
		 

		 // move to update
		 updateTable(settings);
		 
//		 var vspCatalog = new VspCatalog();
//		 var chartUri = vspCatalog.downloadChartUri(query);
//		 result.setChartUri(chartUri);
//		 this.vspChart.showChart(result, settings);
		 
//		 
//		 var tableRows = result.getTableRows(settings);
//		 this.tableListener.updateTable(tableRows);		
//		 this.tabListener.updateCounts(result.getFieldObjectsCollection());
	}
	
	
	
	
	public void doUpdateTable(CatalogSettings settings) {
		updateTable(settings);
		
//		var tableRows = this.result.getTableRows(settings);
//		
//		this.tableListener.updateTable(tableRows);		
//		this.tabListener.updateCounts(result.getFieldObjectsCollection());
		
	}
	
	private void updateTable(CatalogSettings settings) { 
		var tableRows = result.getTableRows(settings);
		this.tableListener.updateTable(tableRows);		
		this.tabListener.updateCounts(result.getFieldObjectsCollection());
		
		 var chartUri = new VspCatalog().downloadChartUri(this.result.getQuery());
		 this.result.setChartUri(chartUri);
		 this.vspChart.showChart(result, settings);
	}
	
	public void doClearTable(CatalogSettings settings) {
		this.result.clearFieldObjects();		
		System.out.println("handler clear");
		
		var tableRows = result.getTableRows(settings);
		this.tableListener.updateTable(tableRows);		
		this.tabListener.updateCounts(result.getFieldObjectsCollection());
		
	}
	
	
	public void doImportRaDecfile() {
		System.out.println("save in handler");
	}
	
	public void doSaveRaDecFile(CatalogSettings settings) {
		System.out.println("save the radec");
		this.fileWriter.writeRaDecFile(this.result, settings);
		
	}
	
	public static void main(String[] args) {
		
	}

}
