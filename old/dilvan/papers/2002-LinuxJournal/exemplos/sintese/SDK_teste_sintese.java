import javax.speech.synthesis.*;
import javax.speech.*;
import java.util.Locale;

class SDK_teste_sintese{
    static Synthesizer synthesizer;   
    
    public static void main(String args[]){
        try{
            Locale.setDefault(new Locale("en","US"));
            synthesizer = Central.createSynthesizer(null);
            synthesizer.allocate();
        }
        catch(Exception e){
            System.out.println("Error message: "+e.toString());
        }
    }
}