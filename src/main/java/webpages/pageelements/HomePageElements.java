package webpages.pageelements;

import org.openqa.selenium.By;
import decorators.Driver;


public class HomePageElements {
	Driver driver;
	
	public HomePageElements(Driver driver) {
		this.driver=driver;
	}
	
	private final By welcomeMessage = By.xpath("//*[text()='Default welcome msg!']");
	private final By createAnAccountLink = By.xpath("//a[text()='Create an Account']");	

	public By getCreateAnAccountLink() {
		return createAnAccountLink;
	}
	
	public By getWelcomeMessage() {
		return welcomeMessage;
	}



}
