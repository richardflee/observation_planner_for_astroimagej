package com.github.richardflee.astroimagej.fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

public class CatalogTabPropertiesFile {

	private static final String CLASS_PROPS_ID = "catalog_tab.";

	private static final String SORT_BY = CLASS_PROPS_ID.concat("sortBy");
	private static final String SORT_BY_DISTANCE = "distanceSort";
	private static final String SORT_BY_DELTAMAG = "deltaMagSort";
	private static final String NOM_MAG = CLASS_PROPS_ID.concat("nomMag");

	public static void writeProperties(boolean isSortedByDistance) {
		var prop = AijPropsReadWriter.getPlannerProperties();
		try (OutputStream output = new FileOutputStream(AijPropsReadWriter.getPropertiesFilePath())) {
			if (isSortedByDistance) {
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
	
	public static void writeProperties(double nominalMag) {

		var prop = AijPropsReadWriter.getPlannerProperties();
		try (OutputStream output = new FileOutputStream(AijPropsReadWriter.getPropertiesFilePath())) {
			prop.setProperty(NOM_MAG, String.format("%.3f", nominalMag));			
			prop.store(output, null);
		} catch (IOException io) {
			var message = String.format("File write error:%s", AijPropsReadWriter.getPropertiesFilePath());
			JOptionPane.showMessageDialog(null, message);
		}
	}
	
	public static double readNominalMag() {
		double nominalMag = 0.0;
		try (InputStream input = new FileInputStream(AijPropsReadWriter.getPropertiesFilePath())) {
			var prop = new Properties();
			prop.load(input);
			nominalMag = Double.valueOf(prop.getProperty(NOM_MAG));			
		} catch (IOException ex) {
			// error dialog
			String message = String.format("Failed to read properties file: \n%s",
					AijPropsReadWriter.getPropertiesFilePath());
			JOptionPane.showMessageDialog(null, message);
		}
		return nominalMag;		
	}

	public static boolean isSortByDistance() {
		var isDistanceSort = false;
		try (InputStream input = new FileInputStream(AijPropsReadWriter.getPropertiesFilePath())) {
			var prop = new Properties();
			prop.load(input);
			isDistanceSort =  prop.getProperty(SORT_BY).equals(SORT_BY_DISTANCE);
		} catch (IOException ex) {
			String message = String.format("Failed to read properties file: \n%s",
					AijPropsReadWriter.getPropertiesFilePath());
			JOptionPane.showMessageDialog(null, message);
		}
		return isDistanceSort;
	}

	public static void main(String[] args) {

//		// var prop = AijPropsReadWriter.getPlannerProps();
//		
//		var settings = new CatalogSettings();
//		settings.setSortDistanceValue(true);
//		CatalogTabPropertiesFile.writeProperties(settings);
//		
//		System.out.println(String.format("Sort by distance: %b", settings.isSortDistanceValue()));
//		System.out.println(String.format("Sort by delt mag: %b", settings.isSortDeltaMagValue()));
//		System.out.println();
//		
//		settings.setSortDistanceValue(false);
//		CatalogTabPropertiesFile.writeProperties(settings);
//		System.out.println(String.format("Sort by distance: %b", settings.isSortDistanceValue()));
//		System.out.println(String.format("Sort by delt mag: %b", settings.isSortDeltaMagValue()));
	}
}
