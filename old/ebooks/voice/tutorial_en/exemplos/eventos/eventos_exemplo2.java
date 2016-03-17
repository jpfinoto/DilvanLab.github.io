import javax.speech.synthesis.*;
import javax.speech.*;
import java.util.Locale;
import java.net.URL;
import java.io.File;

class eventos_exemplo2{
    static Synthesizer synthesizer;
   
    static SpeakableListener speakableListener =
        new SpeakableAdapter() {

            // accepted result
            public void wordStarted(SpeakableEvent e) {
                System.out.println(e.getText());
            }

            //In the JSML code we can put markers that generate special events for
            //the sinthesizer, refer to the file eventos_exemplo2.jsml to best 
            //understandd how this event is coded
            public void markerReached(SpeakableEvent e) {
                System.out.println("Marker reached !");
                System.out.println(e.getText());
            }
         
        };
   
   
    static SynthesizerListener synthesizerListener =
      
        new SynthesizerAdapter() {
            public void queueUpdated(SynthesizerEvent e) {
                System.out.println("==========>"+e.paramString());
            }
         
            public void queueEmptied(SynthesizerEvent e) {
                System.out.println("==========>"+e.paramString());
            }
        };
   
    public static void main(String args[]){				
        try{
            Locale.setDefault(new Locale("en","EN"));
            synthesizer = Central.createSynthesizer(null);
            synthesizer.addSpeakableListener(speakableListener);
            synthesizer.addEngineListener(synthesizerListener);
            synthesizer.allocate();
         
            //==============================The 4 ways to sinthesize voice===================================
         
            //example of method speakPlainText(String object, SpeakableListener object)
            synthesizer.speakPlainText("This is a Plain Text sample: Hi master",null);
         
            //example of method speak(Speakable object, SpeakableListener object)
            //take a look at the implementation of speakableFrame class at the file end
            speakableFrame SP_Frame = new speakableFrame();		
            synthesizer.speak(SP_Frame,null);
         
            //example of method speak(URL object, SpeakableListener object)
            //refer to file ./eventos_exemplo2.jsml
            synthesizer.speak(new File("eventos_exemplo2.jsml").toURL(),null);
         
            //example of method speak(String JSML, SpeakableListener object);
            synthesizer.speak("<PROS RANGE=\"-50%\" VOL=\"+15%\">This is a <EMP>JSML sample: Hi Master!</EMP></PROS>",null);
         
            //==============================================================================================         
        }
        catch(Exception e){
            System.out.println("Error message: "+e.toString());
        }
    }
}



class speakableFrame extends java.awt.Frame implements javax.speech.synthesis.Speakable 
{
    public String getJSMLText() {
        return("<PROS RANGE=\"-100%\"> This is a frame that might be spoken.</PROS>");
    }
}
