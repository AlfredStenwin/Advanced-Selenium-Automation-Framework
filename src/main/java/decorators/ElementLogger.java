package decorators;

import org.openqa.selenium.By;

import logsetup.Log;

public class ElementLogger extends ElementDecorator {

	
	protected ElementLogger(Element element) {
        super(element);
    }

    @Override
    public By getBy() {
        return element.getBy();
    }

    @Override
    public String getText() {
    	String elementName = element.getText();
    	Log.info(String.format("Element Text = %s", elementName));
        return elementName;
    }

    @Override
    public Boolean isEnabled() {
    	Log.info(String.format("Element Enabled = %b", element.isEnabled()));
        return element.isEnabled();
    }

    @Override
    public Boolean isDisplayed() {
    	Log.info((String.format("Element Displayed = %b", element.isDisplayed())));
        return element.isDisplayed();
    }

    @Override
    public void typeText(String text){
    	Log.info((String.format("Type Text = %s", text)));
        element.typeText(text);
    }

    @Override
    public void click() {
        element.click();
        Log.info("Element  Clicked");
    }

    @Override
    public String getAttribute(String attributeName) {
    	Log.info("Trying to get attribute");
        return element.getAttribute(attributeName);
    }
}
