package reports;

import java.io.File;
import java.util.Objects;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import constants.GlobalConstants;
import logsetup.Log;
import utilities.PropertyFileReader;

public final class ExtentReport {
	
	// Parameters read from extentreports config file 
	enum ConfigParameters {
		THEME,
		REPORT_NAME,
		DOCUMENT_TITLE,
		TIMESTAMP_FORMAT
	}
	
	private static ExtentReports extentReport;

	private ExtentReport() {}
	
	/*
	 * Method to generate the extentreport report and set the values for parameters in the report  
	 * Improvemnt - parameter can be read from a config file
	 */
	public static ExtentReports initReport() {	
		Properties extentReportConfig = PropertyFileReader.readFile(GlobalConstants.EXTENTREPORT_CONFIG);
		String theme = extentReportConfig.get(ConfigParameters.THEME.name()).toString();
		String fileName = extentReportConfig.get(ConfigParameters.REPORT_NAME.name()).toString();
		String documentTitle = extentReportConfig.get(ConfigParameters.DOCUMENT_TITLE.name()).toString();
		String timeStampFormat = extentReportConfig.get(ConfigParameters.TIMESTAMP_FORMAT.name()).toString();
	
		if(Objects.isNull(extentReport)) {			
			extentReport = new ExtentReports();
			ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(
					new File(GlobalConstants.EXTENTREPORT_HTML));
				
			//attach the extentSparkReporter to extendReports object
			extentReport.attachReporter(extentSparkReporter);
			
			// SPark report configuration
			switch(theme.toLowerCase()) {
		      case "standard":
					extentSparkReporter.config().setTheme(Theme.STANDARD);
					break;
		      case "dark":
					extentSparkReporter.config().setTheme(Theme.DARK);
					break;
		      default :
					Log.info("Invalid theme "+theme+" configured in " +GlobalConstants.EXTENTREPORT_CONFIG+" file. Please enter 'standard' or 'dark' for 'Theme'.");
	    	  	break;
		    }

			extentSparkReporter.config().setReportName(fileName);
			extentSparkReporter.config().setDocumentTitle(documentTitle);
			extentSparkReporter.config().setTimeStampFormat(timeStampFormat);	
			
			// setting test and system info from test/resources/Config.properties file
			extentReport.setSystemInfo("Application URL", PropertyFileReader.readFile(GlobalConstants.CONFIG).get("url").toString());
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
			
			//to open the report in the default browser after flushing
			//Desktop.getDesktop().browse(new File(fileName).toURI());
		}
	}
}
