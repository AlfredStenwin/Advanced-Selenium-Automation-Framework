package utilities;

import java.io.File;

import drivermanager.DriverManager;

/**
 * @author Alfred Sunny
 * 
 */
public final class ScreenshotUtility {
	
	//Method to get the screenshots. Instance of the threadlocal is used to prevent the thread related issue
	public static File getscreenshot() {	
		return DriverManager.getDriver().takescreenshot();
	}
}
