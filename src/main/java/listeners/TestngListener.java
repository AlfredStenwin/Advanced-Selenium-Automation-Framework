package listeners;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import decorators.Driver;
import logsetup.LogUtility;

public class TestngListener implements ITestListener, ISuiteListener{
	ExtentReports extentReport;
	ExtentTest extentTest ;
	
	//protected LogUtility log = LogUtility.getInstance();
	private static Logger log = LogManager.getLogger("LOG");


	@Override
	public void onStart(ISuite suite) {
		//To generate extend report at the start of the suite execution
		extentReport=ExtentReportGenerator.generateReport();	
		LogUtility.info("\""+suite.getName()+ "\" test suite execution started.");
	}

	@Override
	public void onFinish(ISuite suite) {
		//Flush is used to create the extend report
		extentReport.flush();		
		LogUtility.info("\""+suite.getName()+ "\" test suite execution ended.");				
	}
	
	@Override
	public void onStart(ITestContext context) {
		//Invoked after the test class is instantiated and before any configuration method is called
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String testName=result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName+" started." );
		log.info("\""+testName+"\" execution started. EntentTest created");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName=result.getName();
		extentTest.log(Status.PASS, testName+" test passed." );
		log.info("\""+testName+"\" passed.");		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getName();
		
		//Getting the driver from result parameter for taking the screenshot on failure of test
		try {
			Driver driver = (Driver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			
			//Take screenshot and copying to Screenshot folder in the project
			String screenshotsFolderPath =System.getProperty("user.dir")+"/Screenshots/"+testName+".png";
			
			//Call takescreenshot() method from DriverLogger class and copying the screenshot from source path to Screenshot folder 	
			FileHandler.copy(driver.takescreenshot(), new File(screenshotsFolderPath));
			
			//Add screenshot from Screenshot folder to extent report
			extentTest.addScreenCaptureFromPath(screenshotsFolderPath);
			
		} catch (IllegalArgumentException | SecurityException | NoSuchFieldException | IllegalAccessException | IOException e) {
			e.printStackTrace();
		}
		
		var thrower= result.getThrowable();
		extentTest.log(Status.FAIL, testName +" failed. \n"+result.getThrowable());
		log.error("\""+result.getName()+"\" failed.", result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName=result.getName();
		extentTest.log(Status.SKIP, testName +" skipped." + result.getThrowable());		
		log.error("\""+result.getName()+"\" skipped.", result.getThrowable());		
	}

	@Override
	public void onFinish(ITestContext context) {
		//Invoked after all the tests have run and all theirConfiguration methods have been called.				
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		log.info("onTestFailedButWithinSuccessPercentage");		
		
	}


}
