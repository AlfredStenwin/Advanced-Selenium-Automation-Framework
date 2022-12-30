package decorators;

import org.openqa.selenium.By;

import logsetup.LogUtility;

import java.io.File;
import java.util.List;

public class DriverLogger extends DriverDecorator {
	//public static Logger log = LogManager.getLogger(DriverLogger.class);
	private LogUtility log = LogUtility.getInstance();
	
	public DriverLogger(Driver driver ) {
        super(driver);
    }

    @Override
    public void start(String browser) {
        driver.start(browser);
        log.info(String.format("Started browser: %s", browser));
    }

    @Override
    public void quit() {
        driver.quit();
    	log.info("Closed browser");
    }

    @Override
    public void goToUrl(String url) {
        driver.goToUrl(url);
    	log.info(String.format("Navigated to url: %s", url));
    }

    @Override
    public Element findElement(By locator) {
    	var element = driver.findElement(locator);
    	log.info("Located element by locator "+locator);

        return element;
    }

    @Override
    public List<Element> findElements(By locator) {
        return driver.findElements(locator);
    }
    
    @Override
    public File takescreenshot() {
    	log.info("Screenshot taken.");
		return driver.takescreenshot();		
	}
}
