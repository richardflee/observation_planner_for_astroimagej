package com.github.richardflee.astroimagej.visibility_plotter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatePlotDemo {
	
	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	
	public LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
	
	public LocalDateTime convertToLocalDateTimeViaMilisecond(Date dateToConvert) {
	    return Instant.ofEpochMilli(dateToConvert.getTime())
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
	
	public static void main(String[] args) {
		Date date = new Date(); 
		System.out.println("The time in milliseconds is "+  date.getTime());
		System.out.println("The date is "+date.toString());

		Calendar c = Calendar.getInstance();
//		System.out.println("The year is "+ c.get(Calendar.YEAR)); 
//		System.out.println("The month is "+ c.get(Calendar.MONTH)); 
//		System.out.println("The day is "+ c.get(Calendar.DATE)); 
//		System.out.println("The hour is "+ c.get(Calendar.HOUR)); 
//		System.out.println("The day of the week is " + c.get(Calendar.DAY_OF_WEEK));
		
		var cc = new GregorianCalendar(2014, 2, 15, 12, 0, 0);
		System.out.println(cc.getTime().toString());
		
		
		var data = cc.getTime();
		var dpd = new DatePlotDemo();
		var x = dpd.convertToLocalDateViaInstant(cc.getTime());
		System.out.println(dpd.convertToLocalDateViaInstant(date).toString());
		System.out.println(dpd.convertToLocalDateTimeViaInstant(date).toString());
		System.out.println(dpd.convertToLocalDateTimeViaMilisecond(date).toString());
		
		

	}

}
