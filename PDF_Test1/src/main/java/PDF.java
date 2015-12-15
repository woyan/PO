
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDF{
    public static void main(String[] args)throws COSVisitorException, IOException{
    	PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage( page );
        PDPageContentStream contentStream = new PDPageContentStream(doc, page);	
        PDFont font = PDType1Font.HELVETICA_BOLD;
        String text = "StudentID:" + "12";
        String text2 = "StudentInfo: " + "study computer science in the 5th. semster. Have got already 120 credit points. 60 credit points are still missing.";
        System.out.println("The size of the page is: " + page.getMediaBox());
        drawMultiLineText(text,10,600,790,page,contentStream,font,12,40);
        //drawMultiLineText(text2,10,650,500,page,contentStream,font,12,40);
        doc.save("student.pdf");
        doc.close();
    }
    /**
     * @param text The text to write on the page.
     * @param x The position on the x-axis.
     * @param y The position on the y-axis.
     * @param allowedWidth The maximum allowed width of the whole text (e.g. the width of the page - a defined margin).
     * @param page The page for the text.
     * @param contentStream The content stream to set the text properties and write the text.
     * @param font The font used to write the text.
     * @param fontSize The font size used to write the text.
     * @param lineHeight The line height of the font (typically 1.2 * fontSize or 1.5 * fontSize).
     * @throws IOException
     */
    private static void drawMultiLineText(String text, int x, int y, int allowedWidth, PDPage page, PDPageContentStream contentStream, PDFont font, int fontSize, int lineHeight) throws IOException {

        List<String> lines = new ArrayList<String>();

        String myLine = "";
        String[] words = text.split(" ");
        for(String word : words) {
           if(!myLine.isEmpty()) {
                myLine += " ";
            }

            int size = (int) (fontSize * font.getStringWidth(myLine + word) / 1000);
            if(size > allowedWidth) {
                // if the line would be too long with the current word, add the line without the current word
                lines.add(myLine);

                // and start a new line with the current word
                myLine = word;
            } else {
                // if the current line + the current word would fit, add the current word to the line
                myLine += word;
            }
        }
        // add the rest to lines
        lines.add(myLine);

        for(String line : lines) {
        	try{
        
	            contentStream.beginText();
	            contentStream.setFont(font, fontSize);
	            contentStream.moveTextPositionByAmount(x, y);
	            contentStream.drawString(line);
	            contentStream.endText();
        	    y -= lineHeight;
             }
        	catch (Exception e)
	        {
               e.printStackTrace();
            }
        	
           }
        
         contentStream.close();
    }
  }
  
