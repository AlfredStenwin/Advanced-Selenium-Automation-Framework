package decorators;

import org.openqa.selenium.By;

import logsetup.LogUtility;

public class ElementLogger extends ElementDecorator {
	//public static Logger log = LogManager.getLogger("LOG");
	private LogUtility log = LogUtility.getInstance();

	
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
    	log.info(String.format("Element Text = %s", elementName));
        return elementName;
    }

    @Override
    public Boolean isEnabled() {
        log.info(String.format("Element Enabled = %b", element.isEnabled()));
        return element.isEnabled();
    }

    @Override
    public Boolean isDisplayed() {
    	log.info((String.format("Element Displayed = %b", element.isDisplayed())));
        return element.isDisplayed();
    }

    @Override
    public void typeText(String text){
    	log.info((String.format("Type Text = %s", text)));
        element.typeText(text);
    }

    @Override
    public void click() {
        element.click();
    	log.info("Element  Clicked");
    }

    @Override
    public String getAttribute(String attributeName) {
    	log.info("Trying to get attribute");
        return element.getAttribute(attributeName);
    }
}
