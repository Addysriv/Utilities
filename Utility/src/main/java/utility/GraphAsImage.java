package dummy;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.PieChart;
import javafx.scene.image.WritableImage;

public class GraphAsImage {
	
	
	
	
	public static void createGraph() throws IOException {
		
		 ObservableList<PieChart.Data>pieChartData =
			      FXCollections.observableArrayList(
			      new PieChart.Data("Iphone 5S", 13),
			      new PieChart.Data("Samsung Grand", 25),
			      new PieChart.Data("MOTO G", 10),
			      new PieChart.Data("Nokia Lumia", 22));
			      //Creating a Pie chart
			      PieChart pieChart = new PieChart(pieChartData);
			      pieChart.setTitle("Mobile Sales");
			      pieChart.setClockwise(true);
			      pieChart.setLabelLineLength(50);
			      pieChart.setLabelsVisible(true);
			      pieChart.setStartAngle(180);
			      //Creating a Group object
			      Scene scene = new Scene(new Group(), 595, 400);
			      //stage.setTitle("Charts Example");
			      ((Group) scene.getRoot()).getChildren().add(pieChart);
			      //Saving the scene as image
			      WritableImage image = scene.snapshot(null);
			      File file = new File("F:\\tempPieChart.png");
			      ImageIO.write(SwingFXUtils.fromFXImage(image, null), "PNG", file);
			      System.out.println("Image Saved");
	}
	
	
	public static void main(String[] args) throws IOException {
		createGraph();
	}
}
