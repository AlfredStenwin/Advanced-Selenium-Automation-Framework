package webpages.pageelements;

import org.openqa.selenium.By;
import decorators.Driver;
import decorators.Element;


public class HomePageElements {
	Driver driver;
	
	public HomePageElements(Driver driver) {
		this.driver=driver;
	}
	
	private final By welcomeMessage = By.xpath("//*[text()='Default welcome msg!']");
	private final By createAnAccountLink = By.xpath("//a[text()='Create an Account']");	

	public By getCreateAnAccountLink() {
		//return driver.findElements(CreateAnAccountLink).get(0);
		return createAnAccountLink;
	}
	
	public By getWelcomeMessage() {
		return welcomeMessage;
	}



}
