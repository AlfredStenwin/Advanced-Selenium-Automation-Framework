package decorators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementBase implements Element {
    private final WebElement webElement;
    private final By by;

    public ElementBase( WebElement webElement, By by) {
        this.webElement = webElement;
        this.by = by;
    }

    public By getBy() {
        return by;
    }

    public String getText() {
        return webElement.getText();
    }

    public Boolean isEnabled() {
        return webElement.isEnabled();
    }

    public Boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    public void typeText(String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void click() {
     //   waitToBeClickable(by);
        webElement.click();
    }

    public String getAttribute(String attributeName) {
        return webElement.getAttribute(attributeName);
    }

//    private void waitToBeClickable(By by) {
//        var webDriverWait = new WebDriverWait(webDriver, 30);
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
//    }
}
