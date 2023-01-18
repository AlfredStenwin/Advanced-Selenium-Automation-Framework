package webpages;

import drivermanager.DriverManager;
import logsetup.Log;
import webpages.pageelements.UserRegistrationPageElements;

public class UserRegistrationPage  {

		
	//get elements by composition
	public UserRegistrationPageElements elements() {
		return new UserRegistrationPageElements();
	}
	
		
	public String getPageTitle(){
		Log.info("Getting page title in userregistration page." +Thread.currentThread().getId());		
		return DriverManager.getDriver().getPageTitle();
	}
	
	public UserRegistrationPage enterFirstname(String firstname) {	
		DriverManager.getDriver().findElement(elements().getTxtboxFirstname()).typeText(firstname);
		Log.info("Entered firstname.");		
		return this;
	}
	
	public UserRegistrationPage enterLastname(String lastname) {	
		DriverManager.getDriver().findElement(elements().getTxtboxLastname()).typeText(lastname);
		Log.info("Entered last name.");		
		return this;
	}
	
	public UserRegistrationPage enterEmail(String email) {	
		DriverManager.getDriver().findElement(elements().getTxtboxEmail()).typeText(email);
		Log.info("Entered email.");		

		return this;
	}
	
	public UserRegistrationPage enterPassword(String password) {	
		DriverManager.getDriver().findElement(elements().getTxtboxPassword()).typeText(password);
		Log.info("Entered password.");		
		return this;
	}
	
	public UserRegistrationPage confirmPassword(String password) {	
		DriverManager.getDriver().findElement(elements().getTxtboxConfirmPassword()).typeText(password);
		Log.info("confirmed password.");		
		return this;
	}
	
	public MyAccountPage ClickCreateAnAccountButton() {	
		DriverManager.getDriver().findElement(elements().getBtnCreateAnAccount()).click();
		Log.info("Clicked CreateAnAccount Button.");		
		return new MyAccountPage();
	}
	
	
}
