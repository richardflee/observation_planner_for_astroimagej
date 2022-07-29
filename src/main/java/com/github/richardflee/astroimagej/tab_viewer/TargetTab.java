package com.github.richardflee.astroimagej.tab_viewer;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.github.richardflee.astroimagej.data_objects.CatalogQuery;
import com.github.richardflee.astroimagej.enums.CatalogsEnum;
import com.github.richardflee.astroimagej.listeners.CatalogDataListener;
import com.github.richardflee.astroimagej.utils.AstroCoords;
import com.github.richardflee.astroimagej.utils.InputsVerifier;

public class TargetTab implements CatalogDataListener {
	
	private JTextField objectIdText;
	private JTextField raText;
	private JTextField decText;
	private JTextField fovText;
	private JTextField magLimitText;
	
	private JComboBox catalogCombo;
	private JComboBox filterCombo;
	
	private JButton save;
	private JButton runQuey;
	
	private ViewerUI viewer;
	private VerifyTextFields verifier;
	
	
	public TargetTab(ViewerUI viewer) {
		
		this.viewer = viewer;
		this.verifier = new VerifyTextFields();
		
		this.objectIdText = viewer.getObjectIdField();
		this.raText = viewer.getRaField();
		this.decText = viewer.getDecField();
		this.fovText = viewer.getFovField();
		this.magLimitText = viewer.getMagLimitField();
		
		this.catalogCombo = viewer.getCatalogCombo();
		this.filterCombo = viewer.getFilterCombo();
		
		this.save = viewer.getSaveQueryButton();
		this.runQuey = viewer.getRunSimbadButton();	
		
		setupActionListeners();
	}
	
	
	private void setupActionListeners() {
		
		objectIdText.addActionListener(e -> verifier.verifyObjectId());
		raText.addActionListener(e -> System.out.println("ratext"));
		decText.addActionListener(e -> System.out.println("dectext"));
		
		fovText.addActionListener(e -> System.out.println("fov"));
		magLimitText.addActionListener(e -> System.out.println("mags"));		
	}
	
	
//	/*
//	 * verifies user input objectId format
//	 * 
//	 * @param input objectId in alphanumeric format
//	 */
//	private boolean verifyObjectId() {
//		boolean isValid = InputsVerifier.isValidObjectId(objectIdText.getText());
//		if (isValid) {
//			this.objectIdText.setForeground(Color.BLACK);
//			this.raText.requestFocus();
//		} else {
//			this.objectIdText.setForeground(Color.RED);
//			this.objectIdText.requestFocus();
//		}
//		return isValid;
//	}


	@Override
	public void setQueryData(CatalogQuery query) {
		this.objectIdText.setText(query.getObjectId());
		this.raText.setText(AstroCoords.raHrToRaHms(query.getRaHr()));
		this.decText.setText(AstroCoords.decDegToDecDms(query.getDecDeg()));
		
		this.fovText.setText(String.format("%.1f", query.getFovAmin()));
		this.magLimitText.setText(String.format("%.1f", query.getMagLimit()));

		// selected catalog
		CatalogsEnum en = query.getCatalogType();
		String selectedCatalog = en.toString().toUpperCase();
		catalogCombo.setSelectedItem(selectedCatalog);

		// populate filterCombo
		String selectedFilter = query.getMagBand();
		populateFilterCombo(selectedCatalog, selectedFilter);
		
	}


	@Override
	public CatalogQuery getQueryData() {
//		// return null query if invalid input
//		if (!verifyAllInputs()) {
//			return null;
//		}
		
		// copy text field data
		CatalogQuery query = new CatalogQuery();
		
		query.setObjectId(this.objectIdText.getText());
		query.setRaHr(AstroCoords.raHmsToRaHr(this.raText.getText()));
		query.setDecDeg(AstroCoords.decDmsToDecDeg(this.decText.getText()));
		
		query.setFovAmin(Double.valueOf(this.fovText.getText()));
		query.setMagLimit(Double.valueOf(this.magLimitText.getText()));

		// copy combo data
		query.setCatalogType(CatalogsEnum.getEnum(catalogCombo.getSelectedItem().toString()));
		query.setMagBand(filterCombo.getSelectedItem().toString());

		return query;
	}
	
	
	
	/*
	 * Clears current and imports new filter list in the filter selection combo
	 * 
	 * @param selectedCatalog uppercase name of current catalog selected in catalog
	 * combo
	 * 
	 * @param selectedFilter filter name of current filter selection in filter combo
	 */
	private void populateFilterCombo(String selectedCatalog, String selectedFilter) {
		// clear filters list
		filterCombo.removeAllItems();

		// retrieve catalog from enum
		CatalogsEnum en = CatalogsEnum.valueOf(selectedCatalog);

		// import filter list for selected catalog & select specified filter
		en.getMagBands().forEach(item -> filterCombo.addItem(item));
		filterCombo.setSelectedItem(selectedFilter);
	}
	
	private class VerifyTextFields {
		
		/*
		 * verifies user input objectId format
		 * 
		 * @param input objectId in alphanumeric format
		 */
		private boolean verifyObjectId() {
			boolean isValid = InputsVerifier.isValidObjectId(objectIdText.getText());
			if (isValid) {
				objectIdText.setForeground(Color.BLACK);
				raText.requestFocus();
			} else {
				objectIdText.setForeground(Color.RED);
				objectIdText.requestFocus();
			}
			return isValid;
		}
		
	}
	

}
