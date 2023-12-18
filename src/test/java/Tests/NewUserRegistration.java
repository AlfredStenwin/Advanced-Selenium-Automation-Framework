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
		String expectedTitle = "Home Page";
		String actualtitle = homePage.gotoUrl(url).getPageTitle();
		Assert.assertEquals(actualtitle , expectedTitle);
		Log.info("Completed test for Navigate to home page.");
	}	
	
	@Test
	public void navigateToUserSignupPage() {
		String expectedTitle = "Create New Customer Account";						
		homePage.gotoUrl(url).clickOnSignUpTab().getPageTitle();			
		String actualtitle = userRegistrationPage.getPageTitle();
		Assert.assertEquals(actualtitle, expectedTitle);	
		Log.info("Completed test for Navigate to user signup page.");
	}
	
	@Test( dataProvider = "dataProvider1" )
	public void registerNewUser(Map<String, Object> map) {
		String expectedTitle = "My Account";		
		homePage.gotoUrl(url)
		.clickOnSignUpTab()
		.enterFirstname(map.get("firstname").toString())
		.enterLastname(map.get("lastname").toString())
		.enterEmail(map.get("email").toString())
		.enterPassword(map.get("password").toString())
		.confirmPassword(map.get("password").toString())
		.ClickCreateAnAccountButton();	
		
		String actualTitle = myaccountsPage.GetPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);	// Expected to fail now as the page wont be displayed 
		Log.info("Completed test for Register new user.");
	}
	

	
	@DataProvider (name = "dataProvider1")
	public Object[] getData()  {
		String dataFilePath = System.getProperty("user.dir")+"/src/test/resources/TestData.json";						
		return JsonFileReader.readFile(dataFilePath);
				
	}
}
