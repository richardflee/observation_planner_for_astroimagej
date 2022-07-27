package com.github.richardflee.astroimagej.data_objects;

public class Observer {
	
	private String observerCode;
	private String observerName;
	
	private String telescopeShortName;
	private String telescopeLongName;	
	private double telescopeAperture;
	private double telescopeFocalLength;
	
	private String camera;
	private double horizPixelSize;
	private double vertPixelSize;
	private int horizArraySize;
	private int vertArraySize;
	
	private double darkCurrent;
	private double readoutNoise;
	
	// set defaults
	public Observer() {
		this.observerCode = "xxx";
		this.observerName = "observer";
		
		this.telescopeShortName = "MORC24";
		this.telescopeLongName = "Moore Observatory 24-inch Ritchie-Chretien";
		this.telescopeAperture = 600.0;
		this.telescopeFocalLength = 4800.0;
		this.camera = "Apogee U16M CCD";
		this.horizPixelSize = 9.0;
		this.vertPixelSize = 9.0;
		this.horizArraySize = 4096;
		this.vertArraySize = 4096;
		
		this.darkCurrent = 0.05;
		this.readoutNoise = 9.0;
	}
	
	
	public Observer(String observerCode, String observerName, 
			String telescopeShortName, String telescopeLongName, double telescopeAperture, double telescopeFocalLength, 
			String camera, double horizPixelSize,
			double vertPixelSize, int horizArraySize, int vertArraySize) {
		this.observerCode = observerCode;
		this.observerName = observerName;
		this.telescopeShortName = telescopeShortName;
		this.telescopeLongName = telescopeLongName;
		this.telescopeAperture = telescopeAperture;
		this.telescopeFocalLength = telescopeFocalLength;
		this.camera = camera;
		this.horizPixelSize = horizPixelSize;
		this.vertPixelSize = vertPixelSize;
		this.horizArraySize = horizArraySize;
		this.vertArraySize = vertArraySize;
	}
	public String getObserverCode() {
		return observerCode;
	}
	public String getObserverName() {
		return observerName;
	}
	public String getTelescopeShortName() {
		return telescopeShortName;
	}
	public String getTelescopeLongName() {
		return telescopeLongName;
	}
	public double getTelescopeAperture() {
		return telescopeAperture;
	}
	public double getTelescopeFocalLength() {
		return telescopeFocalLength;
	}
	public String getCamera() {
		return camera;
	}
	public double getHorizPixelSize() {
		return horizPixelSize;
	}
	public double getVertPixelSize() {
		return vertPixelSize;
	}
	public int getHorizArraySize() {
		return horizArraySize;
	}
	public int getVertArraySize() {
		return vertArraySize;
	}
	public double getDarkCurrent() {
		return darkCurrent;
	}
	public double getReadoutNoise() {
		return readoutNoise;
	}


	public void setObserverCode(String observerCode) {
		this.observerCode = observerCode;
	}


	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}


	public void setTelescopeShortName(String telescopeShortName) {
		this.telescopeShortName = telescopeShortName;
	}


	public void setTelescopeLongName(String telescopeLongName) {
		this.telescopeLongName = telescopeLongName;
	}


	public void setTelescopeAperture(double telescopeAperture) {
		this.telescopeAperture = telescopeAperture;
	}


	public void setTelescopeFocalLength(double telescopeFocalLength) {
		this.telescopeFocalLength = telescopeFocalLength;
	}


	public void setCamera(String camera) {
		this.camera = camera;
	}


	public void setHorizPixelSize(double horizPixelSize) {
		this.horizPixelSize = horizPixelSize;
	}


	public void setHorizArraySize(int horizArraySize) {
		this.horizArraySize = horizArraySize;
	}


	public void setVertPixelSize(double vertPixelSize) {
		this.vertPixelSize = vertPixelSize;
	}


	public void setVertArraySize(int vertArraySize) {
		this.vertArraySize = vertArraySize;
	}


	public void setDarkCurrent(double darkCurrent) {
		this.darkCurrent = darkCurrent;
	}


	public void setReadoutNoise(double readoutNoise) {
		this.readoutNoise = readoutNoise;
	}


	@Override
	public String toString() {
		return "Observer [observerCode=" + observerCode + ", observerName=" + observerName + ", telescopeShortName="
				+ telescopeShortName + ", telescopeLongName=" + telescopeLongName + ", telescopeAperture="
				+ telescopeAperture + ", telescopeFocalLength=" + telescopeFocalLength + ", camera=" + camera
				+ ", horizPixelSize=" + horizPixelSize + ", vertPixelSize=" + vertPixelSize + ", horizArraySize="
				+ horizArraySize + ", vertArraySize=" + vertArraySize + ", darkCurrent=" + darkCurrent
				+ ", readoutNoise=" + readoutNoise + "]";
	}
	
	
	
}
