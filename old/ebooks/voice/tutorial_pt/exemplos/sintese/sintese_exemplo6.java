   import javax.speech.synthesis.*;
   import javax.speech.*;
   import java.util.Locale;
   class sintese_exemplo6{
      static Synthesizer synthesizer;
      public static void main(String args[]){
         try{
            Locale.setDefault(new Locale("pt","BR"));
            synthesizer = Central.createSynthesizer(null);
				synthesizer.allocate();
				
				SynthesizerProperties sintetizadorProps = synthesizer.getSynthesizerProperties();
				
            sintetizadorProps.setVoice(new Voice(null,Voice.GENDER_MALE,Voice.AGE_CHILD,null));
				synthesizer.speak("<PARA>Ol�, eu sou um menininho que est� falando com voc�, apesar de me parecer com um computador.</PARA>",null);
				
				sintetizadorProps.setVoice(new Voice(null,Voice.GENDER_FEMALE,Voice.AGE_OLDER_ADULT,null));
				synthesizer.speak("<PARA>Oi, eu sou uma velha senhora conversando com voc�, lembre-se de respeitar os mais velhos.</PARA>",null);
				
				sintetizadorProps.setVoice(new Voice(null,Voice.GENDER_MALE,Voice.AGE_MIDDLE_ADULT,null));
				synthesizer.speak("<PARA>E eu sou um adulto que n�o pode ser visto apenas ouvido, cuidado com quem voc� fala.</PARA>",null);
				
				sintetizadorProps.setVoice(new Voice(null,Voice.GENDER_FEMALE,Voice.AGE_CHILD,null));
							synthesizer.speak("<PARA>Dizem que as garotas adolescentes n�o se importam com o que est� ao redor delas, eu sou um exemplo de que isto n�o � verdade.</PARA>",null);


         }
            catch(Exception e){
               System.out.println("Mensagem de erro: "+e.toString());
            }
      }
   }