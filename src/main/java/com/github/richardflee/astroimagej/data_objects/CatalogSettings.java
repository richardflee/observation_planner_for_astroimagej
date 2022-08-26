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
	private double nominalValue = 10.0;
	private double upperLimitValue;
	private double lowerLimitValue;

	// number observations / APASS
	private int nObsValue;

	// record totals
	private int totalRecordsValue;
	private int filteredRecordsValue;
	private int selectedRecordsValue;

	// default target magnitude value
	public static final double DEFAULT_TGT_MAG = 10.0;
	
	
	/**
	 * One parameter constructor specifies new target spinner value; resets filter
	 * and sort controls to default values;
	 * @param targetMag
	 *     target spinner setting
	 */
	public CatalogSettings() {
		setDefaultSettings();
	}
	
	
	// resets sort & filter defaults; optional update target mag data
	// target mag, dss and sort order controls excluded
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
	

	// auto getter - setters
	public double getUpperLimitValue() {
		return upperLimitValue;
	}

	public void srtUpperLimitValue(double upperLimitValue) {
		this.upperLimitValue = upperLimitValue;
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

	public void setLowerLimitValue(double lowerLimitValue) {
		this.lowerLimitValue = lowerLimitValue;
	}

	public boolean isApplyLimitsValue() {
		return applyLimitsValue;
	}

	public void setApplyLimitsValue(boolean isMagLimitsValue) {
		this.applyLimitsValue = isMagLimitsValue;
	}

	public boolean isSortDistanceValue() {
		return sortDistanceValue;
	}

	public void setSortDistanceValue(boolean distanceValue) {
		this.sortDistanceValue = distanceValue;
	}

	public boolean isSortDeltaMagValue() {
		return sortDeltaMagValue;
	}

	public void setSortDeltaMagValue(boolean deltaMagValue) {
		this.sortDeltaMagValue = deltaMagValue;
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

	// custom setter
	public void setTotalRecordsValue(int nTotalRecords) {
		this.totalRecordsValue = Math.max(nTotalRecords, 0);
	}

	public int getFilteredRecordsValue() {
		return filteredRecordsValue;
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
	}

}
