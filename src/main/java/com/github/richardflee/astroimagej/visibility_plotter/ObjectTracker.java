package com.github.richardflee.astroimagej.visibility_plotter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import com.github.richardflee.astroimagej.data_objects.BaseFieldObject;
import com.github.richardflee.astroimagej.data_objects.ObservationSite;
import com.github.richardflee.astroimagej.utils.AstroCoords;
import com.github.richardflee.astroimagej.visibility_plotter.CoordsConverter.CoordsEnum;

/**
* Creates 24 hr StarAlt tracker data in 1 minute intervals starting and ending at noon.abstract
*/

public class ObjectTracker {
	
	private ObservationSite site = null;
	private TimesConverter timesConverter = null;
	
	public ObjectTracker(ObservationSite site) {
		this.site = site;
		this.timesConverter = new TimesConverter(site);		
	}
	
	/**
	 * Generates a list of star altitudes in 1 minute intervals over 24 hr period, 
	 * Staring from noon on star date to next day noon.
	 * 
	 * @param fo stellar object to track
	 * @param startDate first observation day
	 * @return list of star altitudes in deg
	 */
	public List<Double> updateStarAltTrack(BaseFieldObject fo, LocalDate startDate) {
		
		var yData = new ArrayList<Double>();
		var coords = new CoordsConverter(fo, this.site);
		
		// converts start date time noon to utc0
		var startDateTime = LocalDateTime.of(startDate, TimesConverter.LOCAL_TIME_NOON);
		var utc0 = timesConverter.convertCivilDateTimeToUtc(startDateTime);
		
		// compiles altitude array
		for (int minutes = 0; minutes < TimesConverter.MINS_IN_DAY; minutes++) {
			var utc = utc0.plusMinutes(minutes);			
			// var altDeg = coords.getAltAzm(utc).get(CoordsEnum.ALT_DEG);
			var altDeg = coords.getAltDeg(utc);
			yData.add(altDeg);
		}			
		return yData;		
	}
	
	public static void main(String[] args) {
		// site
		var siteLong = -85.5; // W
		var siteLat = 38.33; // N
		var siteElevation = 0.0;
		var site = new ObservationSite(siteLong, siteLat, siteElevation, -5.0);
		
		// object
		var objectId = "wasp12";
		var raHr = AstroCoords.raHmsToRaHr("06:30:32.797");
		var decDeg = AstroCoords.decDmsToDecDeg("+29:40:20.27");
		var fo = new BaseFieldObject(objectId, raHr, decDeg);
		
		// starting night
		var startDate = LocalDate.of(2019, 1, 1);	
		var startDateTime = LocalDateTime.of(startDate, TimesConverter.LOCAL_TIME_NOON);
		System.out.println(startDateTime.toString());
		
		var tracker = new ObjectTracker(site);
		var X_TICK_FORMATTER = DateTimeFormatter.ofPattern("HH");
		
		var yData = tracker.updateStarAltTrack(fo,  startDate);
		var xData = IntStream.range(0, yData.size()).boxed().collect(Collectors.toList());
		
		var chart = QuickChart.getChart("Star Alt", "Civil Time (hr)", "Altitude", "data", xData, yData);
		chart.getStyler()
	     .setxAxisTickLabelsFormattingFunction(
	    		 x -> startDateTime.plusMinutes(x.longValue()).format(X_TICK_FORMATTER));
		new SwingWrapper<XYChart>(chart).displayChart();
	}

}
