package webpages;

import decorators.Driver;
import logsetup.LogUtility;

public abstract class BasePage{
	
	protected LogUtility log = LogUtility.getInstance();
	protected final Driver driver;
	
	public BasePage(Driver driver) {
		this.driver = driver;
	}
	
	protected abstract void waitForPageLoad();
	
	
	

}
