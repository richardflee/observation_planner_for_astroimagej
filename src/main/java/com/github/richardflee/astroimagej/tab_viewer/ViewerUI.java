/*
 * Created by JFormDesigner on Sun Jul 17 05:56:34 BST 2022
 */

package com.github.richardflee.astroimagej.tab_viewer;

import java.awt.Component;
import java.awt.Font;

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
import javax.swing.border.TitledBorder;

/**
 * @author Richard Lee
 */
public class ViewerUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public ObserverTab observertab;
	
	public ViewerUI() {
		initComponents();
		
		this.observertab = new ObserverTab(this);
		
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

	public JButton getUpdateButton() {
		return updateButton;
	}

	public JButton getSaveButton() {
		return saveButton;
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

	public JTextField getFocalRatio() {
		return focalRatio;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner non-commercial license
		tabbedPane1 = new JTabbedPane();
		TAB1 = new JPanel();
		panel2 = new JPanel();
		button1 = new JButton();
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
		focalRatio = new JTextField();
		label1 = new JLabel();
		saveButton = new JButton();
		updateButton = new JButton();

		//======== this ========
		setTitle("DEMO!!");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		var contentPane = getContentPane();

		//======== tabbedPane1 ========
		{

			//======== TAB1 ========
			{

				//======== panel2 ========
				{

					GroupLayout panel2Layout = new GroupLayout(panel2);
					panel2.setLayout(panel2Layout);
					panel2Layout.setHorizontalGroup(
						panel2Layout.createParallelGroup()
							.addGap(0, 913, Short.MAX_VALUE)
					);
					panel2Layout.setVerticalGroup(
						panel2Layout.createParallelGroup()
							.addGap(0, 471, Short.MAX_VALUE)
					);
				}

				//---- button1 ----
				button1.setText("text");
				button1.setFont(new Font("Tahoma", Font.PLAIN, 12));

				GroupLayout TAB1Layout = new GroupLayout(TAB1);
				TAB1.setLayout(TAB1Layout);
				TAB1Layout.setHorizontalGroup(
					TAB1Layout.createParallelGroup()
						.addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(TAB1Layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(button1, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(743, Short.MAX_VALUE))
				);
				TAB1Layout.setVerticalGroup(
					TAB1Layout.createParallelGroup()
						.addGroup(TAB1Layout.createSequentialGroup()
							.addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(button1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
				);
			}
			tabbedPane1.addTab("TAB1", TAB1);

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
							.addGap(0, 471, Short.MAX_VALUE)
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
								.addComponent(scrollPane1)
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
							label25.setFont(new Font("Tahoma", Font.BOLD, 12));

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

							//---- focalRatio ----
							focalRatio.setFont(new Font("Tahoma", Font.PLAIN, 12));
							focalRatio.setEditable(false);

							//---- label1 ----
							label1.setText("f/#:");
							label1.setFont(new Font("Tahoma", Font.PLAIN, 12));

							GroupLayout equipmentPanel2Layout = new GroupLayout(equipmentPanel2);
							equipmentPanel2.setLayout(equipmentPanel2Layout);
							equipmentPanel2Layout.setHorizontalGroup(
								equipmentPanel2Layout.createParallelGroup()
									.addGroup(equipmentPanel2Layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
											.addGroup(equipmentPanel2Layout.createSequentialGroup()
												.addGroup(equipmentPanel2Layout.createParallelGroup()
													.addComponent(label20, GroupLayout.Alignment.TRAILING)
													.addComponent(label21, GroupLayout.Alignment.TRAILING)
													.addComponent(label22, GroupLayout.Alignment.TRAILING)
													.addComponent(label23, GroupLayout.Alignment.TRAILING)
													.addComponent(label24, GroupLayout.Alignment.TRAILING)
													.addComponent(label25, GroupLayout.Alignment.TRAILING)
													.addComponent(label1, GroupLayout.Alignment.TRAILING))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(equipmentPanel2Layout.createParallelGroup()
													.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
														.addComponent(focalLengthField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
														.addComponent(apertureField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
														.addComponent(teleShortField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
														.addComponent(nameField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
														.addComponent(codeField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
														.addComponent(focalRatio, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
													.addComponent(teleFullField, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)))
											.addGroup(GroupLayout.Alignment.LEADING, equipmentPanel2Layout.createSequentialGroup()
												.addGap(35, 35, 35)
												.addGroup(equipmentPanel2Layout.createParallelGroup()
													.addComponent(label26, GroupLayout.Alignment.TRAILING)
													.addComponent(label27, GroupLayout.Alignment.TRAILING)
													.addComponent(label28, GroupLayout.Alignment.TRAILING)
													.addComponent(label29, GroupLayout.Alignment.TRAILING)
													.addComponent(label30, GroupLayout.Alignment.TRAILING)
													.addComponent(label31, GroupLayout.Alignment.TRAILING)
													.addComponent(label32, GroupLayout.Alignment.TRAILING))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
													.addComponent(darkCurrentField, GroupLayout.Alignment.LEADING)
													.addComponent(vertArraySizeField, GroupLayout.Alignment.LEADING)
													.addComponent(horizArraySizeField, GroupLayout.Alignment.LEADING)
													.addComponent(vertPixelSizeUmField, GroupLayout.Alignment.LEADING)
													.addComponent(horizPixelSizeUmField, GroupLayout.Alignment.LEADING)
													.addComponent(cameraField, GroupLayout.Alignment.LEADING)
													.addComponent(readoutNoiseField, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)))
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
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(equipmentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label1)
											.addComponent(focalRatio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
										.addContainerGap(61, Short.MAX_VALUE))
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
									.addComponent(systemParamsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(observerPanelLayout.createParallelGroup()
									.addComponent(locationPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(observerNotesPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					);
					observerPanelLayout.setVerticalGroup(
						observerPanelLayout.createParallelGroup()
							.addGroup(observerPanelLayout.createSequentialGroup()
								.addGroup(observerPanelLayout.createParallelGroup()
									.addGroup(observerPanelLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(locationPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(observerNotesPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(observerPanelLayout.createSequentialGroup()
										.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(systemParamsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap())
					);
				}

				//---- saveButton ----
				saveButton.setText("Save");
				saveButton.setFont(new Font("Tahoma", Font.PLAIN, 12));

				//---- updateButton ----
				updateButton.setText("Update Params");
				updateButton.setFont(new Font("Tahoma", Font.PLAIN, 12));

				GroupLayout observerTabLayout = new GroupLayout(observerTab);
				observerTab.setLayout(observerTabLayout);
				observerTabLayout.setHorizontalGroup(
					observerTabLayout.createParallelGroup()
						.addGroup(observerTabLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(613, Short.MAX_VALUE))
						.addComponent(observerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
				observerTabLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {saveButton, updateButton});
				observerTabLayout.setVerticalGroup(
					observerTabLayout.createParallelGroup()
						.addGroup(observerTabLayout.createSequentialGroup()
							.addComponent(observerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(observerTabLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
				);
				observerTabLayout.linkSize(SwingConstants.VERTICAL, new Component[] {saveButton, updateButton});
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
					.addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
					.addContainerGap())
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner non-commercial license
	private JTabbedPane tabbedPane1;
	private JPanel TAB1;
	private JPanel panel2;
	private JButton button1;
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
	private JTextField focalRatio;
	private JLabel label1;
	private JButton saveButton;
	private JButton updateButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
