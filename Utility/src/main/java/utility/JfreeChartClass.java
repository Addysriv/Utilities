package dummy;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Stroke;
import java.io.File;
import java.io.IOException;

import javax.swing.text.NumberFormatter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleInsets;




public class JfreeChartClass {

	public static void main(String[] args) throws IOException {

		String labelForBar="  Facets according to big five traits ";
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

		dataset.addValue( 50 , labelForBar , "Conscientiousness" );
		dataset.addValue( 40 , labelForBar , "Openness" );
		dataset.addValue( 80 , labelForBar , "Agreeableness" );
		dataset.addValue( 10 , labelForBar , "Neuroticism" );
		dataset.addValue( 60 , labelForBar , "Extraversion" );

		Color color = new Color(255, 136, 42);

		JFreeChart barChart = ChartFactory.createBarChart(
				"", 
				"", "", 
				dataset,PlotOrientation.VERTICAL, 
				false, false, false);
		barChart.setBorderVisible(false);
		barChart.setBackgroundPaint(Color.white);

		final CategoryPlot plot = barChart.getCategoryPlot();
		plot.setAxisOffset(new RectangleInsets(0, 0, 3, 0));
		final CategoryItemRenderer renderer = plot.getRenderer();
		renderer.setSeriesItemLabelsVisible(0, Boolean.TRUE);
		renderer.setSeriesPaint(0, color);

		((BarRenderer) renderer).setBarPainter(new StandardBarPainter());
		Color lightColor=new Color(255, 229, 204);
		
		Stroke solid = new BasicStroke(8);
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setLowerMargin(0);
		ValueAxis valueAxis = plot.getRangeAxis();
		valueAxis.setTickLabelsVisible(false);
		valueAxis.setTickMarkOutsideLength(0); // longer tick lines
		valueAxis.setAxisLinePaint(lightColor); // X and Y axis line color
		valueAxis.setTickMarkPaint(lightColor); // tiny dashes sticking out every Nth value on Y axis
		valueAxis.setAxisLineStroke(solid);
		valueAxis.setTickMarkStroke(solid);
		valueAxis.setTickMarksVisible(false);
		
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setAxisLineStroke(solid);
		domainAxis.setTickMarkStroke(solid);
		domainAxis.setAxisLinePaint(lightColor); // X and Y axis line color
		domainAxis.setTickMarkPaint(lightColor);
		domainAxis.setTickMarkOutsideLength(0); 
		plot.getRenderer().setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator());  

		  CategoryPlot categoryPlot = barChart.getCategoryPlot();
	       BarRenderer rendererBar = (BarRenderer) categoryPlot.getRenderer();
	       Font font = new Font("AvenirNext", Font.PLAIN, 12);
	       
	       rendererBar.setBaseItemLabelFont(font); 
	       rendererBar.setSeriesItemLabelFont(0, font);
	       
	       domainAxis.setTickLabelFont(font);
		plot.setBackgroundPaint(Color.white);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		plot.setOutlineVisible(false);
		plot.setDrawSharedDomainAxis(false);

		int width = 740;    /* Width of the image */
		int height = 490;   /* Height of the image */ 
		File BarChart = new File( "F:\\BarChart.jpeg" ); 

		ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );

		System.out.println("Chart created");
	}

}
