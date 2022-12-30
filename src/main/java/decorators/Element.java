package decorators;

import org.openqa.selenium.By;

public interface Element {
    public By getBy();
    public String getText();
    public Boolean isEnabled();
    public Boolean isDisplayed();
    public void typeText(String text);
    public void click();
    public String getAttribute(String attributeName);
    
}
