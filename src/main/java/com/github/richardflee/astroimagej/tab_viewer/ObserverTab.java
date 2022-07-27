package com.github.richardflee.astroimagej.tab_viewer;

import java.awt.Color;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.github.richardflee.astroimagej.utils.InputsVerifier;
import com.github.richardflee.astroimagej.data_objects.NoiseData;
import com.github.richardflee.astroimagej.data_objects.ObservationSite;
import com.github.richardflee.astroimagej.data_objects.Observer;
import com.github.richardflee.astroimagej.fileio.ObserverTabProerties;
import com.github.richardflee.astroimagej.listeners.ObserverTabListener;

public class ObserverTab implements ObserverTabListener {

	private JTextField codeText;
	private JTextField nameText;
	private JTextField teleShortText;
	private JTextField teleFullText;
	private JTextField apertureText;
	private JTextField cameraText;
	
	// pixel array inputs
	private JTextField fLengthText;
	private double fLength = 0.0;
	
	private JTextField horizPixelUmText;
//	private double horizPixelUm = 0.0;
	
	private JTextField vertPixelUmText;
//	private double vertPixelUm = 0.0;
	
	
	private JTextField horizArrayText;
//	private double horizArraySize = 0.0;
	
	private JTextField vertArrayText;
//	private double vertArraySize = 0.0;

	// computed pixel array params
	private JTextField horizPixelAsecText;
	private double horizPixelAsec = 0.0;
	
	private JTextField vertPixelAsecText;
	private double vertPixelAsec = 0.0;
	
	private JTextField horizFovAminText;
	//private double horizFovAmin = 0.0;
	
	private JTextField vertFovAminText;
	//private double vertFovAmin = 0.0;
	
	private JTextField darkCurrentText;
	private JTextField readoutNoiseText;
	
	
	private JTextField latitudeText;
	private JTextField longitudeText;
	private JTextField altitudeText;
	private JTextField utcOffsetText;
	
	private JTextField northSouthText;
	private JTextField eastWestText;

	private JButton save;
	private JButton update;

//	private double fLength = 0.0;
//	private double horizPixelSizeDeg = 0.0;
//	private double vertPixelSizeDeg = 0.0;
//	private double horizFovDeg = 0.0;
//	private double vertFovDeg = 0.0;

//	public ObserverTab( viewer) {
//
//	}
	
	private ViewerUI viewer;
	
	public ObserverTab(ViewerUI viewer) {
		
		this.viewer = viewer;

		codeText = viewer.getCodeField();
		nameText = viewer.getNameField();

		teleShortText = viewer.getTeleShortField();
		teleFullText = viewer.getTeleFullField();
		apertureText = viewer.getApertureField();
		fLengthText = viewer.getFocalLengthField();

		cameraText = viewer.getCameraField();
		horizPixelUmText = viewer.getHorizPixelSizeUmField();
		vertPixelUmText = viewer.getVertPixelSizeUmField();
		horizArrayText = viewer.getHorizArraySizeField();
		vertArrayText = viewer.getVertArraySizeField();

		horizPixelAsecText = viewer.getHorizPixelSizeAsecField();
		vertPixelAsecText = viewer.getVertPixelSizeAsecField();
		horizFovAminText = viewer.getHorizFovAminField();
		vertFovAminText = viewer.getVertFovAminField();
		
		darkCurrentText = viewer.getDarkCurrentField();
		readoutNoiseText = viewer.getReadoutNoiseField();
		
		latitudeText = viewer.getLatitudeField();
		longitudeText = viewer.getLongitudeField();
		altitudeText = viewer.getAltitudeField();
		utcOffsetText = viewer.getUtcOffsetField();
		
		northSouthText = viewer.getNorthSouthField();
		eastWestText = viewer.getEastWestField();

		save = viewer.getSaveButton();
		update = viewer.getUpdateButton();

		setUpActionHandlers();

		//
		// System.out.println(observerPanel.code);
		// System.out.println();
	}
	
	@Override
	public void setNoiseData(NoiseData noiseData) {
		
		boolean noData = Double.valueOf(noiseData.getCcdDark()).isNaN();
		var data = noData ? "" : String.format("%1.4f", noiseData.getCcdDark());
		darkCurrentText.setText(data);
		
		noData = Double.valueOf(noiseData.getCcdNoise()).isNaN();
		data = noData ? "" : String.format("%.1f",  noiseData.getCcdNoise());
		readoutNoiseText.setText(data);
		
		
		//darkCurrentField.setText(String.format("%1.4f", noiseData.getCcdDark()));
		//readoutNoiseField.setText(String.format("%.1f",  noiseData.getCcdNoise()));
	}
	
	
	@Override
	public void setObservationSiteData(ObservationSite site) {
		if (site == null) {
			site= new ObservationSite();
		}
		
		longitudeText.setText(site.getSiteLongitudeDms());
		eastWestText.setText(site.getSiteEastWest());
		
		latitudeText.setText(site.getSiteLatitudeDms());
		northSouthText.setText(site.getSiteNorthSouth());
		
		altitudeText.setText(String.format("%4.0f", site.getSiteAlt()));		
		utcOffsetText.setText(String.format("%3.1f", site.getUtcOffsetHr()));			
	}
	
	@Override
	public void setObserverData(Observer observer) {
		codeText.setText(observer.getObserverCode());
		nameText.setText(observer.getObserverName());
		
		teleShortText.setText(observer.getTelescopeShortName());
		teleFullText.setText(observer.getTelescopeLongName());
		apertureText.setText(String.format("%3.1f",  observer.getTelescopeAperture()));
		fLengthText.setText(String.format("%3.1f", observer.getTelescopeFocalLength()));
		
		cameraText.setText(observer.getCamera());
		horizPixelUmText.setText(String.format("%.2f", observer.getHorizPixelSize()));
		vertPixelUmText.setText(String.format("%.2f", observer.getVertPixelSize()));
		horizArrayText.setText(String.format("%d", observer.getHorizArraySize()));
		vertArrayText.setText(String.format("%d", observer.getVertArraySize()));
		
		darkCurrentText.setText(String.format("%.3f", observer.getDarkCurrent()));
		readoutNoiseText.setText(String.format("%.4f", observer.getReadoutNoise()));
		
		computeDerivedParameters();
		
	}
	
	@Override
	public Observer getObserverData() {	
		var observer = new Observer();

		observer.setObserverCode(codeText.getText());
		observer.setObserverName(nameText.getText());
		
		observer.setTelescopeShortName(teleShortText.getText());
		observer.setTelescopeLongName(teleFullText.getText());
		
		observer.setTelescopeAperture(Double.valueOf(apertureText.getText()));		
		observer.setTelescopeFocalLength(Double.valueOf(fLengthText.getText()));

		observer.setCamera(cameraText.getText());
		observer.setHorizPixelSize(Double.valueOf(horizPixelUmText.getText()));
		observer.setVertPixelSize(Double.valueOf(vertPixelUmText.getText()));
		
		observer.setHorizArraySize(Integer.valueOf(horizArrayText.getText()));
		observer.setVertArraySize(Integer.valueOf(vertArrayText.getText()));
		
		observer.setDarkCurrent(Double.valueOf(darkCurrentText.getText()));
		observer.setReadoutNoise(Double.valueOf(readoutNoiseText.getText()));
		
		return observer;
	}

	private void setUpActionHandlers() {

		// observer
		codeText.addActionListener(e -> nameText.requestFocus());
		nameText.addActionListener(e -> teleShortText.requestFocus());

		// telescope
		teleShortText.addActionListener(e -> teleFullText.requestFocus());
		teleFullText.addActionListener(e -> apertureText.requestFocus());
		apertureText.addActionListener(e -> verifyAperture());
		fLengthText.addActionListener(e -> verifyFocalLength());

		// camera
		cameraText.addActionListener(e -> horizPixelUmText.requestFocus());
		horizPixelUmText.addActionListener(e -> verfiyHorizPixelSize());
		vertPixelUmText.addActionListener(e -> verifyVertPixelSize());
		horizArrayText.addActionListener(e -> verifyHorizArraySize());
		vertArrayText.addActionListener(e -> verifyVertArraySize());

		// update & save
		update.addActionListener(e -> updateAll());
		save.addActionListener(e -> {
			ObserverTabProerties.writeProperties(this.getObserverData());			
		});
	}

	private void verifyVertArraySize() {
		var input = vertArrayText.getText();
		if (InputsVerifier.isPositiveDecimal(input)) {
			vertArrayText.setForeground(Color.BLACK);
			codeText.requestFocus();
		} else {
			vertArrayText.setForeground(Color.RED);
		}
	}

	private void verifyHorizArraySize() {
		var input = horizArrayText.getText();
		if (InputsVerifier.isPositiveDecimal(input)) {
			horizArrayText.setForeground(Color.BLACK);
			vertArrayText.requestFocus();
		} else {
			horizArrayText.setForeground(Color.RED);
		}
	}

	private void verifyVertPixelSize() {
		var input = vertPixelUmText.getText();
		if (InputsVerifier.isPositiveDecimal(input)) {
			// vertPixelSizeAsec.setText(getPixelSizeAsec(input));
			vertPixelUmText.setForeground(Color.BLACK);
			horizArrayText.requestFocus();
		} else {
			vertPixelUmText.setForeground(Color.RED);
		}
	}

	private void verfiyHorizPixelSize() {
		var input = horizPixelUmText.getText();
		if (InputsVerifier.isPositiveDecimal(input)) {
			// horizPixelSizeAsec.setText(getPixelSizeAsec(input));
			horizPixelUmText.setForeground(Color.BLACK);
			vertPixelUmText.requestFocus();
		} else {
			horizPixelUmText.setForeground(Color.RED);
		}
	}

	private void verifyFocalLength() {
		if (InputsVerifier.isPositiveDecimal(fLengthText.getText())) {
			this.fLength = Double.valueOf(fLengthText.getText());
			fLengthText.setForeground(Color.BLACK);
			cameraText.requestFocus();
		} else {
			fLengthText.setForeground(Color.RED);
		}
	}

	private void verifyAperture() {
		if (InputsVerifier.isPositiveDecimal(apertureText.getText())) {
			apertureText.setForeground(Color.BLACK);
			fLengthText.requestFocus();
		} else {
			apertureText.setForeground(Color.RED);
		}
	}

	// update inputs, compute pixel asec and fov params
	private void updateAll() {

		boolean isValid = InputsVerifier.isPositiveDecimal(fLengthText.getText())
				&& InputsVerifier.isPositiveDecimal(horizPixelUmText.getText())
				&& InputsVerifier.isPositiveDecimal(vertPixelUmText.getText())
				&& InputsVerifier.isPositiveDecimal(horizArrayText.getText())
				&& InputsVerifier.isPositiveDecimal(vertArrayText.getText());

		if (isValid) {
			computeDerivedParameters();
		} else {
			var message = "At least one data entry is invalid";
			JOptionPane.showMessageDialog(null, message);
		}

	}

	private void computeDerivedParameters() {
		setfLength();
		setHorizPixelAsecText();
		setVertPixelAsecText();
		setHorizFovAminText();
		setVertFovAminText();
	}

	
	// custom focal length setter
	public void setfLength() {
		this.fLength = Double.valueOf(this.fLengthText.getText());
	}
	
	
	public void writeObserTabProps(Properties prop) {
		
		
	}
	
	
//	public void setHorizPixelUm() {
//		this.horizPixelUm = Double.valueOf(this.horizPixelUmText.getText());
//	}
	
//	public void setVertPixelUm() {
//		this.vertPixelUm = Double.valueOf(this.vertPixelUmText.getText());
//	}
	
	
//	public void setHorizArraySize() {
//		this.horizArraySize = Double.valueOf(this.horizArrayText.getText());
//	}
	
//	public void setVertArraySize() {
//		this.vertArraySize = Double.valueOf(this.vertArrayText.getText());
//	}
	
	public void setHorizPixelAsecText() {
		var wpix = Double.valueOf(this.horizPixelUmText.getText());
		this.horizPixelAsec = 3600 * Math.toDegrees(Math.atan(0.001 * wpix / this.fLength));
		this.horizPixelAsecText.setText(String.format("%4.2f", this.horizPixelAsec));
	}
	
	public void setVertPixelAsecText() {
		var wpix = Double.valueOf(this.vertPixelUmText.getText());
		this.vertPixelAsec = 3600 * Math.toDegrees(Math.atan(0.001 * wpix / this.fLength));
		this.vertPixelAsecText.setText(String.format("%4.2f", this.vertPixelAsec ));
	}
	
	public void setHorizFovAminText() {
		var npix = Double.valueOf(this.horizArrayText.getText());
		var fovAsec = this.horizPixelAsec * npix;		
		this.horizFovAminText.setText(String.format("%4.2f", fovAsec / 60.0));		
	}
	
	
	public void setVertFovAminText() {
		var npix = Double.valueOf(this.vertArrayText.getText());
		var fovAsec = this.vertPixelAsec * npix;			
		this.vertFovAminText.setText(String.format("%4.2f", fovAsec / 60.0));		
	}

}
