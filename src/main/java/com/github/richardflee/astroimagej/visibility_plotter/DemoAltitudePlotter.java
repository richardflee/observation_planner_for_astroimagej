/*
 * Created by JFormDesigner on Sat Aug 13 14:06:57 BST 2022
 */

package com.github.richardflee.astroimagej.visibility_plotter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.style.markers.SeriesMarkers;

import com.github.richardflee.astroimagej.data_objects.BaseFieldObject;
import com.github.richardflee.astroimagej.data_objects.ObservationSite;
import com.github.richardflee.astroimagej.utils.AstroCoords;

/**
 * @author Richard Lee
 */
public class DemoAltitudePlotter extends JFrame {
	
	private final static DateTimeFormatter X_TICK_FORMATTER = DateTimeFormatter.ofPattern("HH");
	
	private final static String ALTITUDE_SERIES = "Altitude";
	private final static int HINT_Y = 30;
	private final static int GREY = 225;
	private final static Color BGND_GREY = new Color(GREY, GREY, GREY);
	
	private XYChart xyChart = null;
	private XChartPanel<XYChart> chartPanel = null;
	
	private ObjectTracker tracker = null;
	
	public DemoAltitudePlotter(ObservationSite site) {
				
		initComponents();
		
		this.tracker = new ObjectTracker(site);		
		this.xyChart = configureXyChart();
		this.chartPanel = new XChartPanel<>(xyChart);
		demoPlotPanel.add(chartPanel, BorderLayout.CENTER);
		this.setVisible(true);		
	}
	
	private XYChart configureXyChart() {
		var chart = new XYChartBuilder().title("pending..")
			.xAxisTitle("Local Site Time (hr)")
			.yAxisTitle("Altitude (deg)")
			.build();
	
		var styler = chart.getStyler();
		styler.setYAxisMin(0.0);
		styler.setYAxisMax(90.0);
		styler.setLegendVisible(false);
		styler.setYAxisTickMarkSpacingHint(HINT_Y);
		styler.setCursorEnabled(false);		
		styler.setChartBackgroundColor(BGND_GREY);
		
		var data = IntStream.range(0, TimesConverter.MINS_IN_DAY).boxed().collect(Collectors.toList());
		chart.addSeries(ALTITUDE_SERIES, data, data).setMarker(SeriesMarkers.NONE);
		return chart;		
	}
	

	
	public void updateChart(BaseFieldObject fo, LocalDate startDate) {
		
		var startDateTime = LocalDateTime.of(startDate,  TimesConverter.LOCAL_TIME_NOON);
		var yData = tracker.computeAltitudeData(fo, startDate);
		var xData = IntStream.range(0, yData.size()).boxed().collect(Collectors.toList());
		
		this.xyChart.updateXYSeries(ALTITUDE_SERIES, xData, yData, null);
		this.chartPanel.revalidate();
		this.chartPanel.repaint();			
		
//		xyChart.getStyler()
//	     .setxAxisTickLabelsFormattingFunction(
//	    		 x -> startDateTime.plusMinutes(x.longValue()).format(X_TICK_FORMATTER));
		
		xyChart.getStyler()
			.setxAxisTickLabelsFormattingFunction(
				x -> TimesConverter.LOCAL_TIME_NOON.plusMinutes(x.longValue()).format(X_TICK_FORMATTER));
	
		var title = String.format("StarAlt Plot - Starting night: %s",
				DateTimeFormatter.ISO_LOCAL_DATE.format(startDate));
		this.xyChart.setTitle(title);
	}

//	private void setChartTitle(LocalDate startDate) {
//		var title = String.format("StarAlt Plot - Starting night: %s",
//				DateTimeFormatter.ISO_LOCAL_DATE.format(startDate));		
//		this.xyChart.setTitle(title);
//	}
	
	
	public static void main(String[] args) {
		
		// site
		var siteLong = -85.5; // W
		var siteLat = 38.33; // N
		var siteElevation = 0.0;
		var site = new ObservationSite(siteLong, siteLat, siteElevation, -5.0);
		var plotter = new DemoAltitudePlotter(site);
		
		// object
		var objectId = "wasp12";
		var raHr = AstroCoords.raHmsToRaHr("06:30:32.797");
		var decDeg = AstroCoords.decDmsToDecDeg("+29:40:20.27");
		var fo = new BaseFieldObject(objectId, raHr, decDeg);
		
		// starting night
		var startDate = LocalDate.of(2019, 1, 1);	
		
		// startDate solar times
		var solar = new Solar(site);
		var solarTimes = solar.getCivilSunTimes(startDate);
		
		EventQueue.invokeLater(() -> {
			plotter.sunSetField.setText(solarTimes.getCivilSunSetValue());
			plotter.twilightEndField.setText(solarTimes.getCivilTwilightEndsValue());
			plotter.twilightStartField.setText(solarTimes.getCivilTwilightStartsValue());
			plotter.sunRiseField.setText(solarTimes.getCivilSunRiseValue());
			plotter.updateChart(fo, startDate);
		});
	}


	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		// Generated using JFormDesigner non-commercial license
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		demoPlotPanel = new JPanel();
		panel11 = new JPanel();
		label24 = new JLabel();
		label26 = new JLabel();
		sunSetField = new JTextField();
		twilightEndField = new JTextField();
		label27 = new JLabel();
		twilightStartField = new JTextField();
		label25 = new JLabel();
		sunRiseField = new JTextField();
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

				//======== panel11 ========
				{
					panel11.setBorder(new TitledBorder("Civil Solar Times "));
					panel11.setPreferredSize(new Dimension(190, 164));

					//---- label24 ----
					label24.setText("Sunset:");

					//---- label26 ----
					label26.setText("Twi End:");

					//---- sunSetField ----
					sunSetField.setToolTipText("<html>\nSet the target mag upper limit\n<p>Setting Upper = 0 disables this limit</p>\n<p>Range: 0 - 5 mag in 0.1 mag increment</p>\n</html>");
					sunSetField.setEditable(false);
					sunSetField.setText("00:00");

					//---- twilightEndField ----
					twilightEndField.setToolTipText("<html>\nSet the nominal target mag for the selected filter band\n<p>Use the scroll control  or type value in text box</p>\n<p>Range: 5.5 - 25 mag in 0.1 mag increment</p>\n</html>");
					twilightEndField.setEditable(false);
					twilightEndField.setText("00:00");

					//---- label27 ----
					label27.setText("Twi Start:");

					//---- twilightStartField ----
					twilightStartField.setToolTipText("<html>\nSet the nominal target mag for the selected filter band\n<p>Use the scroll control  or type value in text box</p>\n<p>Range: 5.5 - 25 mag in 0.1 mag increment</p>\n</html>");
					twilightStartField.setEditable(false);
					twilightStartField.setText("00:00");

					//---- label25 ----
					label25.setText("Sunrise");

					//---- sunRiseField ----
					sunRiseField.setToolTipText("<html>\nSet the target mag upper limit\n<p>Setting Upper = 0 disables this limit</p>\n<p>Range: 0 - 5 mag in 0.1 mag increment</p>\n</html>");
					sunRiseField.setEditable(false);
					sunRiseField.setText("00:00");

					GroupLayout panel11Layout = new GroupLayout(panel11);
					panel11.setLayout(panel11Layout);
					panel11Layout.setHorizontalGroup(
						panel11Layout.createParallelGroup()
							.addGroup(panel11Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(label24)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(sunSetField, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(label26)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(twilightEndField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(label27)
								.addGap(5, 5, 5)
								.addComponent(twilightStartField, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(label25)
								.addGap(5, 5, 5)
								.addComponent(sunRiseField, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(63, Short.MAX_VALUE))
					);
					panel11Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {sunSetField, twilightEndField});
					panel11Layout.setVerticalGroup(
						panel11Layout.createParallelGroup()
							.addGroup(panel11Layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(panel11Layout.createParallelGroup()
									.addGroup(panel11Layout.createSequentialGroup()
										.addGap(3, 3, 3)
										.addComponent(label25))
									.addComponent(sunRiseField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(panel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addGroup(panel11Layout.createParallelGroup()
											.addGroup(panel11Layout.createSequentialGroup()
												.addGap(3, 3, 3)
												.addComponent(label27))
											.addComponent(twilightStartField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(panel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label24)
											.addComponent(sunSetField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(label26)
											.addComponent(twilightEndField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					);
				}

				//---- okButton ----
				okButton.setText("OK");

				//---- cancelButton ----
				cancelButton.setText("Cancel");

				GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
				contentPanel.setLayout(contentPanelLayout);
				contentPanelLayout.setHorizontalGroup(
					contentPanelLayout.createParallelGroup()
						.addComponent(demoPlotPanel, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
						.addGroup(contentPanelLayout.createSequentialGroup()
							.addComponent(panel11, GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(contentPanelLayout.createParallelGroup()
								.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
							.addGap(10, 10, 10))
				);
				contentPanelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {cancelButton, okButton});
				contentPanelLayout.setVerticalGroup(
					contentPanelLayout.createParallelGroup()
						.addGroup(contentPanelLayout.createSequentialGroup()
							.addComponent(demoPlotPanel, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
							.addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addGroup(contentPanelLayout.createSequentialGroup()
									.addGap(18, 18, 18)
									.addComponent(okButton)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(cancelButton))
								.addGroup(contentPanelLayout.createSequentialGroup()
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
									.addComponent(panel11, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())
				);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);
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
	private JPanel panel11;
	private JLabel label24;
	private JLabel label26;
	protected JTextField sunSetField;
	protected JTextField twilightEndField;
	private JLabel label27;
	protected JTextField twilightStartField;
	private JLabel label25;
	protected JTextField sunRiseField;
	private JButton okButton;
	private JButton cancelButton;
	// JFormDesigner - End of variables declaration //GEN-END:variables

	
}