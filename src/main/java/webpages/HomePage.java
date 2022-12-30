package webpages;

import decorators.Driver;
import webpages.pageelements.HomePageElements;
import webpages.pagesections.MainMenuSection;

public class HomePage extends BasePage{
		
	public HomePage(Driver driver) {
		super(driver);	
	}		

	//composition
	public HomePageElements elements() {
		return new HomePageElements(driver);
	}
	
//	//composition
//	public MainMenuSection mainMenuSection() {
//		return new MainMenuSection(driver);
//	}
	
	@Override
	protected void waitForPageLoad() {		
	}
	
	//Methods
	public HomePage gotoUrl(String url) {
		driver.goToUrl(url);
		log.info("Navigated to URL.");
		
		return this;
	}
	
	public String getPageTitle(){
		return driver.getPageTitle();
	}

	
	public UserRegistrationPage clickOnSignUpTab(){
		driver.findElement(elements().getCreateAnAccountLink()).click();
		log.info("Clicked on signup tab");

		return new UserRegistrationPage(driver);
	}			
}
