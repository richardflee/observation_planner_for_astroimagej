package com.github.richardflee.astroimagej.fileio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.github.richardflee.astroimagej.collections.QueryResult;
import com.github.richardflee.astroimagej.data_objects.CatalogQuery;
import com.github.richardflee.astroimagej.data_objects.FieldObject;
import com.github.richardflee.astroimagej.enums.RaDecFilesEnum;

/**
 * Imports radec file data and populates catlog table and creates new query
 * object. Comment lines have a leading char "#".Radec is split
 *  into 4 sections, split by text lines mapped to RaDecFilesEnum enums. 
 * 
 * <p> Block 1: data = astroimagej radec format data
 * to draw apertures on plate solve images </p>
 * 
 * <p>Block 2: data lines encoding catalog table data</p> 
 * 
 * <p>Block 3: data line encoding  catalog query data</p> 
 * 
 * <p>Block 4: text line somprising vsp chart chart uri for current query</p>
 */
public class RaDecFileReader extends RaDecFileBase {
	
	private String radecFilepath = "";
	private List<String> radecLines = null;
	
	// foCollecition
	// url
	//query
	public QueryResult getRaDecResult() {
		var result = new QueryResult();
		var radecQuery = getRaDecQuery();
		result.setQuery(radecQuery);
		
		var fos = getRaDecFieldObjects();
		result.addFieldObjects(fos);
		
		// extract chart uri
		var chartUri = getChartUriLine();
		result.setChartUri(chartUri);
		
		return result;
	}
	
	public double getRaDecNominalMag() {
		var nominalMag = getRaDecTarget().getMag();
		return nominalMag;
	}
	
	
	public boolean isRaDecFileSelected() {
		var jfc = radecFileChooser();
		
		// sets file object to selected text file or null if Cancel
		File file = null;			
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			file = jfc.getSelectedFile();
			loadRaDecLines(file);
			setRadecFilepath(file.getAbsolutePath());			
		}
		return file != null;
	}
	
	/*
	 * Compiles CatalogQuery object from data line embedded in radec line array
	 * 
	 * @param radecLines text array mapped from selected radec file
	 * @return radec file catalog query object
	 */
	private CatalogQuery getRaDecQuery() {
		int matchIndex = matchIndex(RaDecFilesEnum.QUERY_DATA_LINE);
		var dataLine = radecLines.get(matchIndex + 2);		
		return CatalogQuery.fromFormattedString(dataLine);
	}
	
	/*
	 * Finds line of target object data embedded in radec line array
	 * 
	 * @param radecLines text array mapped from selected radec file
	 * @return target object data line
	 */
	private FieldObject getRaDecTarget() {
		int matchIndex = matchIndex(RaDecFilesEnum.DATA_TABLE_START);
		var dataLine = radecLines.get(matchIndex + 2);
		var target = compileFieldObject(dataLine);
		return target;
	}
	
	/*
	 * Compiles list of reference field objects data lines embedded in radec line array
	 * 
	 * @param radecLines text array mapped from selected radec file
	 * @return radec file table lines comprising field object data
	 */
	private List<FieldObject> getRaDecFieldObjects() {
		List<String> tableLines = extractTableLines();
		List<FieldObject> fos = tableLines.stream()
				.map(p -> compileFieldObject(p))
				.collect(Collectors.toList());
		return fos;
	}
	
	
	/*
	 * Finds line array of field object data embedded in radec line array
	 * 
	 * @param radecLines text array mapped from selected radec file
	 * @return text array comprising field object data
	 */
	private List<String> extractTableLines() {
		// start index 3 row below DATA_TABLE_START 
		var matchIndex = matchIndex(RaDecFilesEnum.DATA_TABLE_START);
		var startIndex = matchIndex + 3;
		
		// end index same row as DATA_TABLE_END
		matchIndex = matchIndex(RaDecFilesEnum.DATA_TABLE_END);
		var endIndex = matchIndex;
		return radecLines.subList(startIndex, endIndex);
	}

	
	/*
	 * Finds chart uri text embedded in radec line array
	 * 
	 * @param radecLines text array mapped from selected radec file
	 * @return chart uri data
	 */
	private String getChartUriLine() {
		int matchIndex = matchIndex(RaDecFilesEnum.CHART_URI_LINE);
		// data 1 row below marker
		return radecLines.get(matchIndex + 1);
	}
	
	
	/*
	 * Finds first line in line array matching enum text
	 * 
	 *  Example: en=RaDecFilesEnum.DATA_TABLE_START matches #*** DATA_TABLE_START 
	 * 
	 * @param lines text array contents of selected rade file
	 * @param en enum specifying line ot match
	 * @return matching index in lines array; -1 if no match found 
	 */
	private int matchIndex(RaDecFilesEnum en) {
		var enStr = en.toString();		
		Integer matchIndex = this.radecLines.stream()
				.filter(p -> p.contains(enStr))
				.map(p -> radecLines.indexOf(p)).findFirst()
                .orElse(-1);		
		return matchIndex;
	}
	
	
	/*
	 * Converts user selected radec text file to text list
	 * @param file reference to selected file
	 * @return text file contents copied to String array
	 */
	private void loadRaDecLines(File file) {
		List<String> lines = new ArrayList<String>();
		try (Stream<String> stream = Files.lines(file.toPath())) {
			lines = stream.collect(Collectors.toList());
		} catch (IOException e) {
			String message = String.format("Error reading radec file:\n %s", this.radecFilepath);
			JOptionPane.showMessageDialog(null, message);
		}
		this.radecLines = lines;
	}
	
	/*
	 * Opens file dialog configured for radec folder and file type
	 * @return file reference to selected file, or null if Cancel pressed
	 */
	private JFileChooser radecFileChooser() {
		// configures file chooser dialog start folder and file type
		File file = new File(System.getProperty(RaDecFileBase.USER_DIR), RaDecFileBase.RADEC_DIR);
		JFileChooser jfc = new JFileChooser(file);
		jfc.setDialogTitle("Select radec file");
		jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("RaDec files (*.txt)", "txt");
		jfc.addChoosableFileFilter(filter);		
		return jfc;
	}
	
	public String getRadecFilepath() {
		return radecFilepath;
	}

	public void setRadecFilepath(String radecFilepath) {
		this.radecFilepath = radecFilepath;
	}
	
	public static void main(String[] args) {		
		var fr = new RaDecFileReader();
		
		if (! fr.isRaDecFileSelected()) {
			System.exit(0);	
			System.out.println("cancel");
		}
		System.out.println(fr.getRadecFilepath());
		
		var result = fr.getRaDecResult();
		System.out.println(result.getQuery().toString());
		System.out.println(result.getChartUri());
		System.out.println();
		System.out.println(result.getFieldObjectsCollection().toString());
	}
}
