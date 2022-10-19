package com.github.richardflee.astroimagej.data_objects;

import java.util.regex.Pattern;

public class NoiseData {
	
	private String ccdGain = "";
	private String ccdNoise = "";
	private String ccdDark = "";
	
	private final Pattern PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");
	
	public boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false; 
	    }
	    return PATTERN.matcher(strNum).matches();
	}
	
	public NoiseData(String ccdGain, String ccdNoise, String ccdDark) {
		this.ccdGain = ccdGain;
		this.ccdNoise = ccdNoise;
		this.ccdDark = ccdDark;
	}

	public String getCcdGain() {
		var str = this.ccdGain;
		return (isNumeric(str)) ? String.format("%.3f", Double.valueOf(str)) : "";
	}

	public String getCcdNoise() {
		var str = this.ccdNoise;
		return (isNumeric(str)) ? String.format("%.1f", Double.valueOf(str)) : "";
	}

	public String getCcdDark() {
		var str = this.ccdDark;
		return (isNumeric(str)) ?  String.format("%.3f", Double.valueOf(str)) : "";
	}

	@Override
	public String toString() {
		return "NoiseData [strGain=" + ccdGain + ", strNoise=" + ccdNoise + ", strDark=" + ccdDark + ", PATTERN="
				+ PATTERN + "]";
	}
	
}
