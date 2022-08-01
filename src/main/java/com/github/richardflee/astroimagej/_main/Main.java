package com.github.richardflee.astroimagej._main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;
import com.github.richardflee.astroimagej.data_objects.CatalogQuery;
import com.github.richardflee.astroimagej.fileio.AijPrefsFileIO;
import com.github.richardflee.astroimagej.fileio.AijPropsReadWriter;
import com.github.richardflee.astroimagej.fileio.ObserverTabFileProps;
import com.github.richardflee.astroimagej.fileio.TargetTabFileProps;
import com.github.richardflee.astroimagej.tab_viewer.ViewerUi;


/**
 * 
 * Main class for JVoyagerLogViewer program to read, view and save selected
 * abstracts from Voyager session logs
 *
 */
public class Main {

	public final static String PLANNER_TITLE = "AstroImageJ Observation Planner";
	public final static String PLANNER_VERSION = "SNAPSHOT-1.00a";

		public static void runApp() {
			
			// aborts with extended error message if AIJ_Prefs.txt not found
			if (! AijPrefsFileIO.fileExists()) {
				JOptionPane.showMessageDialog(null,  AijPrefsFileIO.errorMessage());
				System.exit(0);
			}
			
			// creates new properties file with default data if AIJ_Planner.properties not found
			if (! AijPropsReadWriter.fileExists()) {
				AijPropsReadWriter.writeDefaultPropsFile();
				JOptionPane.showMessageDialog(null,  AijPropsReadWriter.newFileMessage());
			}
			
			// creates AIJ_Prefs data objects
			var site = AijPrefsFileIO.readObservationSitePrefsData();			
			var noiseData = AijPrefsFileIO.readCcdNoisePrefsData();			
			
			// creates aij_planner data objects
			var observer = ObserverTabFileProps.readProerties();
			CatalogQuery query = TargetTabFileProps.readProerties();
			
			// User  interface
			var viewerUI = new ViewerUi();
			viewerUI.observer_tab.setObservationSiteData(site);
			viewerUI.observer_tab.setNoiseData(noiseData);
			viewerUI.observer_tab.setObserverData(observer);
			
			viewerUI.target_tab.setQueryData(query);
			
			// Plan catalogUi = new CatalogUI(handler, ctm);
			
//			
//			// window title text
			var version = String.format("%s - %s", PLANNER_TITLE, PLANNER_VERSION); 
			viewerUI.setTitle(version);
//			
			viewerUI.setVisible(true);
		}

	public static void main(String[] args) {
		try {
			// dashing flat laf dark theme
			UIManager.setLookAndFeel(new FlatLightLaf());
			UIManager.put("TabbedPane.showTabSeparators", true);
			UIManager.put("TabbedPane.selectedBackground", Color.white);
			UIManager.put("OptionPane.minimumSize",new Dimension(500,80)); 
		} catch (Exception ex) {
			System.err.println("Failed to initialize LaF");
		}
		
		// runs app in EDT (event dispatching thread)
			EventQueue.invokeLater(() -> {
				runApp();
			});
	}
}
