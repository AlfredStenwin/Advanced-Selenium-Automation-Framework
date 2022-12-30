package decorators;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverfactory.DriverFactory;

public class DriverBase implements Driver {
    private WebDriver driver;
    private WebDriverWait wait;
    
	protected static ThreadLocal<WebDriver> threadLocaldriver = new ThreadLocal<>();
 
    public void start(String browser) {
    	driver = DriverFactory.getDriverManager(browser).initDriver();
    	wait = new WebDriverWait(driver, 60);
    	threadLocaldriver.set(driver);
    }

    public void quit() {
        threadLocaldriver.get().quit();
        threadLocaldriver.remove();
    }

    public void goToUrl(String url) {
    	threadLocaldriver.get().get(url);
    }

	public String getPageTitle() {  	
    	return threadLocaldriver.get().getTitle();
	}
    
    public Element findElement(By locator) {
        var nativeWebElement = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Element element = new ElementBase(nativeWebElement, locator );
        // use decorated element
        Element logElement = new ElementLogger(element);

        return logElement;
    }

    public List<Element> findElements(By locator) {
        List<WebElement> nativeWebElements =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        var elements = new ArrayList<Element>();
        for (WebElement nativeWebElement:nativeWebElements) {
            Element element = new ElementBase(nativeWebElement, locator);
            Element logElement = new ElementLogger(element);
            elements.add(logElement);
        }

        return elements;
    }
    
    public void waitForAjax() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) threadLocaldriver.get();
        wait.until(d -> (Boolean) javascriptExecutor.executeScript("return window.jQuery != undefined && jQuery.active == 0"));
    }
    
    public void waitUntilPageLoadsCompletely() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) threadLocaldriver.get();
        wait.until(d -> javascriptExecutor.executeScript("return document.readyState").toString().equals("complete"));
    }

	public File takescreenshot() {
		var scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		return scr;
	}
	
}
