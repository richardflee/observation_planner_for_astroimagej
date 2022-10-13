package com.github.richardflee.astroimagej.data_objects;

public class NoiseData {
	
	private double ccdGain = 1.0;
	private double ccdNoise = 0.0;
	private double ccdDark = 0.00;
	
	
	public NoiseData(double ccdGain, double ccdNoise, double ccdDark) {
		this.ccdGain = ccdGain;
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


	public double getCcdGain() {
		return ccdGain;
	}


	public void setCcdGain(double ccdGain) {
		this.ccdGain = ccdGain;
	}


	@Override
	public String toString() {
		return "NoiseData [ccdGain=" + ccdGain + ", ccdNoise=" + ccdNoise + ", ccdDark=" + ccdDark + "]";
	}

}
