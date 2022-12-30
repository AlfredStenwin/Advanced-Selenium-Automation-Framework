package decorators;

import org.openqa.selenium.By;

import java.io.File;
import java.util.List;

public class DriverDecorator implements Driver {
    protected Driver driver;

    public DriverDecorator(Driver driver) {
        this.driver = driver;
    }

    public void start(String browser) {
        driver.start(browser);
    }

    public void quit() {
        driver.quit();
    }

    public void goToUrl(String url) {
        driver.goToUrl(url);
    }
    
	public String getPageTitle() {
		return driver.getPageTitle();
	}

    public Element findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<Element> findElements(By locator) {
        return driver.findElements(locator);
    }
    
    public void waitForAjax() {
        driver.waitForAjax();
    }
    
    public void waitUntilPageLoadsCompletely() {
        driver.waitUntilPageLoadsCompletely();
    }

	public File takescreenshot() {
		return driver.takescreenshot();		
	}

	
}