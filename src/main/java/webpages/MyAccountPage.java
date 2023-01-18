package webpages;

import drivermanager.DriverManager;
import logsetup.Log;
import webpages.pageelements.MyaccountPageElements;

public class MyAccountPage {
		
	public MyaccountPageElements elements() {
		return new MyaccountPageElements();
	}
		
	
	//Methods
	public String GetPageTitle(){
		Log.info("Getting page title in Myaccounts page.");		
		return DriverManager.getDriver().getPageTitle();
	}
	

}
