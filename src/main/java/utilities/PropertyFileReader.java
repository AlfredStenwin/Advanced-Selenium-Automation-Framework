package utilities;

import java.io.FileReader;
import java.util.Properties;

import logsetup.Log;

public class PropertyFileReader  {
	static Properties props;

	public static Properties readFile(String filePath)
	{	  
		try {
			props=new Properties();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			FileReader reader=new FileReader(filePath);		
			props.load(reader);
			
		} catch (Exception e) {	
			Log.error("Property file couldn't be read.", e);
		}
		return props;
		
	
	}
     
	public static String get(String key) {
		return props.getProperty(key);
	}
		
}
