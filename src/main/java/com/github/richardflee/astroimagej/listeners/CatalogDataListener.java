package com.github.richardflee.astroimagej.listeners;

import com.github.richardflee.astroimagej.data_objects.CatalogQuery;

/**
 * Specifies interface to read from and write to catalog ui controls
 */

public interface CatalogDataListener {

	// maps CatalogQuery object data & viewer.target_tab controls
	public void setQueryData(CatalogQuery query);
	public CatalogQuery getQueryData();

}
