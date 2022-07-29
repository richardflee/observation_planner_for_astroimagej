package com.github.richardflee.astroimagej.tab_viewer;

import javax.swing.JTextField;

public class TargetTab {
	
	private JTextField objectIdText;
	private JTextField raText;
	private JTextField decText;
	private JTextField fovText;
	private JTextField magLimitText;
	
	
	public TargetTab(ViewerUI viewer) {
		
		objectIdText = viewer.getObjectIdField();
		raText = viewer.getRaField();
		decText = viewer.getDecField();
		fovText = viewer.getFovField();
		magLimitText = viewer.getMagLimitField();
		
		
		
		
		
		
	}
	

}
