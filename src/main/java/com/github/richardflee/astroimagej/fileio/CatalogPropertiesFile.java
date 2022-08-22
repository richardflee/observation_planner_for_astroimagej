package com.github.richardflee.astroimagej.fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.github.richardflee.astroimagej.data_objects.CatalogSettings;
import com.github.richardflee.astroimagej.data_objects.Observer;

public class CatalogPropertiesFile {

	private static final String CLASS_PROPS_ID = "catalog_tab.";

	private static final String SORT_BY = CLASS_PROPS_ID.concat("sortBy");
	private static final String SORT_BY_DISTANCE = "distanceSort";
	private static final String SORT_BY_DELTAMAG = "deltaMagSort";

	public static void writeProperties(CatalogSettings settings) {

		var prop = AijPropsReadWriter.getPlannerProps();
		try (OutputStream output = new FileOutputStream(AijPropsReadWriter.getPropertiesFilePath())) {
			if (settings.isSortDistanceValue() == true) {
				prop.setProperty(SORT_BY, SORT_BY_DISTANCE);
			}
			if (settings.isSortDeltaMagValue() == true) {
				prop.setProperty(SORT_BY, SORT_BY_DELTAMAG);
			}
			prop.store(output, null);
		} catch (IOException io) {
			var message = String.format("File write error:%s", AijPropsReadWriter.getPropertiesFilePath());
			JOptionPane.showMessageDialog(null, message);
		}
	}

	public static CatalogSettings readProerties() {

		var settings = new CatalogSettings(null);
		try (InputStream input = new FileInputStream(AijPropsReadWriter.getPropertiesFilePath())) {
			var prop = new Properties();
			prop.load(input);

			switch (prop.getProperty(SORT_BY)) {
			case SORT_BY_DISTANCE:
				System.out.println("distance");
				settings.setSortDistanceValue(true);
				settings.setSortDeltaMagValue(false);
				break;
			case SORT_BY_DELTAMAG:
				System.out.println("deltamag");
				settings.setSortDistanceValue(false);
				settings.setSortDeltaMagValue(true);
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

		var prop = AijPropsReadWriter.getPlannerProps();
		
		var settings = new CatalogSettings(null);
		settings.setSortDistanceValue(true);
		settings.setSortDeltaMagValue(! settings.isSortDistanceValue());		
		CatalogPropertiesFile.writeProperties(settings);
		
		settings = CatalogPropertiesFile.readProerties();		
		System.out.println(String.format("Sort by distance: %b", settings.isSortDistanceValue()));
		System.out.println(String.format("Sort by delt amg: %b", settings.isSortDeltaMagValue()));
		System.out.println();
		
		settings.setSortDistanceValue(false);
		settings.setSortDeltaMagValue(! settings.isSortDistanceValue());			
		CatalogPropertiesFile.writeProperties(settings);
		settings = CatalogPropertiesFile.readProerties();		
		System.out.println(String.format("Sort by distance: %b", settings.isSortDistanceValue()));
		System.out.println(String.format("Sort by delt amg: %b", settings.isSortDeltaMagValue()));
	}
}
