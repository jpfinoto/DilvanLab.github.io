import java.io.*;
import java.util.Locale;
import javax.speech.*;
import javax.speech.recognition.*;

public class eventos_exemplo6 {
    static RuleGrammar testeGrammar;
    static Recognizer recognizer;
   
    static ResultListener ruleListener =
        new ResultAdapter() {

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

                    if ((SB_comando.toString()).equals("hi")) {
                        System.out.println("hi, my name is computer.");
                  
                    }
                    else if((SB_comando.toString()).equals("master")){
                        if(result.isAudioAvailable()) {
                            result.getAudio().play();
                        }
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
    
            public void grammarFinalized(ResultEvent e) {
                FinalRuleResult finalRuleResult = (FinalRuleResult) e.getSource();
                System.out.println("This result possibly belongs to the grammar \""+finalRuleResult.getGrammar().getName()+"\" foi reconhecido.");
            }

            public void resultUpdated(ResultEvent e) {              
                System.out.println("Finalized result.");
            }

            public void resultRejected(ResultEvent e) {
                if(((FinalResult)e.getSource()).getGrammar() instanceof RuleGrammar) {
                    System.out.println("Rejected result.");
                }
            }

        };
    
    public static void main(String args[]) {
        System.out.println("Say hi -> for a greeting");
        System.out.println("Say how are you doing ? -> to know about the computer");
        System.out.println("Say bye -> to finish the application");
        System.out.println("Say \"hi computer, I'm your master.\" to the itens queue function.");
      	System.out.println("Say something not expected to see the other event treatment functions");

        try {
            Locale.setDefault(new Locale("en","US"));

            //instanciate a recognizer
            recognizer = Central.createRecognizer(null);
         
            recognizer.allocate();									 //dispara o reconhecedor
         
            //Load the rule grammar with the basic words for recognition
            Reader reader = new FileReader("teste.gram");
            testeGrammar = recognizer.loadJSGF(reader);

            //associate the grammar with its listener
            testeGrammar.addResultListener(ruleListener);

            //enable the grammar
            testeGrammar.setEnabled(true);					 //habilita a gramatica
         
            RecognizerProperties recognizerProperties = recognizer.getRecognizerProperties();
            recognizerProperties.setResultAudioProvided(true);

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
