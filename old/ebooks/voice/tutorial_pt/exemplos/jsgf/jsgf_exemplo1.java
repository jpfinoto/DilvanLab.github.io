   import java.io.*;
   import java.util.Locale;
   import javax.speech.*;
   import javax.speech.recognition.*;

   public class jsgf_exemplo1 {
      static RuleGrammar testeGrammar;
      static RuleGrammar notDefinedGrammar;
      static Recognizer recognizer;
   
   
   
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
                  if ((SB_comando.toString()).equals("one")) {
                     testeGrammar.setEnabled("1",false);
                     System.out.println("Regra 1 da gramatica teste desabilitada.");
                     testeGrammar.setEnabled("2",true);
                     System.out.println("Regra 2 da gramatica teste habilitada.");
                     notDefinedGrammar.setRule("1",notDefinedGrammar.ruleForJSGF("Repeat each word I say{repeat}"),true);
                     notDefinedGrammar.setEnabled("1",true);
                     System.out.println("Regra 1 da gramatica notDefinedGrammar definida.");
                     recognizer.commitChanges();
                  }
                  if ((SB_comando.toString()).equals("four")) {
                     testeGrammar.setEnabled("2",false);
                     System.out.println("Regra 2 da gramatica teste desabilitada.");
                     testeGrammar.setEnabled("3",true);
                     System.out.println("Regra 3 da gramatica teste habilitada.");
                     notDefinedGrammar.setRule("2",notDefinedGrammar.ruleForJSGF("so I can test my English skills{so}"),true);
                     notDefinedGrammar.setEnabled("2",true);
                     System.out.println("Regra 2 da gramatica notDefinedGrammar definida.");
                     recognizer.commitChanges();
                  }
                  else if ((SB_comando.toString()).equals("seven")) {
                     testeGrammar.setEnabled("3",false);
                     System.out.println("Regra 3 da gramatica teste desabilitada.");
                     notDefinedGrammar.setRule("3",notDefinedGrammar.ruleForJSGF("thanks computer{thanks}"),true);
                     notDefinedGrammar.setEnabled("3",true);
                     System.out.println("Regra 3 da gramatica notDefinedGrammar definida.");
                     System.out.println("A gramatica notDefinedGrammar agora esta definida e sera habilitada.");
                     notDefinedGrammar.setEnabled(true);
                     recognizer.commitChanges();
                     RuleGrammar ruleGrammars[] = recognizer.listRuleGrammars();
                     System.out.println("Gramaticas Definidas:");
                     for(int i=0;i<ruleGrammars.length;i++)
                     {
                        System.out.println(ruleGrammars[i].toString());
                     }
                     System.out.println("Diga \"Repeat each word I say\" em seguida");
                     System.out.println("Diga \"so I can test my English skills\" em seguida");
                     System.out.println("Diga \"thanks computer\".");                  
                  }
                  else if ((SB_comando.toString()).equals("repeat")) {
                     if(result.isAudioAvailable())
                     {
                        result.getAudio().play();
                     }
                  }
                  else if ((SB_comando.toString()).equals("so")) {
                     if(result.isAudioAvailable())
                     {
                        result.getAudio().play();
                     }
                  }
                  else if ((SB_comando.toString()).equals("thanks")) {
                     if(result.isAudioAvailable())
                     {
                        result.getAudio().play();
                     }
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
         System.out.println("Diga \"one little two little three little indians\" em seguida");
         System.out.println("Diga \"four little five little six little indians\" em seguida");
         System.out.println("Diga \"seven little eight little nine little indians\".");
         System.out.println("Diga \"bye\" para encerrar a aplicação.");
      
         try {
         
            Locale.setDefault(new Locale("pt","BR"));
            recognizer = Central.createRecognizer(null);     //instancia um reconhecedor
         
            recognizer.allocate();									 //dispara o reconhecedor
         
          //carrega a gramatica de regras com palavras basicas para reconhecimento
            Reader reader = new FileReader("teste.gram");
            testeGrammar = recognizer.loadJSGF(reader);
         
         
            testeGrammar.addResultListener(ruleListener); //associa o ouvidor
            testeGrammar.setEnabled(true);					 //habilita a gramatica
            testeGrammar.setEnabled("2",false);
            testeGrammar.setEnabled("3",false);
         
            notDefinedGrammar = recognizer.newRuleGrammar("notDefinedGrammar");
            notDefinedGrammar.addResultListener(ruleListener); //associa o ouvidor
            notDefinedGrammar.setEnabled(false);
         
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
