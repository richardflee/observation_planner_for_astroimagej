package com.github.richardflee.astroimagej.fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.github.richardflee.astroimagej.data_objects.CatalogQuery;
import com.github.richardflee.astroimagej.enums.CatalogsEnum;
import com.github.richardflee.astroimagej.utils.AstroCoords;


public class TargetTabFileProps {
	
	private static final String CLASS_PROPS_ID = "target_tab.";
	
	private static final String OBJECT_ID = CLASS_PROPS_ID.concat("objectId");
	
	private static final String RA_HMS = CLASS_PROPS_ID.concat("raHms");
	private static final String DEC_DMS = CLASS_PROPS_ID.concat("decDms");
	
	private static final String RA_DEG = CLASS_PROPS_ID.concat("raDeg");
	private static final String DEC_DEG = CLASS_PROPS_ID.concat("decDeg");
	
	private static final String FOV_AMIN = CLASS_PROPS_ID.concat("fovAmin");
	private static final String MAG_LIMIT = CLASS_PROPS_ID.concat("magLimit");
	private static final String CATALOG = CLASS_PROPS_ID.concat("catalog");
	private static final String FILTER = CLASS_PROPS_ID.concat("filter");
	
	public static void writeProperties(CatalogQuery query) { 
		try (OutputStream output = new FileOutputStream(AijPropsReadWriter.getPropertiesFilePath(), true)) {

			Properties prop = new Properties();

			var strVal = query.getObjectId();
			prop.setProperty(OBJECT_ID, strVal);
			
			strVal = AstroCoords.raHrToRaHms(query.getRaHr());
			prop.setProperty(RA_HMS, strVal);
			
			strVal = AstroCoords.decDegToDecDms(query.getDecDeg());
			prop.setProperty(DEC_DMS, strVal);
			
			strVal = String.format("%.6f", query.getRaHr());
			prop.setProperty(RA_DEG, strVal);
			
			strVal = String.format("%.6f", query.getDecDeg());
			prop.setProperty(DEC_DEG, strVal);
			
			strVal = String.format("%.2f", query.getFovAmin());
			prop.setProperty(FOV_AMIN, strVal);
			
			strVal = String.format("%.2f", query.getMagLimit());
			prop.setProperty(MAG_LIMIT, strVal);
			
			strVal = query.getCatalogType().toString();
			prop.setProperty(CATALOG, strVal);
			
			strVal = query.getMagBand();
			prop.setProperty(FILTER, strVal);
			
			prop.store(output, null);
		} catch (IOException io) {
			var message = String.format("Properties file write error:%s", AijPropsReadWriter.getPropertiesFilePath());
			JOptionPane.showMessageDialog(null, message);
		}
	}
	
	
	public static CatalogQuery readProerties() {
		
		var query = new CatalogQuery();		
		try (InputStream input = new FileInputStream(AijPropsReadWriter.getPropertiesFilePath())) {			
			Properties prop = new Properties();
			prop.load(input);
			
			String strVal = prop.getProperty(OBJECT_ID);
			query.setObjectId(strVal);
			
			strVal = prop.getProperty(RA_DEG);			
			query.setRaHr(Double.valueOf(strVal));
			
			strVal = prop.getProperty(DEC_DEG);			
			query.setDecDeg(Double.valueOf(strVal));
			
			strVal = prop.getProperty(DEC_DEG);			
			query.setDecDeg(Double.valueOf(strVal));
			
			strVal = prop.getProperty(FOV_AMIN);			
			query.setFovAmin(Double.valueOf(strVal));
			
			strVal = prop.getProperty(MAG_LIMIT);			
			query.setMagLimit(Double.valueOf(strVal));
			
			strVal = prop.getProperty(CATALOG);		
			query.setCatalogType(CatalogsEnum.getEnum(strVal));
			
			strVal = prop.getProperty(FILTER);			
			query.setMagBand(strVal);
			
		} catch (IOException ex) {
			// error dialog
			String message = String.format("Properties file read error:%s", AijPropsReadWriter.getPropertiesFilePath());
			JOptionPane.showMessageDialog(null, message);

			// return default settings
			query = new CatalogQuery();
		}
		return query;
	}
}
