   import java.io.*;
   import java.util.Locale;
   import javax.speech.*;
   import javax.speech.recognition.*;

   public class eventos_exemplo3 {
      static RuleGrammar testeGrammar;
      static Recognizer recognizer;
      static RecognizerListener recognizerListener =
         new RecognizerAdapter(){
            public void recognizerProcessing(RecognizerEvent e)
            {
               System.out.println("Item sendo processado.");								
            }
            public void recognizerSuspended(RecognizerEvent e)
            {
               System.out.println("Reconhecedor suspenso.");								
            }
         
         
         };
   
      static ResultListener ruleListener =
         new ResultAdapter() {
         // accepted result
            public void resultAccepted(ResultEvent e) {
               try {
                  FinalRuleResult result = (FinalRuleResult) e.getSource();
                  String tags[] = result.getTags();
                  StringBuffer SB_comando = new StringBuffer();     //junta todas as tags em um unico buffer
                  for(int i=0;i<tags.length;i++)                    //faz o append de cada token reconhecido
                  {
                     SB_comando.append(tags[i]);         //junta ao fim do buffer cada token
                  }
                  System.out.println(SB_comando.toString());    //imprime na tela o que foi reconhecido
                  if ((SB_comando.toString()).equals("suspend")) {
                     System.out.println("Reconhecimento sendo suspenso.");
                     recognizer.suspend();							
                  }
                  else if ((SB_comando.toString()).equals("how")) {
                     System.out.println("Fine thanks, and you ?");
                  }
                  else if ((SB_comando.toString()).equals("bye")) {
                     System.exit(0);
                  }
               }
                  catch (Exception ex) {
                     ex.printStackTrace();
                  }
            }
         };
      public static void main(String args[]) {
         System.out.println("Diga \"Oi\" -> para ver um cumprimento");
         System.out.println("Diga \"Como você está ?\" -> para saber como esta o computador");
         System.out.println("Diga \"Tchau\" -> para encerrar a aplicacao");
         System.out.println("Diga \"Suspender\" -> para testar o ouvidor do reconhecedor");
         try {
            Locale.setDefault(new Locale("pt","BR"));
            recognizer = Central.createRecognizer(null);     //instancia um reconhecedor
         
         	//aqui associamos o ouvidor ao engine do reconhecedor
            recognizer.addEngineListener(recognizerListener);
         
            recognizer.allocate();									 //dispara o reconhecedor
         
          //carrega a gramatica de regras com palavras basicas para reconhecimento
            Reader reader = new FileReader("teste.gram");
            testeGrammar = recognizer.loadJSGF(reader);
            testeGrammar.addResultListener(ruleListener); //associa o ouvidor
            testeGrammar.setEnabled(true);					 //habilita a gramatica
            recognizer.commitChanges();
         
            recognizer.requestFocus();
         
         //rehabilita o funcionamento
            recognizer.resume();
         }
            catch (Exception e) {
               e.printStackTrace();
               System.exit(-1);
            }
      
      }
   }
