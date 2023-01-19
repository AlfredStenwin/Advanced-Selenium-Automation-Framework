/**
 * 
 */
package utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import decorators.Driver;
import drivermanager.DriverManager;

/**
 * @author Alfred Sunny
 * 
 */
public class ScreenshotUtility {
	
	//Method to get the screenshots
	public static File takescreenshot(Driver driver) {
		
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	}
}
