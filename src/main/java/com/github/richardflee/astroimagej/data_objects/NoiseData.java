package com.github.richardflee.astroimagej.data_objects;

public class NoiseData {
	
	private double ccdNoise = 0.0;
	private double ccdDark = 0.00;
	
	
	public NoiseData(double ccdNoise, double ccdDark) {
		this.ccdNoise = ccdNoise;
		this.ccdDark = ccdDark;
	}


	public double getCcdNoise() {
		return ccdNoise;
	}


	public void setCcdNoise(double ccdNoise) {
		this.ccdNoise = ccdNoise;
	}


	public double getCcdDark() {
		return ccdDark;
	}


	public void setCcdDark(double ccdDark) {
		this.ccdDark = ccdDark;
	}


	@Override
	public String toString() {
		return "NoiseData [ccdNoise=" + ccdNoise + ", ccdDark=" + ccdDark + "]";
	}
	
	
	
}
