/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.xy.DefaultXYDataset;

/**
 *
 * @author Mkus
 */
public class MyChart {
    private XYPlot plot = new XYPlot();
    private JFreeChart chart = null;
    private ChartPanel chartPanel;
    private String valName;
    
    
    /**
     * Tworzy wykres sinusa o zadanej liczbie punktów
     * @param vName nazwa serii
     * @param pointNb liczba punktów wykresu
     * @return 
     */
     public ChartPanel createChart(String vName, int pointNb) {
        valName = vName;
        
        StandardXYItemRenderer renderer
            = new StandardXYItemRenderer(StandardXYItemRenderer.SHAPES_AND_LINES);
        renderer.setSeriesShapesFilled(0, true);
        
        DefaultXYDataset dataset = new DefaultXYDataset();
        dataset.addSeries(valName, calcSin(pointNb));
        
        plot = new XYPlot(dataset, new NumberAxis(), new NumberAxis(), renderer);         
        chart = new JFreeChart(plot);
        
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        chartPanel.setMouseZoomable(true, false);
        chartPanel.setVisible(true);
        
        return chartPanel;
    }
     
    public ChartPanel createGanttChart() {
        IntervalCategoryDataset dataset = getCategoryDataset();
    
      // Create chart
      JFreeChart chart = ChartFactory.createGanttChart(
            "Gantt Chart Example | Opel-PressShop ProductionSchedule", // Chart title
            "Machines", // X-Axis Label
            "Timeline", // Y-Axis Label
            dataset, false, false, false);

      ChartPanel panel = new ChartPanel(chart);
        
        return panel;
    }
     
     /**
      * Zwraca dwuwymiarową tablicę z rzędnymi i odciętymi wwykresu sinusa
      * @param pointNb liczba punktów wykresu
      * @return dane do wykresu
      */
     private double[][] calcSin(int pointNb) {
        double[][] y = new double[2][pointNb];
        for (int i = 0; i < pointNb; i++) {
            y[0][i] = (2*Math.PI/(pointNb-1))*i;
            y[1][i] = Math.sin((2*Math.PI/(pointNb-1))*i);   
        }
        return y;
     }
     
     private IntervalCategoryDataset getCategoryDataset() {

      TaskSeries series1 = new TaskSeries("Estimated Date");
      series1.add(new Task("Requirement",
            Date.from(LocalDate.of(2017, 7, 3).atStartOfDay().toInstant(ZoneOffset.UTC)),
            Date.from(LocalDate.of(2017, 7, 7).atStartOfDay().toInstant(ZoneOffset.UTC))
         ));
      
      series1.add(new Task("Design",
            Date.from(LocalDate.of(2017, 7, 10).atStartOfDay().toInstant(ZoneOffset.UTC)),
            Date.from(LocalDate.of(2017, 7, 14).atStartOfDay().toInstant(ZoneOffset.UTC))
         ));
      
      series1.add(new Task("Coding",
            Date.from(LocalDate.of(2017, 7, 17).atStartOfDay().toInstant(ZoneOffset.UTC)),
            Date.from(LocalDate.of(2017, 7, 21).atStartOfDay().toInstant(ZoneOffset.UTC))
         ));
      
      series1.add(new Task("Testing",
            Date.from(LocalDate.of(2017, 7, 24).atStartOfDay().toInstant(ZoneOffset.UTC)),
            Date.from(LocalDate.of(2017, 7, 28).atStartOfDay().toInstant(ZoneOffset.UTC))
         ));
      
      series1.add(new Task("Deployment",
            Date.from(LocalDate.of(2017, 07, 31).atStartOfDay().toInstant(ZoneOffset.UTC)),
            Date.from(LocalDate.of(2017, 8, 4).atStartOfDay().toInstant(ZoneOffset.UTC))
         ));
      
      
      TaskSeries series2 = new TaskSeries("Actual Date");
      series2.add(new Task("Requirement",
            Date.from(LocalDate.of(2017, 7, 3).atStartOfDay().toInstant(ZoneOffset.UTC)),
            Date.from(LocalDate.of(2017, 7, 05).atStartOfDay().toInstant(ZoneOffset.UTC))
         ));
      
      series2.add(new Task("Design",
            Date.from(LocalDate.of(2017, 7, 6).atStartOfDay().toInstant(ZoneOffset.UTC)),
            Date.from(LocalDate.of(2017, 7, 17).atStartOfDay().toInstant(ZoneOffset.UTC))
         ));
      
      series2.add(new Task("Coding",
            Date.from(LocalDate.of(2017, 7, 18).atStartOfDay().toInstant(ZoneOffset.UTC)),
            Date.from(LocalDate.of(2017, 7, 27).atStartOfDay().toInstant(ZoneOffset.UTC))
         ));
      
      series2.add(new Task("Testing",
            Date.from(LocalDate.of(2017, 7, 28).atStartOfDay().toInstant(ZoneOffset.UTC)),
            Date.from(LocalDate.of(2017, 8, 1).atStartOfDay().toInstant(ZoneOffset.UTC))
         ));
      
      series2.add(new Task("Deployment",
            Date.from(LocalDate.of(2017, 8, 2).atStartOfDay().toInstant(ZoneOffset.UTC)),
            Date.from(LocalDate.of(2017, 8, 4).atStartOfDay().toInstant(ZoneOffset.UTC))
         ));

      TaskSeriesCollection dataset = new TaskSeriesCollection();
      dataset.add(series1);
      dataset.add(series2);
      return dataset;
   }
}
