package com.github.richardflee.astroimagej.collections;

import java.util.ArrayList;
import java.util.List;

import com.github.richardflee.astroimagej.data_objects.CatalogQuery;
import com.github.richardflee.astroimagej.data_objects.CatalogSettings;
import com.github.richardflee.astroimagej.data_objects.FieldObject;
import com.github.richardflee.astroimagej.fileio.CatalogTabPropertiesFile;

/**
 * Objects of this class encapsulate results of queries of on-line astronomical
 * databases in a list of FieldObjects <p> Target star data is the first list
 * item, identified "T01". The remainder comprises a list of reference star
 * objects where selected records are identified as "C02", "C03" .. in sort
 * order </p> <p>Reference star records are ordered either by radial distance
 * from the target star (in arcmin) or by the absolute difference in magnitude
 * relative to user-input target star magnitude.</p> <p><b>Handling target
 * magnitude values:</b></p> <p><i>Start:</i> reads properties file value and
 * updates catalog ui target spinner</p> <p><b>Save Query Data</b> saves current
 * catalog ui target spinner value to properties file</p> <p><b>Run Catalog
 * Query, Update Table</b> applies catalog ui spinner value</p> <p><b>Import
 * RaDec File</b> applies radec file value</p> <p><b>Save RaDecFile</b> saves
 * catalog table value
 */
public class QueryResult {

	private String CHART_URI = "https://app.aavso.org/vsp/chart/X26836EQ.png?type=chart";
	private String chartUri = CHART_URI;

	// query settings associated with current QueryResult
	private CatalogQuery query = null;

	// list of target and reference field objects
	private FieldObjectsCollection foCollection = null;
	
	public QueryResult() {
		this.foCollection = new FieldObjectsCollection();		
	}
	
	public QueryResult(CatalogQuery query, List<FieldObject> fieldObjects) {
		this.query = query;
		this.foCollection = new FieldObjectsCollection();		
		this.addFieldObjects(fieldObjects);		
	}
	
	private void addFieldObjects(List<FieldObject> fieldObjects) {
		this.foCollection.addFieldObjects(fieldObjects);		
	}
	
	public void clearFieldObjects() {
		this.foCollection.getFieldObjects().clear();
		System.out.println(foCollection.getFieldObjects().size());
	}
	
	public List<FieldObject> getTableRows(CatalogSettings settings) {
		var nominalMag = settings.getNominalMagValue();
		var target = FieldObject.compileTargetFromQuery(this.query, nominalMag);
		foCollection.update(target);
		
		var sortByDistance = CatalogTabPropertiesFile.isSortByDistance();
		this.sortCatalogTable(sortByDistance);
		this.applyFilters(settings);		
		
		List<FieldObject> tableRows = new ArrayList<>();
		for (var fo : foCollection.getFieldObjects()) {
			tableRows.add(fo);
		}
		tableRows.add(0, target);
		return tableRows;
	}
	
	public void setChartUri(String chartUri) {
	if (chartUri == null) {
		return;
	}

	// strip leading "#" from radec chart uri
	chartUri = chartUri.startsWith("#") ? chartUri.substring(1) : chartUri;

	// strip any text from url including and beyond "?" char
	chartUri = (chartUri.contains("?")) ? chartUri.split("\\?")[0] : chartUri;
	this.chartUri = chartUri;
	}
	
	
	public String getChartUri() {
		return chartUri;
	}
	
//	private boolean isSortedByDeltaMag() {
//		return ! this.foCollection.isSortedByDeltaMag();
//	}
	
	public boolean isSortedByDistance() {
		return (! this.foCollection.isSortedByDeltaMag()); 
	}

	private void sortCatalogTable(boolean sortByDistance) {
		// var nominalMag = settings.getNominalMagValue();
		//var target = FieldObject.compileTargetFromQuery(this.query, nominalMag);
		if (sortByDistance) {
			foCollection.sortByDistance();
		} else {
			foCollection.sortByDeltaMag();			
		}		
	}
	
	private void applyFilters(CatalogSettings settings) {
		foCollection.filterByNumberObservations(settings.getnObsValue());
		foCollection.filterByMagLimits(settings);
	}
	

	public void setQuery(CatalogQuery query) {
		this.query = query;
	}


	public FieldObjectsCollection getFieldObjectsCollection() {
		return foCollection;
	}

	public void setFieldObjectsCollection(FieldObjectsCollection foCollection) {
		this.foCollection = foCollection;
	}

	public CatalogQuery getQuery() {
		return query;
	}
	
	

	@Override
	public String toString() {
		return foCollection.toString();
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	
//	
//	
//	
//	/**
//	 * Constructor for QueryResult objects created by query of on-line astronomical
//	 * database or importing radec dataset. <p> A QueryResult object comprises the
//	 * database query object and a list of FieldObjects initialised with a single
//	 * target object. </p> <p> Target fields are extracted from the CatalogQuery
//	 * object</p>
//	 * @param query
//	 *     parameters for on-line database query
//	 */
//	public QueryResult(CatalogQuery query, CatalogSettings settings) {
//		// copy query
//		this.query = new CatalogQuery(query);
//
//		// creates target field object from query and saves target 1st item in
//		// FieldObjects array
//		fieldObjects = new ArrayList<>();
//		FieldObject targetObject = createTargetObject(query);
//		fieldObjects.add(targetObject);
//
//		// initialise default catalog settings
//		if (settings == null) {
//			this.settings = new CatalogSettings();
//		} else {
//			setSettings(settings);
//		}
//
//		// chart X26835JN: wasp12/06:30:32.80/29:40:20.3/60' fov/maglimit=16 /
//		// N-E=up-left
//		setChartUri(CHART_URI);
//	}
//
//	// import list field objects and update delta mag & radeSep fields
//	/**
//	 * Imports full list of field objects downloaded from on-line catalog query or
//	 * imported from radec file. <p>Computes differences in magnitude and radial
//	 * separation to target object</p>
//	 * @param fieldObjects
//	 */
//	// public void appendFieldObjects(List<FieldObject> fieldObjects) {
//	// // append reference field objects to target object
//	// this.fieldObjects.addAll(fieldObjects);
//	//
//	// // update fields relative to target: delta mag & distance
//	// for (FieldObject fo : this.fieldObjects) {
//	// fo.computeRadSepAmin(getTargetObject());
//	// fo.computeDeltaMag(getTargetObject().getMag());
//	// }
//	// setTotalsAndButtons();
//	// }
//
//	/**
//	 * CalaogSettings setter, copies settings object and copies settings target mag
//	 * spinner value to target object.
//	 * @param settings
//	 *     CatalogSettings object
//	 */
//	public void setSettings(CatalogSettings settings) {
//		setTotalsAndButtons();
//	}
//
//	/**
//	 * Imports CatalogSettings data from radec file; copies radec target mag value
//	 * to settings mag spinner
//	 * @param settings
//	 *     CatalogSettings object
//	 */
//	public void importRadecSettings(CatalogSettings settings) {
//		// this.settings = new CatalogSettings(settings);
//		setTotalsAndButtons();
//	}
//
//	/**
//	 * Applies observation number and magnitude selection filters to catalog table
//	 * data
//	 */
//	public void applySelectedFilters() {
//		// nObs filter
//		int numberObs = this.settings.getnObsValue();
//		for (FieldObject fo : this.fieldObjects) {
//			boolean isAccepted = ((fo.getnObs() >= numberObs));
//			fo.setAccepted(isAccepted);
//		}
//		// current target mag
//		double targetMag = settings.getNominalMagValue();
//
//		// magband filter
//		// upper and lower mag range settings; 0.01 disables range check
//		double upperLimit = settings.getUpperLimitValue();
//		double lowerLimit = settings.getLowerLimitValue();
//
//		// disables respective range check if magnitude is less than 0.01
//		boolean disableUpperLimit = Math.abs(upperLimit) < 0.01;
//		boolean disableLowerLimit = Math.abs(lowerLimit) < 0.01;
//
//		// apply mag limits filter
//		if (settings.isApplyLimitsValue() == true) {
//			for (FieldObject fo : fieldObjects) {
//				// Initialise with result of nobs filter
//				boolean isAccepted = fo.isAccepted();
//				isAccepted = isAccepted && (disableUpperLimit || (fo.getMag() <= upperLimit + targetMag));
//				isAccepted = isAccepted && (disableLowerLimit || (fo.getMag() >= lowerLimit + targetMag));
//				fo.setAccepted(isAccepted);
//
//			}
//		}
//		setTotalsAndButtons();
//	}
//
//	/**
//	 * Compiles list of accepted and selected field objects to export to radec file
//	 * <p>Note: default sort order by radial distance to target</p>
//	 * @return filtered list of user-selected records
//	 */
//	public List<FieldObject> getSelectedRecords() {
//		// filter user selected records from accepted field objects
//		return this.getFieldObjects().stream().filter(p -> p.isAccepted()).filter(p -> p.isSelected())
//				.collect(Collectors.toList());
//	}
//
//	/**
//	 * Strips leading '#' fom radec chart uri & removes any text including and after
//	 * embedded '?' char
//	 * @param chartUri
//	 *     pre-processed vsp chart address
//	 */
//	
//
//	private FieldObject createTargetObject(CatalogQuery query) {
//		// initialise target from query params
//		String objectId = query.getObjectId();
//		double raHr = query.getRaHr();
//		double decDeg = query.getDecDeg();
//		double targetMag = 10.000;
//		double targetMagErr = 0.00;
//		FieldObject targetObject = new FieldObject(objectId, raHr, decDeg, targetMag, targetMagErr);
//
//		// set defaults
//		// targetObject.setTarget(true);
//		targetObject.setSelected(true);
//		targetObject.setAccepted(true);
//		targetObject.setApertureId("T01");
//
//		targetObject.setnObs(1);
//
//		return targetObject;
//	}
//
//	/*
//	 * Updates total and filtered (accepted) labels and flag indicating whether is
//	 * catalog table is populated
//	 */
//	private void setTotalsAndButtons() {
//		settings.setTotalRecordsValue(getRecordsTotal());
//		settings.setFilteredRecordsValue(getAcceptedTotal());
//		settings.setSelectedRecordsValue(getSelectedTotal());
//
//		// flags catalog table is populated
//		// settings.setTableData(getRecordsTotal() > 0);
//	}
//
//	// getters / setters
//
//	public CatalogQuery getQuery() {
//		return query;
//	}
//
//	public void setQuery(CatalogQuery query) {
//		this.query = query;
//	}
//
//	public CatalogSettings getSettings() {
//		return this.settings;
//	}
//
//	public List<FieldObject> getFieldObjects() {
//		return fieldObjects;
//	}
//
//	public void setFieldObject(FieldObject fieldObject) {
//		fieldObjects.add(fieldObject);
//	}
//
//	/**
//	 * Total number of reference field objects, excludes target object
//	 * @return total reference field objects
//	 */
//	public int getRecordsTotal() {
//		return fieldObjects.size() - 1;
//	}
//
//	/**
//	 * Number of reference field objects within filter limits, excludes target
//	 * object
//	 * @return total accepted field objects
//	 */
//	public int getAcceptedTotal() {
//		long count = getFieldObjects().stream().filter(p -> p.isAccepted()).count() - 1;
//		return Math.toIntExact(count);
//	}
//
//	/**
//	 * Number of user selected reference field objects, excludes target object
//	 * @return total selected field objects
//	 */
//	public int getSelectedTotal() {
//		long count = getFieldObjects().stream().filter(p -> p.isAccepted()).filter(p -> p.isSelected()).count() - 1;
//		return Math.toIntExact(count);
//	}
//
//
//
//	public String getChartUri() {
//		return chartUri;
//	}
//
//	@Override
//	public String toString() {
//		String s = this.query.toString() + "\n";
//		s += this.settings.toString() + "\n\n";
//		for (FieldObject fo : this.getFieldObjects()) {
//			s += fo.toString() + "\n";
//		}
//		s += String.format("QueryResult: %s\n", s);
//		s += String.format("Chart uri: %s", chartUri);
//		return s;
//	}
//
//	public static void main(String[] args) {
//
//		// result.getFieldObjects().stream().forEach(System.out::println);;
//		// double tgtMag0 = 12.345;
//
//		// // build default catalog result object, init new result object
//		// CatalogQuery query = new CatalogQuery();
//		// QueryResult result = new QueryResult(query, null);
//		//
//		// // build default CatalogSettngs object, assign to result_settings
//		// CatalogSettings settings = new CatalogSettings(tgtMag0);
//		// result.setSettings(settings);
//		//
//		// // compile ref object list from apass file
//		// ApassFileReader fr = new ApassFileReader();
//		// List<FieldObject> referenceObjects = fr.runQueryFromFile(query);
//		// result.appendFieldObjects(referenceObjects);
//		//
//		// // vsp chart uri
//		// String chartUri = "https://app.aavso.org/vsp/chart/X26835JN.png?type=chart";
//		// result.setChartUri(chartUri);
//		//
//		// System.out.println("\n TARGET MAG
//		// *****************************************************");
//		// // set target mag test
//		// FieldObject tgt = result.getTargetObject();
//		// System.out.println("input Settings Target");
//		// System.out.println(
//		// String.format("%7.3f %7.3f %9.3f", tgtMag0,
//		// settings.getTargetMagSpinnerValue(), tgt.getMag()));
//		//
//		// double tgtMag1 = 9.876;
//		// settings = new CatalogSettings(tgtMag1);
//		// result.setSettings(settings);
//		// System.out.println(
//		// String.format("%7.3f %7.3f %9.3f", tgtMag1,
//		// settings.getTargetMagSpinnerValue(), tgt.getMag()));
//		//
//		// FieldObject fo2 = result.getFieldObjects().get(2);
//		// FieldObject fo7 = result.getFieldObjects().get(7);
//		// double rad0 = 0.0;
//		// double rad2 = 1.0424;
//		// double rad7 = 2.1266;
//		//
//		// // radial distance test
//		// System.out.println("\nTest radial separation");
//		// System.out.println("raHr decDeg radSep Trig");
//		// System.out.println(
//		// String.format("%.7f %.6f %.4f %.4f", tgt.getRaHr(), tgt.getDecDeg(),
//		// tgt.getRadSepAmin(), rad0));
//		// System.out.println(
//		// String.format("%.7f %.6f %.4f %.4f", fo2.getRaHr(), fo2.getDecDeg(),
//		// fo2.getRadSepAmin(), rad2));
//		// System.out.println(
//		// String.format("%.7f %.6f %.4f %.4f", fo7.getRaHr(), fo7.getDecDeg(),
//		// fo7.getRadSepAmin(), rad7));
//		//
//		// // delta mag test
//		// System.out.println("\nTest delta mag");
//		// System.out.println("Mag Delta Sums");
//		// System.out.println(
//		// String.format("%7.3f %7.3f %7.3f", tgt.getMag(), tgt.getDeltaMag(),
//		// tgt.getMag() - tgtMag0));
//		// System.out.println(
//		// String.format("%7.3f %7.3f %7.3f", fo2.getMag(), fo2.getDeltaMag(),
//		// fo2.getMag() - tgtMag0));
//		// System.out.println(
//		// String.format("%7.3f %7.3f %7.3f", fo7.getMag(), fo7.getDeltaMag(),
//		// fo7.getMag() - tgtMag0));
//		//
//		// // sort option radial distance
//		// System.out.println("\n SORT BY DISTANCE
//		// *****************************************************");
//		// result.getSettings().setDistanceRadioButtonValue(true);
//		// result.getSettings().setDeltaMagRadioButtonValue(false);
//		// result.applySelectedSort();
//		//
//		// // distance sort test
//		// boolean sorted = true;
//		// for (int idx = 1; idx < result.getFieldObjects().size(); idx++) {
//		// sorted = sorted && (result.getFieldObjects().get(idx).getRadSepAmin() >
//		// result.getFieldObjects()
//		// .get(idx - 1).getRadSepAmin());
//		// }
//		// System.out.println(String.format("Sorted by radial distance: %b", sorted));
//		//
//		// // mag delta sort test
//		// sorted = true;
//		// for (int idx = 1; idx < result.getFieldObjects().size(); idx++) {
//		// double item1 = Math.abs(result.getFieldObjects().get(idx).getDeltaMag());
//		// double item0 = Math.abs(result.getFieldObjects().get(idx - 1).getDeltaMag());
//		// sorted = sorted && (item1 >= item0);
//		// }
//		// System.out.println(String.format("Sorted by delta mag: %b", sorted));
//		//
//		// System.out.println("\n SORT BY DELTA MAG
//		// *****************************************************");
//		// result.getSettings().setDistanceRadioButtonValue(false);
//		// result.getSettings().setDeltaMagRadioButtonValue(true);
//		// result.applySelectedSort();
//		//
//		// // distance sort test
//		// sorted = true;
//		// for (int idx = 1; idx < result.getFieldObjects().size(); idx++) {
//		// sorted = sorted && (result.getFieldObjects().get(idx).getRadSepAmin() >
//		// result.getFieldObjects()
//		// .get(idx - 1).getRadSepAmin());
//		// }
//		// System.out.println(String.format("Sorted by radial distance: %b", sorted));
//		//
//		// // mag delta sort test
//		// sorted = true;
//		// for (int idx = 1; idx < result.getFieldObjects().size(); idx++) {
//		// double item1 = Math.abs(result.getFieldObjects().get(idx).getDeltaMag());
//		// double item0 = Math.abs(result.getFieldObjects().get(idx - 1).getDeltaMag());
//		// sorted = sorted && (item1 >= item0);
//		// }
//		// System.out.println(String.format("Sorted by delta mag: %b", sorted));
//		//
//		// System.out.println("\n APPLY NOBS FILTER
//		// *****************************************************");
//		//
//		// System.out.println(("Nobs No records"));
//		// for (int idx = 1; idx <= 5; idx++) {
//		// settings.setnObsSpinnerValue(idx);
//		// result.setSettings(settings);
//		// result.applySelectedFilters();
//		// int total = result.getAcceptedTotal();
//		// System.out.println(String.format("%d %d", idx, total));
//		// }
//		//
//		// System.out.println("\n APPLY MAGBAND FILTER
//		// *****************************************************");
//		// System.out.println(("Nobs Flag Upper Nominal Lower ULimit LLimit NRecs"));
//		// // array filter settings nObs, flag, upper & lower limits
//		// int[] nObs = { 1, 2, 3, 3, 3, 3 };
//		// boolean[] isChecked = { false, true, true, true, true, true };
//		// double[] upper = { 1.00, 0.00, 0.00, 1.50, 0.00, 4.50 };
//		// double[] lower = { -1.00, 0.00, 0.00, 0.00, -1.50, -4.50 };
//		// double nominal = 14.500;
//		// int nRecs;
//		//
//		// settings = new CatalogSettings(nominal);
//		// for (int idx = 0; idx < nObs.length; idx++) {
//		// settings.setnObsSpinnerValue(nObs[idx]);
//		// settings.setMagLimitsCheckBoxValue(isChecked[idx]);
//		// settings.setUpperLimitSpinnerValue(upper[idx]);
//		// settings.setLowerLimitSpinnerValue(lower[idx]);
//		// result.setSettings(settings);
//		// result.applySelectedFilters();
//		// String upperLabel = result.getSettings().getUpperLabelValue();
//		// String lowerLabel = result.getSettings().getLowerLabelValue();
//		// nRecs = result.getAcceptedTotal();
//		// System.out.println((String.format("%d %b %.3f %.3f %.3f %s %s %d", nObs[idx],
//		// isChecked[idx], upper[idx], nominal, lower[idx], upperLabel, lowerLabel,
//		// nRecs)));
//		// }
//		//
//		// System.out.println("\n RESULT TOSTRING
//		// **********************************************************");
//		//
//		// System.out.println(result.toString());
//		//
//		// System.out.println("\n TWO PARAM CONSTRUCTOR
//		// ******************************************************");
//		//
//		// // two param constructor no field objects
//		// QueryResult result2 = new QueryResult(query, settings);
//		// System.out.println(result2.toString());
//
//	}
//}
//
///**
// * Sorts catalog table data in ascending order by radial separation or absolute
// * difference between reference and target mag
// */
//// public void applySelectedSort() {
//// // sort by distance option
//// if (this.settings.isDistanceRadioButtonValue() == true) {
//// this.fieldObjects =
//// this.fieldObjects.stream().sorted(Comparator.comparingDouble(p ->
//// p.getRadSepAmin()))
//// .collect(Collectors.toList());
//// // sort by delta mag option
//// } else if (this.settings.isDeltaMagRadioButtonValue() == true) {
//// this.fieldObjects = this.fieldObjects.stream()
//// .sorted(Comparator.comparingDouble(p ->
//// Math.abs(p.getDeltaMag()))).collect(Collectors.toList());
//// }
//// setTotalsAndButtons();
//// }
