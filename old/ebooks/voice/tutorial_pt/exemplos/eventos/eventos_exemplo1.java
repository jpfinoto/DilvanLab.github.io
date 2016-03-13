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
               System.out.println("1. Alocando recursos para o engine");
            }
            public void engineAllocated(EngineEvent e) {
               System.out.println("2. Engine alocado");
               try{
                  recognizer.deallocate();
               }
                  catch(Exception err){
                  }
            }
         
            public void engineDeallocatingResources(EngineEvent e) {
               System.out.println("3. Desalocando recursos do engine");
            }
         
         };
      public static void main(String args[]) {
         try {
            Locale.setDefault(new Locale("pt","BR"));
            recognizer = Central.createRecognizer(null);     //instancia um reconhecedor
         
            //com este comando associamos um ouvidor do engine a uma entidade herdeira de um
            //engine, ja que um engine sera sempre um reconhecedor ou um sintetizador
            recognizer.addEngineListener(engineListener);
         
            recognizer.allocate();									 //dispara o reconhecedor
         
          //carrega a gramatica de regras com palavras basicas para reconhecimento
         }
            catch (Exception e) {
               e.printStackTrace();
               System.exit(-1);
            }
      
      }
   }
