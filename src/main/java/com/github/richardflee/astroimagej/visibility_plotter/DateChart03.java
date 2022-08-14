package com.github.richardflee.astroimagej.visibility_plotter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.colors.XChartSeriesColors;
import org.knowm.xchart.style.markers.SeriesMarkers;

/**
 * Minute Scale * <p>Demonstrates the following: <ul> <li>Minute Scale <li>10^9
 * formatting <li>LegendPosition.InsideS <li>Two YAxis Groups - one on left, one
 * on right
 */
public class DateChart03 implements ExampleChart<XYChart> {

	public static void main(String[] args) {

		ExampleChart<XYChart> exampleChart = new DateChart03();
		XYChart chart = exampleChart.getChart();
		new SwingWrapper<>(chart).displayChart();
	}

	@Override
	public XYChart getChart() {

		// Create Chart
		XYChart chart = new XYChartBuilder().width(800).height(600).title("Minute Scale")
				.xAxisTitle("Local Site Time, starting night 2022-08-04").build();

		// Customize Chart
		chart.getStyler().setLegendPosition(Styler.LegendPosition.OutsideE);
		chart.getStyler().setYAxisGroupPosition(1, Styler.YAxisPosition.Right);

		// Series
		List<Date> xData1 = new ArrayList<>();
		List<Integer> ldtData = new ArrayList<>();

		List<Double> yData1 = new ArrayList<>();
		// List<Date> xData2 = new ArrayList<>();
		// List<Double> yData2 = new ArrayList<>();

		Random random = new Random();

		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss.SSS");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date date = null;

		var calendar = new GregorianCalendar(2013, 07, 22, 12, 0, 0);
		var ldt = LocalDateTime.of(2013, 07, 22, 12, 0, 0);

		for (int i = 0; i < 24 * 60; i++) {

			calendar.add(Calendar.MINUTE, 1);
			date = calendar.getTime();
			xData1.add(date);

			LocalDateTime ldtCurrent = ldt.plusMinutes(i);
			ldtData.add(ldtCurrent.getMinute());

			var ydata = i % 60;

			yData1.add(ydata * 1.0);
		}

		XYSeries series = chart.addSeries("series1", xData1, ldtData);
		series.setLineColor(XChartSeriesColors.PINK);
		series.setLineWidth(2);
		series.setMarker(SeriesMarkers.NONE);

		return chart;
	}

	@Override
	public String getExampleChartName() {

		return getClass().getSimpleName() + " - Minute Scale with Two Separate Y Axis Groups";
	}
}
