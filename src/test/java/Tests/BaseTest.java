package Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import decorators.Driver;
import decorators.DriverBase;
import decorators.DriverLogger;
import enums.FileType;
import filereaderfactory.FileReaders;
import filereaderfactory.ReaderManager;
import logsetup.Log;
import webpages.HomePage;
import webpages.MyAccountPage;
import webpages.UserRegistrationPage;
import webpages.pagesections.MainMenuSection;

public class BaseTest {
	
	public Driver driver;
	//private Logger log = LogManager.getLogger(BaseTest.class);
	
	protected MyAccountPage myaccountsPage;
	protected UserRegistrationPage userRegistrationPage;
	protected HomePage homePage;
	protected MainMenuSection mainMenuSection;
	
	protected ReaderManager configFile = FileReaders.getFileReader(FileType.PROPERTY)
			.readFile(System.getProperty("user.dir")+"/src/test/resources/Config.properties");
	
	final String url = configFile.get("url");
	
	@Parameters({"browser"})
	@BeforeTest
	public void testInit(String browser) throws Exception {
		
		//
		driver = new DriverLogger(new DriverBase());	
		Log.info("Driver set up Successfull." +Thread.currentThread().getId());
		
		homePage=new HomePage(driver);
		myaccountsPage=new MyAccountPage(driver);
		userRegistrationPage=new UserRegistrationPage(driver);
		Log.info("Trying to start browser: "+browser +Thread.currentThread().getId());
		driver.start(browser);
		Log.info("Broswer "+browser+" started" +Thread.currentThread().getId());	
	}
	
	@AfterTest
	public void testCleanup() {
		if (driver != null) {
			driver.quit();
		}
		Log.info("Driver quit successfully.");

	}
}
