package com.github.richardflee.astroimagej.fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.github.richardflee.astroimagej.data_objects.Observer;

public class ObserverTabFileProps {

	private static final String CLASS_PROPS_ID = "observertab.";

	private static final String OBSERVER_CODE = CLASS_PROPS_ID.concat("observerCode");
	private static final String OBSERVER_NAME = CLASS_PROPS_ID.concat("observerName");

	private static final String TELESCOPE_SHORT = CLASS_PROPS_ID.concat("telescopeShortName");
	private static final String TELESCOPE_FULL = CLASS_PROPS_ID.concat("telescopeLongName");
	private static final String TELESCOPE_APERTURE = CLASS_PROPS_ID.concat("telescopeAperture");
	private static final String TELESCOPE_FLENGTH = CLASS_PROPS_ID.concat("telescopeFocalLength");

	private static final String CAMERA = CLASS_PROPS_ID.concat("camera");
	private static final String HORIZ_PIXEL_SIZE = CLASS_PROPS_ID.concat("horizPixelSize");
	private static final String VERT_PIXEL_SIZE = CLASS_PROPS_ID.concat("vertPixelSize");
	private static final String HORIZ_ARRAY_SIZE = CLASS_PROPS_ID.concat("horizArraySize");
	private static final String VERT_ARRAY_SIZE = CLASS_PROPS_ID.concat("vertArraySize");

	public static void writeProperties(Observer observer) {
		try (OutputStream output = new FileOutputStream(AijPropsReadWriter.getPropertiesFilePath())) {

			Properties prop = new Properties();

			var strVal = observer.getObserverCode();
			prop.setProperty(OBSERVER_CODE, strVal);

			strVal = observer.getObserverName();
			prop.setProperty(OBSERVER_NAME, strVal);

			strVal = observer.getTelescopeShortName();
			prop.setProperty(TELESCOPE_SHORT, strVal);

			strVal = observer.getTelescopeLongName();
			prop.setProperty(TELESCOPE_FULL, strVal);

			strVal = String.format("%.5f", observer.getTelescopeAperture());
			prop.setProperty(TELESCOPE_APERTURE, strVal);

			strVal = String.format("%.5f", observer.getTelescopeFocalLength());
			prop.setProperty(TELESCOPE_FLENGTH, strVal);

			strVal = observer.getCamera();
			prop.setProperty(CAMERA, strVal);

			strVal = String.format("%.5f", observer.getHorizPixelSize());
			prop.setProperty(HORIZ_PIXEL_SIZE, strVal);

			strVal = String.format("%.5f", observer.getVertPixelSize());
			prop.setProperty(VERT_PIXEL_SIZE, strVal);

			strVal = String.format("%d", observer.getHorizArraySize());
			prop.setProperty(HORIZ_ARRAY_SIZE, strVal);

			strVal = String.format("%d", observer.getVertArraySize());
			prop.setProperty(VERT_ARRAY_SIZE, strVal);

			prop.store(output, null);
		} catch (IOException io) {
			var message = String.format("File write error:%s", AijPropsReadWriter.getPropertiesFilePath());
		}

	}

	public static Observer readProerties() {

		var observer = new Observer();
		try (InputStream input = new FileInputStream(AijPropsReadWriter.getPropertiesFilePath())) {
			Properties prop = new Properties();
			prop.load(input);

			String strVar = prop.getProperty(OBSERVER_CODE);
			observer.setObserverCode(strVar);

			strVar = prop.getProperty(OBSERVER_NAME);
			observer.setObserverName(strVar);

			strVar = prop.getProperty(TELESCOPE_SHORT);
			observer.setTelescopeShortName(strVar);

			strVar = prop.getProperty(TELESCOPE_FULL);
			observer.setTelescopeLongName(strVar);

			strVar = prop.getProperty(TELESCOPE_APERTURE);
			observer.setTelescopeAperture(Double.valueOf(strVar));

			strVar = prop.getProperty(TELESCOPE_FLENGTH);
			observer.setTelescopeFocalLength(Double.valueOf(strVar));

			strVar = prop.getProperty(CAMERA);
			observer.setCamera(strVar);

			strVar = prop.getProperty(HORIZ_PIXEL_SIZE);
			observer.setHorizPixelSize(Double.valueOf(strVar));

			strVar = prop.getProperty(VERT_PIXEL_SIZE);
			observer.setVertPixelSize(Double.valueOf(strVar));

			strVar = prop.getProperty(HORIZ_ARRAY_SIZE);
			observer.setHorizArraySize(Integer.valueOf(strVar));

			strVar = prop.getProperty(VERT_ARRAY_SIZE);
			observer.setVertArraySize(Integer.valueOf(strVar));
			
		} catch (IOException ex) {
			// error dialog
			String message = String.format("Failed to read properties file: \n%s", AijPropsReadWriter.getPropertiesFilePath());
			message += "\nLoaded default query data";
			JOptionPane.showMessageDialog(null, message);

			// return default settings
			observer = new Observer();
		}
		return observer;

	}
}
