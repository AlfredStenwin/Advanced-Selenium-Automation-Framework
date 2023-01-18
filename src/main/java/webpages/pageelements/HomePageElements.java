package webpages.pageelements;

import org.openqa.selenium.By;

public class HomePageElements {
	
	private final By welcomeMessage = By.xpath("//*[text()='Default welcome msg!']");
	private final By createAnAccountLink = By.xpath("//a[text()='Create an Account']");	

	public By getCreateAnAccountLink() {
		return createAnAccountLink;
	}
	
	public By getWelcomeMessage() {
		return welcomeMessage;
	}



}
