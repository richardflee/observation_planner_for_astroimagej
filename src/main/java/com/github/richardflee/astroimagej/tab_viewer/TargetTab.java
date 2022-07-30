package com.github.richardflee.astroimagej.tab_viewer;

import java.awt.Color;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.github.richardflee.astroimagej.data_objects.CatalogQuery;
import com.github.richardflee.astroimagej.enums.CatalogsEnum;
import com.github.richardflee.astroimagej.fileio.AijPropsReadWriter;
import com.github.richardflee.astroimagej.fileio.TargetTabFileProps;
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
	private String selectedCatalog;

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
		this.catalogCombo.addItem(CatalogsEnum.APASS.toString());
		this.catalogCombo.addItem(CatalogsEnum.VSP.toString());
		this.selectedCatalog = CatalogsEnum.APASS.toString();
		this.catalogCombo.setSelectedItem(this.selectedCatalog);

		this.filterCombo = viewer.getFilterCombo();
		populateFilterCombo(null);

		this.save = viewer.getSaveQueryButton();
		this.runQuey = viewer.getRunSimbadButton();

		setupActionListeners();
	}

	private void setupActionListeners() {

		objectIdText.addActionListener(e -> verifier.verifyObjectId());
		raText.addActionListener(e -> verifier.verifyRaHms());
		decText.addActionListener(e -> verifier.verifyDecDms());

		fovText.addActionListener(e -> verifier.verifyFov());
		magLimitText.addActionListener(e -> verifier.verifyMagLimit());

		// handles change in selected catalog (VSP, APASS ..)
		catalogCombo.addItemListener(ie -> selectCatalog(ie));
		save.addActionListener(e -> {
			TargetTabFileProps.writeProperties(this.getQueryData());
			JOptionPane.showMessageDialog(null,  AijPropsReadWriter.savedFileMessage());
			
		});
	}

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
		populateFilterCombo(selectedFilter);

	}

	@Override
	public CatalogQuery getQueryData() {
		// // return null query if invalid input
		// if (!verifyAllInputs()) {
		// return null;
		// }

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
	 * @param selectedCatalog uppercase name of current catalog selected in catalog
	 * combo
	 * @param selectedFilter filter name of current filter selection in filter combo
	 */
	private void populateFilterCombo(String selectedFilter) {
		// clear filters list
		filterCombo.removeAllItems();

		// retrieve catalog from enum
		CatalogsEnum en = CatalogsEnum.valueOf(this.selectedCatalog);

		// import filter list for selected catalog & select specified filter
		en.getMagBands().forEach(item -> filterCombo.addItem(item));

		if (selectedFilter == null) {
			filterCombo.setSelectedIndex(0);
		} else {
			filterCombo.setSelectedItem(selectedFilter);
		}
	}

	/*
	 * Handles change in catalogCombo selection. Clears existing filterCombo list
	 * and loads a new list based on CatalogType enum
	 * @param ie event indicates an item was selected in the catalogCombo control
	 */
	private void selectCatalog(ItemEvent ie) {
		if (ie.getStateChange() == ItemEvent.SELECTED) {
			this.selectedCatalog = catalogCombo.getSelectedItem().toString();
			populateFilterCombo(null);
		}
	}

	private class VerifyTextFields {

		/*
		 * verifies user input objectId format
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

		/*
		 * Verifies user input RA format and in range
		 * @param input RA in sexagesimal format
		 */
		private boolean verifyRaHms() {
			boolean isValid = InputsVerifier.isValidRaCoords(raText.getText());
			if (isValid) {
				raText.setForeground(Color.BLACK);
				decText.requestFocus();
			} else {
				raText.setForeground(Color.RED);
				raText.requestFocus();
			}
			return isValid;
		}

		/*
		 * Verifies user input dec format and in range
		 * @param input RA in sexagesimal format
		 */
		private boolean verifyDecDms() {
			boolean isValid = InputsVerifier.isValidDecCoords(decText.getText());
			if (isValid) {
				decText.setForeground(Color.BLACK);
				fovText.requestFocus();
			} else {
				decText.setForeground(Color.RED);
				decText.requestFocus();
			}
			return isValid;
		}

		/*
		 * Verifies user input FOV format and in range
		 * @param input FOV in numeric format
		 */
		private boolean verifyFov() {
			boolean isValid = InputsVerifier.isValidFov(fovText.getText());
			if (isValid) {
				fovText.setForeground(Color.BLACK);
				magLimitText.requestFocus();
			} else {
				fovText.setForeground(Color.RED);
				fovText.requestFocus();
			}
			return isValid;
		}

		/*
		 * Verifies user input magLimit format and in range
		 * @param input magLimit in numeric format
		 */
		private boolean verifyMagLimit() {
			boolean isValid = InputsVerifier.isValidMagLimit(magLimitText.getText());
			if (isValid) {
				magLimitText.setForeground(Color.BLACK);
				objectIdText.requestFocus();
			} else {
				magLimitText.setForeground(Color.RED);
				magLimitText.requestFocus();
			}
			return isValid;
		}

		private boolean verifyTargetTabInputs() {
			var isValid = verifyObjectId() && verifyRaHms() && verifyFov() && verifyFov() && verifyMagLimit();
			if (!isValid) {
				var message = "At least one data entry is invalid";
				JOptionPane.showMessageDialog(null, message);
			}
			return isValid;
		}

	}

}