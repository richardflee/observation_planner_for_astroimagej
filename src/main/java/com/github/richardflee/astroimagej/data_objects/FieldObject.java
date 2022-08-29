package com.github.richardflee.astroimagej.data_objects;


import com.github.richardflee.astroimagej.utils.AstroCoords;

/**
 * Single record resulting from an on-line catalog database query. Instances of this class
 * encapsulate coordinate and magnitude data for a single Comparison or
 * Reference star.
 */
public class FieldObject extends BaseFieldObject {
	
	private double mag;
	private double magErr;
	private Integer nObs;
	
	private double radSepAmin;
	private double deltaMag;

	private String apertureId; 
	private boolean selected;
	private boolean filtered;
	
	/**
	 * No arg constructor, default Sirius parameters
	 */	
	public FieldObject() {
		this("sirius", 
				AstroCoords.raHmsToRaHr("06:45:08.917"), 
				AstroCoords.decDmsToDecDeg("-16:42:58.02"), 
				-1.46, 0.02);
	}
	
	/**
	 * Four parameter constructor
	 * 
	 * @param objectId object identifier
	 * @param raHr J2000 RA in hour (0 to 24 hr)
	 * @param decDeg J2000 Dec in degree (±90°)
	 * @param mag catalog magnitude for current filter band
	 * @param magErr estimate uncertainty in mag value
	 */
	public FieldObject(String objectId, double raHr, double decDeg, double mag, double magErr) {
		super(objectId, raHr, decDeg);
		this.mag = mag;
		this.magErr = magErr;
		this.radSepAmin = 0.0;
		this.deltaMag = 0.0;
		this.nObs = 1;
		this.apertureId = "Cnn"; 
		this.filtered = true;
		this.selected = true;
	}

	
	public static FieldObject compileTargetFromQuery(CatalogQuery query, CatalogSettings settings) {
		var objectId = query.getObjectId();
		var raHr = query.getRaHr();
		var decDeg = query.getDecDeg();
		var nominalMag = settings.getNominalMagValue();
		var fo = new FieldObject(objectId, raHr, decDeg, nominalMag, 0.0);
		fo.setApertureId("T01");
		return fo;
	}
	
//	public FieldObject copy(FieldObject fieldObject) {
//		var objectId = fieldObject.getObjectId();
//		var raHr = fieldObject.getRaHr();
//		var decDeg = fieldObject.getDecDeg();
//		var mag = fieldObject.getMag();
//		var magErr = fieldObject.getMagErr();
//		
//		var fo = new FieldObject(objectId, raHr, decDeg, mag, magErr);		
//		fo.nObs = fieldObject.getnObs();
//		fo.apertureId = fieldObject.getApertureId();
//		fo.filtered = fieldObject.isFiltered();
//		fo.selected = fieldObject.isSelected();
//		return fo;
//	}
//	
	
	public FieldObject copy() {
		var objectId = this.getObjectId();
		var raHr = this.getRaHr();
		var decDeg = this.getDecDeg();
		var mag = this.getMag();
		var magErr = this.getMagErr();
		
		var fo = new FieldObject(objectId, raHr, decDeg, mag, magErr);		
		fo.nObs = this.getnObs();
		fo.apertureId = this.getApertureId();
		fo.filtered = this.isFiltered();
		fo.selected = this.isSelected();
		return fo;
	}
	
	
	/**
	 * Computes angular distance in arcmin between current object and the target object
	 * Eqn: A = acos(sin(dec)*sin(dec0)+cos(dec)*cos(dec0)*cos(ra-ra0))
	 * where (ra0, dec0) and (ra, dec) are astro coordinates for target & this object in DEGREEs
	 * 
	 * @param target target FieldObject 
	 */
	public double getRadSepAmin() {
		return this.radSepAmin;
	}
	
	public void setRadSepAmin(FieldObject target) {
		this.radSepAmin = computeRadSep(target);
	}
	
	private double computeRadSep(FieldObject target) {
		double ra = Math.toRadians(this.raHr * 15.0);
		double ra0 = Math.toRadians(target.getRaHr() * 15.0);

		double dec = Math.toRadians(this.decDeg);
		double dec0 = Math.toRadians(target.getDecDeg());

		double cosA = Math.sin(dec) * Math.sin(dec0) + Math.cos(dec) * Math.cos(dec0) * Math.cos(ra - ra0);
		return Math.toDegrees(Math.acos(cosA)) * 60.0;
	}
	
	public double getDeltaMag() {
		return this.deltaMag;		
	}
	
	public void setDeltaMag(FieldObject target) {
		this.deltaMag = this.mag - target.getMag();
	}
	
	// auto-generated getters, setters and toString methods
	public String getApertureId() {
		return apertureId;
	}

	public void setApertureId(String apertureId) {
		this.apertureId = apertureId;
	}

	public Integer getnObs() {
		return nObs;
	}

	public void setnObs(Integer nObs) {
		this.nObs = nObs;
	}

	public String getObjectId() {
		return objectId;
	}

	public double getRaHr() {
		return raHr;
	}

	public void setRaHr(double raHr) {
		this.raHr = raHr;
	}

	public double getDecDeg() {
		return decDeg;
	}

	public void setDecDeg(double decDeg) {
		this.decDeg = decDeg;
	}

	public double getMag() {
		return mag;
	}


	public void setMag(double mag) {
		this.mag = mag;
	}

	public double getMagErr() {
		return magErr;
	}

	public void setMagErr(double magErr) {
		this.magErr = magErr;
	}
	
	public boolean isSelected() {
		return selected;
	}


	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isFiltered() {
		return filtered;
	}


	public void setFiltered(boolean filtered) {
		this.filtered = filtered;
	}

	
	
	@Override
	public String toString() {
		return "FieldObject [mag=" + mag + ", magErr=" + magErr + ", nObs=" + nObs + ", radSepAmin=" + radSepAmin
				+ ", deltaMag=" + deltaMag + ", apertureId=" + apertureId + ", selected=" + selected + ", filtered="
				+ filtered + ", objectId=" + objectId + ", raHr=" + raHr + ", decDeg=" + decDeg + "]";
	}

	public static void main(String[] args) {
		// tests coords-based id for unamed apass objects
		FieldObject foID = new FieldObject(null, 6.50862013, 29.688453, 14.716, 0.09);
		String testId = "06303103+29411843";		
		System.out.println(testId);
		System.out.println(foID.getObjectId());		
		
		// sirius ref, wasp12 tgt
		FieldObject target_wasp12 = new FieldObject("wasp12", 6.509110, 29.672295, 12.345, 0.23);
		var sirius = new FieldObject();		
		System.out.println(target_wasp12.toString());
		System.out.println(sirius.toString());
		System.out.println();
		
		var sep = sirius.getRadSepAmin();
		var diff = sirius.getDeltaMag();
		System.out.println(String.format("Compare ref & computed Radial sep in amin = %.2f, %.2f", 2792.31, sep));
		System.out.println(String.format("Compare ref & computed delta mag = %.2f, %.2f", -1.46 - 12.345, diff));
		System.out.println();
		
		// compile from query, default = wasp 12 params
		var query = new CatalogQuery();
		System.out.println(query.toString());
	}
		
}



