package filereaderfactory;

import java.io.FileReader;
import java.util.Properties;

import logsetup.LogUtility;

public class PropertyFileReader implements ReaderManager{
	Properties props;

	public ReaderManager readFile(String filePath)
	{	  
		props=new Properties();
		try {
			FileReader reader=new FileReader(filePath);		
			props.load(reader);
			
		} catch (Exception e) {	
			LogUtility.getInstance().error("Property file couldn't be read.", e);
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
