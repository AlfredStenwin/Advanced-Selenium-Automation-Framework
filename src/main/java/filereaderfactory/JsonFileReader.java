package filereaderfactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

//import logsetup.LogUtility;

/*Simple json reader - Will fail if used for nested json*/

public class JsonFileReader implements ReaderManager{
	HashMap<String, Object> map;
	Object[] dataObject;
	private static Logger LogUtility = LogManager.getLogger(JsonFileReader.class);


	
	public ReaderManager readFile(String filePath) {

		try {
			map = new ObjectMapper()
					.readValue(new File(filePath), 
							new TypeReference<HashMap<String, Object>>() {});

		} catch (IOException e) {
			
			LogUtility.error("Reading from json file failed.");
			e.printStackTrace();
		}
		
		dataObject = new Object[] {map};
		
		return this;
	}

	@Override
	public Object[] getObject() {
		return dataObject;
	}

	@Override
	public String get(String key) {
		return null;
	}
}
