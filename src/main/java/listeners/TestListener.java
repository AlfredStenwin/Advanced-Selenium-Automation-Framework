package listeners;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import constants.GlobalConstants;
import decorators.Driver;
import drivermanager.DriverManager;
import logsetup.Log;
import reports.ExtentReport;
import utilities.ScreenshotUtility;

public class TestListener implements ITestListener, ISuiteListener{
	ExtentReports extentReport;
	ExtentTest extentTest ;

	@Override
	public void onStart(ISuite suite) {
		//To generate extend report at the start of the suite execution
		extentReport=ExtentReport.initReport();	
		Log.info("\""+suite.getName()+ "\" test suite execution started.");
	}

	@Override
	public void onFinish(ISuite suite) {
		//Flush is used to create the extend report
		extentReport.flush();
		Log.info("\""+suite.getName()+ "\" test suite execution ended.");				
	}
	
	@Override
	public void onStart(ITestContext context) {
		//Invoked after the test class is instantiated and before any configuration method is called
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String testDesc=result.getMethod().getDescription();
		extentTest = extentReport.createTest(testDesc);
		extentTest.log(Status.INFO, testDesc+" started." );
		Log.info("\""+testDesc+"\" execution started. EntentTest created");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testDesc=result.getMethod().getDescription();
		extentTest.log(Status.PASS, testDesc+" test passed." );
		Log.info("\""+testDesc+"\" passed.");		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testDesc=result.getMethod().getDescription();
		try {						
			//Take screenshot and copying to Screenshot folder in the project
			String screenshotsFolderPath =GlobalConstants.SCREENSHOT_FOLDER + testDesc + ".png";
			
			//Call takescreenshot() method from DriverLogger class and copying the screenshot from source path to Screenshot folder 				
			FileHandler.copy(ScreenshotUtility.getscreenshot(),new File(screenshotsFolderPath));
		
			//Add screenshot from Screenshot folder to extent report
			extentTest.addScreenCaptureFromPath(screenshotsFolderPath);
			
		} catch (IllegalArgumentException | SecurityException | WebDriverException | IOException  e) {
			e.printStackTrace();
		}
		
		extentTest.log(Status.FAIL, testDesc +" failed.");
		extentTest.fail(Arrays.toString(result.getThrowable().getStackTrace()));//beautify stacktrace		
		Log.error("\""+result.getName()+"\" failed.", result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName=result.getName();
		extentTest.log(Status.SKIP, testName +" skipped.");		
		extentTest.skip(Arrays.toString(result.getThrowable().getStackTrace()));		
		Log.error("\""+result.getName()+"\" skipped.", result.getThrowable());		
	}

	@Override
	public void onFinish(ITestContext context) {
		//Invoked after all the tests have run and all theirConfiguration methods have been called.				
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Log.info("onTestFailedButWithinSuccessPercentage");		
		
	}


}
