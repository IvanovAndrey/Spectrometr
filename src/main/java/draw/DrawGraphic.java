package draw;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class DrawGraphic {
    public static void drawGraph(int [] input, int[][] patterns) {
        XYSeries series = new XYSeries("input");
        for (int i = 0; i < input.length; i ++) {
            series.add(i, input[i]);
        }
        XYSeries series1 = new XYSeries("data1");
        XYSeries series2 = new XYSeries("data2");
        XYSeries series3 = new XYSeries("data3");

        for (int i = 0; i < patterns[0].length; i ++) {
            series1.add(i, patterns[0][i]);
            series2.add(i, patterns[1][i]);
            series3.add(i, patterns[2][i]);
        }

        XYSeriesCollection xyDataset = new XYSeriesCollection();
        xyDataset.addSeries(series);
        xyDataset.addSeries(series1);
        xyDataset.addSeries(series2);
        xyDataset.addSeries(series3);
        JFreeChart chart = ChartFactory
                .createXYLineChart("Graphic title", "x", "y",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);
        JFrame frame =
                new JFrame("MinimalStaticChart");
        frame.getContentPane()
                .add(new ChartPanel(chart));
        frame.setSize(1000, 650);
        frame.show();
    }
}
