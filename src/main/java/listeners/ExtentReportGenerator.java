package listeners;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import enums.FileType;
import filereaderfactory.FileReaders;

public class ExtentReportGenerator {
	
	/*
	 * Method to generate the extentreport report and set the values for parameters in the report  
	 */
	public static ExtentReports generateReport() {
		
		ExtentReports extentReport = new ExtentReports();
		File extentReportFile=new File(System.getProperty("user.dir")+"/ExtentReports/ExtentReports.html");
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(extentReportFile);
	
		//spark report configurations
		extentSparkReporter.config().setTheme(Theme.STANDARD);//DARK for dark theme
		extentSparkReporter.config().setReportName("Demo Test Automation Results");
		extentSparkReporter.config().setDocumentTitle("Demo Test Automation Results");
		extentSparkReporter.config().setTimeStampFormat("yyyy/MM/dd hh:mm:ss");
	
		//attach the extentSparkReporter to extendReports object
		extentReport.attachReporter(extentSparkReporter);
		
		// setting test and system info from test/resources/Config.properties file
		extentReport.setSystemInfo("Application URL", 
				FileReaders.getFileReader(FileType.PROPERTY)
				.readFile(System.getProperty("user.dir")+"/src/test/resources/Config.properties")
				.get("url"));
		extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));
		extentReport.setSystemInfo("User name ",System.getProperty("user.name"));
		extentReport.setSystemInfo("Java version",System.getProperty("java.version"));

		return extentReport;
	}
}
