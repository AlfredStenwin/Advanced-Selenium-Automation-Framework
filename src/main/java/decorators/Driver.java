package decorators;

import org.openqa.selenium.By;

import java.io.File;
import java.util.List;

public interface Driver {
    public void start(String browser);
    public void quit();
    public void goToUrl(String url);
    public String getPageTitle();
    public Element findElement(By locator);
    public List<Element> findElements(By locator);
    public void waitForAjax();
    public void waitUntilPageLoadsCompletely();
    public File takescreenshot();
}
