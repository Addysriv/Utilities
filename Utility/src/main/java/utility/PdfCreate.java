package dummy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfCreate {

	private static Font mainHeading = new Font(Font.FontFamily.TIMES_ROMAN, 30,Font.BOLD);

	private static Font facetHeading = new Font(Font.FontFamily.TIMES_ROMAN, 22,Font.BOLD);

	private static Font subFacetHeading = new Font(Font.FontFamily.TIMES_ROMAN, 16,Font.BOLD);

	private static Font smallNormal = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
	
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	public static void main(String[] args) {
		System.out.println("Pdf started");
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("F://newPdf.pdf"));
			document.open();
			addMetaData(document);
			addTitlePage(document);
			addContent(document);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


		System.out.println("Pdf created");
	}



	private static void addMetaData(Document document) {
		document.addTitle("Contus");
		document.addSubject("Personality Test");
		document.addKeywords("Facets, PDF, iText");
		document.addAuthor("Contus");
		document.addCreator("Aditya Srivastava");
	}

	private static void addTitlePage(Document document)
			throws DocumentException, MalformedURLException, IOException {


		Image contusLogo = Image.getInstance("F://Logo.png");
		contusLogo.scaleToFit(100f, 200f);
		document.add(contusLogo);

		document.add(new Paragraph(" "));

		Paragraph preface1 = new Paragraph("The Results", mainHeading);

		preface1.setAlignment(Element.ALIGN_CENTER);


		document.add(preface1);

		// Start a new page
		//  document.newPage();
	}


	private static void addContent(Document document) {

		String cons="Conscientiousness";
		String open="Openness";
		String agree="Agreeableness";
		String neuro="Neuroticism";		
		String extr="Extraversion";
		
		try {
			
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			
			Paragraph preface = new Paragraph(neuro, facetHeading);
			
			document.add(preface);
			
			Paragraph neuroDef = new Paragraph();
			//addEmptyLine(neuroDef, 1);
			
			neuroDef.add(new Paragraph("Neuroticism refers to the tendency to experience negative feelings.", smallNormal));
			neuroDef.add(new Paragraph("Score - high", smallNormal));
			
			addEmptyLine(neuroDef, 1);
			
			neuroDef.add(new Paragraph("Your score on Neuroticism is high, indicating that you are easily upset, even by what most people consider the" + 
					"normal demands of living. People consider you to be sensitive and emotional.", smallBold));
			
			addEmptyLine(neuroDef, 1);
			
			neuroDef.add(new Paragraph("Freud originally used the term neurosis to describe a condition marked by mental distress, emotional suffering, and an" + 
					"inability to cope effectively with the normal demands of life. He suggested that everyone shows some signs of neurosis," + 
					"but that we differ in our degree of suffering and our specific symptoms of distress. Today neuroticism refers to the" + 
					"tendency to experience negative feelings. Those who score high on Neuroticism may experience primarily one" + 
					"specific negative feeling such as anxiety, anger, or depression, but are likely to experience several of these emotions." + 
					"People high in neuroticism are emotionally reactive. They respond emotionally to events that would not affect most" + 
					"people, and their reactions tend to be more intense than normal. They are more likely to interpret ordinary situations as" + 
					"threatening, and minor frustrations as hopelessly difficult. Their negative emotional reactions tend to persist for" + 
					"unusually long periods of time, which means they are often in a bad mood. These problems in emotional regulation" + 
					"can diminish a neurotic's ability to think clearly, make decisions, and cope effectively with stress.", smallNormal));
			
			document.add(neuroDef);

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}


	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

}
