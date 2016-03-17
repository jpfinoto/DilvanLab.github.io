import java.util.Locale;
import javax.speech.Central;
import javax.speech.recognition.Recognizer;
import javax.speech.synthesis.Synthesizer;

public class sintese_exemplo1 {
    static Recognizer recognizer;
    static Synthesizer synthesizer;
 
    public static void main(String args[]) {
        try {
            Locale.setDefault(new Locale("en","US"));
     
            // create a recognizer matching default locale
            recognizer = Central.createRecognizer(null);
            recognizer.allocate();
         
            // create a synthesizer, speak a greeting
            synthesizer = Central.createSynthesizer(null);
            synthesizer.allocate();
        
        }
        catch (Exception e) {
            e.printStackTrace();               
        }
    }
}
