package driverfactory;

public class DriverFactory  {
	
	public static DriverManager getDriverManager(String browser) {
        DriverManager driverManager; 
             
        switch (browser) {
		case "chrome":
        	driverManager = new ChromeDriverManager();
			break;
		case "edge":
        	driverManager = new EdgeDriverManager();
        	break;
		default:
			throw new IllegalArgumentException(browser);
		}
        
        return driverManager;
    }
    
}
