package webpages;

import decorators.Driver;
import webpages.pageelements.UserRegistrationPageElements;

public class UserRegistrationPage extends BasePage{
		
	public UserRegistrationPage(Driver driver) {
		super(driver);
	}
		
	//get elements by composition
	public UserRegistrationPageElements elements() {
		return new UserRegistrationPageElements(driver);
	}
	
	@Override
	protected void waitForPageLoad() {
	}
		
	public String getPageTitle(){
		return driver.getPageTitle();
	}
	
	public UserRegistrationPage enterFirstname(String firstname) {	
		driver.findElement(elements().getTxtboxFirstname()).typeText(firstname);
		return this;
	}
	
	public UserRegistrationPage enterLastname(String lastname) {	
		driver.findElement(elements().getTxtboxLastname()).typeText(lastname);
		return this;
	}
	
	public UserRegistrationPage enterEmail(String email) {	
		driver.findElement(elements().getTxtboxEmail()).typeText(email);
		return this;
	}
	
	public UserRegistrationPage enterPassword(String password) {	
		driver.findElement(elements().getTxtboxPassword()).typeText(password);
		return this;
	}
	
	public UserRegistrationPage confirmPassword(String password) {	
		driver.findElement(elements().getTxtboxConfirmPassword()).typeText(password);
		return this;
	}
	
	public MyAccountPage ClickCreateAnAccountButton() {	
		driver.findElement(elements().getBtnCreateAnAccount()).click();
		return new MyAccountPage(driver);
	}
	
	
}
