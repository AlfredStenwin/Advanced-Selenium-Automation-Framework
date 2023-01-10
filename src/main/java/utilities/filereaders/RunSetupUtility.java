package utilities.filereaders;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import utilities.filereaders.models.RunSetupModel;


public class RunSetupUtility  {
	static List<RunSetupModel> listOfTcToRun = new ArrayList<>();
	
	
	public static List<RunSetupModel> readFile() {
		//read runSetupFilePath from property file
		
		String runSetupFilePath = PropertyFileReader.readFile(System.getProperty("user.dir")+"/Advanced_Selenium_Framework/src/test/resources/RunSetup.csv").toString();
		File csvFile = new File(runSetupFilePath);
		
		CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = csvMapper
                .typedSchemaFor(RunSetupModel.class)
                .withHeader()
                .withColumnSeparator(',')
                .withComments();

		try {
			MappingIterator<RunSetupModel> iterator = csvMapper
			        .readerWithTypedSchemaFor(RunSetupModel.class)
			        .with(csvSchema)
			        .readValues(csvFile);
			List<RunSetupModel> listOfCsvRows = iterator.readAll();	
			
			listOfCsvRows.forEach(System.out::println);
			
		    for (var row : listOfCsvRows) {
				if(row.getRunneeded().equals(true)){
					//if a testcase has run needed equals to true, Add it to a new list and return the new list
					listOfTcToRun.add(row);
				}
			}
			
			//dataObject = listOfTcToRun.toArray();
		    //should return newList
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listOfTcToRun;
	}

}
