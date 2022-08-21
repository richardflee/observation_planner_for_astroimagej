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
	private double nominalMagValue;
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
	
	// flag enable / disable catalog ui buttons
	// private boolean isTableData;


//	/**
//	 * Default constructor resets filter and sort controls to default values;
//	 * current target spinner value is unchanged
//	 */
//	public CatalogSettings() {
//		resetSettingsToDefaults(null);
//		this.sortDistanceValue = true;
//		this.sortDeltaMagValue = false;
//	}

	/**
	 * One parameter constructor specifies new target spinner value; resets filter
	 * and sort controls to default values;
	 * @param targetMag
	 *     target spinner setting
	 */
	public CatalogSettings(Double targetMag) {
		resetSettingsToDefaults(targetMag);
	}

	// resets sort & filter defaults; optional update target mag data
	// target mag, dss and sort order controls excluded
	private void resetSettingsToDefaults(Double targetMag) {
		// number observations / APASS
		nObsValue = 1;

		// mag limtis and flag
		nominalMagValue = (targetMag != null) ? targetMag : CatalogSettings.DEFAULT_TGT_MAG;
		upperLimitValue = 0.0;
		lowerLimitValue = 0.0;
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
		return nominalMagValue;
	}

	public void setNominalMagValue(double targetMagValue) {
		this.nominalMagValue = targetMagValue;
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

	public String getTotalRecordsValue() {
		return Integer.toString(totalRecordsValue);
	}

	public void setTotalRecordsValue(int nTotalRecords) {
		this.totalRecordsValue = Math.max(nTotalRecords, 0);
	}

	public int getFilteredRecordsValue() {
		return filteredRecordsValue;
	}

	public void setFilteredRecordsValue(int nFilteredRecords) {
		this.filteredRecordsValue = Math.max(nFilteredRecords, 0);
	}

	public int getSelectedRecordsValue() {
		return selectedRecordsValue;
	}

	public void setSelectedRecordsValue(int selectedRecordsValue) {
		this.selectedRecordsValue = selectedRecordsValue;
	}

	
	@Override
	public String toString() {
		return "CatalogSettings [\napplyLimitsValue=" + applyLimitsValue + ", \nsortDistanceValue=" + sortDistanceValue
				+ ", \nsortDeltaMagValue=" + sortDeltaMagValue + ", \nsaveDssValue=" + saveDssValue + ", \nnominalMagValue="
				+ nominalMagValue + ", \nupperLimitValue=" + upperLimitValue + ", \nlowerLimitValue=" + lowerLimitValue
				+ ", \nnObsValue=" + nObsValue + ", \ntotalRecordsValue=" + totalRecordsValue + ", \nfilteredRecordsValue="
				+ filteredRecordsValue + ", \nselectedRecordsValue=" + selectedRecordsValue + "]";
	}

	public static void main(String[] args) {
		
		var s0 = new CatalogSettings(null);
		System.out.println(s0.toString());

//		double targetMag = 12.3;
//		CatalogSettings set0 = new CatalogSettings(targetMag);
//
//		set0.srtUpperLimitValue(1.2);
//		System.out.println(String.format("Target value %.3f", targetMag));
//
//		System.out.println("Spinner value:");
//		set0.setLowerLimitValue(0.00);
////		System.out.println(String.format("Upper limit spinner = 1.2, upper label: %s", set0.getUpperLabelValue()));
////		System.out.println(String.format("Lower limit spinner = 0.00, lower label: %s", set0.getLowerLabelValue()));
//
//		System.out.println("\nCopy constructor:");
//		CatalogSettings set1 = new CatalogSettings(set0);
//		set1.srtUpperLimitValue(0.00);
//		set1.setLowerLimitValue(-1.3);
////		System.out.println(String.format("Upper limit spinner = 0.0, upper label: %s", set1.getUpperLabelValue()));
////		System.out.println(String.format("Lower limit spinner = -1.3, lower label: %s", set1.getLowerLabelValue()));
//		System.out.println(String.format("Confirm equal target values = 12.3 %.1f, %b", set1.getNominalMagValue(),
//				set0.getNominalMagValue() == set1.getNominalMagValue()));
//		
//		System.out.println(set0.toString());

	}

}

/**
// * Copy constructor
// * @param settings
// *     source object to copy
// */
//public CatalogSettings(CatalogSettings settings) {
//	// target mag value
//	this.nominalMagValue = settings.getNominalMagValue();
//
//	// mag limits
//	this.upperLimitValue = settings.getUpperLimitValue();
//	this.lowerLimitValue = settings.getLowerLimitValue();
//	this.applyLimitsValue = settings.isApplyLimitsValue();
//
//	// sort option
//	this.sortDistanceValue = settings.isSortDistanceValue();
//	this.sortDeltaMagValue = settings.isSortDeltaMagValue();
//
//	// number observations / APASS
//	this.nObsValue = settings.getnObsValue();
//
//	// record totals
//	this.totalRecordsValue = Integer.valueOf(settings.getTotalRecordsValue());
//	this.filteredRecordsValue = Integer.valueOf(settings.getFilteredRecordsValue());
//	this.selectedRecordsValue = Integer.valueOf(settings.getSelectedRecordsValue());
//
//	// DSS flag
//	// this.isSaveDssValue = settings.isSaveDssCheckBoxValue();
//
//}
