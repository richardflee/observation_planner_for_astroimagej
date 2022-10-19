package com.github.richardflee.astroimagej.tab_viewer;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.github.richardflee.astroimagej.data_objects.NoiseData;
import com.github.richardflee.astroimagej.data_objects.ObservationSite;
import com.github.richardflee.astroimagej.data_objects.Observer;
import com.github.richardflee.astroimagej.fileio.AijPropsReadWriter;
import com.github.richardflee.astroimagej.fileio.ObserverTabPropertiesFile;
import com.github.richardflee.astroimagej.utils.InputsVerifier;

public class ObserverTab {

	private ObservationSite site = null;
	
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
	private JTextField vertPixelUmText;
	private JTextField horizArrayText;
	private JTextField vertArrayText;

	// computed pixel array params
	private JTextField horizPixelAsecText;
	private double horizPixelAsec = 0.0;
	
	private JTextField vertPixelAsecText;
	private double vertPixelAsec = 0.0;
	
	private JTextField horizFovAminText;
	private JTextField vertFovAminText;
	
	private JTextField gainText;
	private JTextField readoutNoiseText;
	private JTextField darkCurrentText;
	
	private JTextField latitudeText;
	private JTextField longitudeText;
	private JTextField altitudeText;
	private JTextField utcOffsetText;
	
	private JTextField northSouthText;
	private JTextField eastWestText;

	private JButton save;
	private JButton update;
	
	private VerifyTextFields verifier;
	
	public ObserverTab() {}
	
	public ObserverTab(ViewerUi viewer, ObservationSite site) {
		
		// this.viewer = viewer;
		this.site = site;
		this.verifier = new VerifyTextFields();

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
		
		gainText = viewer.getGainField();
		readoutNoiseText = viewer.getReadoutNoiseField();
		darkCurrentText = viewer.getDarkCurrentField();
		
		latitudeText = viewer.getLatitudeField();
		longitudeText = viewer.getLongitudeField();
		altitudeText = viewer.getAltitudeField();
		utcOffsetText = viewer.getUtcOffsetField();
		
		northSouthText = viewer.getNorthSouthField();
		eastWestText = viewer.getEastWestField();

		save = viewer.getSaveObserverButton();
		update = viewer.getUpdateParamsButton();

		setUpActionListeners();		
	}
	
	/**
	 * writes CCD noise data from AIJ_Prefs.txt file to observert tab text controls
	 */
	public void setNoiseData(NoiseData noiseData) {
		gainText.setText(noiseData.getCcdGain());
		readoutNoiseText.setText(noiseData.getCcdNoise());
		darkCurrentText.setText(noiseData.getCcdDark());		
	}
	
	public void setObservationSiteData() {
		longitudeText.setText(this.site.getSiteLongDms());
		eastWestText.setText(this.site.getSiteEastWest());
		
		latitudeText.setText(this.site.getSiteLatDms());
		northSouthText.setText(this.site.getSiteNorthSouth());
		
		altitudeText.setText(String.format("%4.0f", this.site.getSiteAlt()));		
		utcOffsetText.setText(String.format("%3.1f", this.site.getUtcOffsetHr()));			
	}
	
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
		
		getDerivedParameters();
		
	}
	
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
		return observer;
	}

	private void setUpActionListeners() {

		// observer
		codeText.addActionListener(e -> nameText.requestFocus());
		nameText.addActionListener(e -> teleShortText.requestFocus());

		// telescope
		teleShortText.addActionListener(e -> teleFullText.requestFocus());
		teleFullText.addActionListener(e -> apertureText.requestFocus());
		apertureText.addActionListener(e -> verifier.verifyAperture());
		fLengthText.addActionListener(e -> verifier.verifyFocalLength());

		// camera
		cameraText.addActionListener(e -> horizPixelUmText.requestFocus());
		horizPixelUmText.addActionListener(e -> verifier.verfiyHorizPixelSize());
		vertPixelUmText.addActionListener(e -> verifier.verifyVertPixelSize());
		horizArrayText.addActionListener(e -> verifier.verifyHorizArraySize());
		vertArrayText.addActionListener(e -> verifier.verifyVertArraySize());

		// update & save
		update.addActionListener(e -> verifier.verifyAllTextInputs());
		
		save.addActionListener(e -> {
			if (verifier.verifyAllTextInputs() == true) {
				ObserverTabPropertiesFile.writeProperties(this.getObserverData());
				JOptionPane.showMessageDialog(null,  AijPropsReadWriter.savedFileMessage());
			}
		});
	}
	

	private void getDerivedParameters() {
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
	
	
	private class VerifyTextFields {
		
//		VerifyTextFields() { }
		private boolean verifyAperture() {
			var isValid = InputsVerifier.isPositiveDecimal(apertureText.getText());
			if (isValid) {
				apertureText.setForeground(Color.BLACK);
				fLengthText.requestFocus();
			} else {
				apertureText.setForeground(Color.RED);
				apertureText.requestFocus();
			}
			return isValid;
		}
		
		private boolean verifyFocalLength() {
			var isValid = InputsVerifier.isPositiveDecimal(fLengthText.getText());
			if (isValid) {
				ObserverTab.this.fLength = Double.valueOf(fLengthText.getText());
				fLengthText.setForeground(Color.BLACK);
				cameraText.requestFocus();
			} else {
				fLengthText.setForeground(Color.RED);
				fLengthText.requestFocus();
			}
			return isValid;
		}
		
		private boolean verfiyHorizPixelSize() {
			var input = horizPixelUmText.getText();
			var isValid = InputsVerifier.isPositiveDecimal(input);
			if (isValid) {
				// horizPixelSizeAsec.setText(getPixelSizeAsec(input));
				horizPixelUmText.setForeground(Color.BLACK);
				vertPixelUmText.requestFocus();
			} else {
				horizPixelUmText.setForeground(Color.RED);
				horizArrayText.requestFocus();
			}
			return isValid;
		}
		
		private boolean verifyVertPixelSize() {
			var input = vertPixelUmText.getText();
			var isValid = InputsVerifier.isPositiveDecimal(input);
			if (isValid) {
				// vertPixelSizeAsec.setText(getPixelSizeAsec(input));
				vertPixelUmText.setForeground(Color.BLACK);
				horizArrayText.requestFocus();
			} else {
				vertPixelUmText.setForeground(Color.RED);
				vertArrayText.requestFocus();
			}
			return isValid;
		}

		private boolean verifyHorizArraySize() {
			var input = horizArrayText.getText();
			var isValid = InputsVerifier.isPositiveDecimal(input);
			if (isValid) {
				horizArrayText.setForeground(Color.BLACK);
				vertArrayText.requestFocus();
			} else {
				horizArrayText.setForeground(Color.RED);
				horizArrayText.requestFocus();
			}
			return isValid;
		}

		private boolean verifyVertArraySize() {
			var input = vertArrayText.getText();
			var isValid = InputsVerifier.isPositiveDecimal(input);
			if (isValid) {
				vertArrayText.setForeground(Color.BLACK);
				codeText.requestFocus();
			} else {
				vertArrayText.setForeground(Color.RED);
				vertArrayText.requestFocus();
			}
			return isValid;
		}	
		
		 // update inputs, compute pixel asec and fov params
		private boolean verifyAllTextInputs() {
	
			boolean isValid =  verifyAperture() && verifyFocalLength()
					&& verfiyHorizPixelSize() && verifyVertPixelSize()
					&& verifyHorizArraySize()  && verifyVertArraySize();
	
			if (isValid) {
				getDerivedParameters();
			} else {
				var message = "At least one data entry is invalid";
				JOptionPane.showMessageDialog(null, message);
			}
			return isValid;
		}
	}
	
}
