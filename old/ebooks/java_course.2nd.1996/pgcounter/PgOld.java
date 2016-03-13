//******************************************************************************
// PgCount.java:	Applet
//
//******************************************************************************
import java.applet.*;
import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.*;							   


//==============================================================================
//	Class	PgCount
//==============================================================================

public class PgCount extends Applet
{
   public static final int BUFFER_SIZE= 64;
   public static final int SERVER_PORT= 4545;

   private byte[] buffer= new byte[BUFFER_SIZE];
   private long timer;

   private Scrollbar horz;
   private Label note;
   private int noteValue;
   private Button statis;

   // APPLET INFO SUPPORT:
   //		The getAppletInfo() method returns a string describing the applet's
   // author, copyright date, or miscellaneous information.
   //--------------------------------------------------------------------------
   public String getAppletInfo()
   {
      return "Name: PgOld\r\n" +
             "Author: Dilvan Moreira\r\n";
   }

   public void init()
   {
    

      Color corback= getBackground();
      setBackground(Color.white);

      //	Scrollbar for Notes
      horz = new Scrollbar(Scrollbar.HORIZONTAL, 5 ,1 , 0, 10);
      horz.setBackground(corback);
      note= new Label("?");
      note.setForeground(Color.red);
      noteValue= -1;

      //	Statis button
      statis= new Button("Statistics");
      statis.setBackground(corback);

      //	Label button
      Label label= new Label("What note do you give to this page?");
      label.setForeground(Color.blue);

      //Add the text field to the applet.
      setFont(new Font("Helvetica", Font.BOLD, 15));
      add(statis);
      add(new Label(" "));
      add(label);
      add(note);
      add(horz);
      validate();
   }

   public boolean handleEvent(Event evt) 
   {
      switch (evt.id) {
         case Event.SCROLL_LINE_UP:
         case Event.SCROLL_LINE_DOWN:
         case Event.SCROLL_PAGE_UP:
         case Event.SCROLL_PAGE_DOWN:
         case Event.SCROLL_ABSOLUTE:
            if (evt.target == horz) {
               noteValue= horz.getValue();
               note.setText(Integer.toString(noteValue));
            }
      }
      return super.handleEvent(evt);
   }

   public boolean action(Event e, Object arg) {
      Object target = e.target;
                  
      if (target == statis) {
         URL url;
         try {
            url= new URL(getDocumentBase(), "pgCountOld.html");
         } catch (java.net.MalformedURLException me) {
            showStatus("Error: URL malformed found.");
            return true;
         }
         getAppletContext().showDocument(url);
         return true;
      }
      return false;
   }

 
          
}


