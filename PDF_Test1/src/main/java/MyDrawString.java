import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


public class MyDrawString {
   public static List<String> myDrawString(String text, int width, int fontSize, PDFont font) throws IOException{
	   List<String> lines = new ArrayList<String>();

       String myLine = "";
       String[] words = text.split(" ");
       for(String word : words) {
          if(!myLine.isEmpty()) {
               myLine += " ";
           }

           int size = (int) (fontSize * font.getStringWidth(myLine + word) / 1000);
           if(size > width) {
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
	   return lines;
   }
   
   public static String longest_string(List<String> strings){
	   String longest_string = "";
	   for(String str : strings){
		   if (str.length()>longest_string.length())
			   longest_string = str;
	   }
	   return longest_string;
   }
   
   
   public static void main(String[] args) throws IOException{
	   String text = "study computer science in the 5th. semster. Have got already 120 credit points. 60 credit points are still missing.It should be"
	   		+ "       much longer. test test. need a relatv long text to test!  merry Chrismas! happy new year! Is it long enough? I am not quite sure "
	   		+ "       about it";
	   PDFont font = PDType1Font.HELVETICA;
	   int fontSize = 14;
	   int width = 100;
	   List<String> lines = myDrawString(text,width,fontSize,font);
	   for(String line:lines)
	      System.out.println(line);
   }
}
