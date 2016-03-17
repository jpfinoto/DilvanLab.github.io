   import javax.speech.synthesis.*;
   import javax.speech.*;
   import java.util.Locale;
   import java.net.URL;
   import java.io.File;
   class sintese_exemplo4{
      static Synthesizer synthesizer;

      public static void main(String args[]){
         try{
            Locale.setDefault(new Locale("pt","BR"));
            synthesizer = Central.createSynthesizer(null);
            synthesizer.allocate();
         	
//==============================AS 4 FORMAS DE SINTETIZAR VOZ===================================
         	
         		//exemplo do metodo speakPlainText(String object, SpeakableListener object)
            synthesizer.speakPlainText("This is a Plain Text sample: Hi master",null);
         	
         		//exemplo do metodo speak(Speakable object, SpeakableListener object)
					//refira-se a implementacao da classe speakableFrame no fim deste arquivo
         	speakableFrame SP_Frame = new speakableFrame();		
				synthesizer.speak(SP_Frame,null);
				
					//exemplo do metodo speak(URL object, SpeakableListener object)
					//refira-se ao arquivo ./sintese_exemplo5.jsml
            synthesizer.speak(new File("sintese_exemplo5.jsml").toURL(),null);

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
