package Tests;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import decorators.Driver;
import enums.FileType;
import filereaderfactory.FileReaders;

public class NewUserRegistration extends BaseTest{	
	Driver driver;
	private static Logger LogUtility = LoggerFactory.getLogger(BaseTest.class);

		
	@Test( description = "Navigate to home page" , enabled = true, priority = 1)
	public void navigateToHomepage() {
		String pageTitle = "Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites";
		String title = homePage.gotoUrl(url).getPageTitle();
		Assert.assertEquals(title , pageTitle);
		LogUtility.info("Completed test for Navigate to home page");
	}	
	
	@Test( description = "Navigate to user signup page", enabled = true)
	public void navigateToUserSignupPage() {
		String pageTitle = "Create New Customer Account Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites";						
		homePage.gotoUrl(url).clickOnSignUpTab().getPageTitle();			
		String title = userRegistrationPage.getPageTitle();
		Assert.assertEquals(title, pageTitle);	
		LogUtility.info("Completed test for Navigate to user signup page");
	}
	
	@Test( description = "Register new user", enabled = false, dataProvider = "dataProvider1" )
	public void registerNewUser(Map<String, String> map) {
		String title = "My Account Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites";		
		homePage.gotoUrl(url)
		.clickOnSignUpTab()
		.enterFirstname(map.get("firstname"))
		.enterLastname(map.get("lastname"))
		.enterEmail(map.get("email"))
		.enterPassword(map.get("password"))
		.confirmPassword(map.get("password"))
		.ClickCreateAnAccountButton();	
		
		String pageTitle = myaccountsPage.GetPageTitle();
		Assert.assertEquals(pageTitle, title);	
		LogUtility.info("Completed test for Register new user");
	}
	

	
	@DataProvider (name = "dataProvider1")
	public Object[] getData()  {
		String dataFilePath = System.getProperty("user.dir")+"/src/test/resources/TestData.json";
		
		return FileReaders.getFileReader(FileType.JSON).readFile(dataFilePath).getObject();	
	}
}
