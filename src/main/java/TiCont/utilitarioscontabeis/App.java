package TiCont.utilitarioscontabeis;

import TiCont.utilitarioscontabeis.models.ResponsabilityLetter;

public class App 
{	
    public static void main( String[] args )
    {
    	IContainer container = new Container();
    	
    	ResponsabilityLetter rl = container.getResponsabilityLetterRepository().getResponsabilityLetter();
    	
    	if (rl == null) {
    		System.out.println("Null");
    	} else {
    		System.out.println("Tem valor");
    	}
    	
    	System.out.println("App funcionando!");
    }
}
