package com.github.richardflee.astroimagej.fileio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import com.github.richardflee.astroimagej.collections.QueryResult;
import com.github.richardflee.astroimagej.data_objects.CatalogQuery;
import com.github.richardflee.astroimagej.data_objects.CatalogSettings;
import com.github.richardflee.astroimagej.data_objects.FieldObject;
import com.github.richardflee.astroimagej.enums.RaDecFilesEnum;
import com.github.richardflee.astroimagej.utils.AstroCoords;

/**
 * Writes catalog table data to radec file format: 
 * 
 * <p> Block 1: data = astroimagej radec format data
 * to draw apertures on plate solve images </p>
 * 
 * <p>Block 2: data lines encoding catalog table data</p> 
 * 
 * <p>Block 3: data line encoding  catalog query data</p> 
 * 
 * <p>Block 4: text line comprises vsp chart chart uri for current query</p>
 */
public class RaDecFileWriter extends RaDecFileBase {

	// flag data block
	private boolean isDataBlock = true;

	public RaDecFileWriter() {
		super();
		// compile data lines first
		isDataBlock = true;
		
		// first use, create new radec folder in user.dir path
		File dir = new File(System.getProperty(RaDecFileBase.USER_DIR), RaDecFileBase.RADEC_DIR);
		dir.mkdirs();
	}

	/**
	 * Writes radec file to import apertures into astroimagej with filename format
	 * [objectid].[magband].radec.txt <p> Ref:
	 * https://www.astro.louisville.edu/software/astroimagej/ </p>
	 * @param selectedList
	 *     list of target and selected reference objects in user-specified sort
	 *     order
	 * @param query
	 *     parameters of on-line database query
	 */
	public void writeRaDecFile(QueryResult result, CatalogSettings settings) {
		// converts query data to string list to write to radec file
		List<String> lines = compileRaDecList(result, settings);

		// write new radec file and update message
		File file = getFile(result.getQuery());
		String filePath = file.toString();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
			for (String line : lines) {
				bw.append(line);
			}
		} catch (IOException e) {
			var message = String.format("ERROR: Error saving radec file: %s", filePath);
			JOptionPane.showMessageDialog(null,  message);
		}
		var message = String.format("Saved radec file: %s", filePath);
		JOptionPane.showMessageDialog(null,  message);		
	}

	/*
	 * Compiles radec filename pattern <object_id>.<filter>.<fov_amin>.radec.txt
	 * @param query on-line query parameters
	 * @return formatted filename <objectid>.<magband>.<fov_amin>.radec.txt
	 */
	private String compileFilename(CatalogQuery query) {
		String filename = String.join(".", Arrays.asList(query.getObjectId(), query.getMagBand(),
				String.format("%03d", query.getFovAmin().intValue()), "radec.txt"));
		return filename.replace(" ", "_");
	}

	/*
	 * Compiles file object to radec file path, ./astroimagej/radec. <p>Creates new
	 * folders as necessary</p>
	 * @param query on-line query parameters
	 * @return file object with path: ./astroimagej/radec/<filename>
	 */
	private File getFile(CatalogQuery query) {
		// path to radec file, create new folder if necessary
		File dir = new File(System.getProperty(RaDecFileBase.USER_DIR), RaDecFileBase.RADEC_DIR);
		File file = new File(dir, compileFilename(query));
		return file;
	}

	/*
	 * Compiles a single data line in astroimagej radec format from a FieldObject
	 * @param fo current target or reference field object
	 * @return single data record ordered: RA, Dec, RefStar, Centroid, Mag <p>If
	 * current parameter is target object, indicate Ref = 0, mag = 99.99, otherwise
	 * ref = 1 and mag = catalog mag for this filter band</p>
	 */
	private String getFieldLine(FieldObject fo) {
		String line = AstroCoords.raHrToRaHms(fo.getRaHr()) + ",";
		line += AstroCoords.decDegToDecDms(fo.getDecDeg()) + ",";
		if (isDataBlock) {
			line += fo.isTarget() ? "0,1,99.99" : String.format("1,1,%.3f", fo.getMag());
			isDataBlock = false;
		} else {
			line += String.format("1,1,%.3f", fo.getMag());
		}
		return line;
	}

	/*
	 * Compiles list of strings to write to radec file. List comprises 3 blocks
	 * separated by single char '#'. Comment lines start with '#' <p>Block 1: data
	 * lines: astroimagej radec format</p> <p>Block 2: comment lines: catalog table
	 * data</p> <p>Block 3: comment line: query data</p>
	 * @param selectedList list of FieldObjects to convert to write to radec file
	 * @param query catalog query data for this data set
	 * @return data and comment line string array
	 */
	private List<String> compileRaDecList(QueryResult result, CatalogSettings settings) {
		var target = FieldObject.compileTargetFromQuery(result.getQuery(), settings);
		
		List<FieldObject> filteredList = result.getFieldObjectsCollection().getFilteredFieldObjects();
		filteredList.add(0, target);
		
		List<FieldObject> selectedList = result.getFieldObjectsCollection().getSelectedFieldObjects();
		selectedList.add(0, target);

		// astrominagej radec data block
		// append accepted AND selected records
		List<String> lines = new ArrayList<>();
		lines.add("#RA, Dec, RefStar, Centroid, Mag\n");
		for (FieldObject fo : selectedList) {
			String line = getFieldLine(fo) + "\n";
			lines.add(line);
		}
		

		// table block start
		// append accepted records, includes selected & de-selected table records
		lines.add(RaDecFilesEnum.DATA_TABLE_START.getStrVal());
		lines.add("#Ap, ObjectId, RA, Dec, Mag, MagErr, MagDelta, RadSep, Nobs\n");
		for (FieldObject fo : filteredList) {
			lines.add(compileTableLine(fo));
		}
		// table block end
		lines.add(RaDecFilesEnum.DATA_TABLE_END.getStrVal());

		// query line
		lines.add(RaDecFilesEnum.QUERY_DATA_LINE.getStrVal());
		lines.add(result.getQuery().toFormattedString()[0]); // query item names
		lines.add(result.getQuery().toFormattedString()[1]); // query data

		// chart line
		lines.add(RaDecFilesEnum.CHART_URI_LINE.getStrVal());
		String chartUri = result.getChartUri();
		lines.add(String.format("#%s\n", chartUri));
		return lines;
	}
}
