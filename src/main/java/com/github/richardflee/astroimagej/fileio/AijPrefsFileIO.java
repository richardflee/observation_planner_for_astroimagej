package com.github.richardflee.astroimagej.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.github.richardflee.astroimagej.data_objects.NoiseData;
import com.github.richardflee.astroimagej.data_objects.ObservationSite;

public class AijPrefsFileIO {

	private static final String AIJ_PREFS_FILE = "AIJ_Prefs.txt";
	//private String aijPrefsFilePath = null;

	public AijPrefsFileIO() {
		// AIJ_Prefs.txt
//		var homePath = Paths.get(System.getProperty("user.home")).toAbsolutePath().toString();
//		this.aijPrefsFilePath = Paths.get(homePath, ".astroimagej", AIJ_PREFS_FILE).toString();
	}
	
	public static ObservationSite readObservationSitePrefsData() {
		ObservationSite site = null;
		try (InputStream input = new FileInputStream(getAijPrefsFilePath())) {
			Properties prop = new Properties();
			prop.load(input);

			// import observation site parameters from AIJ_Prefs.txt & create new Site
			// object
			double siteLongDeg = Double.parseDouble(prop.getProperty(".coords.lon").toString());
			double siteLatDeg = Double.parseDouble(prop.getProperty(".coords.lat").toString());
			double siteElevation = Double.parseDouble(prop.getProperty(".coords.alt").toString());
			double utcOffsetHr = Double.parseDouble(prop.getProperty(".coords.nowTimeZoneOffset").toString());

			site = new ObservationSite(siteLongDeg, siteLatDeg, siteElevation, utcOffsetHr);
		} catch (NullPointerException | IOException ex) {
			String message = "Failed to read Observation Site data: \n" + getAijPrefsFilePath();
			JOptionPane.showMessageDialog(null, message);
		}
		return site;
	}
	
	public static NoiseData readCcdNoisePrefsData() {

		NoiseData data = null;
		try (InputStream input = new FileInputStream(getAijPrefsFilePath())) {
			Properties prop = new Properties();
			prop.load(input);

			double ccdNoise = Double.valueOf(prop.getProperty(".aperture.ccdnoise").toString());
			double ccdDark = Double.valueOf(prop.getProperty(".aperture.ccddark").toString());
			data = new NoiseData(ccdNoise, ccdDark);

		} catch (NullPointerException | IOException ex) {
			String message = "Failed to read ccd noise data: \n"  + getAijPrefsFilePath();
			JOptionPane.showMessageDialog(null, message);
		}
		return data;

	}
	
	
	
	public static boolean fileExists() {
		var file = new File(getAijPrefsFilePath());
		return file.exists();
	}

	
	public static String errorMessage() {
		var message = String.format("%s not found\n\n", AijPrefsFileIO.getAijPrefsFilePath());
		message += "1. If necessary, download and install AstroImageJ \n";
		message +=      "https://www.astro.louisville.edu/software/astroimagej/installation_packages\n";
		message += "2. Open and close AstroImageJ once to create an AIJ_Prefs.txt file\n";
		message += "3. Run aij_planner: confirm the aij_planner user interface now opens";
		return message;
	}
	
	private static String getAijPrefsFilePath() {
		var homePath = Paths.get(System.getProperty("user.home")).toAbsolutePath().toString();
		return Paths.get(homePath, ".astroimagej", AIJ_PREFS_FILE).toString();
	}
	
	public static void main(String[] args) {
		
		if (! AijPrefsFileIO.fileExists()) {
			JOptionPane.showMessageDialog(null,  AijPrefsFileIO.errorMessage());
			System.out.println(AijPrefsFileIO.errorMessage());
			System.exit(0);
		}
		
		var site = AijPrefsFileIO.readObservationSitePrefsData();
		System.out.println(site.toString());
		System.out.println();
		
		var noiseData = AijPrefsFileIO.readCcdNoisePrefsData();
		System.out.println(noiseData.toString());
		
	}

}
