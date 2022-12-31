package filereaderfactory;

import java.io.FileReader;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import logsetup.LogUtility;

public class PropertyFileReader implements ReaderManager{
	Properties props;
	private static Logger LogUtility = LogManager.getLogger(PropertyFileReader.class);

	public ReaderManager readFile(String filePath)
	{	  
		props=new Properties();
		try {
			FileReader reader=new FileReader(filePath);		
			props.load(reader);
			
		} catch (Exception e) {	
			LogUtility.error("Property file couldn't be read.", e);
		}
		return this;
		
	
	}
     
	public String get(String key) {
		return this.props.getProperty(key);
	}

	@Override
	public Object[] getObject() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
