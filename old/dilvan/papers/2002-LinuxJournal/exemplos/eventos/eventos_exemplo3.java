import java.io.*;
import java.util.Locale;
import javax.speech.*;
import javax.speech.recognition.*;

public class eventos_exemplo3 {

    static RuleGrammar testeGrammar;

    static Recognizer recognizer;

    static RecognizerListener recognizerListener =
        new RecognizerAdapter(){
            public void recognizerProcessing(RecognizerEvent e) {
                System.out.println("Item being processed.");								
            }
            public void recognizerSuspended(RecognizerEvent e) {
                System.out.println("Recognizer suspended.");								
            }       
        };
   
    static ResultListener ruleListener =
        new ResultAdapter() {
              
            // accepted result
            public void resultAccepted(ResultEvent e) {
                try {
                    FinalRuleResult result = (FinalRuleResult) e.getSource();
                    String tags[] = result.getTags();

                    //put all tags in the same buffer
                    StringBuffer SB_comando = new StringBuffer();     

                    //append each recognized token
                    for(int i=0;i<tags.length;i++) {

                        // join each token to the end of the buffer 
                        SB_comando.append(tags[i]);
                    }

                    //print what was recoginized
                    System.out.println(SB_comando.toString());
                    if ((SB_comando.toString()).equals("suspend")) {
                        System.out.println("Recognizer being suspended.");
                        recognizer.suspend();							
                    }
                    else if ((SB_comando.toString()).equals("how")) {
                        System.out.println("Fine thanks, and you ?");
                    }
                    else if ((SB_comando.toString()).equals("bye")) {
                        System.exit(0);
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

    public static void main(String args[]) {
        System.out.println("Say hi -> for a greeting");
        System.out.println("Say how are you doing ? -> to know about the computer");
        System.out.println("Say bye -> to finish the app");
        System.out.println("Say suspend -> to test the recognizer");
        try {
            Locale.setDefault(new Locale("en","US"));

            //instanciate a recognizer
            recognizer = Central.createRecognizer(null);
         
            //associate the listener to the recognizer Engine
            recognizer.addEngineListener(recognizerListener);
         
            recognizer.allocate();						         
            //Load the rule grammar with the basic words for recognition
            Reader reader = new FileReader("teste.gram");
            testeGrammar = recognizer.loadJSGF(reader);

            //associate the listener
            testeGrammar.addResultListener(ruleListener);

            //activate the grammar
            testeGrammar.setEnabled(true);
            recognizer.commitChanges();
         
            recognizer.requestFocus();
         
            //resume work 
            recognizer.resume();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
