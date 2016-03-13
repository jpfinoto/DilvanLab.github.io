   import javax.speech.synthesis.*;
   import javax.speech.*;
   import java.util.Locale;
   class sintese_exemplo2{
      static Synthesizer synthesizer;   
      public static void main(String args[]){
         try{
					//define a localidade
            Locale.setDefault(new Locale("pt","BR"));
					//instancia um sintetizador que suporte a localidade padrão
            synthesizer = Central.createSynthesizer(null);
					//efetiva o funcionamento
            synthesizer.allocate();
         }
            catch(Exception e){
               System.out.println("Mensagem de erro: "+e.toString());
            }
      }
   }