import java.io.*;
import java.util.Locale;
import javax.speech.*;
import javax.speech.recognition.*;

public class eventos_exemplo4 {

    static RuleGrammar testeGrammar;
    static Recognizer recognizer;
   
    static RecognizerAudioListener audioListener =
        new RecognizerAudioAdapter(){
            public void audioLevel(RecognizerAudioEvent e) {
                System.out.println("Audio level " + e.getAudioLevel());
            }
            public void speechStarted(RecognizerAudioEvent e) {
                System.out.println("You started to speak.");
            }
            public void  speechStopped(RecognizerAudioEvent e) {
                System.out.println("You stopped speaking.");
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
        try {
            System.out.println("Say hi -> for a greeting");
            System.out.println("Say how are you doing ? -> to know about the computer");
            System.out.println("Say bye -> to finish the App);
            Locale.setDefault(new Locale("en","US"));

            //instanciate a recognizer
            recognizer = Central.createRecognizer(null);    

       	    //to associate an audio listener to a recognizer we have to recover the 
            //audio manager of the respective Engine. The manager is in charge of
       	    //the audio events and we have to associate to it the audio listener
            AudioManager audioManager = recognizer.getAudioManager();
            audioManager.addAudioListener(audioListener);

            recognizer.allocate();									 //dispara o reconhecedor
       
            //Load the rule grammar with the basic words for recognition
            Reader reader = new FileReader("teste.gram");
            testeGrammar = recognizer.loadJSGF(reader);

            //associate the listener
            testeGrammar.addResultListener(ruleListener);

            //activate the grammar
            testeGrammar.setEnabled(true);
         
            //validate the changes
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
