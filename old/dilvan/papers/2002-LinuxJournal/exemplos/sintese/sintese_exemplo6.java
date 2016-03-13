import javax.speech.synthesis.*;
import javax.speech.*;
import java.util.Locale;

class sintese_exemplo6{
    static Synthesizer synthesizer;
    
    public static void main(String args[]){
        try{
            Locale.setDefault(new Locale("en","US"));
            synthesizer = Central.createSynthesizer(null);
            synthesizer.allocate();
				
            SynthesizerProperties sintetizadorProps = synthesizer.getSynthesizerProperties();
				
            sintetizadorProps.setVoice(new Voice(null,Voice.GENDER_MALE,Voice.AGE_CHILD,null));
            synthesizer.speak("<PARA>Hi, I am a male child speaking to you, even though I look like a computer.</PARA>",null);
				
            sintetizadorProps.setVoice(new Voice(null,Voice.GENDER_FEMALE,Voice.AGE_OLDER_ADULT,null));
            synthesizer.speak("<PARA>Hello, I am an old woman speaking to you, you better respect older people.</PARA>",null);
				
            sintetizadorProps.setVoice(new Voice(null,Voice.GENDER_MALE,Voice.AGE_MIDDLE_ADULT,null));
            synthesizer.speak("<PARA>Finally, I am a male adult that can't be seen just heard, becarefull with whom you talk.</PARA>",null);
				
            sintetizadorProps.setVoice(new Voice(null,Voice.GENDER_FEMALE,Voice.AGE_TEENAGER,null));
            synthesizer.speak("<PARA>They teenager woman don't mind for what's arround them, I am an example that that's not true.</PARA>",null);
        }
        catch(Exception e){
            System.out.println("Error message: "+e.toString());
        }
    }
}