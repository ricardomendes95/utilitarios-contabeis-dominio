package TiCont.utilitarioscontabeis;

import java.io.InputStream;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
	public App() {
		teste();
	}
	private void teste () {
		Properties prop = new Properties();
    	
    	String fileName = "database.properties";
    	
    	try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
			if (inputStream != null ) {
				prop.load(inputStream);
				System.out.println(prop.getProperty("uid"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public static void main( String[] args )
    {
    	new App();
    	
    	
        System.out.println( "Hello World!" );
    }
}
