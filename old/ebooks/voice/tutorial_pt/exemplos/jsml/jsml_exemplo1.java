   import javax.speech.synthesis.*;
   import javax.speech.*;
   import java.util.Locale;
   import java.net.URL;
   import java.io.File;
   class jsml_exemplo1{
      static Synthesizer synthesizer;
   
      public static void main(String args[]){
         try{
            Locale.setDefault(new Locale("pt","BR"));
            synthesizer = Central.createSynthesizer(null);
            synthesizer.allocate();
         
         //==============================AS 4 FORMAS DE SINTETIZAR VOZ===================================
         	   //exemplo do metodo speak(URL object, SpeakableListener object)
         		//refira-se ao arquivo ./jsml_exemplo1.jsml
            synthesizer.speak(new File("jsml_exemplo1.jsml").toURL(),null);
         
         //==============================================================================================         
         }
            catch(Exception e){
               System.out.println("Mensagem de erro: "+e.toString());
            }
      }
   }