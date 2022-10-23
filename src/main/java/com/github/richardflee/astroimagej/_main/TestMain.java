package com.github.richardflee.astroimagej._main;

import javax.swing.JOptionPane;

import com.github.richardflee.astroimagej.catalogs.CatalogFactory;
import com.github.richardflee.astroimagej.collections.QueryResult;
import com.github.richardflee.astroimagej.data_objects.CatalogSettings;
import com.github.richardflee.astroimagej.fileio.CatalogTabPropertiesFile;
import com.github.richardflee.astroimagej.fileio.DssFitsWriter;
import com.github.richardflee.astroimagej.fileio.RaDecFileReader;
import com.github.richardflee.astroimagej.fileio.TargetTabPropertiesFile;

public class TestMain {

	private QueryResult result = null;

	public void doRunCatalogQuery() {
		var query = TargetTabPropertiesFile.readProperties();
		var catalog = CatalogFactory.createCatalog(query.getCatalogType());
		var fieldObjects = catalog.runQuery(query);

		this.result = new QueryResult(query, fieldObjects);
	// 	var nominalMag = CatalogTabPropertiesFile.readNominalMagProperties();
		// updateTable(settings);
	}

	public void downLoadDssFits(boolean isDownloadDssFile) {
		if (isDownloadDssFile) {
			var query = TargetTabPropertiesFile.readProperties();
			var message = DssFitsWriter.downloadDssFits(query);
			JOptionPane.showMessageDialog(null, message);
		}
	}

	public void doImportRaDecfile() {
		var fr = new RaDecFileReader();
		if (!fr.isRaDecFileSelected()) {
			return;
		}

		this.result = fr.getRaDecResult();
		var isSortedByDistance = result.isSortedByDistance();
		CatalogTabPropertiesFile.writeProperties(isSortedByDistance);
		
		var nominalMag = fr.getRaDecNominalMag();
		 CatalogTabPropertiesFile.writeProperties(nominalMag);
		
		var settings = new CatalogSettings(nominalMag);
//		settings.setSortDistanceValue(isSortedByDistance);
		
		temp(settings);

		// tabListener.importRaDecSettings(nominalMag, isSortedByDeltaMag);
		// updateCatalogTableRecords(settings);

	}
	
	private void temp(CatalogSettings settings) {
		var tableRows = this.result.getTableRows(settings);
		System.out.println(tableRows.toString());
		
	}

	private QueryResult getResult() {
		return result;
	}

	public static void main(String[] args) {

		var tester = new TestMain();

		var nominalMag = CatalogTabPropertiesFile.readNominalMag();
		// System.out.println(nominalMag);

		// run query
		tester.doRunCatalogQuery();
		// System.out.println(tester.getResult().toString());

		// dss download
		tester.downLoadDssFits(false);

		// import radec - distance
		tester.doImportRaDecfile();
		System.out.println("\nimport radec distance");
		nominalMag = CatalogTabPropertiesFile.readNominalMag();
		System.out.println(nominalMag);
		System.out.println(String.format("sorted by distance: %b", tester.getResult().isSortedByDistance()));
		//System.out.println(tester.getResult().toString());
		
		
//
//		// import radec - mag
//		tester.doImportRaDecfile();
//		System.out.println("\nimport radec mag");
//		nominalMag = CatalogTabPropertiesFile.readNominalMagProperties();
//		System.out.println(nominalMag);
//		System.out.println(String.format("sorted by distance: %b", tester.getResult().isSortedByDistance()));
//		//System.out.println(tester.getResult().toString());
//		
		
		
		

	}

}
