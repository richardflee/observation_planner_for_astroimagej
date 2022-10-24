package com.github.richardflee.astroimagej._main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;
import com.github.richardflee.astroimagej.fileio.AijPrefsFileIO;
import com.github.richardflee.astroimagej.fileio.AijPropsReadWriter;
import com.github.richardflee.astroimagej.fileio.ObserverTabPropertiesFile;
import com.github.richardflee.astroimagej.tab_viewer.ViewerUi;



public class Main {
	
	private static final String BUILD_NO = ".11";

	public static final String PLANNER_TITLE = "AstroImageJ Observation Planner";
	public static final String PLANNER_VERSION = "1.00a" + BUILD_NO;

		public static void runApp() {
			
			// aborts with extended error message if AIJ_Prefs.txt not found
			if (! AijPrefsFileIO.fileExists()) {
				var message = AijPrefsFileIO.errorMessage();
				JOptionPane.showMessageDialog(null, message);
				System.exit(0);
			}
			
			// creates new properties file with default data if AIJ_Planner.properties not found
			if (! AijPropsReadWriter.fileExists()) {
				AijPropsReadWriter.writeDefaultPropertiesFile();
				var message = AijPropsReadWriter.newFileMessage();
				JOptionPane.showMessageDialog(null, message);
			}
			
			// creates AIJ_Prefs data objects
			var site = AijPrefsFileIO.readObservationSitePrefsData();			
			var noiseData = AijPrefsFileIO.readCcdNoisePrefsData();			
			
			// creates aij_planner data objects
			var observer = ObserverTabPropertiesFile.readProerties();
			
			
			// User  interface
			var viewer = new ViewerUi(site); //, tableModel);
			var observer_tab = viewer.getObserver_tab();
			observer_tab.setObservationSiteData();
			observer_tab.setNoiseData(noiseData);
			observer_tab.setObserverData(observer);
			
			// window title text
			var version = String.format("%s - %s", PLANNER_TITLE, PLANNER_VERSION); 
			viewer.setTitle(version);
			viewer.setVisible(true);
		}

	public static void main(String[] args) {
		try {
			// dashing flat laf dark theme
			UIManager.setLookAndFeel(new FlatLightLaf());
			UIManager.put("TabbedPane.showTabSeparators", true);
			UIManager.put("TabbedPane.selectedBackground", Color.white);
			UIManager.put("OptionPane.minimumSize",new Dimension(500,80)); 
		} catch (Exception ex) {
			var message = "Failed to initialize LaF";
			JOptionPane.showMessageDialog(null,  message);
		}
		
		// runs app in EDT (event dispatching thread)
			EventQueue.invokeLater(() -> {
				runApp();
			});
	}
}
