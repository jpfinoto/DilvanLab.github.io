import java.io.*;
import java.util.Locale;
import javax.speech.*;
import javax.speech.recognition.*;

public class eventos_exemplo1 {
    static RuleGrammar testeGrammar;

    static Recognizer recognizer;

    static EngineListener engineListener =
        new EngineAdapter() {
            public void engineAllocatingResources(EngineEvent e) {
                System.out.println("1. Allocating resources for the engine");
            }
            public void engineAllocated(EngineEvent e) {
                System.out.println("2. Engine allocated");
                try{
                    recognizer.deallocate();
                }
                catch(Exception err){}
            }
            public void engineDeallocatingResources(EngineEvent e) {
                System.out.println("3. Deallocating engine resources");
            }
        };

    public static void main(String args[]) {
        try {
            Locale.setDefault(new Locale("en","US"));

            //instanciate a recognizer
            recognizer = Central.createRecognizer(null);  
         
            //the following command associates an Engine listener to an object
            //descendant of an Engine
            recognizer.addEngineListener(engineListener);
         
            recognizer.allocate();									 //dispara o reconhecedor
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }  
    }
}
