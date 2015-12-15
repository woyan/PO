import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


public class HelloWorldPDF {
	public void writeMessage( String file, String message) throws IOException, COSVisitorException
    {
      // the document
     PDDocument doc = null;
      try

	         {

	             doc = new PDDocument();

	             PDPage page1 = new PDPage();

	             doc.addPage( page1 );


	             PDFont font = PDType1Font.HELVETICA_BOLD;


	             PDPageContentStream contentStream = new PDPageContentStream(doc, page1);

	             contentStream.beginText();

	
	             contentStream.setFont( font, 12 );


	             contentStream.moveTextPositionByAmount( 100, 700 );

	
	             contentStream.drawString( message );

	             contentStream.endText();

	             contentStream.close();

	             doc.save( file );
    }

	         finally

	         {


	             if( doc != null )


	             {


	                 doc.close();

	             }


	         }


	     }
	
	public static void main(String[] args)


	     {


	         HelloWorldPDF app = new HelloWorldPDF();


	         try



	        {


	                app.writeMessage("BlankPage.pdf", "We have corpus-informed dictionaries for English language learners at all levels. They’re ideal for anyone preparing for Cambridge English exams and IELTS.");
	  
	        }



	        catch (Exception e)
	        {
               e.printStackTrace();
            }


	    }
	 private void usage()
     {

       System.err.println( "usage: " + this.getClass().getName() + " <output-file> <Message>" );

	     }
	 }

