/*
 * Created by JFormDesigner on Sat Aug 13 14:06:57 BST 2022
 */

package com.github.richardflee.astroimagej.visibility_plotter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.knowm.xchart.AnnotationLine;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.style.markers.SeriesMarkers;

import com.github.richardflee.astroimagej.data_objects.BaseFieldObject;
import com.github.richardflee.astroimagej.data_objects.ObservationSite;
import com.github.richardflee.astroimagej.utils.AstroCoords;
import com.github.richardflee.astroimagej.visibility_plotter.CoordsConverter.CoordsEnum;

/**
 * @author Richard Lee
 */
public class DemoAltitudePlotter extends JFrame {
	
	private final static DateTimeFormatter X_TICK_FORMATTER = DateTimeFormatter.ofPattern("HH");
	
	private final static String ALTITUDE_SERIES = "Altitude";
	private final static int HINT_Y = 30;
	public final static int MINS_IN_DAY = 24 * 60;
	
	private LocalDateTime startDate = null;
	private List<Integer> xData = null;
	private List<Double> yData = null;
	
	private XYChart xyChart = null;
	private XChartPanel<XYChart> chartPanel = null;
	
	public DemoAltitudePlotter() {
		
		initComponents();
		
		okButton.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "here i am");
			this.startDate = this.startDate.plusDays(1);
			setChartTitle();
			
			this.xyChart.updateXYSeries(ALTITUDE_SERIES, xData, yData, null);
			this.chartPanel.revalidate();
			this.chartPanel.repaint();
		});
		
		cancelButton.addActionListener(e -> {
			var sunset = LocalDateTime.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth(), 21,  12, 0);
			
			long numberOfMinutes = ChronoUnit.MINUTES.between(startDate, sunset);
			System.out.println(numberOfMinutes);
			
			this.xyChart.addAnnotation( new AnnotationLine(12*60, true, false));
			this.chartPanel.revalidate();
			this.chartPanel.repaint();
			
		});
		
		this.xyChart = new XYChartBuilder().title("pending..")
				.xAxisTitle("Local Site Time (hr)")
				.yAxisTitle("Altitude (deg)")
				.build();
		
		var styler = this.xyChart.getStyler();
		styler.setYAxisMin(0.0);
		styler.setYAxisMax(90.0);
		styler.setLegendVisible(false);
		styler.setYAxisTickMarkSpacingHint(HINT_Y);
		styler.setCursorEnabled(false);
		
		this.chartPanel = new XChartPanel<>(xyChart);
		
		demoPlotPanel.add(chartPanel, BorderLayout.CENTER);
		
	}
	

	
	public void updateChart(LocalDateTime startDateTime, List<Double> altitudeData) {
		this.startDate = startDateTime;
		this.yData = altitudeData;
		this.xData = IntStream.range(0, yData.size()).boxed().collect(Collectors.toList());
		
		setChartTitle();
		this.xyChart.addSeries(ALTITUDE_SERIES, this.xData, this.yData).setMarker(SeriesMarkers.NONE);

		// 
		xyChart.getStyler()
	     .setxAxisTickLabelsFormattingFunction(
	    		 x -> startDateTime.plusMinutes(x.longValue()).format(X_TICK_FORMATTER));
	
		this.setVisible(true);
			
	}

	private void setChartTitle() {
		var title = String.format("StarAlt Plot - Starting night: %s",
				DateTimeFormatter.ISO_LOCAL_DATE.format(this.startDate));		
		this.xyChart.setTitle(title);
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
		
		// times converter, CoordsConverter
		var tc = new TimesConverter(site);
		var coords = new CoordsConverter(fo, site);
		
		// convert start date time to utc
		var utc0 = tc.convertCivilDateTimeToUtc(startDateTime);
		
		var yData = new ArrayList<Double>();
		for (int minutes = 0; minutes < MINS_IN_DAY; minutes++) {
			var t = utc0.plusMinutes(minutes);			
			var altDeg = coords.getAltAzm(t).get(CoordsEnum.ALT_DEG);
			yData.add(altDeg);
		}
		
		EventQueue.invokeLater(() -> {
			var plotter = new DemoAltitudePlotter();
			plotter.updateChart(startDateTime, yData);
		});
		
		

	}


	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		// Generated using JFormDesigner non-commercial license
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		demoPlotPanel = new JPanel();
		buttonBar = new JPanel();
		okButton = new JButton();
		cancelButton = new JButton();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		var contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{
				contentPanel.setPreferredSize(new Dimension(850, 450));

				//======== demoPlotPanel ========
				{
					demoPlotPanel.setBorder(LineBorder.createBlackLineBorder());
					demoPlotPanel.setLayout(new BorderLayout());
				}

				GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
				contentPanel.setLayout(contentPanelLayout);
				contentPanelLayout.setHorizontalGroup(
					contentPanelLayout.createParallelGroup()
						.addComponent(demoPlotPanel, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
				);
				contentPanelLayout.setVerticalGroup(
					contentPanelLayout.createParallelGroup()
						.addComponent(demoPlotPanel, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
				);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			//======== buttonBar ========
			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
				((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

				//---- okButton ----
				okButton.setText("OK");
				buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- cancelButton ----
				cancelButton.setText("Cancel");
				buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			dialogPane.add(buttonBar, BorderLayout.SOUTH);
		}
		contentPane.add(dialogPane, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY //GEN-BEGIN:variables
	// Generated using JFormDesigner non-commercial license
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JPanel demoPlotPanel;
	private JPanel buttonBar;
	private JButton okButton;
	private JButton cancelButton;
	// JFormDesigner - End of variables declaration //GEN-END:variables

	
}