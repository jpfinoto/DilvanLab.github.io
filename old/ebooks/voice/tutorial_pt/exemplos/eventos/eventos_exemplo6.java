   import java.io.*;
   import java.util.Locale;
   import javax.speech.*;
   import javax.speech.recognition.*;

   public class eventos_exemplo6 {
      static RuleGrammar testeGrammar;
      static Recognizer recognizer;
   
      static ResultListener ruleListener =
         new ResultAdapter() {

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
                  if ((SB_comando.toString()).equals("hi")) {
                     System.out.println("hi, my name is computer.");
                  
                  }
                  else if((SB_comando.toString()).equals("master")){
                     if(result.isAudioAvailable())
                     {
                        result.getAudio().play();
                     }
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
            public void grammarFinalized(ResultEvent e)
            {
               FinalRuleResult finalRuleResult = (FinalRuleResult) e.getSource();
               System.out.println("Resultado possivelmente pertencente a gramatica \""+finalRuleResult.getGrammar().getName()+"\" foi reconhecido.");
            }
         	public void resultUpdated(ResultEvent e)
            {              
               System.out.println("Resultado finalizado.");
            }
            public void resultRejected(ResultEvent e)
            {
               if(((FinalResult)e.getSource()).getGrammar() instanceof RuleGrammar)
               {
                  System.out.println("Resultado rejeitado.");
               }
            }
         };
      public static void main(String args[]) {
         System.out.println("Diga \"Oi\" -> para ver um cumprimento");
         System.out.println("Diga \"Como você está ?\" -> para saber como esta o computador");
         System.out.println("Diga \"Tchau\" -> para encerrar a aplicacao");
         System.out.println("Diga \"Oi computador, eu sou seu mestre.\" para ver a funcao de armazenamento de dados sonoros.");
      	System.out.println("Diga algo nao previsto para ver o funcionamento dos outros tratamentos de eventos.");

      
         try {
         
            Locale.setDefault(new Locale("pt","BR"));
            recognizer = Central.createRecognizer(null);     //instancia um reconhecedor
         
            recognizer.allocate();									 //dispara o reconhecedor
         
          //carrega a gramatica de regras com palavras basicas para reconhecimento
            Reader reader = new FileReader("teste.gram");
            testeGrammar = recognizer.loadJSGF(reader);
            testeGrammar.addResultListener(ruleListener); //associa o ouvidor
            testeGrammar.setEnabled(true);					 //habilita a gramatica
         
            RecognizerProperties recognizerProperties = recognizer.getRecognizerProperties();
            recognizerProperties.setResultAudioProvided(true);
         //valida as alteracoes
            recognizer.commitChanges();
         //rehabilita o funcionamento
            recognizer.resume();
         }
            catch (Exception e) {
               e.printStackTrace();
               System.exit(-1);
            }
      
      }
   }
