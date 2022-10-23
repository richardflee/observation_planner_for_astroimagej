package com.github.richardflee.astroimagej.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import com.github.richardflee.astroimagej.data_objects.CatalogQuery;
import com.github.richardflee.astroimagej.data_objects.CatalogSettings;
import com.github.richardflee.astroimagej.data_objects.Observer;

public class AijPropsReadWriter {

	private static final String PLANNER_PROPERTIES_FILE = "AIJ_Planner.properties";
	
	
	public static Properties getPlannerProperties() {
		Properties prop = new Properties();
		try (InputStream input = new FileInputStream(AijPropsReadWriter.getPropertiesFilePath())) {			
			prop.load(input);			
		} catch (IOException ex) {
			System.out.println("error");
			// error dialog
		}
		
		return prop;
	}

	public static void writeDefaultPropertiesFile() {
		
		Path path = Paths.get(getPropertiesFilePath());
		try {
			Files.createFile(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObserverTabPropertiesFile.writeProperties(new Observer());		
		TargetTabPropertiesFile.writeProperties(new CatalogQuery());		
		CatalogTabPropertiesFile.writeProperties(true);
		CatalogTabPropertiesFile.writeProperties(CatalogSettings.DEFAULT_TGT_MAG);
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

		AijPropsReadWriter.writeDefaultPropertiesFile();

		System.out.println("\nhere");

	}

}
