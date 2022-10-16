package com.github.richardflee.astroimagej.fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.github.richardflee.astroimagej.data_objects.CatalogSettings;

public class CatalogTabPropertiesFile {

	private static final String CLASS_PROPS_ID = "catalog_tab.";

	private static final String SORT_BY = CLASS_PROPS_ID.concat("sortBy");
	private static final String SORT_BY_DISTANCE = "distanceSort";
	private static final String SORT_BY_DELTAMAG = "deltaMagSort";

	public static void writeProperties(CatalogSettings settings) {

		var prop = AijPropsReadWriter.getPlannerProps();
		try (OutputStream output = new FileOutputStream(AijPropsReadWriter.getPropertiesFilePath())) {
			if (settings.isSortDistanceValue() == true) {
				prop.setProperty(SORT_BY, SORT_BY_DISTANCE);
			} else {
				prop.setProperty(SORT_BY, SORT_BY_DELTAMAG);
			}			
			prop.store(output, null);
		} catch (IOException io) {
			var message = String.format("File write error:%s", AijPropsReadWriter.getPropertiesFilePath());
			JOptionPane.showMessageDialog(null, message);
		}
	}

	public static CatalogSettings readProerties() {

		var settings = new CatalogSettings();
		try (InputStream input = new FileInputStream(AijPropsReadWriter.getPropertiesFilePath())) {
			var prop = new Properties();
			prop.load(input);

			switch (prop.getProperty(SORT_BY)) {
			case SORT_BY_DISTANCE:
				settings.setSortDistanceValue(true);
				break;
			case SORT_BY_DELTAMAG:
				settings.setSortDistanceValue(false);
				break;
			default:
				var message = String.format("File read error:%s", AijPropsReadWriter.getPropertiesFilePath());
				JOptionPane.showMessageDialog(null, message);
			}
		} catch (IOException ex) {
			// error dialog
			String message = String.format("Failed to read properties file: \n%s",
					AijPropsReadWriter.getPropertiesFilePath());
			JOptionPane.showMessageDialog(null, message);
		}
		return settings;
	}

	public static void main(String[] args) {

		// var prop = AijPropsReadWriter.getPlannerProps();
		
		var settings = new CatalogSettings();
		settings.setSortDistanceValue(true);
		CatalogTabPropertiesFile.writeProperties(settings);
		
		settings = CatalogTabPropertiesFile.readProerties();		
		System.out.println(String.format("Sort by distance: %b", settings.isSortDistanceValue()));
		System.out.println(String.format("Sort by delt amg: %b", settings.isSortDeltaMagValue()));
		System.out.println();
		
		settings.setSortDistanceValue(false);
		CatalogTabPropertiesFile.writeProperties(settings);
		settings = CatalogTabPropertiesFile.readProerties();		
		System.out.println(String.format("Sort by distance: %b", settings.isSortDistanceValue()));
		System.out.println(String.format("Sort by delt amg: %b", settings.isSortDeltaMagValue()));
	}
}
