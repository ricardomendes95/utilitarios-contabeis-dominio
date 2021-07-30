package TiCont.utilitarioscontabeis.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
	private String fileName;
	private Properties prop;
	private InputStream inputStream;
	
	public PropertiesReader(String fileName) {
		this.fileName = fileName;
		
		this.prop = new Properties();
		
		loadFile();
	}
	
	private void loadFile() {
		inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
		
		try {
			if (inputStream != null) {
				prop.load(inputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getProp(String key) {
		return prop.getProperty(key);
	}	
}
