   import java.util.Locale;
   import java.util.StringTokenizer;
   import javax.speech.*;
   import javax.speech.recognition.*;

   public class reconhecimento_exemplo3 {
   
      static DictationGrammar dictationGrammar;
      static Recognizer recognizer;
   
   
   //ouvidor da gramatica de ditado
      static ResultListener dictationListener = 
         new ResultAdapter() {
            int n = 0; // number of tokens seen so far
         
            public void resultUpdated(ResultEvent e) {
               Result result = (Result) e.getSource();
               for (int i=n; i<result.numTokens(); i++)
                  System.out.println("XXXXXX
            		"+result.getBestToken(i).getSpokenText());
               n = result.numTokens();
            	System.out.println("RESULTADO UPDATED");
            }
         
            public void resultAccepted(ResultEvent e) {
               Result result = (Result) e.getSource();
               String s = "";
               for (int i=0; i<n; i++)
                  s += result.getBestToken(i).getSpokenText() + " ";
               System.out.println(s);
               n = 0;
            	System.out.println("RESULTADO ACCEPTED");
            }
         };
   
   
      public static void main(String args[]) {
      
         try {
         
            Locale.setDefault(new Locale("pt","BR"));
            recognizer = Central.createRecognizer(null);
            recognizer.allocate();
         
            	//cria uma gramatica de ditado com auxilio do reconhecedor
            dictationGrammar = recognizer.getDictationGrammar(null);
         		//associa um ouvidor a gramatica criada
            dictationGrammar.addResultListener(dictationListener);
         		//confirma o funcionamento da gramatica
            dictationGrammar.setEnabled(true);
         
         	//habilita as alteracoes
            recognizer.commitChanges();
            recognizer.requestFocus();
            recognizer.resume();
         
         } 
            catch (Exception e) {
            
               e.printStackTrace();
               System.exit(-1);
            
            }
      }
   
   }

