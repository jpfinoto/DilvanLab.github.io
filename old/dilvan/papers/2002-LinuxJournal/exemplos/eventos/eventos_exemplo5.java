import java.io.*;
import java.util.Locale;
import javax.speech.*;
import javax.speech.recognition.*;

public class eventos_exemplo5 {
    static RuleGrammar testeGrammar;
    static Recognizer recognizer;
   
    static GrammarListener grammarListener =
        new GrammarAdapter(){
            public void grammarActivated(GrammarEvent e) {
                System.out.println("Grammar activated");
            }
            public void grammarDeactivated(GrammarEvent e) {
                System.out.println("Grammar deactivated.");
            }
            public void changesCommited(GrammarEvent e) {
                System.out.println("Changes commited.");
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

                    if ((SB_comando.toString()).equals("deactivate")) {
                        System.out.println("Deactivating the grammar.");
                        testeGrammar.setEnabled(false);
                        recognizer.commitChanges();
                        for(int i=0;i<100000000;i++){}
                        System.out.println("Reactivating the grammar.");
                        testeGrammar.setEnabled(true);
                        recognizer.commitChanges();
                    }

                    if ((SB_comando.toString()).equals("hi")) {
                        System.out.println("hi, my name is computer.");
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
        System.out.println("Say: hi -> to see a salutation");
        System.out.println("Say: how are you doing ? -> to know how is the computer");
        System.out.println("Say: bye -> to finish the application");
        System.out.println("Say: \"deactivate\" to test the grammar listener.");
      
        try {
            Locale.setDefault(new Locale("en","US"));

            //instanciate a recognizer
            recognizer = Central.createRecognizer(null);
         
            recognizer.allocate();									         
            //Load the rule grammar with the basic words for recognition
            Reader reader = new FileReader("teste.gram");
            testeGrammar = recognizer.loadJSGF(reader);
      
            //associate the grammar with its listener
            testeGrammar.addGrammarListener(grammarListener);
         
            //associate the listener
            testeGrammar.addResultListener(ruleListener);

            //enable the grammar
            testeGrammar.setEnabled(true);
         
            //commit the changes
            recognizer.commitChanges();

            //resume work
            recognizer.resume();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
