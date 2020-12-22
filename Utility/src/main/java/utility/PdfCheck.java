package dummy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class PdfCheck {
	
	public static void main(String args[])
	{
		
		System.out.println("**********");
		
		 try
         {
			 
                 PdfReader pdfReader = new PdfReader("F:\\temp.pdf");
                 System.out.println(pdfReader.getPdfVersion());
                 System.out.println(pdfReader.getNumberOfPages());
                 System.out.println(pdfReader.getFileLength());
                 //PdfReader pdfReadernew = new PdfReader("F:\\cam-auto-loan.pdf");
                 FileOutputStream out=new FileOutputStream("newPdf.pdf");
                 PdfStamper pdfStamper = new PdfStamper(pdfReader, out);
                 //PdfContentByte canvas = pdfStamper.getOverContent(1);
                 //ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("Hello people!"), 250, 750, 0);
                 AcroFields acro=pdfStamper.getAcroFields();
                 
                 acro.setField("score anxiety", "20 high");
                 
                 acro.setField("addyName", "Addy Sriv");
                 System.out.println(pdfReader.getPdfVersion());
                 
                 //acaro.setGenerateAppearances(false);
                 pdfStamper.close();
                // pdfReader.close();
         }
         catch (IOException e)
         {
                 e.printStackTrace();
         }
         catch (DocumentException e)
         {
             e.printStackTrace();
         }
		
	}

}
