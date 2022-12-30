package webpages;

import decorators.Driver;
import webpages.pageelements.MyaccountPageElements;

public class MyAccountPage extends BasePage{
		
	public MyAccountPage(Driver driver) {
		super(driver);
	}
		
	public MyaccountPageElements elements() {
		return new MyaccountPageElements(driver);
	}
		
	@Override
	protected void waitForPageLoad( ) {
	}
	
	//Methods
	public String GetPageTitle(){
		return driver.getPageTitle();
	}
	

}
