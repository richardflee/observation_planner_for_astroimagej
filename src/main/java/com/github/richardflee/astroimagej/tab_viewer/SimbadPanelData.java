package com.github.richardflee.astroimagej.tab_viewer;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.github.richardflee.astroimagej.data_objects.SimbadResult;
import com.github.richardflee.astroimagej.utils.AstroCoords;

public class SimbadPanelData {
	
	private JTextField raText;
	private JTextField decText;
	
	private JLabel idLabel;
	private JLabel raLabel;
	private JLabel decLabel;
	private JLabel magBLabel;
	private JLabel magVLabel;
	private JLabel magRLabel;
	private JLabel magILabel;
	
	
	public SimbadPanelData(ViewerUi viewer) {		
		raText = viewer.getRaField();
		decText = viewer.getDecField();
		
		idLabel = viewer.getSimbadIdLabel();
		raLabel = viewer.getSimbadRaLabel();
		decLabel = viewer.getSimbadDecLabel();
		magBLabel = viewer.getSimbadMagBLabel();
		magVLabel = viewer.getSimbadMagVLabel();
		magRLabel = viewer.getSimbadMagRLabel();
		magILabel = viewer.getSimbadMagILabel();		
	}
	
	public void setSimbadData(SimbadResult simbadResult) {
		// null => reset simbad data
		if (simbadResult == null) {
			idLabel.setText(".");
			raLabel.setText(".");
			decLabel.setText(".");
			magBLabel.setText(".");
			magVLabel.setText(".");
			magRLabel.setText(".");
			magILabel.setText(".");
			return;
		}

		// Simbad catalog match for user objectId
		// update catalog ra
		String raHms = AstroCoords.raHrToRaHms(simbadResult.getSimbadRaHr());
		raText.setText(raHms);
		raText.setForeground(Color.black);

		// update catalog dec
		String decDms = AstroCoords.decDegToDecDms(simbadResult.getSimbadDecDeg());
		decText.setText(decDms);
		decText.setForeground(Color.black);

		// update info labels
		idLabel.setText(simbadResult.getSimbadId());
		raLabel.setText(raHms);
		decLabel.setText(decDms);

		// handle no data, usually R and I bands
		String mag = (simbadResult.getMagB() == null) ? "." : simbadResult.getMagB().toString();
		magBLabel.setText(mag);

		mag = (simbadResult.getMagV() == null) ? "." : simbadResult.getMagV().toString();
		magVLabel.setText(mag);

		mag = (simbadResult.getMagR() == null) ? "." : simbadResult.getMagR().toString();
		magRLabel.setText(mag);

		mag = (simbadResult.getMagI() == null) ? "." : simbadResult.getMagI().toString();
		magILabel.setText(mag);
	}

}
