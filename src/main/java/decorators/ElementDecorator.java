package decorators;

import org.openqa.selenium.By;

public class ElementDecorator implements Element {
    protected final Element element;//composition - by containing
    //instances of other classes that implement the desired functionality. 
    //Element class in this case

    protected ElementDecorator(Element element) {
        this.element = element;
    }

    public By getBy() {
        return element.getBy();
    }

    public String getText() {
        return element.getText();
    }

    public Boolean isEnabled() {
        return element.isEnabled();
    }

    public Boolean isDisplayed() {
        return element.isDisplayed();
    }

    public void typeText(String text) {
        element.typeText(text);
    }

    public void click() {
        element.click();
    }

    public String getAttribute(String attributeName) {
        return element.getAttribute(attributeName);
    }

}
