package com.github.richardflee.astroimagej.tab_viewer;

import javax.swing.JOptionPane;

import com.github.richardflee.astroimagej.catalogs.CatalogFactory;
import com.github.richardflee.astroimagej.collections.QueryResult;
import com.github.richardflee.astroimagej.data_objects.CatalogSettings;
import com.github.richardflee.astroimagej.fileio.DssFitsWriter;
import com.github.richardflee.astroimagej.fileio.TargetPropertiesFile;
import com.github.richardflee.astroimagej.listeners.CatalogTabListener;
import com.github.richardflee.astroimagej.listeners.TableModelListener;

public class CatalogHandler {
	
	private CatalogTabListener tabListener;
	private TableModelListener tableListener;
	
	private QueryResult result = null;
	
	
	public CatalogHandler() {
		this.result = new QueryResult();
		
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
		 var catalogFieldObjects = catalog.runQuery(query);	 
		 this.result.addFieldObjects(catalogFieldObjects);
		 
		 if (settings.isSaveDssValue()) {
			 var message = DssFitsWriter.downloadDssFits(query);
			 JOptionPane.showMessageDialog(null, message);
		 }
		 

		 // move to update
		 
		 var tableRows = result.getTableRows(settings);
		 this.tableListener.updateTable(tableRows);		
		 this.tabListener.updateCounts(result.getFieldObjectsCollection());
	}
	
	public void doUpdateTable(CatalogSettings settings) {
		var tableRows = this.result.getTableRows(settings);
		
		this.tableListener.updateTable(tableRows);		
		this.tabListener.updateCounts(result.getFieldObjectsCollection());
		
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
	
	
	public static void main(String[] args) {
		
	}

}
