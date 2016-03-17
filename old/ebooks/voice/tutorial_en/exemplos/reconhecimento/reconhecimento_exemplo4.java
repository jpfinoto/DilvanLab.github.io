import java.io.*;
import java.util.Locale;
import javax.speech.*;
import javax.speech.recognition.*;

public class reconhecimento_exemplo4 {
    static RuleGrammar testeGrammar;
    static Recognizer recognizer;
    
    static ResultListener ruleListener =
        new ResultAdapter() {
        
            // accepted result
            public void resultAccepted(ResultEvent e) {
                try {
                    FinalRuleResult result = (FinalRuleResult) e.getSource();
                    String tags[] = result.getTags();

                    //Put all tags in the same buffer
                    StringBuffer SB_comando = new StringBuffer();

                    // Append each recognized token
                    for(int i=0;i<tags.length;i++) {

                        //Append each token at the buffers's end
                        SB_comando.append(tags[i]);
                    }

                    //print what was recognized   
                    System.out.println(SB_comando.toString());

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
        System.out.println("Say hi -> for a greeting");
        System.out.println("Say how are you doing ? -> to know about the computer");
        System.out.println("Say bye -> to finish the application");
        try {
            Locale.setDefault(new Locale("en","US"));

            //instanciate a recognizer
            recognizer = Central.createRecognizer(null);

            recognizer.allocate();									         
            //load the rule grammar with basic words for recognition
            Reader reader = new FileReader("teste.gram");
            testeGrammar = recognizer.loadJSGF(reader);

            //associate a listenner
            testeGrammar.addResultListener(ruleListener);

            //Enable the grammar
            testeGrammar.setEnabled(true);
         
            //commit changes
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
