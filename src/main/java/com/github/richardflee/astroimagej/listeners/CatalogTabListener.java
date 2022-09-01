package com.github.richardflee.astroimagej.listeners;

import com.github.richardflee.astroimagej.collections.FieldObjectsCollection;
import com.github.richardflee.astroimagej.data_objects.CatalogSettings;

public interface CatalogTabListener {

	// public CatalogSettings getSettingsData();

	public void updateCounts(FieldObjectsCollection fieldObjects);
	
	public void importRaDecSettings(double nominalMag, boolean isSortedByDeltaMag);
	
}
