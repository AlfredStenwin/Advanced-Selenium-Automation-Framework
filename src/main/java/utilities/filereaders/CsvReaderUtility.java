package utilities.filereaders;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

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
