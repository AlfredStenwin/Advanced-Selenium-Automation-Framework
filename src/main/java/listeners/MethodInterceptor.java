package listeners;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import constants.GlobalConstants;
import enums.TestCaseDetails;
import utilities.CsvReaderUtility;

/* 
 * MethodInterceptor implements the IMethodInterceptor listener from TestNG. The intercept method returns
 * a list of test that should be executed according to the data read from RUN_SETUP_CSV file. 
 * If columns 'name', 'execute' or 'description' is altered in RunSetup.csv file, it should also be updated 
 * in getListOfTestCasesToRun method. If the column name in RunSetup.csv file does not match with the names 
 * used here, it will lead to none of the test cases being run.
 * 
 * */ 
public class MethodInterceptor implements IMethodInterceptor{

	List<IMethodInstance> testList = new ArrayList<>();

	// Method will be executed only once for the entire test suite
	// Returns the list of test cases to run according to the execute parameter in csv file	
	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		
		List<Map<String, String>> mapList = new ArrayList<>();		
		
		try {
			mapList.addAll(CsvReaderUtility.read(new File(GlobalConstants.RUNSETUP)));
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
				if(method.getMethod().getMethodName().equalsIgnoreCase(map.get(TestCaseDetails.NAME.toString().toLowerCase())) &&
						map.get(TestCaseDetails.EXECUTE.toString().toLowerCase()).equalsIgnoreCase("true")) {
						
					method.getMethod().setDescription(map.get(TestCaseDetails.DESCRIPTION.toString().toLowerCase()));
					testList.add(method);
				}
			}
		}
		return testList;
	}
}
