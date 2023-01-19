package utilities;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

/*
 * Simple csv reader using Jackson library to read mainly the RunSetup.csv file. Models are not used 
 * to prevent frequent updating in the pojo class/models when the structure of the RunSetup file might 
 * change according to the preferences of the test execution. 
 * */

public final class CsvReaderUtility  {
	
	private CsvReaderUtility() {}
	
	public static List<Map<String, String>> read(File file) throws JsonProcessingException, IOException {
	    List<Map<String, String>> response = new LinkedList<Map<String, String>>();
	    CsvMapper mapper = new CsvMapper();
	    CsvSchema schema = CsvSchema.emptySchema().withHeader().withColumnSeparator(',').withComments();
		MappingIterator<Map<String, String>> iterator = mapper.reader(Map.class)
				.with(schema)
	            .readValues(file);
		
	    while (iterator.hasNext()) {
	        response.add(iterator.next());
	    }
	    return response;
	}
	

}
