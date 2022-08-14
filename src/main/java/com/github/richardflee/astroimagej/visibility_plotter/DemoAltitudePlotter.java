/*
 * Created by JFormDesigner on Sat Aug 13 14:06:57 BST 2022
 */

package com.github.richardflee.astroimagej.visibility_plotter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.style.markers.SeriesMarkers;

import com.formdev.flatlaf.FlatLightLaf;
import com.github.richardflee.astroimagej.fileio.AijPropsReadWriter;

/**
 * @author Richard Lee
 */
public class DemoAltitudePlotter extends JFrame {
	
	private final static DateTimeFormatter X_CURSOR_FORMATTER = 
			DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm");
	private final static DateTimeFormatter X_TICK_FORMATTER = DateTimeFormatter.ofPattern("HH");
	
	private final static String ALTITUDE_SERIES = "Altitude";
	private final static int HINT_Y = 30;
	
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
			
			
			this.yData = getRndData();
			this.xyChart.updateXYSeries(ALTITUDE_SERIES, xData, yData, null);
			
			this.chartPanel.revalidate();
			this.chartPanel.repaint();

			//this.xyChart.getStyler().setCursorEnabled(true);
//			this.xyChart.getStyler().setCustomCursorXDataFormattingFunction(
//		            x -> startDate.plusMinutes(x.longValue()).format(X_CURSOR_FORMATTER));


			// this.xyChart.getStyler().setCursorEnabled(true);
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
		
//		styler.setCustomCursorXDataFormattingFunction(
//	            x -> startDate.plusMinutes(x.longValue()).format(X_CURSOR_FORMATTER));
		
		//styler.setCustomCursorYDataFormattingFunction(y -> y).format("%.2f");
		//  styler.setCustomCursorYDataFormattingFunction(y -> "hello yvalue: " + y);
		
		this.chartPanel = new XChartPanel<>(xyChart);
		
		demoPlotPanel.add(chartPanel, BorderLayout.CENTER);
		
	}
	

	
	public void updateChart(LocalDateTime startDate, List<Double> altitudeData) {
		this.startDate = startDate;
		this.yData = altitudeData;
		this.xData = IntStream.range(0, yData.size()).boxed().collect(Collectors.toList());
		
		setChartTitle();
		this.xyChart.addSeries(ALTITUDE_SERIES, this.xData, this.yData).setMarker(SeriesMarkers.NONE);

		// 
		xyChart.getStyler()
	     .setxAxisTickLabelsFormattingFunction(
	    		 x -> startDate.plusMinutes(x.longValue()).format(X_TICK_FORMATTER));
	
		this.setVisible(true);
			
	}

	private void setChartTitle() {
		var title = String.format("StarAlt Plot - Starting night: %s",
				DateTimeFormatter.ISO_LOCAL_DATE.format(this.startDate));		
		this.xyChart.setTitle(title);
	}
	
	
	private static List<Double> getRndData() {
		var num = Math.random() * 90.0;
		List<Double> data = IntStream
				.range(0, 24*60)
				.mapToDouble(x -> num) // random.nextDouble())
				.boxed().collect(Collectors.toList());	
		return data;
	}

	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatLightLaf());
			UIManager.put("TabbedPane.showTabSeparators", true);
			UIManager.put("TabbedPane.selectedBackground", Color.white);
			UIManager.put("OptionPane.minimumSize", new Dimension(500, 80));
		} catch (Exception ex) {
			System.err.println("Failed to initialize LaF");
		}
		
		
		// data
		var startDate = LocalDateTime.of(2022,  Month.AUGUST, 14, 12, 0, 0);
		var yData = getRndData();
		
		EventQueue.invokeLater(() -> {
			var plotter = new DemoAltitudePlotter();
			plotter.updateChart(startDate, yData);
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