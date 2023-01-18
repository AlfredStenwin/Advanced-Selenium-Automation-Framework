package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeDriverManager implements BrowserManager{

	WebDriver driver;
	
	public WebDriver initDriver() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		
		return driver;
	}

}
