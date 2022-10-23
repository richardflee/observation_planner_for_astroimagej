/*
 * Created by JFormDesigner on Sun Jul 17 05:56:34 BST 2022
 */

package com.github.richardflee.astroimagej.tab_viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import com.github.richardflee.astroimagej.data_objects.ObservationSite;
import com.github.richardflee.astroimagej.fileio.TargetTabPropertiesFile;

/**
 * @author Richard Lee
 */
public class ViewerUi extends JFrame {
	private static final long serialVersionUID = 1L;
	
//	private DatePicker datePicker = null;
	
	// private ObservationSite site = null;
	
	private ObserverTab observer_tab = null;
	private TargetTab target_tab = null;
	private CatalogsTab catalogs_tab = null;
	
	public static final int TARGET_TAB_IDX = 0;
	public static final int CATALOGS_TAB_IDX = 1;
	public static final int OBSERVER_TAB_IDX = 2;
	
	
	public ViewerUi(ObservationSite site) { //, CatalogTableModel tableModel) {
		// this.site = site;
		
		initComponents();
		this.observer_tab = new ObserverTab(this, site);
		this.target_tab = new TargetTab(this, site);
		this.catalogs_tab = new CatalogsTab(this); //, tableModel);
		
		this.aijTabbedPane.addChangeListener(e -> {
			switch (aijTabbedPane.getSelectedIndex()) {
			case TARGET_TAB_IDX:
				var query = TargetTabPropertiesFile.readProperties();
				target_tab.applyQueryData(query);
				target_tab.doSaveQueryData(query);
				new SimbadPanelData(this).setSimbadData(null);
				break;
			case CATALOGS_TAB_IDX:
				catalogs_tab.updateQueryPanel(this);
				break;
				
			case OBSERVER_TAB_IDX:
				break;
			}
		});
	}
	
	
//	public ObservationSite getSite() {
//		return site;
//	}

	public JTextField getHorizPixelSizeAsecField() {
		return horizPixelSizeAsecField;
	}

	public JTextField getHorizFovAminField() {
		return horizFovAminField;
	}

	public JTextField getVertPixelSizeAsecField() {
		return vertPixelSizeAsecField;
	}

	public JTextField getCodeField() {
		return codeField;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public JTextField getTeleShortField() {
		return teleShortField;
	}

	public JTextField getTeleFullField() {
		return teleFullField;
	}

	public JTextField getApertureField() {
		return apertureField;
	}

	public JTextField getFocalLengthField() {
		return focalLengthField;
	}

	public JTextField getCameraField() {
		return cameraField;
	}

	public JTextField getHorizPixelSizeUmField() {
		return horizPixelSizeUmField;
	}

	public JTextField getVertPixelSizeUmField() {
		return vertPixelSizeUmField;
	}

	public JTextField getHorizArraySizeField() {
		return horizArraySizeField;
	}

	public JTextField getVertArraySizeField() {
		return vertArraySizeField;
	}

	public JButton getUpdateParamsButton() {
		return updateParamsButton;
	}

	public JButton getSaveObserverButton() {
		return saveObserverButton;
	}

	public JTextField getLatitudeField() {
		return latitudeField;
	}

	public JTextField getNorthSouthField() {
		return northSouthField;
	}

	public JTextField getLongitudeField() {
		return longitudeText;
	}

	public JTextField getEastWestField() {
		return eastWestField;
	}

	public JTextField getAltitudeField() {
		return altitudeField;
	}

	public JTextField getUtcOffsetField() {
		return utcOffsetField;
	}

	public JTextField getLongitudeText() {
		return longitudeText;
	}

	public JTextField getGainField() {
		return gainField;
	}

	public JTextField getReadoutNoiseField() {
		return readoutNoiseField;
	}

	public JButton getRunSimbadButton() {
		return runSimbadButton;
	}

	public JButton getSaveQueryButton() {
		return saveQueryButton;
	}

	public JTextField getObjectIdField() {
		return objectIdField;
	}

	public JTextField getRaField() {
		return raField;
	}

	public JTextField getDecField() {
		return decField;
	}

	public JTextField getFovField() {
		return fovField;
	}

	public JTextField getMagLimitField() {
		return magLimitField;
	}

	public JComboBox<String> getCatalogCombo() {
		return catalogCombo;
	}

	public JComboBox<String> getFilterCombo() {
		return filterCombo;
	}

	public JLabel getSimbadRaLabel() {
		return simbadRaLabel;
	}

	public JLabel getSimbadDecLabel() {
		return simbadDecLabel;
	}

	public JLabel getSimbadMagBLabel() {
		return simbadMagBLabel;
	}

	public JLabel getSimbadMagVLabel() {
		return simbadMagVLabel;
	}

	public JLabel getSimbadMagRLabel() {
		return simbadMagRLabel;
	}

	public JLabel getSimbadMagILabel() {
		return simbadMagILabel;
	}

	public JLabel getSimbadIdLabel() {
		return simbadIdLabel;
	}

	public JPanel getDatePickerPanel() {
		return datePickerPanel;
	}

	public JPanel getAltitudePlotPanel() {
		return altitudePlotPanel;
	}

	public JTextField getSunSetField() {
		return sunSetField;
	}

	public JTextField getTwilightEndField() {
		return twilightEndField;
	}

	public JTextField getTwilightStartField() {
		return twilightStartField;
	}

	public JTextField getSunRiseField() {
		return sunRiseField;
	}

	public JPanel getCatalogTablePanel() {
		return catalogTablePanel;
	}

	

	public ObserverTab getObserver_tab() {
		return observer_tab;
	}


	public TargetTab getTarget_tab() {
		return target_tab;
	}


	public CatalogsTab getCatalogs_tab() {
		return catalogs_tab;
	}

	public JScrollPane getTableScrollPane() {
		return tableScrollPane;
	}

	public JRadioButton getDistanceRadioButton() {
		return distanceRadioButton;
	}

	public JRadioButton getDeltaMagRadioButton() {
		return deltaMagRadioButton;
	}

	public JSpinner getUpperLimitSpinner() {
		return upperLimitSpinner;
	}

	public JSpinner getLowerLimitSpinner() {
		return lowerLimitSpinner;
	}

	public JSpinner getTargetMagSpinner() {
		return targetMagSpinner;
	}

	public JCheckBox getIsMagLimitsCheckBox() {
		return isMagLimitsCheckBox;
	}

	public JSpinner getNObsSpinner() {
		return nObsSpinner;
	}

	public JCheckBox getSaveDssCheckBox() {
		return saveDssCheckBox;
	}

	public JLabel getTotalRecordsField() {
		return totalRecordsField;
	}

	public JLabel getFilteredRecordsField() {
		return filteredRecordsField;
	}

	public JLabel getSelectedRecordsField() {
		return selectedRecordsField;
	}

	public JButton getCatalogQueryButton() {
		return catalogQueryButton;
	}

	public JButton getImportRaDecButton() {
		return importRaDecButton;
	}

	public JButton getSaveRaDecButton() {
		return saveRaDecButton;
	}

	public JButton getUpdateButton() {
		return updateButton;
	}

	public JButton getClearButton() {
		return clearButton;
	}

	public JLabel getUpperLabel() {
		return upperLabel;
	}

	public JLabel getLowerLabel() {
		return lowerLabel;
	}

	public JLabel getQueryIdLabel() {
		return queryIdLabel;
	}

	public JLabel getQueryRaDecLabel() {
		return queryRaDecLabel;
	}

	public JLabel getQueryCatFilterLabel() {
		return queryCatFilterLabel;
	}

	public JTextField getVertFovAminField() {
		return vertFovAminField;
	}

	public JTextField getDarkCurrentField() {
		return darkCurrentField;
	}


	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner non-commercial license
		aijTabbedPane = new JTabbedPane();
		targetTab = new JPanel();
		targetPanel = new JPanel();
		targetTabPanel = new JPanel();
		panel3 = new JPanel();
		label1 = new JLabel();
		objectIdField = new JTextField();
		label2 = new JLabel();
		raField = new JTextField();
		label3 = new JLabel();
		decField = new JTextField();
		label4 = new JLabel();
		fovField = new JTextField();
		label5 = new JLabel();
		magLimitField = new JTextField();
		label7 = new JLabel();
		label8 = new JLabel();
		label9 = new JLabel();
		label10 = new JLabel();
		catalogCombo = new JComboBox<>();
		label11 = new JLabel();
		filterCombo = new JComboBox<>();
		label12 = new JLabel();
		panel4 = new JPanel();
		idLabel = new JLabel();
		raLabel = new JLabel();
		decLabel = new JLabel();
		simbadIdLabel = new JLabel();
		simbadRaLabel = new JLabel();
		simbadDecLabel = new JLabel();
		idLabel2 = new JLabel();
		idLabel3 = new JLabel();
		idLabel4 = new JLabel();
		idLabel5 = new JLabel();
		simbadMagBLabel = new JLabel();
		simbadMagVLabel = new JLabel();
		simbadMagRLabel = new JLabel();
		simbadMagILabel = new JLabel();
		altitudePlotPanel = new JPanel();
		solarPanel = new JPanel();
		runSimbadButton = new JButton();
		saveQueryButton = new JButton();
		datePickerPanel = new JPanel();
		label6 = new JLabel();
		panel11 = new JPanel();
		label33 = new JLabel();
		label34 = new JLabel();
		sunSetField = new JTextField();
		twilightEndField = new JTextField();
		label35 = new JLabel();
		twilightStartField = new JTextField();
		label36 = new JLabel();
		sunRiseField = new JTextField();
		catalogsTab = new JPanel();
		catalogsPanel = new JPanel();
		catalogSettingsPanel = new JPanel();
		querySummaryPanel = new JPanel();
		queryIdLabel = new JLabel();
		queryRaDecLabel = new JLabel();
		queryCatFilterLabel = new JLabel();
		sortByPanel = new JPanel();
		distanceRadioButton = new JRadioButton();
		deltaMagRadioButton = new JRadioButton();
		slectionFiltersPanel = new JPanel();
		label38 = new JLabel();
		label39 = new JLabel();
		label40 = new JLabel();
		upperLimitSpinner = new JSpinner();
		lowerLimitSpinner = new JSpinner();
		targetMagSpinner = new JSpinner();
		isMagLimitsCheckBox = new JCheckBox();
		upperLabel = new JLabel();
		label41 = new JLabel();
		lowerLabel = new JLabel();
		label37 = new JLabel();
		nObsSpinner = new JSpinner();
		saveDssCheckBox = new JCheckBox();
		panel1 = new JPanel();
		label42 = new JLabel();
		label43 = new JLabel();
		label44 = new JLabel();
		totalRecordsField = new JLabel();
		filteredRecordsField = new JLabel();
		selectedRecordsField = new JLabel();
		catalogTablePanel = new JPanel();
		tableScrollPane = new JScrollPane();
		solarPanel2 = new JPanel();
		catalogQueryButton = new JButton();
		importRaDecButton = new JButton();
		saveRaDecButton = new JButton();
		updateButton = new JButton();
		clearButton = new JButton();
		observerTab = new JPanel();
		observerPanel = new JPanel();
		locationPanel = new JPanel();
		label14 = new JLabel();
		latitudeField = new JTextField();
		northSouthField = new JTextField();
		label15 = new JLabel();
		longitudeText = new JTextField();
		eastWestField = new JTextField();
		label16 = new JLabel();
		altitudeField = new JTextField();
		label17 = new JLabel();
		utcOffsetField = new JTextField();
		systemParamsPanel = new JPanel();
		label18 = new JLabel();
		horizPixelSizeAsecField = new JTextField();
		label19 = new JLabel();
		horizFovAminField = new JTextField();
		vertPixelSizeAsecField = new JTextField();
		vertFovAminField = new JTextField();
		observerNotesPanel = new JPanel();
		scrollPane2 = new JScrollPane();
		equipmentPanel2 = new JPanel();
		label20 = new JLabel();
		codeField = new JTextField();
		label21 = new JLabel();
		nameField = new JTextField();
		label22 = new JLabel();
		teleShortField = new JTextField();
		label23 = new JLabel();
		teleFullField = new JTextField();
		label24 = new JLabel();
		apertureField = new JTextField();
		label25 = new JLabel();
		focalLengthField = new JTextField();
		label26 = new JLabel();
		cameraField = new JTextField();
		label27 = new JLabel();
		horizPixelSizeUmField = new JTextField();
		label28 = new JLabel();
		vertPixelSizeUmField = new JTextField();
		label29 = new JLabel();
		horizArraySizeField = new JTextField();
		label30 = new JLabel();
		vertArraySizeField = new JTextField();
		label31 = new JLabel();
		gainField = new JTextField();
		label32 = new JLabel();
		readoutNoiseField = new JTextField();
		label45 = new JLabel();
		darkCurrentField = new JTextField();
		saveObserverButton = new JButton();
		updateParamsButton = new JButton();

		//======== this ========
		setTitle("DEMO!!");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		var contentPane = getContentPane();

		//======== aijTabbedPane ========
		{

			//======== targetTab ========
			{

				//======== targetPanel ========
				{

					//======== targetTabPanel ========
					{

						//======== panel3 ========
						{
							panel3.setBorder(new TitledBorder("Catalog Query settings"));

							//---- label1 ----
							label1.setText("ObjectID");

							//---- objectIdField ----
							objectIdField.setText("WASP-12");
							objectIdField.setFocusCycleRoot(true);
							objectIdField.setBackground(Color.white);
							objectIdField.setToolTipText("<html>\nEnter target name\n<p> Note: This field is <b>not </b>changed after a SIMBAD query</p>\n<p>Examples: WASP-12, wasp_12, Wasp12</p>\n</html>");

							//---- label2 ----
							label2.setText("RA:");

							//---- raField ----
							raField.setText("06:30:32.80");
							raField.setToolTipText("<html>\nEnter target J2000 RA (hours), in sexagesimal format  HH:MM:SS.SS\n<p>Note 1: Use  ':' delimiter</p>\n<p>Note 2: RA updates after a successful SIMBAD query</p>\n<p>RA range: 00:00:00 to 23:59:59.99</p>\n<p>Examples: 12:34:56.78,  1: 2:3.456, => 01:02:03.46</p>\n</html>");

							//---- label3 ----
							label3.setText("Dec:");

							//---- decField ----
							decField.setText("+20:40:20.27");
							decField.setToolTipText("<html>\nEnter target J2000 DEC (degrees), in sexagesimal format  \u00b1DD:MM:SS.SS\n<p>Note 1: Use  ':' delimiter</p>\n<p>Note 2: DEC updates after a successful SIMBAD query</p>\n<p>DEC range: 00:00:00 to \u00b190:00:00</p>\n<p>Examples: 12:34:56.78 => +12:34:56.78,  -1:2:3.456, => -01:02:03.46</p>\n</html>");

							//---- label4 ----
							label4.setText("Fov:");

							//---- fovField ----
							fovField.setText("60.0");
							fovField.setToolTipText("<html>\nEnter square field-of-view width (arcmin)\n<p>FOV range: 1.0 to 1199.9 amin\n<p>Examples: 25.0, 1150.0</p>\n</html>");

							//---- label5 ----
							label5.setText("Limit:");

							//---- magLimitField ----
							magLimitField.setText("17.0");
							magLimitField.setToolTipText("<html>\nEnter magnitude limit\n<p>Range: 1.0 to 99.9 mag\n<p>Example: 15.5</p>\n</html>");

							//---- label7 ----
							label7.setText(" HH:MM:SS.SS");

							//---- label8 ----
							label8.setText("\u00b1DD:MM:SS.SS");

							//---- label9 ----
							label9.setText("arcmin");

							//---- label10 ----
							label10.setText("mag");

							//---- catalogCombo ----
							catalogCombo.setToolTipText("<html>\nSelect on-line astronomical database from list\n</html>");

							//---- label11 ----
							label11.setText("Catalog:");

							//---- filterCombo ----
							filterCombo.setToolTipText("<html>\nSelect photometric filter from list\n<p>Listed filters depends on selected catalog</p>\n</html>");

							//---- label12 ----
							label12.setText("Filter:");

							GroupLayout panel3Layout = new GroupLayout(panel3);
							panel3.setLayout(panel3Layout);
							panel3Layout.setHorizontalGroup(
								panel3Layout.createParallelGroup()
									.addGroup(panel3Layout.createSequentialGroup()
										.addGap(15, 15, 15)
										.addGroup(panel3Layout.createParallelGroup()
											.addComponent(label1, GroupLayout.Alignment.TRAILING)
											.addComponent(label2, GroupLayout.Alignment.TRAILING)
											.addComponent(label3, GroupLayout.Alignment.TRAILING)
											.addComponent(label4, GroupLayout.Alignment.TRAILING)
											.addComponent(label5, GroupLayout.Alignment.TRAILING)
											.addComponent(label11, GroupLayout.Alignment.TRAILING)
											.addComponent(label12, GroupLayout.Alignment.TRAILING))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(panel3Layout.createParallelGroup()
											.addGroup(panel3Layout.createSequentialGroup()
												.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
													.addComponent(fovField, GroupLayout.Alignment.LEADING)
													.addComponent(decField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
													.addComponent(raField, GroupLayout.Alignment.LEADING)
													.addComponent(magLimitField))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(panel3Layout.createParallelGroup()
													.addComponent(label7)
													.addComponent(label8)
													.addComponent(label9)
													.addComponent(label10)))
											.addComponent(objectIdField, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
											.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
												.addComponent(filterCombo, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
												.addComponent(catalogCombo, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)))
										.addContainerGap(11, Short.MAX_VALUE))
							);
							panel3Layout.setVerticalGroup(
								panel3Layout.createParallelGroup()
									.addGroup(panel3Layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label1)
											.addComponent(objectIdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(panel3Layout.createParallelGroup()
											.addGroup(panel3Layout.createSequentialGroup()
												.addGap(16, 16, 16)
												.addComponent(label2))
											.addGroup(panel3Layout.createSequentialGroup()
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
													.addComponent(raField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(label7))))
										.addGroup(panel3Layout.createParallelGroup()
											.addGroup(panel3Layout.createSequentialGroup()
												.addGap(16, 16, 16)
												.addComponent(label3))
											.addGroup(panel3Layout.createSequentialGroup()
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
													.addComponent(decField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(label8))))
										.addGroup(panel3Layout.createParallelGroup()
											.addGroup(panel3Layout.createSequentialGroup()
												.addGap(16, 16, 16)
												.addComponent(label4))
											.addGroup(panel3Layout.createSequentialGroup()
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
													.addComponent(fovField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(label9))))
										.addGroup(panel3Layout.createParallelGroup()
											.addGroup(panel3Layout.createSequentialGroup()
												.addGap(16, 16, 16)
												.addComponent(label5))
											.addGroup(panel3Layout.createSequentialGroup()
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
													.addComponent(magLimitField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(label10))))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(catalogCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(label11))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label12)
											.addComponent(filterCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							);
						}

						//======== panel4 ========
						{
							panel4.setBorder(new TitledBorder("SIMBAD Data"));
							panel4.setPreferredSize(new Dimension(190, 164));

							//---- idLabel ----
							idLabel.setText("ObjectId:");
							idLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- raLabel ----
							raLabel.setText("RA:");
							raLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- decLabel ----
							decLabel.setText("DEC:");
							decLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- simbadIdLabel ----
							simbadIdLabel.setText(".");
							simbadIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- simbadRaLabel ----
							simbadRaLabel.setText("HH:MM:SS.SS");
							simbadRaLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- simbadDecLabel ----
							simbadDecLabel.setText("DD:MM:SS.SS");
							simbadDecLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- idLabel2 ----
							idLabel2.setText("MagB:");
							idLabel2.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- idLabel3 ----
							idLabel3.setText("MagV:");
							idLabel3.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- idLabel4 ----
							idLabel4.setText("MagR:");
							idLabel4.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- idLabel5 ----
							idLabel5.setText("MagI:");
							idLabel5.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- simbadMagBLabel ----
							simbadMagBLabel.setText(".");
							simbadMagBLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- simbadMagVLabel ----
							simbadMagVLabel.setText(".");
							simbadMagVLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- simbadMagRLabel ----
							simbadMagRLabel.setText(".");
							simbadMagRLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- simbadMagILabel ----
							simbadMagILabel.setText(".");
							simbadMagILabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

							GroupLayout panel4Layout = new GroupLayout(panel4);
							panel4.setLayout(panel4Layout);
							panel4Layout.setHorizontalGroup(
								panel4Layout.createParallelGroup()
									.addGroup(panel4Layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(panel4Layout.createParallelGroup()
											.addComponent(idLabel, GroupLayout.Alignment.TRAILING)
											.addComponent(raLabel, GroupLayout.Alignment.TRAILING)
											.addComponent(decLabel, GroupLayout.Alignment.TRAILING)
											.addComponent(idLabel2, GroupLayout.Alignment.TRAILING)
											.addComponent(idLabel3, GroupLayout.Alignment.TRAILING)
											.addComponent(idLabel4, GroupLayout.Alignment.TRAILING)
											.addComponent(idLabel5, GroupLayout.Alignment.TRAILING))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(panel4Layout.createParallelGroup()
											.addComponent(simbadIdLabel)
											.addComponent(simbadRaLabel)
											.addComponent(simbadDecLabel)
											.addComponent(simbadMagBLabel)
											.addComponent(simbadMagVLabel)
											.addComponent(simbadMagRLabel)
											.addComponent(simbadMagILabel))
										.addContainerGap(102, Short.MAX_VALUE))
							);
							panel4Layout.setVerticalGroup(
								panel4Layout.createParallelGroup()
									.addGroup(panel4Layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(simbadIdLabel)
											.addComponent(idLabel))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(raLabel)
											.addComponent(simbadRaLabel))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(decLabel)
											.addComponent(simbadDecLabel))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(idLabel2)
											.addComponent(simbadMagBLabel))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(idLabel3)
											.addComponent(simbadMagVLabel))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(idLabel4)
											.addComponent(simbadMagRLabel))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(idLabel5)
											.addComponent(simbadMagILabel))
										.addContainerGap(52, Short.MAX_VALUE))
							);
						}

						GroupLayout targetTabPanelLayout = new GroupLayout(targetTabPanel);
						targetTabPanel.setLayout(targetTabPanelLayout);
						targetTabPanelLayout.setHorizontalGroup(
							targetTabPanelLayout.createParallelGroup()
								.addGroup(GroupLayout.Alignment.TRAILING, targetTabPanelLayout.createSequentialGroup()
									.addGroup(targetTabPanelLayout.createParallelGroup()
										.addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(panel4, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
									.addContainerGap())
						);
						targetTabPanelLayout.setVerticalGroup(
							targetTabPanelLayout.createParallelGroup()
								.addGroup(targetTabPanelLayout.createSequentialGroup()
									.addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(panel4, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
									.addContainerGap())
						);
					}

					//======== altitudePlotPanel ========
					{
						altitudePlotPanel.setBorder(null);
						altitudePlotPanel.setLayout(new BorderLayout());
					}

					//======== solarPanel ========
					{
						solarPanel.setBorder(null);

						//---- runSimbadButton ----
						runSimbadButton.setText("SIMBAD Query");
						runSimbadButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
						runSimbadButton.setToolTipText("<html>\nRuns an ObjectId-based query on the SIMBAD astro database\n<p>If the query is successful:</p>\n<p>1. Updates SIMBAD Coordinate and Magnitude fields, and</p>\n<p>2. Saves current query params to aij_planner.properties file</p>\n</html>");

						//---- saveQueryButton ----
						saveQueryButton.setText("Save Query Data");
						saveQueryButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
						saveQueryButton.setToolTipText("Validates and saves current query entries to aij_planner.properties file");

						//======== datePickerPanel ========
						{
							datePickerPanel.setBorder(null);
							datePickerPanel.setToolTipText("<html>\nUse calender Day, Month and Year controls to set observation start date\n<p>Click <b>Clear</b> to reset calender to today's date</p>\n</html>\n");
							datePickerPanel.setLayout(new FlowLayout());
						}

						//---- label6 ----
						label6.setText("Start Night:");
						label6.setFont(new Font("Tahoma", Font.PLAIN, 12));

						//======== panel11 ========
						{
							panel11.setBorder(new TitledBorder("Civil Solar Times "));
							panel11.setPreferredSize(new Dimension(190, 164));

							//---- label33 ----
							label33.setText("Sunset:");

							//---- label34 ----
							label34.setText("Twi End:");

							//---- sunSetField ----
							sunSetField.setText("00:00");
							sunSetField.setEditable(false);
							sunSetField.setToolTipText("Local Sunset time");

							//---- twilightEndField ----
							twilightEndField.setEditable(false);
							twilightEndField.setText("00:00");
							twilightEndField.setToolTipText("Local time when Astronomical Twilight ends");

							//---- label35 ----
							label35.setText("Twi Start:");

							//---- twilightStartField ----
							twilightStartField.setEditable(false);
							twilightStartField.setText("00:00");
							twilightStartField.setToolTipText("Local time when Astronomical Twilight starts");

							//---- label36 ----
							label36.setText("Sunrise");

							//---- sunRiseField ----
							sunRiseField.setEditable(false);
							sunRiseField.setText("00:00");
							sunRiseField.setToolTipText("Local Sunrise time");

							GroupLayout panel11Layout = new GroupLayout(panel11);
							panel11.setLayout(panel11Layout);
							panel11Layout.setHorizontalGroup(
								panel11Layout.createParallelGroup()
									.addGroup(panel11Layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(label33)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(sunSetField, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(label34)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(twilightEndField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(label35)
										.addGap(5, 5, 5)
										.addComponent(twilightStartField, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(label36)
										.addGap(5, 5, 5)
										.addComponent(sunRiseField, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							);
							panel11Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {sunRiseField, sunSetField, twilightEndField, twilightStartField});
							panel11Layout.setVerticalGroup(
								panel11Layout.createParallelGroup()
									.addGroup(panel11Layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(panel11Layout.createParallelGroup()
											.addGroup(panel11Layout.createSequentialGroup()
												.addGap(3, 3, 3)
												.addComponent(label36))
											.addComponent(sunRiseField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGroup(panel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addGroup(panel11Layout.createParallelGroup()
													.addGroup(panel11Layout.createSequentialGroup()
														.addGap(3, 3, 3)
														.addComponent(label35))
													.addComponent(twilightStartField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(panel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
													.addComponent(label33)
													.addComponent(sunSetField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(label34)
													.addComponent(twilightEndField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							);
						}

						GroupLayout solarPanelLayout = new GroupLayout(solarPanel);
						solarPanel.setLayout(solarPanelLayout);
						solarPanelLayout.setHorizontalGroup(
							solarPanelLayout.createParallelGroup()
								.addGroup(solarPanelLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(runSimbadButton)
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
									.addComponent(saveQueryButton)
									.addGap(18, 18, 18)
									.addComponent(label6)
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
									.addComponent(datePickerPanel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
									.addGap(18, 18, 18)
									.addComponent(panel11, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
						);
						solarPanelLayout.setVerticalGroup(
							solarPanelLayout.createParallelGroup()
								.addGroup(solarPanelLayout.createSequentialGroup()
									.addContainerGap()
									.addGroup(solarPanelLayout.createParallelGroup()
										.addComponent(datePickerPanel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
										.addGroup(solarPanelLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
											.addComponent(saveQueryButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
											.addComponent(runSimbadButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
											.addComponent(label6))
										.addComponent(panel11, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						);
					}

					GroupLayout targetPanelLayout = new GroupLayout(targetPanel);
					targetPanel.setLayout(targetPanelLayout);
					targetPanelLayout.setHorizontalGroup(
						targetPanelLayout.createParallelGroup()
							.addGroup(targetPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(targetTabPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(altitudePlotPanel, GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
								.addContainerGap())
							.addComponent(solarPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					);
					targetPanelLayout.setVerticalGroup(
						targetPanelLayout.createParallelGroup()
							.addGroup(targetPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(targetPanelLayout.createParallelGroup()
									.addComponent(targetTabPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(altitudePlotPanel, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(solarPanel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
					);
				}

				GroupLayout targetTabLayout = new GroupLayout(targetTab);
				targetTab.setLayout(targetTabLayout);
				targetTabLayout.setHorizontalGroup(
					targetTabLayout.createParallelGroup()
						.addComponent(targetPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
				targetTabLayout.setVerticalGroup(
					targetTabLayout.createParallelGroup()
						.addComponent(targetPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
			}
			aijTabbedPane.addTab("Target", targetTab);

			//======== catalogsTab ========
			{

				//======== catalogsPanel ========
				{

					//======== catalogSettingsPanel ========
					{

						//======== querySummaryPanel ========
						{
							querySummaryPanel.setBorder(new TitledBorder("Query Data"));
							querySummaryPanel.setPreferredSize(new Dimension(190, 164));

							//---- queryIdLabel ----
							queryIdLabel.setText("ID: . | FOV: .");
							queryIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- queryRaDecLabel ----
							queryRaDecLabel.setText("RA: .| Dec:.");
							queryRaDecLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- queryCatFilterLabel ----
							queryCatFilterLabel.setText("Catalog: . | Filter . | Mag <.");
							queryCatFilterLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

							GroupLayout querySummaryPanelLayout = new GroupLayout(querySummaryPanel);
							querySummaryPanel.setLayout(querySummaryPanelLayout);
							querySummaryPanelLayout.setHorizontalGroup(
								querySummaryPanelLayout.createParallelGroup()
									.addGroup(querySummaryPanelLayout.createSequentialGroup()
										.addContainerGap()
										.addGroup(querySummaryPanelLayout.createParallelGroup()
											.addGroup(querySummaryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addComponent(queryCatFilterLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(queryRaDecLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
											.addComponent(queryIdLabel, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
										.addContainerGap())
							);
							querySummaryPanelLayout.setVerticalGroup(
								querySummaryPanelLayout.createParallelGroup()
									.addGroup(GroupLayout.Alignment.TRAILING, querySummaryPanelLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(queryIdLabel)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(queryRaDecLabel)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(queryCatFilterLabel)
										.addContainerGap(20, Short.MAX_VALUE))
							);
						}

						//======== sortByPanel ========
						{
							sortByPanel.setBorder(new TitledBorder("Sort By"));
							sortByPanel.setPreferredSize(new Dimension(190, 164));

							//---- distanceRadioButton ----
							distanceRadioButton.setText("Distance");
							distanceRadioButton.setSelected(true);
							distanceRadioButton.setToolTipText("Sorts table by increasing radial distance to target");

							//---- deltaMagRadioButton ----
							deltaMagRadioButton.setText("|Delta Mag|");
							deltaMagRadioButton.setToolTipText("<html>\nSorts table by increasing absolute\n<p>difference to Nominal Mag</p>\n</html>");

							GroupLayout sortByPanelLayout = new GroupLayout(sortByPanel);
							sortByPanel.setLayout(sortByPanelLayout);
							sortByPanelLayout.setHorizontalGroup(
								sortByPanelLayout.createParallelGroup()
									.addGroup(sortByPanelLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(distanceRadioButton)
										.addGap(18, 18, 18)
										.addComponent(deltaMagRadioButton)
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							);
							sortByPanelLayout.setVerticalGroup(
								sortByPanelLayout.createParallelGroup()
									.addGroup(sortByPanelLayout.createSequentialGroup()
										.addGroup(sortByPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(distanceRadioButton)
											.addComponent(deltaMagRadioButton))
										.addGap(0, 6, Short.MAX_VALUE))
							);
						}

						//======== slectionFiltersPanel ========
						{
							slectionFiltersPanel.setBorder(new TitledBorder("Selection Filters + DSS FITS"));
							slectionFiltersPanel.setPreferredSize(new Dimension(190, 164));

							//---- label38 ----
							label38.setText("Upper Mag:");

							//---- label39 ----
							label39.setText("Lower Mag:");

							//---- label40 ----
							label40.setText("Nominal Mag:");

							//---- upperLimitSpinner ----
							upperLimitSpinner.setModel(new SpinnerNumberModel(0.0, -0.01, 5.0, 0.1));
							upperLimitSpinner.setToolTipText("<html>\nSet the target mag upper limit\n<p>Range: 0 - 5 mag in 0.1 mag increment</p>\n<p>Setting Upper = 0 disables this limit</p>\n</html>");

							//---- lowerLimitSpinner ----
							lowerLimitSpinner.setModel(new SpinnerNumberModel(0.0, -5.0, 0.01, 0.1));
							lowerLimitSpinner.setToolTipText("<html>\nSet the target mag lower limit\n<p>Range: -5 - 0 mag in 0.1 mag increment</p>\n<p>Setting Lower = 0 disables this limit</p>\n</html>\n");

							//---- targetMagSpinner ----
							targetMagSpinner.setModel(new SpinnerNumberModel(10.0, 5.5, 25.0, 0.10000000149011612));
							targetMagSpinner.setToolTipText("<html>\nSet the nominal target mag for the selected filter band\n<p>Use the scroll control  or type value in text box</p>\n<p>Range: 5.5 - 25 mag in 0.1 mag increment</p>\n</html>");

							//---- isMagLimitsCheckBox ----
							isMagLimitsCheckBox.setText("Apply mag limits");
							isMagLimitsCheckBox.setSelected(true);
							isMagLimitsCheckBox.setToolTipText("<html>\nApply mag limits to filter table rows\n<p>Default: apply limits</p>\n</html>\n");

							//---- upperLabel ----
							upperLabel.setText("N/A");
							upperLabel.setToolTipText("<html>\nMag band upper limit\n<p>N/A: upper limit is disabled</p>\n</html>");

							//---- label41 ----
							label41.setText(".");

							//---- lowerLabel ----
							lowerLabel.setText("N/A");
							lowerLabel.setToolTipText("<html>\nMag band lower limit\n<p>N/A: lower limit is disabled</p>\n</html>");

							//---- label37 ----
							label37.setText("Nobs (APASS)");

							//---- nObsSpinner ----
							nObsSpinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
							nObsSpinner.setToolTipText("<html>\nSet minimum number of observations APASS catalog\n<p>Range: 1 to 10 (defaults to Nobs =1)</p>\n</html>\n");

							//---- saveDssCheckBox ----
							saveDssCheckBox.setText("Save DSS Fits File");
							saveDssCheckBox.setSelected(true);
							saveDssCheckBox.setToolTipText("<html>\nDownload and save DSS fits file \n<p>to dss folder</p>\n<p>Default: save fits file</p>\n</html>");

							GroupLayout slectionFiltersPanelLayout = new GroupLayout(slectionFiltersPanel);
							slectionFiltersPanel.setLayout(slectionFiltersPanelLayout);
							slectionFiltersPanelLayout.setHorizontalGroup(
								slectionFiltersPanelLayout.createParallelGroup()
									.addGroup(slectionFiltersPanelLayout.createSequentialGroup()
										.addContainerGap()
										.addGroup(slectionFiltersPanelLayout.createParallelGroup()
											.addComponent(saveDssCheckBox, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
											.addGroup(slectionFiltersPanelLayout.createSequentialGroup()
												.addGroup(slectionFiltersPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
													.addGroup(GroupLayout.Alignment.LEADING, slectionFiltersPanelLayout.createSequentialGroup()
														.addComponent(label37)
														.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(nObsSpinner))
													.addGroup(GroupLayout.Alignment.LEADING, slectionFiltersPanelLayout.createSequentialGroup()
														.addGroup(slectionFiltersPanelLayout.createParallelGroup()
															.addGroup(slectionFiltersPanelLayout.createSequentialGroup()
																.addGap(9, 9, 9)
																.addGroup(slectionFiltersPanelLayout.createParallelGroup()
																	.addComponent(label39, GroupLayout.Alignment.TRAILING)
																	.addComponent(label38, GroupLayout.Alignment.TRAILING)))
															.addComponent(label40))
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(slectionFiltersPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
															.addComponent(upperLimitSpinner, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
															.addComponent(lowerLimitSpinner, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
															.addComponent(targetMagSpinner, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))))
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(slectionFiltersPanelLayout.createParallelGroup()
													.addComponent(upperLabel)
													.addComponent(label41)
													.addComponent(lowerLabel)))
											.addComponent(isMagLimitsCheckBox))
										.addContainerGap())
							);
							slectionFiltersPanelLayout.setVerticalGroup(
								slectionFiltersPanelLayout.createParallelGroup()
									.addGroup(GroupLayout.Alignment.TRAILING, slectionFiltersPanelLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(saveDssCheckBox)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(isMagLimitsCheckBox)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(slectionFiltersPanelLayout.createParallelGroup()
											.addComponent(label39, GroupLayout.Alignment.TRAILING)
											.addGroup(GroupLayout.Alignment.TRAILING, slectionFiltersPanelLayout.createSequentialGroup()
												.addGroup(slectionFiltersPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
													.addComponent(upperLimitSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(upperLabel)
													.addComponent(label38))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(slectionFiltersPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
													.addComponent(targetMagSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(label41)
													.addComponent(label40))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(slectionFiltersPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
													.addComponent(lowerLimitSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(lowerLabel))))
										.addGap(18, 18, 18)
										.addGroup(slectionFiltersPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label37)
											.addComponent(nObsSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addContainerGap(39, Short.MAX_VALUE))
							);
						}

						//======== panel1 ========
						{
							panel1.setBorder(new TitledBorder("Catalog Record Counts"));

							//---- label42 ----
							label42.setText("Total records:");

							//---- label43 ----
							label43.setText("Filtered records:");

							//---- label44 ----
							label44.setText("Selected records:");

							//---- totalRecordsField ----
							totalRecordsField.setText("0");

							//---- filteredRecordsField ----
							filteredRecordsField.setText("0");

							//---- selectedRecordsField ----
							selectedRecordsField.setText("0");

							GroupLayout panel1Layout = new GroupLayout(panel1);
							panel1.setLayout(panel1Layout);
							panel1Layout.setHorizontalGroup(
								panel1Layout.createParallelGroup()
									.addGroup(panel1Layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(panel1Layout.createParallelGroup()
											.addComponent(label42, GroupLayout.Alignment.TRAILING)
											.addComponent(label43, GroupLayout.Alignment.TRAILING)
											.addComponent(label44, GroupLayout.Alignment.TRAILING))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(panel1Layout.createParallelGroup()
											.addComponent(totalRecordsField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
											.addComponent(filteredRecordsField)
											.addComponent(selectedRecordsField))
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							);
							panel1Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {filteredRecordsField, selectedRecordsField, totalRecordsField});
							panel1Layout.setVerticalGroup(
								panel1Layout.createParallelGroup()
									.addGroup(panel1Layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label42)
											.addComponent(totalRecordsField))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label43)
											.addComponent(filteredRecordsField))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label44)
											.addComponent(selectedRecordsField))
										.addContainerGap(18, Short.MAX_VALUE))
							);
						}

						GroupLayout catalogSettingsPanelLayout = new GroupLayout(catalogSettingsPanel);
						catalogSettingsPanel.setLayout(catalogSettingsPanelLayout);
						catalogSettingsPanelLayout.setHorizontalGroup(
							catalogSettingsPanelLayout.createParallelGroup()
								.addGroup(GroupLayout.Alignment.TRAILING, catalogSettingsPanelLayout.createSequentialGroup()
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(catalogSettingsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(sortByPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
										.addComponent(querySummaryPanel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
										.addComponent(slectionFiltersPanel, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
										.addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addContainerGap())
						);
						catalogSettingsPanelLayout.setVerticalGroup(
							catalogSettingsPanelLayout.createParallelGroup()
								.addGroup(catalogSettingsPanelLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(sortByPanel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
									.addComponent(slectionFiltersPanel, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
									.addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
									.addComponent(querySummaryPanel, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
						);
					}

					//======== catalogTablePanel ========
					{
						catalogTablePanel.setBorder(null);

						GroupLayout catalogTablePanelLayout = new GroupLayout(catalogTablePanel);
						catalogTablePanel.setLayout(catalogTablePanelLayout);
						catalogTablePanelLayout.setHorizontalGroup(
							catalogTablePanelLayout.createParallelGroup()
								.addComponent(tableScrollPane, GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
						);
						catalogTablePanelLayout.setVerticalGroup(
							catalogTablePanelLayout.createParallelGroup()
								.addComponent(tableScrollPane)
						);
					}

					//======== solarPanel2 ========
					{
						solarPanel2.setBorder(null);

						//---- catalogQueryButton ----
						catalogQueryButton.setText("Run Query");
						catalogQueryButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
						catalogQueryButton.setToolTipText("<html>\nRuns a 'Query Data' based online query \n<p>on the selected database</p>\n</html>");

						//---- importRaDecButton ----
						importRaDecButton.setText("Import RaDec Fille");
						importRaDecButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
						importRaDecButton.setToolTipText("Opens a dialog to import radec table data ");

						//---- saveRaDecButton ----
						saveRaDecButton.setText("Save RaDec File");
						saveRaDecButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
						saveRaDecButton.setToolTipText("<html>\nSaves current table data to radec file text file\n<p>filename format [objectID].[filter].[fov].radec.txt</p>\n</html>");

						//---- updateButton ----
						updateButton.setText("Update");
						updateButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
						updateButton.setToolTipText("Applies filter settings to table rows");

						//---- clearButton ----
						clearButton.setText("Clear");
						clearButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
						clearButton.setToolTipText("Clear all");

						GroupLayout solarPanel2Layout = new GroupLayout(solarPanel2);
						solarPanel2.setLayout(solarPanel2Layout);
						solarPanel2Layout.setHorizontalGroup(
							solarPanel2Layout.createParallelGroup()
								.addGroup(solarPanel2Layout.createSequentialGroup()
									.addContainerGap()
									.addComponent(catalogQueryButton, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
									.addComponent(importRaDecButton)
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
									.addComponent(saveRaDecButton)
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
									.addComponent(updateButton)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
									.addComponent(clearButton)
									.addContainerGap())
						);
						solarPanel2Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {catalogQueryButton, clearButton, importRaDecButton, saveRaDecButton, updateButton});
						solarPanel2Layout.setVerticalGroup(
							solarPanel2Layout.createParallelGroup()
								.addGroup(solarPanel2Layout.createSequentialGroup()
									.addContainerGap()
									.addGroup(solarPanel2Layout.createParallelGroup()
										.addGroup(solarPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
											.addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
										.addGroup(solarPanel2Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
											.addComponent(catalogQueryButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
											.addComponent(importRaDecButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
											.addComponent(saveRaDecButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						);
						solarPanel2Layout.linkSize(SwingConstants.VERTICAL, new Component[] {catalogQueryButton, clearButton, importRaDecButton, saveRaDecButton, updateButton});
					}

					GroupLayout catalogsPanelLayout = new GroupLayout(catalogsPanel);
					catalogsPanel.setLayout(catalogsPanelLayout);
					catalogsPanelLayout.setHorizontalGroup(
						catalogsPanelLayout.createParallelGroup()
							.addGroup(catalogsPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(catalogsPanelLayout.createParallelGroup()
									.addGroup(catalogsPanelLayout.createSequentialGroup()
										.addComponent(catalogSettingsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(catalogTablePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap())
									.addComponent(solarPanel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					);
					catalogsPanelLayout.setVerticalGroup(
						catalogsPanelLayout.createParallelGroup()
							.addGroup(catalogsPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(catalogsPanelLayout.createParallelGroup()
									.addComponent(catalogSettingsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(catalogTablePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(solarPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
					);
				}

				GroupLayout catalogsTabLayout = new GroupLayout(catalogsTab);
				catalogsTab.setLayout(catalogsTabLayout);
				catalogsTabLayout.setHorizontalGroup(
					catalogsTabLayout.createParallelGroup()
						.addComponent(catalogsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
				catalogsTabLayout.setVerticalGroup(
					catalogsTabLayout.createParallelGroup()
						.addComponent(catalogsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
			}
			aijTabbedPane.addTab("Catalogs", catalogsTab);

			//======== observerTab ========
			{

				//======== observerPanel ========
				{

					//======== locationPanel ========
					{
						locationPanel.setBorder(new TitledBorder(null, "Observer Location", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
							new Font("Tahoma", Font.BOLD, 12)));

						//---- label14 ----
						label14.setText("Latitude:");
						label14.setFont(new Font("Tahoma", Font.BOLD, 12));

						//---- latitudeField ----
						latitudeField.setEditable(false);
						latitudeField.setFocusable(false);
						latitudeField.setToolTipText("<html>\nLatitude of observing site\n<p>Refer AIJ Coordinate Converter</p>\n</html>");

						//---- northSouthField ----
						northSouthField.setEditable(false);
						northSouthField.setToolTipText("<html>\nNorth / South\n<p>North positive latitude</p>\n</html>");

						//---- label15 ----
						label15.setText("Longitude:");
						label15.setFont(new Font("Tahoma", Font.BOLD, 12));

						//---- longitudeText ----
						longitudeText.setEditable(false);
						longitudeText.setFocusable(false);
						longitudeText.setToolTipText("<html>\nLongitude of observing site\n<p>Refer AIJ Coordinate Converter</p>\n</html>");

						//---- eastWestField ----
						eastWestField.setEditable(false);
						eastWestField.setToolTipText("<html>\nWest / East\n<p>East positive longitude</p>\n</html>");

						//---- label16 ----
						label16.setText("Altitude (m):");
						label16.setFont(new Font("Tahoma", Font.BOLD, 12));

						//---- altitudeField ----
						altitudeField.setEditable(false);
						altitudeField.setFocusable(false);
						altitudeField.setToolTipText("<html>\nHeight of observing site\n<p>Refer AIJ Coordinate Converter</p>\n</html>");

						//---- label17 ----
						label17.setText("UTC Offset (hr):");
						label17.setFont(new Font("Tahoma", Font.PLAIN, 12));

						//---- utcOffsetField ----
						utcOffsetField.setEditable(false);
						utcOffsetField.setFocusable(false);
						utcOffsetField.setToolTipText("<html>\nUTC offset at observing site\n<p>Refer AIJ Coordinate Converter</p>\n</html>");

						GroupLayout locationPanelLayout = new GroupLayout(locationPanel);
						locationPanel.setLayout(locationPanelLayout);
						locationPanelLayout.setHorizontalGroup(
							locationPanelLayout.createParallelGroup()
								.addGroup(locationPanelLayout.createSequentialGroup()
									.addContainerGap()
									.addGroup(locationPanelLayout.createParallelGroup()
										.addComponent(label15, GroupLayout.Alignment.TRAILING)
										.addComponent(label14, GroupLayout.Alignment.TRAILING)
										.addComponent(label16, GroupLayout.Alignment.TRAILING)
										.addComponent(label17, GroupLayout.Alignment.TRAILING))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(locationPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addComponent(altitudeField)
										.addComponent(longitudeText, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
										.addComponent(latitudeField, GroupLayout.Alignment.LEADING)
										.addComponent(utcOffsetField))
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
									.addGroup(locationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(eastWestField, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
										.addComponent(northSouthField))
									.addContainerGap(32, Short.MAX_VALUE))
						);
						locationPanelLayout.setVerticalGroup(
							locationPanelLayout.createParallelGroup()
								.addGroup(locationPanelLayout.createSequentialGroup()
									.addContainerGap()
									.addGroup(locationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(label14)
										.addComponent(latitudeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(northSouthField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(locationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(label15)
										.addComponent(longitudeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(eastWestField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(locationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(label16)
										.addComponent(altitudeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(locationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(label17)
										.addComponent(utcOffsetField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						);
					}

					//======== systemParamsPanel ========
					{
						systemParamsPanel.setBorder(new TitledBorder(null, "Derived Parameters", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
							new Font("Tahoma", Font.BOLD, 12)));

						//---- label18 ----
						label18.setText("Pixel Size (arcsec):");

						//---- horizPixelSizeAsecField ----
						horizPixelSizeAsecField.setEditable(false);
						horizPixelSizeAsecField.setFocusable(false);
						horizPixelSizeAsecField.setToolTipText("<html>\nUnbinned horiz image scale (\"/pix)\n</html>");

						//---- label19 ----
						label19.setText("Field-of-View (arcmin):");

						//---- horizFovAminField ----
						horizFovAminField.setEditable(false);
						horizFovAminField.setFocusable(false);
						horizFovAminField.setToolTipText("Horiz FOV (')");

						//---- vertPixelSizeAsecField ----
						vertPixelSizeAsecField.setEditable(false);
						vertPixelSizeAsecField.setFocusable(false);
						vertPixelSizeAsecField.setToolTipText("<html>\nUnbinned vert image scale (\"/pix)\n</html>");

						//---- vertFovAminField ----
						vertFovAminField.setEditable(false);
						vertFovAminField.setFocusable(false);
						vertFovAminField.setToolTipText("Vert FOV (')");

						GroupLayout systemParamsPanelLayout = new GroupLayout(systemParamsPanel);
						systemParamsPanel.setLayout(systemParamsPanelLayout);
						systemParamsPanelLayout.setHorizontalGroup(
							systemParamsPanelLayout.createParallelGroup()
								.addGroup(GroupLayout.Alignment.TRAILING, systemParamsPanelLayout.createSequentialGroup()
									.addGap(73, 73, 73)
									.addGroup(systemParamsPanelLayout.createParallelGroup()
										.addComponent(label18, GroupLayout.Alignment.TRAILING)
										.addComponent(label19, GroupLayout.Alignment.TRAILING))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(systemParamsPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addGroup(systemParamsPanelLayout.createSequentialGroup()
											.addComponent(horizFovAminField)
											.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
											.addComponent(vertFovAminField, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
										.addGroup(systemParamsPanelLayout.createSequentialGroup()
											.addComponent(horizPixelSizeAsecField, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
											.addComponent(vertPixelSizeAsecField, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
									.addContainerGap(68, Short.MAX_VALUE))
						);
						systemParamsPanelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {horizFovAminField, horizPixelSizeAsecField, vertFovAminField, vertPixelSizeAsecField});
						systemParamsPanelLayout.setVerticalGroup(
							systemParamsPanelLayout.createParallelGroup()
								.addGroup(systemParamsPanelLayout.createSequentialGroup()
									.addContainerGap()
									.addGroup(systemParamsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(horizPixelSizeAsecField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label18)
										.addComponent(vertPixelSizeAsecField))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(systemParamsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(horizFovAminField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label19)
										.addComponent(vertFovAminField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(14, 14, 14))
						);
					}

					//======== observerNotesPanel ========
					{
						observerNotesPanel.setBorder(new TitledBorder(null, "Space for user notes", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
							new Font("Tahoma", Font.BOLD, 12)));
						observerNotesPanel.setToolTipText("<html>\n<b>USER NOTES NOT IMPLEMENTED</b>\n</html>");

						GroupLayout observerNotesPanelLayout = new GroupLayout(observerNotesPanel);
						observerNotesPanel.setLayout(observerNotesPanelLayout);
						observerNotesPanelLayout.setHorizontalGroup(
							observerNotesPanelLayout.createParallelGroup()
								.addGap(0, 408, Short.MAX_VALUE)
						);
						observerNotesPanelLayout.setVerticalGroup(
							observerNotesPanelLayout.createParallelGroup()
								.addGap(0, 370, Short.MAX_VALUE)
						);
					}

					//======== scrollPane2 ========
					{
						scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

						//======== equipmentPanel2 ========
						{
							equipmentPanel2.setBorder(new TitledBorder(null, "Observer & Equipment Details", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
								new Font("Tahoma", Font.BOLD, 12)));

							//---- label20 ----
							label20.setText("BAA VSS Observer Code:");
							label20.setFont(new Font("Tahoma", Font.BOLD, 12));

							//---- codeField ----
							codeField.setFont(new Font("Tahoma", Font.PLAIN, 12));
							codeField.setToolTipText("<html>\nObserver's BAA VSS code\n<p>(Iwhere available)</p>\n</html>");

							//---- label21 ----
							label21.setText("Observer Name:");
							label21.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- nameField ----
							nameField.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- label22 ----
							label22.setText("Telescope Short Description:");
							label22.setFont(new Font("Tahoma", Font.BOLD, 12));

							//---- teleShortField ----
							teleShortField.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- label23 ----
							label23.setText("Telescope Full Description:");
							label23.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- teleFullField ----
							teleFullField.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- label24 ----
							label24.setText("Aperture (mm):");
							label24.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- apertureField ----
							apertureField.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- label25 ----
							label25.setText("Focal Length (mm):");
							label25.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- focalLengthField ----
							focalLengthField.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- label26 ----
							label26.setText("Camera:");
							label26.setFont(new Font("Tahoma", Font.BOLD, 12));

							//---- cameraField ----
							cameraField.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- label27 ----
							label27.setText("Pixel Size (H) (um)");
							label27.setFont(new Font("Tahoma", Font.BOLD, 12));

							//---- horizPixelSizeUmField ----
							horizPixelSizeUmField.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- label28 ----
							label28.setText("Pixel Size (V) (um):");
							label28.setFont(new Font("Tahoma", Font.BOLD, 12));

							//---- vertPixelSizeUmField ----
							vertPixelSizeUmField.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- label29 ----
							label29.setText("Array Size(H) (pixels):");
							label29.setFont(new Font("Tahoma", Font.BOLD, 12));

							//---- horizArraySizeField ----
							horizArraySizeField.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- label30 ----
							label30.setText("Array Size(V) (pixels):");
							label30.setFont(new Font("Tahoma", Font.BOLD, 12));

							//---- vertArraySizeField ----
							vertArraySizeField.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- label31 ----
							label31.setText("Gain (e-/count): ");
							label31.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- gainField ----
							gainField.setFont(new Font("Tahoma", Font.PLAIN, 12));
							gainField.setEditable(false);
							gainField.setFocusable(false);
							gainField.setToolTipText("<html>\nCCD gain\n<p>Refer AIJ Aperture Photometry Settings</p>\n</html>");

							//---- label32 ----
							label32.setText("Readout noise (e-/pix):");
							label32.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- readoutNoiseField ----
							readoutNoiseField.setFont(new Font("Tahoma", Font.PLAIN, 12));
							readoutNoiseField.setEditable(false);
							readoutNoiseField.setFocusable(false);
							readoutNoiseField.setToolTipText("<html>\nCCD readout noise\n<p>Refer AIJ Aperture Photometry Settings</p>\n</html>");

							//---- label45 ----
							label45.setText("Dark current (e-/s/pix):");
							label45.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- darkCurrentField ----
							darkCurrentField.setFont(new Font("Tahoma", Font.PLAIN, 12));
							darkCurrentField.setEditable(false);
							darkCurrentField.setFocusable(false);
							darkCurrentField.setToolTipText("<html>\nCCD dark current\n<p>Refer AIJ Aperture Photometry Settings</p>\n</html>");

							GroupLayout equipmentPanel2Layout = new GroupLayout(equipmentPanel2);
							equipmentPanel2.setLayout(equipmentPanel2Layout);
							equipmentPanel2Layout.setHorizontalGroup(
								equipmentPanel2Layout.createParallelGroup()
									.addGroup(equipmentPanel2Layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(equipmentPanel2Layout.createParallelGroup()
											.addComponent(label20, GroupLayout.Alignment.TRAILING)
											.addComponent(label21, GroupLayout.Alignment.TRAILING)
											.addComponent(label22, GroupLayout.Alignment.TRAILING)
											.addComponent(label23, GroupLayout.Alignment.TRAILING)
											.addComponent(label24, GroupLayout.Alignment.TRAILING)
											.addComponent(label25, GroupLayout.Alignment.TRAILING)
											.addComponent(label26, GroupLayout.Alignment.TRAILING)
											.addComponent(label27, GroupLayout.Alignment.TRAILING)
											.addComponent(label28, GroupLayout.Alignment.TRAILING)
											.addComponent(label29, GroupLayout.Alignment.TRAILING)
											.addComponent(label30, GroupLayout.Alignment.TRAILING)
											.addComponent(label31, GroupLayout.Alignment.TRAILING)
											.addComponent(label32, GroupLayout.Alignment.TRAILING)
											.addComponent(label45, GroupLayout.Alignment.TRAILING))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(equipmentPanel2Layout.createParallelGroup()
											.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
												.addComponent(gainField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
												.addComponent(vertArraySizeField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
												.addComponent(horizArraySizeField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
												.addComponent(vertPixelSizeUmField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
												.addComponent(horizPixelSizeUmField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
												.addComponent(cameraField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
												.addComponent(focalLengthField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
												.addComponent(apertureField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
												.addComponent(teleShortField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
												.addComponent(nameField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
												.addComponent(codeField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
												.addComponent(readoutNoiseField, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
												.addComponent(darkCurrentField, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
											.addComponent(teleFullField, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
										.addGap(141, 141, 141))
							);
							equipmentPanel2Layout.setVerticalGroup(
								equipmentPanel2Layout.createParallelGroup()
									.addGroup(equipmentPanel2Layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label20)
											.addComponent(codeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label21)
											.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label22)
											.addComponent(teleShortField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label23)
											.addComponent(teleFullField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label24)
											.addComponent(apertureField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label25)
											.addComponent(focalLengthField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label26)
											.addComponent(cameraField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label27)
											.addComponent(horizPixelSizeUmField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label28)
											.addComponent(vertPixelSizeUmField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label29)
											.addComponent(horizArraySizeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label30)
											.addComponent(vertArraySizeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label31)
											.addComponent(gainField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label32)
											.addComponent(readoutNoiseField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label45)
											.addComponent(darkCurrentField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addContainerGap(13, Short.MAX_VALUE))
							);
						}
						scrollPane2.setViewportView(equipmentPanel2);
					}

					GroupLayout observerPanelLayout = new GroupLayout(observerPanel);
					observerPanel.setLayout(observerPanelLayout);
					observerPanelLayout.setHorizontalGroup(
						observerPanelLayout.createParallelGroup()
							.addGroup(observerPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(observerPanelLayout.createParallelGroup()
									.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
									.addComponent(systemParamsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(observerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
									.addComponent(locationPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(observerNotesPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					);
					observerPanelLayout.setVerticalGroup(
						observerPanelLayout.createParallelGroup()
							.addGroup(observerPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(locationPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(observerNotesPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(observerPanelLayout.createSequentialGroup()
								.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(systemParamsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
					);
				}

				//---- saveObserverButton ----
				saveObserverButton.setText("Save");
				saveObserverButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
				saveObserverButton.setToolTipText("<html>\nSaves Observer and Equipment inputs to \n<p>Planner.properties file</p>\n</html>");

				//---- updateParamsButton ----
				updateParamsButton.setText("Update Params");
				updateParamsButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
				updateParamsButton.setToolTipText("<html>\nUpdates Observer and Equipment inputs and computes Derived Parameters\n<p>Flags any invalid data entries</p>\n</html>");

				GroupLayout observerTabLayout = new GroupLayout(observerTab);
				observerTab.setLayout(observerTabLayout);
				observerTabLayout.setHorizontalGroup(
					observerTabLayout.createParallelGroup()
						.addGroup(observerTabLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(updateParamsButton, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(saveObserverButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(628, Short.MAX_VALUE))
						.addComponent(observerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
				observerTabLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {saveObserverButton, updateParamsButton});
				observerTabLayout.setVerticalGroup(
					observerTabLayout.createParallelGroup()
						.addGroup(observerTabLayout.createSequentialGroup()
							.addComponent(observerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(observerTabLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(updateParamsButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(saveObserverButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
				);
				observerTabLayout.linkSize(SwingConstants.VERTICAL, new Component[] {saveObserverButton, updateParamsButton});
			}
			aijTabbedPane.addTab("Observer", observerTab);
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(aijTabbedPane)
					.addContainerGap())
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(aijTabbedPane)
					.addContainerGap())
		);
		pack();
		setLocationRelativeTo(getOwner());

		//---- buttonGroup1 ----
		var buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(distanceRadioButton);
		buttonGroup1.add(deltaMagRadioButton);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner non-commercial license
	private JTabbedPane aijTabbedPane;
	private JPanel targetTab;
	private JPanel targetPanel;
	private JPanel targetTabPanel;
	private JPanel panel3;
	private JLabel label1;
	protected JTextField objectIdField;
	private JLabel label2;
	protected JTextField raField;
	private JLabel label3;
	protected JTextField decField;
	private JLabel label4;
	protected JTextField fovField;
	private JLabel label5;
	protected JTextField magLimitField;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	protected JComboBox<String> catalogCombo;
	private JLabel label11;
	protected JComboBox<String> filterCombo;
	private JLabel label12;
	private JPanel panel4;
	private JLabel idLabel;
	private JLabel raLabel;
	private JLabel decLabel;
	private JLabel simbadIdLabel;
	private JLabel simbadRaLabel;
	private JLabel simbadDecLabel;
	private JLabel idLabel2;
	private JLabel idLabel3;
	private JLabel idLabel4;
	private JLabel idLabel5;
	private JLabel simbadMagBLabel;
	private JLabel simbadMagVLabel;
	private JLabel simbadMagRLabel;
	private JLabel simbadMagILabel;
	private JPanel altitudePlotPanel;
	private JPanel solarPanel;
	private JButton runSimbadButton;
	private JButton saveQueryButton;
	private JPanel datePickerPanel;
	private JLabel label6;
	private JPanel panel11;
	private JLabel label33;
	private JLabel label34;
	protected JTextField sunSetField;
	protected JTextField twilightEndField;
	private JLabel label35;
	protected JTextField twilightStartField;
	private JLabel label36;
	protected JTextField sunRiseField;
	private JPanel catalogsTab;
	private JPanel catalogsPanel;
	private JPanel catalogSettingsPanel;
	private JPanel querySummaryPanel;
	private JLabel queryIdLabel;
	private JLabel queryRaDecLabel;
	private JLabel queryCatFilterLabel;
	private JPanel sortByPanel;
	private JRadioButton distanceRadioButton;
	private JRadioButton deltaMagRadioButton;
	private JPanel slectionFiltersPanel;
	private JLabel label38;
	private JLabel label39;
	private JLabel label40;
	private JSpinner upperLimitSpinner;
	private JSpinner lowerLimitSpinner;
	private JSpinner targetMagSpinner;
	private JCheckBox isMagLimitsCheckBox;
	protected JLabel upperLabel;
	private JLabel label41;
	protected JLabel lowerLabel;
	private JLabel label37;
	private JSpinner nObsSpinner;
	private JCheckBox saveDssCheckBox;
	private JPanel panel1;
	private JLabel label42;
	private JLabel label43;
	private JLabel label44;
	private JLabel totalRecordsField;
	private JLabel filteredRecordsField;
	private JLabel selectedRecordsField;
	private JPanel catalogTablePanel;
	private JScrollPane tableScrollPane;
	private JPanel solarPanel2;
	private JButton catalogQueryButton;
	private JButton importRaDecButton;
	private JButton saveRaDecButton;
	private JButton updateButton;
	private JButton clearButton;
	private JPanel observerTab;
	private JPanel observerPanel;
	private JPanel locationPanel;
	private JLabel label14;
	private JTextField latitudeField;
	private JTextField northSouthField;
	private JLabel label15;
	private JTextField longitudeText;
	private JTextField eastWestField;
	private JLabel label16;
	private JTextField altitudeField;
	private JLabel label17;
	private JTextField utcOffsetField;
	private JPanel systemParamsPanel;
	private JLabel label18;
	private JTextField horizPixelSizeAsecField;
	private JLabel label19;
	private JTextField horizFovAminField;
	private JTextField vertPixelSizeAsecField;
	private JTextField vertFovAminField;
	private JPanel observerNotesPanel;
	private JScrollPane scrollPane2;
	private JPanel equipmentPanel2;
	private JLabel label20;
	private JTextField codeField;
	private JLabel label21;
	private JTextField nameField;
	private JLabel label22;
	private JTextField teleShortField;
	private JLabel label23;
	private JTextField teleFullField;
	private JLabel label24;
	private JTextField apertureField;
	private JLabel label25;
	private JTextField focalLengthField;
	private JLabel label26;
	private JTextField cameraField;
	private JLabel label27;
	private JTextField horizPixelSizeUmField;
	private JLabel label28;
	private JTextField vertPixelSizeUmField;
	private JLabel label29;
	private JTextField horizArraySizeField;
	private JLabel label30;
	private JTextField vertArraySizeField;
	private JLabel label31;
	private JTextField gainField;
	private JLabel label32;
	private JTextField readoutNoiseField;
	private JLabel label45;
	private JTextField darkCurrentField;
	private JButton saveObserverButton;
	private JButton updateParamsButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
