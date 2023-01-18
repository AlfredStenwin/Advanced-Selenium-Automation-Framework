package webpages.pageelements;

import org.openqa.selenium.By;

public class UserRegistrationPageElements {	

	private final By txtboxFirstname = By.id("firstname");
	private final By txtboxLastname = By.id("lastname");
	private final By txtboxEmail = By.id("email_address");
	private final By txtboxPassword = By.id("password");
	private final By txtboxConfirmPassword = By.id("password-confirmation");
	private final By btnCreateAnAccount  = By.xpath("//button[@class='action submit primary']");
	
	//Methods
	public By getTxtboxFirstname() {
		return txtboxFirstname;
	}
	
	public By getTxtboxLastname() {
		return txtboxLastname;
	}
	
	public By getTxtboxEmail() {
		return txtboxEmail;
	}
	
	public By getTxtboxPassword() {
		return txtboxPassword;
	}
	
	public By getTxtboxConfirmPassword() {
		return txtboxConfirmPassword;
	}
	
	public By getBtnCreateAnAccount() {
		return btnCreateAnAccount;
	}
	
	
}
