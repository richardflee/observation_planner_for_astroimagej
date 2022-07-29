package com.github.richardflee.astroimagej.fileio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

import com.github.richardflee.astroimagej.data_objects.CatalogQuery;
import com.github.richardflee.astroimagej.data_objects.Observer;

public class AijPropsReadWriter {

	private static final String PLANNER_PROPERTIES_FILE = "AIJ_Planner.properties";

	public static void writeDefaultPropsFile() {

//		try (OutputStream output = new FileOutputStream(getPropertiesFilePath())) {
//			
//		} catch (IOException io) {
//			var message = String.format("Properties file error: \n%s", getPropertiesFilePath());
//			JOptionPane.showMessageDialog(null, message);
//		}
		
		Path x = Paths.get(getPropertiesFilePath());
		try {
			Files.createFile(x);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ObserverTabFileProps.writeProperties(new Observer());
		
		TargetTabFileProps.writeProperties(new CatalogQuery());
	}

	public static boolean fileExists() {
		var file = new File(getPropertiesFilePath());
		return file.exists();
	}

	public static String newFileMessage() {
		return "Created new properties file:\n" + getPropertiesFilePath();
	}
	
	
	public static String savedFileMessage() {
		return "Saved to properties file:\n" + getPropertiesFilePath();
	}

	public static String getPropertiesFilePath() {
		var homePath = Paths.get(System.getProperty("user.home")).toAbsolutePath().toString();
		return Paths.get(homePath, ".astroimagej", PLANNER_PROPERTIES_FILE).toString();
	}

	public static void main(String[] args) {

		AijPropsReadWriter.writeDefaultPropsFile();

		System.out.println("\nhere");

	}

}
