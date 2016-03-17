import java.util.Locale;
import javax.speech.Central;
import javax.speech.recognition.Recognizer;
import javax.speech.synthesis.Synthesizer;

public class reconhecimento_exemplo1 {
    static Recognizer recognizer;        
    
    public static void main(String args[]) {
        try {
            Locale.setDefault(new Locale("en","US"));
         
            // create a recognizer matching default locale
            recognizer = Central.createRecognizer(null);
            recognizer.allocate();         
        }
        catch (Exception e) {
            e.printStackTrace();               
        }
    }
}
