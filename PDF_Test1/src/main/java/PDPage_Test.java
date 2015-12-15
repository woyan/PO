import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDPixelMap;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;

public class PDPage_Test {
    public static void main (String[] args){
    	String outputFileName = "Student13.pdf";
    	Map<String, List<String>> linkedHashMap = new LinkedHashMap<String, List<String>>();
        List<String> strings1 = new ArrayList();
        List<String> strings2 = new ArrayList();
        List<String> strings3 = new ArrayList();
        List<String> strings4 = new ArrayList();
        List<String> strings5 = new ArrayList();
        strings1.add("001");
        strings2.add("21");
        strings3.add("math");
        strings3.add("informatik");
        strings4.add("recent survey by the National Association of Professional Organizers reveals that 54% of Americans feel overwhelmed by clutter and 78% have no idea what to do with it. According to psychologists, people accumulate things because they are unhappy but having too many posessions brings stress and more unhappiness. ");
        strings4.add("Have you already set your goals for the New Year? Do you want to lose 10 kilos, run a marathon or speak fluent English? Some experts believe that you need systems, not goals.");
        strings4.add("- -  -- - -- -  --- -- - -- ---- -- - -- -- -- - - - - - -  - - ----  - -  - - - - - -- - - - - --- - -  - - -- - -- - - - - - - -- - - - - - - - - - - - - - - -   ---  - --- ---- - -- ----");
        strings4.add("a a a a a a a a a a a a a a a a a a a a a a  a a aa  a a a  a a aa aa a a a  a a a a aa a aa a a a aa a  a a a a a  a a a a a a a  a a aa a a a a a a   aa a a a a a a a a a  aa a  a a a  a a a");
        linkedHashMap.put("StudentID",strings1 );
        linkedHashMap.put("age", strings2);
        linkedHashMap.put("majors",strings3);
        linkedHashMap.put("extra",strings4);
        try{makePDF(outputFileName,"Student Information",linkedHashMap);}
        catch(Exception e){
        	e.printStackTrace();
        }
    }	
    	
    	public static void makePDF(String outputFileName,String title, Map<String, List<String>> linkedHashMap)throws Exception{
	        //save all the keys in a string arrayList
    		List<String> keys_List = new ArrayList();
    		for (String key : linkedHashMap.keySet()) {
	               keys_List.add(key);
	        }
    		int num_keys = keys_List.size();
    		String[] keys = new String[num_keys];
    		keys = keys_List.toArray(keys);
    		//get the longest string in keys_List
    		String longest_string = MyDrawString.longest_string(keys_List);
    	  try{
		    // Create a document and add a page to it
	        PDDocument document = new PDDocument();
	        PDPage page1 = new PDPage(PDPage.PAGE_SIZE_A4);	            
	        PDRectangle rect = page1.getMediaBox();
	        document.addPage(page1);
	        // Create a new font object selecting one of the PDF base fonts
	        PDFont fontPlain = PDType1Font.HELVETICA;
	        PDFont fontBold = PDType1Font.HELVETICA_BOLD;
	       	// Start a new content stream which will "hold" the to be created content
	        PDPageContentStream cos = new PDPageContentStream(document, page1);

	        int line = 0;
	        // write the title in the center! 
	        int titleSize= 25;
	        int marginTop = 25;
	        float titleWidth = fontPlain.getStringWidth(title) / 1000 * titleSize;
	        float titleHeight = fontPlain.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * titleSize;
	        cos.beginText();
	        cos.setFont(fontPlain, 25);
	        cos.moveTextPositionByAmount((page1.getMediaBox().getWidth() - titleWidth) / 2, page1.getMediaBox().getHeight() - marginTop - titleHeight);
	        cos.drawString(title);
	        cos.endText();
	        line += 2;
	        float textwidth = fontPlain.getStringWidth(longest_string) / 1000 * 12 + 10;
	        int width = 450;
	        // draw two lines under the title. 
	         float right_y = rect.getHeight()-25*(++line);
	         cos.drawLine(0,right_y,rect.getUpperRightX(),right_y);
	         cos.drawLine(0,right_y-3, rect.getUpperRightX(), right_y-3);
	         // draw the text in format: studentID: 001
	         //                                age: 19
	         //                              major: math
	         //                                     informatik
	        line = 1;
	        for(int i = 0; i<num_keys; i++){
	          cos.beginText();
	          cos.setFont(fontPlain, 12);
	          float pos = textwidth - fontPlain.getStringWidth(keys[i]) / 1000 * 12;
	          cos.moveTextPositionByAmount(10+pos, right_y - 10*(++line));
	          // first draw the key.
	          cos.drawString(keys[i]+": ");
	          cos.endText();
              List<String> texts = linkedHashMap.get(keys[i]);
              // then draw the texts.
              for(String text : texts){
	            List<String> text_lines = MyDrawString.myDrawString(text,width,12,fontPlain);
	            for(String a_line : text_lines){
	        	  cos.beginText();
	        	  cos.setFont(fontPlain, 12);
	        	  System.out.println(a_line);
	        	  cos.moveTextPositionByAmount(50+textwidth, right_y - 10*(line++));
	        	  cos.drawString(a_line);
	        	  cos.endText();
                 }
              }              
	        }

	        // Make sure that the content stream is closed:
	        cos.close();
	        document.save(outputFileName);
	        document.close();
	        }
	        catch(Exception e){
	        	e.printStackTrace();
	        }
	        
	        /*
	        PDPage page2 = new PDPage(PDPage.PAGE_SIZE_A4);
	        document.addPage(page2);
	        cos = new PDPageContentStream(document, page2);

	        // draw a red box in the lower left hand corner
	        cos.setNonStrokingColor(Color.RED);
	        cos.fillRect(10, 10, 100, 100);

	        // add two lines of different widths
	        cos.setLineWidth(1);
	        cos.addLine(200, 250, 400, 250);
	        cos.closeAndStroke();
	        cos.setLineWidth(5);
	        cos.addLine(200, 300, 400, 300);
	        cos.closeAndStroke();
	        cos.close();
           */
	     
	        

	        // Save the results and ensure that the document is properly closed:
	        
	    }
	}


