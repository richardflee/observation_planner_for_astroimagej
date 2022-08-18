package com.github.richardflee.astroimagej.listeners;

import com.github.richardflee.astroimagej.data_objects.NoiseData;
import com.github.richardflee.astroimagej.data_objects.Observer;

public interface ObserverDataListener {
	
	public Observer getObserverData();
	public void setObserverData(Observer observer);
	
	public void setObservationSiteData();
	
	public void setNoiseData(NoiseData data);

}
