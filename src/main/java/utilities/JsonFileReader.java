package utilities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import logsetup.Log;

/*Simple json reader - Will fail if used for nested json*/

public class JsonFileReader  {
	
	public static Object[] readFile(String filePath) {
		HashMap<String, Object> map = null;
		Object[] dataObject;
		try {
			map = new ObjectMapper()
					.readValue(new File(filePath), 
							new TypeReference<HashMap<String, Object>>() {});

		} catch (IOException e) {
			
			Log.error("Reading from json file failed.");
			e.printStackTrace();
		}
		
		dataObject = new Object[] {map};
		
		return dataObject;
	}

}
