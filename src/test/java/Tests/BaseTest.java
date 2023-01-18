package Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.GlobalConstants;
import decorators.Driver;
import decorators.DriverBase;
import decorators.DriverLogger;
import drivermanager.DriverManager;
import logsetup.Log;
import utilities.filereaders.PropertyFileReader;
import webpages.HomePage;
import webpages.MyAccountPage;
import webpages.UserRegistrationPage;
import webpages.pagesections.MainMenuSection;

public class BaseTest {
	public Driver driver;
	
	protected MyAccountPage myaccountsPage;
	protected UserRegistrationPage userRegistrationPage;
	protected HomePage homePage;
	protected MainMenuSection mainMenuSection;
	
	String url = PropertyFileReader.readFile(GlobalConstants.CONFIGFILE).get("url").toString();
	 	
	@Parameters({"browser"})
	@BeforeMethod
	public void testInit(String browser) throws Exception { 			
    	
		// Setup the driver of type Driver
		driver = new DriverLogger(new DriverBase());			
		
		// Add the Driver to Threadlocal from DriverManager
		DriverManager.setDriver(driver);
		Log.info("Driver set up Successfull.");

		// Getting the driver from the Threadlocal internal hashmap
		DriverManager.getDriver().start(browser);
		Log.info("Browser "+browser+" started.");	
		
		homePage=new HomePage();
		myaccountsPage=new MyAccountPage();
		userRegistrationPage=new UserRegistrationPage();
		
		}
	
	@AfterMethod
	public void testCleanup() {
		if (DriverManager.getDriver() != null) {
			DriverManager.removeDriver();
		}
		Log.info("Driver quit successfully.");

	}
}
