package com.github.richardflee.astroimagej.tab_viewer;

import com.github.richardflee.astroimagej.listeners.CatalogTableListener;

public class CatalogHandler {
	
	private CatalogTableListener tableListener; 
	
	public CatalogHandler() {
		
		
	}
	
	/**
	 * Configures local table listener field to broadcast updateTable message
	 * @param catalogTableListener
	 *     reference to CataTableListener interface
	 */
	public void setCatalogTableListener(CatalogTableListener catalogTableListener) {
		this.tableListener = catalogTableListener;
	}
	
	public void test() {
		
		this.tableListener.updateTable(null);
		
	}
	
	public void doImportRaDecfile() {
		System.out.println("save in handler");
	}

}
