/*
 * Created by JFormDesigner on Sun Jul 17 05:56:34 BST 2022
 */

package com.github.richardflee.astroimagej.tab_viewer;

import java.awt.*;
import java.awt.Component;
import java.awt.Font;
import javax.swing.*;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.*;
import javax.swing.border.TitledBorder;

/**
 * @author Richard Lee
 */
public class ViewerUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public ObserverTab observer_tab;
	public TargetTab target_tab;
	
	public ViewerUI() {
		initComponents();
		
		this.observer_tab = new ObserverTab(this);
		this.target_tab = new TargetTab(this);
		
	}
	
	
	
	
	private void createUIComponents() {
		// TODO: add custom component creation code here
	}

	public JTextField getHorizPixelSizeAsecField() {
		return horizPixelSizeAsecField;
	}

	public JTextField getHorizFovAminField() {
		return horizFovAminField;
	}

	public JTextField getVertPixelSizeAsecField() {
		return vertPixelSizeAsecField;
	}

	public JTextField getVertFovAminField() {
		return vertFovAminField;
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

	public JTextField getDarkCurrentField() {
		return darkCurrentField;
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

	public JCheckBox getIsSaveDssCheckBox() {
		return isSaveDssCheckBox;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner non-commercial license
		tabbedPane1 = new JTabbedPane();
		targetTab = new JPanel();
		targetPanel = new JPanel();
		panel1 = new JPanel();
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
		isSaveDssCheckBox = new JCheckBox();
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
		panel2 = new JPanel();
		runSimbadButton = new JButton();
		saveQueryButton = new JButton();
		TAB2 = new JPanel();
		panel6 = new JPanel();
		button3 = new JButton();
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
		scrollPane1 = new JScrollPane();
		textArea1 = new JTextArea();
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
		darkCurrentField = new JTextField();
		label32 = new JLabel();
		readoutNoiseField = new JTextField();
		saveObserverButton = new JButton();
		updateParamsButton = new JButton();

		//======== this ========
		setTitle("DEMO!!");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		var contentPane = getContentPane();

		//======== tabbedPane1 ========
		{

			//======== targetTab ========
			{

				//======== targetPanel ========
				{

					//======== panel1 ========
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

							//---- isSaveDssCheckBox ----
							isSaveDssCheckBox.setText("Save DSS Fits File");
							isSaveDssCheckBox.setSelected(true);

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
												.addComponent(filterCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(isSaveDssCheckBox))
											.addGroup(panel3Layout.createSequentialGroup()
												.addGroup(panel3Layout.createParallelGroup()
													.addComponent(catalogCombo, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
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
													.addComponent(objectIdField, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
												.addGap(0, 0, Short.MAX_VALUE)))
										.addContainerGap())
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
											.addComponent(filterCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(label12)
											.addComponent(isSaveDssCheckBox))
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							);
						}

						//======== panel4 ========
						{
							panel4.setBorder(new TitledBorder("SIMBAD Data"));
							panel4.setPreferredSize(new Dimension(190, 164));

							//---- idLabel ----
							idLabel.setText("ObjectId:");

							//---- raLabel ----
							raLabel.setText("RA:");

							//---- decLabel ----
							decLabel.setText("DEC:");

							//---- simbadIdLabel ----
							simbadIdLabel.setText(".");

							//---- simbadRaLabel ----
							simbadRaLabel.setText("HH:MM:SS.SS");

							//---- simbadDecLabel ----
							simbadDecLabel.setText("DD:MM:SS.SS");

							//---- idLabel2 ----
							idLabel2.setText("MagB:");

							//---- idLabel3 ----
							idLabel3.setText("MagV:");

							//---- idLabel4 ----
							idLabel4.setText("MagR:");

							//---- idLabel5 ----
							idLabel5.setText("MagI:");

							//---- simbadMagBLabel ----
							simbadMagBLabel.setText(".");

							//---- simbadMagVLabel ----
							simbadMagVLabel.setText(".");

							//---- simbadMagRLabel ----
							simbadMagRLabel.setText(".");

							//---- simbadMagILabel ----
							simbadMagILabel.setText(".");

							GroupLayout panel4Layout = new GroupLayout(panel4);
							panel4.setLayout(panel4Layout);
							panel4Layout.setHorizontalGroup(
								panel4Layout.createParallelGroup()
									.addGroup(panel4Layout.createSequentialGroup()
										.addContainerGap(12, Short.MAX_VALUE)
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
										.addGap(0, 125, Short.MAX_VALUE))
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
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							);
						}

						GroupLayout panel1Layout = new GroupLayout(panel1);
						panel1.setLayout(panel1Layout);
						panel1Layout.setHorizontalGroup(
							panel1Layout.createParallelGroup()
								.addGroup(panel1Layout.createSequentialGroup()
									.addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(0, 0, Short.MAX_VALUE))
								.addGroup(panel1Layout.createSequentialGroup()
									.addComponent(panel4, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						);
						panel1Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {panel3, panel4});
						panel1Layout.setVerticalGroup(
							panel1Layout.createParallelGroup()
								.addGroup(panel1Layout.createSequentialGroup()
									.addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(panel4, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
						);
					}

					//======== panel2 ========
					{
						panel2.setBorder(new EtchedBorder());

						GroupLayout panel2Layout = new GroupLayout(panel2);
						panel2.setLayout(panel2Layout);
						panel2Layout.setHorizontalGroup(
							panel2Layout.createParallelGroup()
								.addGap(0, 620, Short.MAX_VALUE)
						);
						panel2Layout.setVerticalGroup(
							panel2Layout.createParallelGroup()
								.addGap(0, 0, Short.MAX_VALUE)
						);
					}

					GroupLayout targetPanelLayout = new GroupLayout(targetPanel);
					targetPanel.setLayout(targetPanelLayout);
					targetPanelLayout.setHorizontalGroup(
						targetPanelLayout.createParallelGroup()
							.addGroup(targetPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap())
					);
					targetPanelLayout.setVerticalGroup(
						targetPanelLayout.createParallelGroup()
							.addGroup(targetPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(targetPanelLayout.createParallelGroup()
									.addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap())
					);
				}

				//---- runSimbadButton ----
				runSimbadButton.setText("Run SIMBAD Query");
				runSimbadButton.setFont(new Font("Tahoma", Font.PLAIN, 12));

				//---- saveQueryButton ----
				saveQueryButton.setText("Save Query Data");
				saveQueryButton.setFont(new Font("Tahoma", Font.PLAIN, 12));

				GroupLayout targetTabLayout = new GroupLayout(targetTab);
				targetTab.setLayout(targetTabLayout);
				targetTabLayout.setHorizontalGroup(
					targetTabLayout.createParallelGroup()
						.addComponent(targetPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(targetTabLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(runSimbadButton, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(saveQueryButton, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(613, Short.MAX_VALUE))
				);
				targetTabLayout.setVerticalGroup(
					targetTabLayout.createParallelGroup()
						.addGroup(targetTabLayout.createSequentialGroup()
							.addComponent(targetPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(targetTabLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(saveQueryButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(runSimbadButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
				);
				targetTabLayout.linkSize(SwingConstants.VERTICAL, new Component[] {runSimbadButton, saveQueryButton});
			}
			tabbedPane1.addTab("Target", targetTab);

			//======== TAB2 ========
			{

				//======== panel6 ========
				{

					GroupLayout panel6Layout = new GroupLayout(panel6);
					panel6.setLayout(panel6Layout);
					panel6Layout.setHorizontalGroup(
						panel6Layout.createParallelGroup()
							.addGap(0, 913, Short.MAX_VALUE)
					);
					panel6Layout.setVerticalGroup(
						panel6Layout.createParallelGroup()
							.addGap(0, 446, Short.MAX_VALUE)
					);
				}

				//---- button3 ----
				button3.setText("text");
				button3.setFont(new Font("Tahoma", Font.PLAIN, 12));

				GroupLayout TAB2Layout = new GroupLayout(TAB2);
				TAB2.setLayout(TAB2Layout);
				TAB2Layout.setHorizontalGroup(
					TAB2Layout.createParallelGroup()
						.addComponent(panel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(TAB2Layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(button3, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(743, Short.MAX_VALUE))
				);
				TAB2Layout.setVerticalGroup(
					TAB2Layout.createParallelGroup()
						.addGroup(TAB2Layout.createSequentialGroup()
							.addComponent(panel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(button3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
				);
			}
			tabbedPane1.addTab("TAB2", TAB2);

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

						//---- northSouthField ----
						northSouthField.setEditable(false);

						//---- label15 ----
						label15.setText("Longitude:");
						label15.setFont(new Font("Tahoma", Font.BOLD, 12));

						//---- longitudeText ----
						longitudeText.setEditable(false);
						longitudeText.setFocusable(false);

						//---- eastWestField ----
						eastWestField.setEditable(false);

						//---- label16 ----
						label16.setText("Altitude (m):");
						label16.setFont(new Font("Tahoma", Font.BOLD, 12));

						//---- altitudeField ----
						altitudeField.setEditable(false);
						altitudeField.setFocusable(false);

						//---- label17 ----
						label17.setText("UTC Offset (hr):");
						label17.setFont(new Font("Tahoma", Font.PLAIN, 12));

						//---- utcOffsetField ----
						utcOffsetField.setEditable(false);
						utcOffsetField.setFocusable(false);

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
						horizPixelSizeAsecField.setToolTipText("Horiz pixel size / arcsec");

						//---- label19 ----
						label19.setText("Field-of-View (arcmin):");

						//---- horizFovAminField ----
						horizFovAminField.setEditable(false);
						horizFovAminField.setFocusable(false);
						horizFovAminField.setToolTipText("Horiz FOV / arcmin");

						//---- vertPixelSizeAsecField ----
						vertPixelSizeAsecField.setEditable(false);
						vertPixelSizeAsecField.setFocusable(false);
						vertPixelSizeAsecField.setToolTipText("Vert pixel size / arcsec");

						//---- vertFovAminField ----
						vertFovAminField.setEditable(false);
						vertFovAminField.setFocusable(false);
						vertFovAminField.setToolTipText("Vert FOV / arcmin");

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
									.addContainerGap(53, Short.MAX_VALUE))
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
						observerNotesPanel.setBorder(new TitledBorder(null, "NOTES:", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
							new Font("Tahoma", Font.BOLD, 12)));

						//======== scrollPane1 ========
						{
							scrollPane1.setViewportView(textArea1);
						}

						GroupLayout observerNotesPanelLayout = new GroupLayout(observerNotesPanel);
						observerNotesPanel.setLayout(observerNotesPanelLayout);
						observerNotesPanelLayout.setHorizontalGroup(
							observerNotesPanelLayout.createParallelGroup()
								.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
						);
						observerNotesPanelLayout.setVerticalGroup(
							observerNotesPanelLayout.createParallelGroup()
								.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
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
							label31.setText("Dark current (e-/s/pixel):");
							label31.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- darkCurrentField ----
							darkCurrentField.setFont(new Font("Tahoma", Font.PLAIN, 12));
							darkCurrentField.setEditable(false);
							darkCurrentField.setFocusable(false);

							//---- label32 ----
							label32.setText("Readout Noise (e-/pixel):");
							label32.setFont(new Font("Tahoma", Font.PLAIN, 12));

							//---- readoutNoiseField ----
							readoutNoiseField.setFont(new Font("Tahoma", Font.PLAIN, 12));
							readoutNoiseField.setEditable(false);
							readoutNoiseField.setFocusable(false);

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
											.addComponent(label32, GroupLayout.Alignment.TRAILING))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(equipmentPanel2Layout.createParallelGroup()
											.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
												.addComponent(darkCurrentField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
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
												.addComponent(readoutNoiseField, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
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
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label31)
											.addComponent(darkCurrentField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label32)
											.addComponent(readoutNoiseField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addContainerGap(52, Short.MAX_VALUE))
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
								.addGroup(observerPanelLayout.createParallelGroup()
									.addComponent(locationPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(observerNotesPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					);
					observerPanelLayout.setVerticalGroup(
						observerPanelLayout.createParallelGroup()
							.addGroup(observerPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(locationPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(observerNotesPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(observerPanelLayout.createSequentialGroup()
								.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(systemParamsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
					);
				}

				//---- saveObserverButton ----
				saveObserverButton.setText("Save");
				saveObserverButton.setFont(new Font("Tahoma", Font.PLAIN, 12));

				//---- updateParamsButton ----
				updateParamsButton.setText("Update Params");
				updateParamsButton.setFont(new Font("Tahoma", Font.PLAIN, 12));

				GroupLayout observerTabLayout = new GroupLayout(observerTab);
				observerTab.setLayout(observerTabLayout);
				observerTabLayout.setHorizontalGroup(
					observerTabLayout.createParallelGroup()
						.addGroup(observerTabLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(updateParamsButton, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(saveObserverButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(613, Short.MAX_VALUE))
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
			tabbedPane1.addTab("Observer", observerTab);
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane1)
					.addContainerGap())
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane1)
					.addContainerGap())
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner non-commercial license
	private JTabbedPane tabbedPane1;
	private JPanel targetTab;
	private JPanel targetPanel;
	private JPanel panel1;
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
	protected JCheckBox isSaveDssCheckBox;
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
	private JPanel panel2;
	private JButton runSimbadButton;
	private JButton saveQueryButton;
	private JPanel TAB2;
	private JPanel panel6;
	private JButton button3;
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
	private JScrollPane scrollPane1;
	private JTextArea textArea1;
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
	private JTextField darkCurrentField;
	private JLabel label32;
	private JTextField readoutNoiseField;
	private JButton saveObserverButton;
	private JButton updateParamsButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
