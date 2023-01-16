package listeners;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import globalconstants.GlobalConstants;
import utilities.filereaders.CsvReaderUtility;

/* 
 * TestNG listener to get the list of tests to run. 
 */
public class MethodInterceptor implements IMethodInterceptor{

	List<IMethodInstance> testList = new ArrayList<>();

	// Method will be executed only once for the entire test suite
	// Returns the list of test cases to run according to the execute parameter in csv file	
	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		
		List<Map<String, String>> mapList = new ArrayList<>();		
		
		try {
			mapList.addAll(CsvReaderUtility.read(new File(GlobalConstants.RUN_SETUP_CSV)));
			testList=getListOfTestCasesToRun(methods, mapList);
			
		} catch (IOException e) {
			e.printStackTrace();	
		}
		
		return testList;
	}
	
	//Method to get the list of test cases to run
	private List<IMethodInstance> getListOfTestCasesToRun(List<IMethodInstance> methods, List<Map<String, String>> mapList){
		for(var method : methods){
			for(var map : mapList){
				if(method.getMethod().getMethodName().equalsIgnoreCase(map.get("name"))) {
					if(map.get("execute").equalsIgnoreCase("true")) {
						method.getMethod().setDescription(map.get("description"));
						testList.add(method);
					}
				}
			}
		}
		return testList;
	}
}
