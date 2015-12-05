package helpMenu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class HelpMenu {
	
	/**
	 * @version 1.0 2015-12-04
	 * @author Yan
	 */
	
	   public static void main(String[] args)
	   {
	      EventQueue.invokeLater(new Runnable()
	         {
	            public void run()
	            {
	               ActionFrame frame = new ActionFrame();
	               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	               frame.setVisible(true);
	            }
	         });
	   }
}	

	/**
	 * A frame with a panel that demonstrates color change actions.
	 */
	class ActionFrame extends JFrame
	{
	   public ActionFrame()
	   {
	      setTitle("ActionTest");
	      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

	      buttonPanel = new JPanel();
	      
	      JMenuBar menuBar = new JMenuBar();
	      setJMenuBar(menuBar);

	     // add a "Help" menu in menu bar.
	      JMenu menu = new JMenu("Help");
	      menuBar.add(menu);
	     // add three items in the Help menu.
	      JMenuItem aboutItem = new JMenuItem("About POSystem");
	      JMenuItem authorItem = new JMenuItem("Authors");
	      JMenuItem docItem = new JMenuItem("Documentation");
	      
	     // add actions for aboutItem. 
	      
	      aboutItem.addActionListener(
	              new ActionListener(){
	                  public void actionPerformed(ActionEvent e)
	                  {
	                      
	                            TextFrame frame = new TextFrame();
	                          /*  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                            frame.setLocation(200 , 200);
	                            frame.setVisible(true);
	                          */
	                  }          
	              }
	          );
	      
	      // add actions for docItem.
	      
	      docItem.addActionListener(
	              new ActionListener(){
	                  public void actionPerformed(ActionEvent e)
	                  {
	                      
	                		       try {
	                		         //Set your page url in this string. For eg, I m using URL for Google Search engine
	                		         // only works in localhost.
	                		    	 String url2 = "https://www.google.de";
	                		         String url = "file:///C:/Users/woyan/Documents/MyWeb/POSystem.html";
	                		         java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
	                		       }
	                		       catch (java.io.IOException eX) {
	                		           System.out.println(eX.getMessage());
	                		       }
	                	}
	              }
	       
	          );
	      
	      menu.add(docItem);
	      menu.add(aboutItem);
	      menu.add(authorItem);
	      
       }
	   
	   
	   

	   private JPanel buttonPanel;

	   public static final int DEFAULT_WIDTH = 300;
	   public static final int DEFAULT_HEIGHT = 200;
	}

	class TextFrame extends JFrame {
		public TextFrame(){
		    setTitle("About POSystem");
	        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	        
	        Runnable r = new Runnable() {
	            public void run() {
	                String pt1 = "<html><body width='";
	                String pt2 =
	                    "'><h1>About POSystem</h1>" +
	                    "<p>POSystem is the abbreviation of the German word Pruefungsordnungssystem," +
	                    "which means Examination Regulation."; 
	          
	                JPanel p = new JPanel( new BorderLayout() );

	                
	                String s = pt1 + pt2;

	                JOptionPane.showMessageDialog(null, s);
	            }
	        };
	        SwingUtilities.invokeLater(r);
	    }
	    public static final int DEFAULT_WIDTH = 300;
		public static final int DEFAULT_HEIGHT = 200;
	}


