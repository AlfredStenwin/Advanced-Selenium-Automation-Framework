package Tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import decorators.Driver;
import enums.FileType;
import filereaderfactory.FileReaders;

public class NewUserRegistration2 extends BaseTest{	
	Driver driver;
		
	@Test( description = "Navigate to home page" , enabled = true, priority = 1)
	public void navigateToHomepage2() {
		String pageTitle = "Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites";
		String title = homePage.gotoUrl(url).getPageTitle();
		Assert.assertEquals(title , pageTitle);
	}	
	
	@Test( description = "Navigate to user signup page", enabled = true)
	public void navigateToUserSignupPage2() {
		String pageTitle = "Create New Customer Account Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites";						
		homePage.gotoUrl(url).clickOnSignUpTab().getPageTitle();			
		String title = userRegistrationPage.getPageTitle();
		Assert.assertEquals(title, pageTitle);		
	}
	
	@Test( description = "Register new user2", enabled = true, dataProvider = "dataProvider1" )
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
	}
	

	
	@DataProvider (name = "dataProvider1")
	public Object[] getData()  {
		String dataFilePath = System.getProperty("user.dir")+"/src/test/resources/TestData.json";
		
		return FileReaders.getFileReader(FileType.JSON).readFile(dataFilePath).getObject();	
	}
}
