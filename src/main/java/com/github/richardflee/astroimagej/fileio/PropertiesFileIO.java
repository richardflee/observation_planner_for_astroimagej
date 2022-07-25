package com.github.richardflee.astroimagej.fileio;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;
import com.github.richardflee.astroimagej.data_objects.NoiseData;
import com.github.richardflee.astroimagej.data_objects.ObservationSite;
import com.github.richardflee.astroimagej.tab_viewer.ViewerUI;

public class PropertiesFileIO {

	private static final String PLANNER_PROPERTIES_FILE = "AIJ_Plan.properties";
	private static final String AIJ_PREFS_FILE = "AIJ_Prefs.txt";

//	public PropertiesFileIO() {
//		// set properties path
//		String homePath = Paths.get(System.getProperty("user.home")).toAbsolutePath().toString();
//		this.data.propertiesFilePath = Paths.get(homePath, ".astroimagej", PLANNER_PROPERTIES_FILE).toString();
//
//		// AIJ_Prefs.txt
//		this.data.aijPrefsFilePath = Paths.get(homePath, ".astroimagej", AIJ_PREFS_FILE).toString();
//
//		// if no properties file, create new file with default query & settings data
//		// File file = new File(propertiesFilePath);
//		// if (!file.exists()) {
//		// setPropertiesFileData(null, null);
//
//		// info new properties file
//		// String message = String.format("Created a new properties file: \n%s\n",
//		// propertiesFilePath);
//		// JOptionPane.showMessageDialog(null, message);
//	}



	

//	public String getPropertiesFilePath() {
//		return data.propertiesFilePath;
//	}
//
//	public String getAijPrefsFilePath() {
//		return data.aijPrefsFilePath;
//	}

	public static void main(String[] args) {

//		// PropertiesFileIO pf = new PropertiesFileIO();
//		// System.out.println(pf.getPropertiesFilePath().toString());
//		// System.out.println(pf.getAijPrefsFilePath().toString());
//
//		try {
//			// dashing flat laf dark theme
//			UIManager.setLookAndFeel(new FlatLightLaf());
//			UIManager.put("TabbedPane.showTabSeparators", true);
//			UIManager.put("TabbedPane.selectedBackground", Color.white);
//			UIManager.put("OptionPane.minimumSize", new Dimension(500, 80));
//		} catch (Exception ex) {
//			System.err.println("Failed to initialize LaF");
//		}
//
//		PropertiesFileIO pf = new PropertiesFileIO();
//		ObservationSite site = pf.readObservationSitePrefsData();
//		NoiseData data = pf.readCcdNoisePrefsData();
//		
//		System.out.println(String.format("%3.3f",  data.getCcdDark()));
//
////		// runs app in EDT (event dispatching thread)
////		EventQueue.invokeLater(() -> {
////			// configure planner ui
////			var view = new ViewerUI();
//
//			// window title text
//			// var version = String.format("%s - %s", Main.PLANNER_TITLE,
//			// Main.PLANNER_VERSION);
//			// view.setTitle(version);
//
//			view.setVisible(true);
//			// select the last tab
//
//			// tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
//
//		});
	}

}
