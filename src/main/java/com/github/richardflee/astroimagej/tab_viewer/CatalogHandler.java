package com.github.richardflee.astroimagej.tab_viewer;

import com.github.richardflee.astroimagej.catalogs.CatalogFactory;
import com.github.richardflee.astroimagej.collections.FieldObjectsCollection;
import com.github.richardflee.astroimagej.collections.QueryResult;
import com.github.richardflee.astroimagej.data_objects.CatalogSettings;
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
		 System.out.println("query in handler");
		 
		 var query = TargetPropertiesFile.readProerties();
		 this.result.setQuery(query);
		 
		 var catalog = CatalogFactory.createCatalog(query.getCatalogType());
		 var x = catalog.runQuery(query);
	 
		 this.result.addFieldObjects(x);

		 // move to update
		 
		 this.result.update(settings); 
		 
		 this.result.applySort(settings);
		 
		 this.result.applyFilters(settings);
		 
		 this.tabListener.updateCounts(result.getFieldObjectsCollection());
		 
		 var tableRows = result.getTableRows(settings);
		 
		 
		 System.out.println();
		 
		 tableRows.get(1).setObjectId("fred");
		
	}
	
//	public void doCatalogQuery() {
//	

//	System.out.println(query.toString());
//	
//	// default settings with catalog ui target mag
//	// assemble catalog result with default settings & targe mag
//	var targetMag = getSettingsData().getNominalMagValue();
//	System.out.println(targetMag);
//	
//	this.result = new QueryResult(query, new CatalogSettings(targetMag));
//	System.out.println(result.toString());
//	
//	// runs query on selected on-line catalog, retruns list of field objects
//	// append this list to CatalogResut object
//	AstroCatalog catalog = CatalogFactory.createCatalog(query.getCatalogType());
//	List<FieldObject> fieldObjects = catalog.runQuery(query);
//	
//	fieldObjects.stream().forEach(p -> System.out.println(p.toString()));
//	
//	
//}
	
	public void doImportRaDecfile() {
		System.out.println("save in handler");
	}
	
	public void updateNominalMag(double nominalMag) {
		System.out.println(String.format("upddate target mag %.3f", nominalMag));
	}
	
	public void test() {
		
		this.tableListener.updateTable(null);
		
	}
	
	public static void main(String[] args) {
		
	}

}
