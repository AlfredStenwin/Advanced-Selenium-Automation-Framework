package Tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import logsetup.Log;
import utilities.JsonFileReader;

public class NewUserRegistration extends BaseTest{	
		
	@Test
	public void navigateToHomepage() {
		String pageTitle = "Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites";
		String title = homePage.gotoUrl(url).getPageTitle();
		Assert.assertEquals(title , pageTitle);
		Log.info("Completed test for Navigate to home page.");
	}	
	
	@Test
	public void navigateToUserSignupPage() {
		String pageTitle = "Create New Customer Account Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites";						
		homePage.gotoUrl(url).clickOnSignUpTab().getPageTitle();			
		String title = userRegistrationPage.getPageTitle();
		Assert.assertEquals(title, pageTitle);	
		Log.info("Completed test for Navigate to user signup page.");
	}
	
	@Test( dataProvider = "dataProvider1" )
	public void registerNewUser(Map<String, Object> map) {
		String title = "My Account Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites";		
		homePage.gotoUrl(url)
		.clickOnSignUpTab()
		.enterFirstname(map.get("firstname").toString())
		.enterLastname(map.get("lastname").toString())
		.enterEmail(map.get("email").toString())
		.enterPassword(map.get("password").toString())
		.confirmPassword(map.get("password").toString())
		.ClickCreateAnAccountButton();	
		
		String pageTitle = myaccountsPage.GetPageTitle();
		Assert.assertEquals(pageTitle, title);	// Expected to fail now as the page wont be displayed 
		Log.info("Completed test for Register new user.");
	}
	

	
	@DataProvider (name = "dataProvider1")
	public Object[] getData()  {
		String dataFilePath = System.getProperty("user.dir")+"/src/test/resources/TestData.json";						
		return JsonFileReader.readFile(dataFilePath);
				
	}
}
