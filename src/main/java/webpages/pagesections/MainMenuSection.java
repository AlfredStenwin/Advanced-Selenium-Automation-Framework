package webpages.pagesections;

import decorators.Driver;
import webpages.pageelements.MainMenuSectionElements;

public class MainMenuSection {
	private final Driver driver;
	
	public MainMenuSection(Driver driver) {
		this.driver = driver;
	}
	
	
	public MainMenuSectionElements elements() {
		return new MainMenuSectionElements(driver);
	}

	
}
