   import javax.speech.synthesis.*;
   import javax.speech.*;
   import java.util.Locale;
   class sintese_exemplo5{
      static Synthesizer synthesizer;

			//ouvidor responsavel por pegar os eventos do sintetizador
		static SpeakableListener speakableListenerOuvidor_do_Sintetizador = new SpeakableAdapter()
		{
			public void wordStarted(SpeakableEvent speakableEventEvento)
			{
				System.out.println("Evento pego pelo ouvidor do sintetizador.");
				System.out.println(speakableEventEvento.getText());
			}
		};
		
		//ouvidor responsavel por pegar os eventos do metodo speak
		static SpeakableListener speakableListenerOuvidor_do_Metodo_Speak = new SpeakableAdapter()
		{
			public void wordStarted(SpeakableEvent speakableEventEvento)
			{
				System.out.println("Evento pego pelo ouvidor do metodo speak.");
				System.out.println(speakableEventEvento.getText());
			}
		};

      public static void main(String args[]){
         try{
            Locale.setDefault(new Locale("pt","BR"));
            synthesizer = Central.createSynthesizer(null);

					//associamos o ouvidor com o sintetizador
				synthesizer.addSpeakableListener(speakableListenerOuvidor_do_Sintetizador);
				synthesizer.allocate();
					//associamos o ouvidor com o metodo speak, sendo
					//que o sintetizador ja possui seu proprio ouvidor
				synthesizer.speak("Hi master",speakableListenerOuvidor_do_Metodo_Speak);
         }
            catch(Exception e){
               System.out.println("Mensagem de erro: "+e.toString());
            }
      }
   }