package com.github.richardflee.astroimagej.data_objects;


/**
 * This class encapsulates catalog ui sort and filter controls methods and data
 */
public class CatalogSettings {
	// boolean options
	private boolean applyLimitsValue;
	private boolean sortDistanceValue;
	private boolean sortDeltaMagValue;
	private boolean saveDssValue;
	
	// nominal mag + spinner limits
	private double nominalValue;
	private double upperLimitValue;
	private double lowerLimitValue;

	// number observations / APASS
	private int nObsValue;

	// record totals
	private int totalRecordsValue;
	private int filteredRecordsValue;
	private int selectedRecordsValue;

	public static final double DEFAULT_TGT_MAG = 10.0;
	public static final double MIN_LIMIT_MAG = 0.01;
	
	
	/**
	 * One parameter constructor specifies new target spinner value; resets filter
	 * and sort controls to default values;
	 * @param targetMag
	 *     target spinner setting
	 */
	public CatalogSettings() {
		this.nominalValue = CatalogSettings.DEFAULT_TGT_MAG;
		setDefaultSettings();
		this.sortDistanceValue = true;
		this.sortDeltaMagValue = false;
	}
	
	
	// resets filter defaults and state checkboxes to selected
	// nominal mag & current sort selection are unchanged
	public void setDefaultSettings() {
		
		// number observations / APASS
		nObsValue = 1;

		// mag limtis and flag
		upperLimitValue = 0.0;
		lowerLimitValue = 0.0;
		
		// check-box flags
		applyLimitsValue = true;
		saveDssValue = true;

		// record totals
		totalRecordsValue = 0;
		filteredRecordsValue = 0;
		selectedRecordsValue = 0;
	}
	
	public static boolean isUpperLimitDisabled(CatalogSettings settings) {
		var limitValue = settings.getUpperLimitValue();
		return (Math.abs(limitValue) < CatalogSettings.MIN_LIMIT_MAG);
	}
	
	public static boolean isLowerLimitDisabled(CatalogSettings settings) {
		var limitValue = settings.getLowerLimitValue();
		return (Math.abs(limitValue) < CatalogSettings.MIN_LIMIT_MAG);
	}
	
	// auto getter - setters
	public double getUpperLimitValue() {
		return upperLimitValue;
	}
	

	public void setUpperLimitValue(double upperLimitValue) {
		var limitValue = roundLimit(upperLimitValue);
		this.upperLimitValue = Math.max(limitValue, 0.0);
	}

	public void setLowerLimitValue(double lowerLimitValue) {
		var limitValue = roundLimit(lowerLimitValue);
		this.lowerLimitValue = Math.min(limitValue, 0.0);
	}
	
	public double getNominalMagValue() {
		return nominalValue;
	}

	public void setNominalMagValue(double nominalMagValue) {
		this.nominalValue = nominalMagValue;
	}

	public double getLowerLimitValue() {
		return lowerLimitValue;
	}


	public boolean isApplyLimitsValue() {
		return applyLimitsValue;
	}

	public void setApplyLimitsValue(boolean isApplyLimitsValue) {
		this.applyLimitsValue = isApplyLimitsValue;
	}

	public boolean isSortDistanceValue() {
		return sortDistanceValue;
	}


	public boolean isSortDeltaMagValue() {
		return sortDeltaMagValue;
	}


	public void setSortDistanceValue(boolean distanceValue) {
		this.sortDistanceValue = distanceValue;
		this.sortDeltaMagValue = ! distanceValue;		
	}

	public int getnObsValue() {
		return nObsValue;
	}

	public void setnObsValue(int nObsValue) {
		this.nObsValue = nObsValue;
	}

	public int getTotalRecordsValue() {
		return totalRecordsValue;
	}


	public int getFilteredRecordsValue() {
		return filteredRecordsValue;
	}
	
	private double roundLimit(double limitValue) {		
		return 1.0 * Math.round(limitValue * 10) / 10.0;
	}

	// custom setter
	public void setFilteredRecordsValue(int nFilteredRecords) {
		this.filteredRecordsValue = Math.max(nFilteredRecords, 0);
	}

	public int getSelectedRecordsValue() {
		return selectedRecordsValue;
	}

	// custom setter
	public void setSelectedRecordsValue(int selectedRecordsValue) {
		this.selectedRecordsValue = Math.max(selectedRecordsValue, 0);
	}

	
	
	public boolean isSaveDssValue() {
		return saveDssValue;
	}


	public void setSaveDssValue(boolean saveDssValue) {
		this.saveDssValue = saveDssValue;
	}


	@Override
	public String toString() {
		return "CatalogSettings [\napplyLimitsValue=" + applyLimitsValue + ", \nsortDistanceValue=" + sortDistanceValue
				+ ", \nsortDeltaMagValue=" + sortDeltaMagValue + ", \nsaveDssValue=" + saveDssValue + ", \nnominalMagValue="
				+ nominalValue + ", \nupperLimitValue=" + upperLimitValue + ", \nlowerLimitValue=" + lowerLimitValue
				+ ", \nnObsValue=" + nObsValue + ", \ntotalRecordsValue=" + totalRecordsValue + ", \nfilteredRecordsValue="
				+ filteredRecordsValue + ", \nselectedRecordsValue=" + selectedRecordsValue + "]";
	}

	public static void main(String[] args) {
		var s0 = new CatalogSettings();
		System.out.println(s0.toString());
		
		var x = 0.09;
		System.out.println((1.0 * Math.round(x * 10) / 10.0));
		
	}

}
