   import javax.speech.recognition.*;
   import javax.speech.*;
   import java.util.Locale;
   class reconhecimento_exemplo3{
      static Recognizer recognizer;
   
      public static void main(String args[]){
         try{
           		//define um SynthesizerModeDesc que suporte ingles norte-americano, seja fabricado pela IBM
					//e que trabalhe no modo "Continuous General Dictation"
         	RecognizerModeDesc recognizerModeDescTeste = new RecognizerModeDesc("IBM","Continuous General Dictation",new Locale("pt","BR"),null,null,null);
         		//cria a instancia
            recognizer = Central.createRecognizer(recognizerModeDescTeste);
        			//efetiva o funcionamento
            recognizer.allocate();
         
         		//verifica os parametros do sintetizador criado
				verificaParametros();
         }
            catch(Exception e){
               System.out.println("Mensagem de erro: "+e.toString());
            }
      }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   //metodo que acessa as caracteristicas do sintetizador e as imprime na tela
      static public void verificaParametros()
      
      {
         RecognizerModeDesc recognizerModeDescTemp = (RecognizerModeDesc)recognizer.getEngineModeDesc();
         System.out.println("Nome do engine utilizado: "+recognizerModeDescTemp.getEngineName());
         System.out.println("Nome do modo de funcionamento utilizado: "+recognizerModeDescTemp.getModeName());
      	System.out.println("Nome da localidade utilizada: "+recognizerModeDescTemp.getLocale().toString());
      		//verifica a flag de controle
         if(recognizerModeDescTemp.getRunning()!=null)
            if(recognizerModeDescTemp.getRunning().booleanValue())
               System.out.println("Engine rodando.");
            else
               System.out.println("Engine parado.");
         else
            System.out.println("A flag de controle não foi setada e tem valor nulo.");
      		//mostra os SpeakerProfiles suportados, isto e, os perfis de usuario
         SpeakerProfile[] speakerProfileTemp = recognizerModeDescTemp.getSpeakerProfiles();
         for(int i=0;i<speakerProfileTemp.length;i++)
         {
            System.out.println("Perfil de usuário numero "+(i+1)+" : "+speakerProfileTemp[i].getName());
         }
      }
   
   }