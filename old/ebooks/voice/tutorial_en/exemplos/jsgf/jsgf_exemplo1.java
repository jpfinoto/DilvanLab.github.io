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

                    //join all tags in the same buffer
                    StringBuffer SB_comando = new StringBuffer();

                    // Append each recognized token
                    for(int i=0;i<tags.length;i++) {

                        //append each token to the buffer's end
                        SB_comando.append(tags[i]);
                    }

                    //print what was recognized
                    System.out.println(SB_comando.toString());

                    if ((SB_comando.toString()).equals("one")) {
                        testeGrammar.setEnabled("1",false);
                        System.out.println("Rule 1 desabled.");
                        testeGrammar.setEnabled("2",true);
                        System.out.println("Rule 2 enabled.");

                        notDefinedGrammar.setRule("1",notDefinedGrammar.ruleForJSGF("Repeat each word I say{repeat}"),true);
                        notDefinedGrammar.setEnabled("1",true);
                        System.out.println("Rule 1 for grammar notDefinedGrammar was set.");
                        recognizer.commitChanges();
                    }
                    if ((SB_comando.toString()).equals("four")) {
                        testeGrammar.setEnabled("2",false);
                        System.out.println("Rule 2 of test grammar desabled.");
                        testeGrammar.setEnabled("3",true);
                        System.out.println("Rule 3 of test grammar enabled.");
                        notDefinedGrammar.setRule("2",notDefinedGrammar.ruleForJSGF("so I can test my English skills{so}"),true);
                        notDefinedGrammar.setEnabled("2",true);
                        System.out.println("Rule 2 grammar notDefinedGrammar was set.");
                        recognizer.commitChanges();
                    }
                    else if ((SB_comando.toString()).equals("seven")) {
                        testeGrammar.setEnabled("3",false);
                        System.out.println("Rule 3 of test grammar desabled.");
                        notDefinedGrammar.setRule("3",notDefinedGrammar.ruleForJSGF("thanks computer{thanks}"),true);
                        notDefinedGrammar.setEnabled("3",true);
                        System.out.println("Rule 3 of grammar notDefinedGrammar was set.");
                        System.out.println("The grammar notDefinedGrammar now is enabled and it's being defined.");
                        notDefinedGrammar.setEnabled(true);
                        recognizer.commitChanges();
                        RuleGrammar ruleGrammars[] = recognizer.listRuleGrammars();
                        System.out.println("Grammars defined:");
                        for(int i=0;i<ruleGrammars.length;i++) {
                            System.out.println(ruleGrammars[i].toString());
                        }
                        System.out.println("Say \"Repeat each word I say\" then");
                        System.out.println("say \"so I can test my English skills\" then");
                        System.out.println("say \"thanks computer\".");                  
                    }
                    else if ((SB_comando.toString()).equals("repeat")) {
                        if(result.isAudioAvailable()) {
                            result.getAudio().play();
                        }
                    }
                    else if ((SB_comando.toString()).equals("so")) {
                        if(result.isAudioAvailable()) {
                            result.getAudio().play();
                        }
                    }
                    else if ((SB_comando.toString()).equals("thanks")) {
                        if(result.isAudioAvailable()) {
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
        System.out.println("Say \"one little two little three little indians\" then");
        System.out.println("Say \"four little five little six little indians\" then");
        System.out.println("Say \"seven little eight little nine little indians\".");
        System.out.println("Say \"bye\" to finish the app.");
      
        try {
            Locale.setDefault(new Locale("en","US"));

            //instanciate a recognizer
            recognizer = Central.createRecognizer(null);
         
            recognizer.allocate();									 //dispara o reconhecedor
         
            //load the rule grammar with basic words for recognition
            Reader reader = new FileReader("teste.gram");
            testeGrammar = recognizer.loadJSGF(reader);
         
            //associate the listener         
            testeGrammar.addResultListener(ruleListener);

            //enable grammar
            testeGrammar.setEnabled(true);
            testeGrammar.setEnabled("2",false);
            testeGrammar.setEnabled("3",false);
         
            notDefinedGrammar = recognizer.newRuleGrammar("notDefinedGrammar");

            //associate listener
            notDefinedGrammar.addResultListener(ruleListener);
            notDefinedGrammar.setEnabled(false);
         
            RecognizerProperties recognizerProperties = recognizer.getRecognizerProperties();
            recognizerProperties.setResultAudioProvided(true);
         
            //commit changes
            recognizer.commitChanges();

            //resume work
            recognizer.resume();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
