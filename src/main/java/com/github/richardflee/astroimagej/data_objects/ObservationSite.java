package com.github.richardflee.astroimagej.data_objects;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.github.richardflee.astroimagej.utils.AstroCoords;


public class ObservationSite {
	
	private final static String NORTH = "North"; 
	private final static String SOUTH = "South"; 
	private final static String EAST = "East"; 
	private final static String WEST = "West"; 

	private double siteLongDeg;
	private double siteLatDeg;
	private double siteAlt;
	private double utcOffsetHr;
	
//	private String siteNorthSouth;
//	private String siteEastWest;

	/**
	 * Default site: Moore Observatory, UofL, Brownsboro, KY
	 * Time zones: Eastern Daylight/Standard Times
	 * 		Mar to Nov EDT UTC-4h; 
	 * 		Nov to Mar EST UTC-5h 
	 */
	public ObservationSite() {
		String longDms = "-85:31:42.51";
		String latDms = "+38:20:41.25";
		this.siteLongDeg = AstroCoords.dmsToDeg(longDms);
		this.siteLatDeg = AstroCoords.dmsToDeg(latDms);
		this.utcOffsetHr = -5.0;		// EST
	}

	/**
	 * Sets observatory geographic location <p> UTC defaults to GMT </p>
	 * @param longitude
	 *     geographic longitude in degrees; positive if E of Greenwich, negative
	 *     otherwise
	 * @param latitude
	 *     geographic latitude in degrees; positive if north, negative otherwise
	 * @param elevation
	 *     height in m
	 * @param utcOffsetHr
	 *     TODO
	 */
	public ObservationSite(double siteLongDeg, double siteLatDeg, double siteAlt, double utcOffsetHr) {
		this.siteLongDeg = ObservationSite.round(siteLongDeg);
		this.siteLatDeg = ObservationSite.round(siteLatDeg);
		this.siteAlt = siteAlt;
		this.utcOffsetHr = utcOffsetHr;
	}

	/**
	 * Converts coordinate in degrees to sexagesimal value with ':' delimiter
	 * @param locationDeg
	 *     longitude or latitude in degrees
	 * @return coordinate in sexagesimal format ±ddd:mm:ss.ss
	 */
	private static String locationDegToDms(double locationDeg) {
		// extract sign
		var sign = (locationDeg >= 0) ? "+" : "-";

		// extract ddd, mm, ss terms
		var data = Math.abs(locationDeg);
		var ddd = (int) (1.0 * data);
		var mm = (int) ((data - ddd) * 60);
		var ss = ((data - ddd) * 60 - mm) * 60;

		// return unsigned sexagesimal coordinate
		return sign + String.format("%02d", ddd) + ":" 
			+ String.format("%02d", mm) + ":"
			+ String.format("%5.2f", ss).replace(' ', '0');
	}
	
	public static double round(double value) {
		int places = 8;
		var bd = new BigDecimal(Double.toString(value));
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public String getSiteLongDms() {
		return ObservationSite.locationDegToDms(this.siteLongDeg);
	}
	
	public String getSiteLatDms() {
		return ObservationSite.locationDegToDms(this.siteLatDeg);
	}

	public double getSiteLongitudeDeg() {
		return siteLongDeg;
	}


	public double getSiteLatitudeDeg() {
		return siteLatDeg;
	}


	public double getSiteAlt() {
		return siteAlt;
	}


	public double getUtcOffsetHr() {
		return utcOffsetHr;
	}

	
	// longitude and latitude hemisphere getters
	public String getSiteNorthSouth() {
		return this.siteLatDeg >= 0 ? NORTH : SOUTH;
	}

	public String getSiteEastWest() {
		return this.siteLongDeg >= 0 ? EAST : WEST;
	}
	
//	// unsigned longitude and latitude sexagesimal (dms) getters
//	public String getSiteLongDms() {
//		return AstroCoords.degToDms(this.getSiteLongitudeDeg()); //.replace("+", "").replace("[+-", "");
//	}
//
//	public String getSiteLatDms() {
//		return AstroCoords.degToDms(this.getSiteLatitudeDeg()); //.replace("+", "").replace("-", "");
//	}

	@Override
	public String toString() {
		String s = String.format("Site long: %.6f, %s, %s\n", siteLongDeg, getSiteLongDms(), getSiteEastWest());
		s += String.format("Site lat: %.6f, %s, %s\n", siteLatDeg, getSiteLatDms(), getSiteNorthSouth());
		s += String.format("Site altitude/utc %.6f, %.6f\n\n", siteAlt, utcOffsetHr);
		return s;
	}

	public static void main(String[] args) {
		
		System.out.println("Abastumani Astrophysical");
		var longDeg = 42.82167;
		var latDeg = 41.755;
		var abastu = new ObservationSite(longDeg, latDeg, 1583, 4.0);
		System.out.println(abastu.toString());
		
		System.out.println("Moore UofL KY");
		longDeg = -85.528476;
		latDeg = 38.344791;
		var moore = new ObservationSite(longDeg, latDeg, 229, -5);
		System.out.println(moore.toString());
		
		System.out.println("Siding Springs");
		longDeg = 149.066666666666;
		latDeg = -31.2766666666667;
		var siding = new ObservationSite(longDeg, latDeg, 1164, 10);
		System.out.println(siding.toString());
		
		System.out.println("Abrahao");
		longDeg = -46.9666666666667;
		latDeg = -23.0016666666667;
		var abrahao = new ObservationSite(longDeg, latDeg, 850, -4);
		System.out.println(abrahao.toString());
	}

}
