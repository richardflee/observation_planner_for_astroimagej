package com.github.richardflee.astroimagej._main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;
import com.github.richardflee.astroimagej.fileio.AijPrefsFileIO;
import com.github.richardflee.astroimagej.tab_viewer.ViewerUI;


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
			
			if (! AijPrefsFileIO.aijPrefsFileExists()) {
				JOptionPane.showMessageDialog(null,  AijPrefsFileIO.aijPrefsErrorMessage());
				System.exit(0);
			}
			
			// Properties file exists
			
			// User  interface
			var viewerUI = new ViewerUI();
			
			// populates civil solar times and geographic location controls
			var site = AijPrefsFileIO.readObservationSitePrefsData();
			viewerUI.observer.setObservationSiteData(site);
			
			var noiseData = AijPrefsFileIO.readCcdNoisePrefsData();
			viewerUI.observer.setNoiseData(noiseData);
			
			
			
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
