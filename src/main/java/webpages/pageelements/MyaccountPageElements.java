package webpages.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import decorators.Driver;


public class MyaccountPageElements {

	
	@FindBy(xpath = "//*")
	@CacheLookup
	private List<WebElement> allElements;
	
	public MyaccountPageElements(Driver driver) {
		//PageFactory.initElements(driver, this);
	}
	
//	//Getters
//	public WebElement GetJetztKotenlosRegistrierenButtonElement() {
//		return driver.findElement(By.xpath("//a[@name='register']"));
//	}	
	
}
