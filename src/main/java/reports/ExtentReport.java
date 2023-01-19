package reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.PropertyFileReader;

public final class ExtentReport {
	
	private static ExtentReports extentReport;

	private ExtentReport() {}
	
	/*
	 * Method to generate the extentreport report and set the values for parameters in the report  
	 * Improvemnt - parameter can be read from a config file
	 */
	public static ExtentReports initReport() {	
		if(Objects.isNull(extentReport)) {
			String propertyFilePath = System.getProperty("user.dir")+"/src/test/resources/Config.properties";
			
			extentReport = new ExtentReports();
			ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(
					new File(System.getProperty("user.dir")+"/ExtentReports/ExtentReports.html"));
				
			//attach the extentSparkReporter to extendReports object
			extentReport.attachReporter(extentSparkReporter);
			
			//spark report configurations
			extentSparkReporter.config().setTheme(Theme.STANDARD);//DARK for dark theme
			extentSparkReporter.config().setReportName("Demo Test Automation Results");
			extentSparkReporter.config().setDocumentTitle("Demo Test Automation Results");
			extentSparkReporter.config().setTimeStampFormat("yyyy/MM/dd hh:mm:ss");
		
			
			// setting test and system info from test/resources/Config.properties file
			extentReport.setSystemInfo("Application URL", 
					PropertyFileReader.readFile(propertyFilePath).get("url").toString());
			extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));
			extentReport.setSystemInfo("User name ",System.getProperty("user.name"));
			extentReport.setSystemInfo("Java version",System.getProperty("java.version"));
		}
		
		return extentReport;
	}
	
	//Method to flush the extend report
	public static void flushReport() {
		if(Objects.nonNull(extentReport)) {
			extentReport.flush();
		}
	}
	
	//Method to create test in extend reports
	public static void getTest(String testName) {
		ExtentManager.setExtentTest(extentReport.createTest(testName));
	}
}
