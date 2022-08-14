package com.github.richardflee.astroimagej.visibility_plotter;

import java.awt.Font;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.style.markers.SeriesMarkers;

/**
* Year scale
*
* <p>Demonstrates the following:
*
* <ul>
*   <li>Rotated 90 degrees X-Axis labels
*   <li>Setting custom X-Axis tick labels
*   <li>Setting custom cursor tool tip text
*/
public class DateChart09 implements ExampleChart<XYChart> {

 public static void main(String[] args) {

   ExampleChart<XYChart> exampleChart = new DateChart09();
   XYChart chart = exampleChart.getChart();
   new SwingWrapper<>(chart).displayChart();
 }

 @Override
 public XYChart getChart() {

   // Create Chart
   XYChart chart =
       new XYChartBuilder()
       	.width(800)
       	.height(600)
       	.title("StarAlt Plot - Starting night 2022-08-22")
       	.xAxisTitle("Local Site Time")
       	.yAxisTitle("Altitude (°)")
       	.build();

   // Customize Chart
   chart.getStyler().setLegendVisible(false);
  // chart.getStyler().setXAxisLabelRotation(90);
   chart.getStyler().setChartTitleFont(new Font("Calibri", Font.BOLD, 20));
   chart.getStyler().setAxisTitleFont(new Font("Calibri", Font.BOLD, 16));

   // Series
   List<Integer> xData = IntStream.range(0, 24*60).boxed().collect(Collectors.toList());
   Random random = new Random();

   List<Double> yData =
       IntStream.range(0, xData.size())
           .mapToDouble(x -> test(x))  //random.nextDouble())
           .boxed()
           .collect(Collectors.toList());

   chart.addSeries("altitude", xData, yData).setMarker(SeriesMarkers.NONE);

   // set custom X-Axis tick labels
   LocalDateTime startTime = LocalDateTime.of(2001, Month.JANUARY, 31, 12, 0, 0);
   DateTimeFormatter xTickFormatter = DateTimeFormatter.ofPattern("HH");
   
   chart
       .getStyler()
       .setxAxisTickLabelsFormattingFunction(
           x -> startTime.plusMinutes(x.longValue()).format(xTickFormatter));

//   // set custom cursor tool tip text
   chart.getStyler().setCursorEnabled(true);
   DateTimeFormatter cursorXFormatter = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm");
   chart
       .getStyler()
       .setCustomCursorXDataFormattingFunction(
           x -> startTime.plusMinutes(x.longValue()).format(cursorXFormatter));

   return chart;
 }
 
 double test(int x) {
	 final var scale = 1000.0;
	 var num = Math.pow(x,  0.5);
	 return Math.round(num * scale) / scale;
 }

 @Override
 public String getExampleChartName() {

   return getClass().getSimpleName() + " - Custom Date Formatter Without Years";
 }
}
