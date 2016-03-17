   import java.io.*;
   import java.util.Locale;
   import javax.speech.*;
   import javax.speech.recognition.*;

   public class eventos_exemplo5 {
      static RuleGrammar testeGrammar;
      static Recognizer recognizer;
   
      static GrammarListener grammarListener =
         new GrammarAdapter(){
            public void grammarActivated(GrammarEvent e) {
               System.out.println("Gramatica ativada");
            }
            public void grammarDeactivated(GrammarEvent e) {
               System.out.println("Gramatica desativada.");
            }
            public void changesCommited(GrammarEvent e) {
               System.out.println("Mudanças confirmadas.");
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
                  if ((SB_comando.toString()).equals("deactivate")) {
                     System.out.println("Desativando a gramatica.");
                     testeGrammar.setEnabled(false);
                     recognizer.commitChanges();
                     for(int i=0;i<100000000;i++){}
                     System.out.println("Reativando a gramatica.");
                     testeGrammar.setEnabled(true);
                     recognizer.commitChanges();
                  }
                  if ((SB_comando.toString()).equals("hi")) {
                     System.out.println("hi, my name is computer.");
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
         System.out.println("Diga \"Desativar\" para testar o ouvidor da gramatica.");
      
         try {
         
            Locale.setDefault(new Locale("pt","BR"));
            recognizer = Central.createRecognizer(null);     //instancia um reconhecedor
         
            recognizer.allocate();									 //dispara o reconhecedor
         
          //carrega a gramatica de regras com palavras basicas para reconhecimento
            Reader reader = new FileReader("teste.gram");
            testeGrammar = recognizer.loadJSGF(reader);
         
         	//aqui associamos a gramatica com o ouvidor de gramatica
            testeGrammar.addGrammarListener(grammarListener);
         
         
            testeGrammar.addResultListener(ruleListener); //associa o ouvidor
            testeGrammar.setEnabled(true);					 //habilita a gramatica
         
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
