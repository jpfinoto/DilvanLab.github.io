import javax.speech.synthesis.*;
import javax.speech.*;
import java.util.Locale;

class sintese_exemplo3{
    static Synthesizer synthesizer;
   
    public static void main(String args[]){
        try{
            //define a SynthesizerModeDesc that supports north american English and was written by IBM
            SynthesizerModeDesc synthesizerModeDescTeste = new SynthesizerModeDesc("IBM", "IBM",new Locale("en","US"),null,null);

            //criates an instance
            synthesizer = Central.createSynthesizer(synthesizerModeDescTeste);

            //Run it
            synthesizer.allocate();
            
            //verify the parameters of the created sinthesizer
            verificaParametros();
        }
        catch(Exception e){
            System.out.println("Error message: "+e.toString());
        }
    }
}
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   //metodo que acessa as caracteristicas do sintetizador e as imprime na tela
      static public void verificaParametros()
      
      {
         SynthesizerModeDesc synthesizerModeDescTemp = (SynthesizerModeDesc)synthesizer.getEngineModeDesc();
         System.out.println("Nome do engine utilizado: "+synthesizerModeDescTemp.getEngineName());
         System.out.println("Nome do modo de funcionamento utilizado: "+synthesizerModeDescTemp.getModeName());
      	System.out.println("Nome da localidade utilizada: "+synthesizerModeDescTemp.getLocale().toString());
      		//verifica a flag de controle
         if(synthesizerModeDescTemp.getRunning()!=null)
            if(synthesizerModeDescTemp.getRunning().booleanValue())
               System.out.println("Engine rodando.");
            else
               System.out.println("Engine parado.");
         else
            System.out.println("A flag de controle não foi setada e tem valor nulo.");
      		//mostra as vozes suportadas
         Voice[] VoiceTemp = synthesizerModeDescTemp.getVoices();
         for(int i=0;i<VoiceTemp.length;i++)
         {
            System.out.println("Voz numero "+(i+1)+" : "+VoiceTemp[i].getName());
         }
      }
   
   }