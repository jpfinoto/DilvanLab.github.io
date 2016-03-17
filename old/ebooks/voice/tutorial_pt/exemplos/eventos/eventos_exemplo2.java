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
            //em um codigo em JSML podemos colocar marcadores que geram eventos especiais para
            //o sintetizador, refira-se ao arquivo eventos_exemplo2.jsml para entender como
            //este evento eh determinado
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
            Locale.setDefault(new Locale("pt","BR"));
            synthesizer = Central.createSynthesizer(null);
            synthesizer.addSpeakableListener(speakableListener);
            synthesizer.addEngineListener(synthesizerListener);
            synthesizer.allocate();
         
         //==============================AS 4 FORMAS DE SINTETIZAR VOZ===================================
         
         		//exemplo do metodo speakPlainText(String object, SpeakableListener object)
            synthesizer.speakPlainText("This is a Plain Text sample: Hi master",null);
         
         		//exemplo do metodo speak(Speakable object, SpeakableListener object)
         		//refira-se a implementacao da classe speakableFrame no fim deste arquivo
            speakableFrame SP_Frame = new speakableFrame();		
            synthesizer.speak(SP_Frame,null);
         
         		//exemplo do metodo speak(URL object, SpeakableListener object)
         		//refira-se ao arquivo ./eventos_exemplo2.jsml
            synthesizer.speak(new File("eventos_exemplo2.jsml").toURL(),null);
         
         		//exemplo do metodo speak(String JSML, SpeakableListener object);
            synthesizer.speak("<PROS RANGE=\"-50%\" VOL=\"+15%\">This is a <EMP>JSML sample: Hi Master!</EMP></PROS>",null);
         
         //==============================================================================================         
         }
            catch(Exception e){
               System.out.println("Mensagem de erro: "+e.toString());
            }
      }
   }




   class speakableFrame extends java.awt.Frame implements javax.speech.synthesis.Speakable 
   {
      public String getJSMLText()
      {
         return("<PROS RANGE=\"-100%\"> This is a frame that might be spoken.</PROS>");
      }
   }
