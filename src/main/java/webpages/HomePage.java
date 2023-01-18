package webpages;

import drivermanager.DriverManager;
import logsetup.Log;
import webpages.pageelements.HomePageElements;
import webpages.pagesections.MainMenuSection;

public class HomePage {	
	
	
	//composition
	public HomePageElements elements() {
		return new HomePageElements();
	}
	
	//composition
	public MainMenuSection mainMenuSection() {
		return new MainMenuSection();
	}

	
	//Methods
	public HomePage gotoUrl(String url) {
		DriverManager.getDriver().goToUrl(url);
		Log.info("Navigated to URL.");		
		return this;
	}
	
	public String getPageTitle(){
		Log.info("Getting page title in home page.");		
		return DriverManager.getDriver().getPageTitle();
	}

	
	public UserRegistrationPage clickOnSignUpTab(){
		DriverManager.getDriver().findElement(elements().getCreateAnAccountLink()).click();
		Log.info("Clicked on signup tab");		


		return new UserRegistrationPage();
	}			
}
