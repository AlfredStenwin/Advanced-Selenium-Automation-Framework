package webpages;

import decorators.Driver;

public abstract class BasePage{
	
	protected final Driver driver;
	
	public BasePage(Driver driver) {
		this.driver = driver;
	}
	
	protected abstract void waitForPageLoad();
	
	
	

}
