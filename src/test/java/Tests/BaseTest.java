package Tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import decorators.Driver;
import decorators.DriverBase;
import decorators.DriverLogger;
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
	
	String url = PropertyFileReader
			.readFile(System.getProperty("user.dir")+"/src/test/resources/Config.properties")
			.get("url")
			.toString();
			 	
	@Parameters({"browser"})
	@BeforeSuite
	public void testInit(String browser) throws Exception {
		
		driver = new DriverLogger(new DriverBase());	
		Log.info("Driver set up Successfull." +Thread.currentThread().getId());
		
		homePage=new HomePage(driver);
		myaccountsPage=new MyAccountPage(driver);
		userRegistrationPage=new UserRegistrationPage(driver);
		Log.info("Trying to start browser: "+browser +Thread.currentThread().getId());
		driver.start(browser);
		Log.info("Broswer "+browser+" started" +Thread.currentThread().getId());	
	}
	
	@AfterSuite
	public void testCleanup() {
		if (driver != null) {
			driver.quit();
		}
		Log.info("Driver quit successfully.");

	}
}
