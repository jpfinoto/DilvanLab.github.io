import java.util.Locale;
import java.util.StringTokenizer;
import javax.speech.*;
import javax.speech.recognition.*;

public class reconhecimento_exemplo3 {
   
    static DictationGrammar dictationGrammar;
    static Recognizer recognizer;
   
   
    //listener of the dictation grammar
    static ResultListener dictationListener = 
        new ResultAdapter() {

            // number of tokens seen so far
            int n = 0;
         
            public void resultUpdated(ResultEvent e) {
                Result result = (Result) e.getSource();
                for (int i=n; i<result.numTokens(); i++)
                    System.out.println("XXXXXX "+result.getBestToken(i).getSpokenText());
                    n = result.numTokens();
            	    System.out.println("RESULT UPDATED");
                }
         
            public void resultAccepted(ResultEvent e) {
                Result result = (Result) e.getSource();
                String s = "";
                for (int i=0; i<n; i++)
                    s += result.getBestToken(i).getSpokenText() + " ";
                    System.out.println(s);
                    n = 0;
            	    System.out.println("RESULT ACCEPTED");
            }
        };
   
    public static void main(String args[]) {
        try {
            Locale.setDefault(new Locale("en","US"));
            recognizer = Central.createRecognizer(null);
            recognizer.allocate();
         
            //create a dictation grammar with the recognizer aid
            dictationGrammar = recognizer.getDictationGrammar(null);
         	
            //associate a listener to the created grammar
            dictationGrammar.addResultListener(dictationListener);

            //test if the grammar is working
            dictationGrammar.setEnabled(true);
         
            //commit changes
            recognizer.commitChanges();
            recognizer.requestFocus();
            recognizer.resume();
        } 
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}

