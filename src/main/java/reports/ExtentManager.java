package reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	
	private ExtentManager() {} //Cannot invoke the constructor from other methods
	
	//To make the extent report thread safe, Thread local is used
	private static ThreadLocal<ExtentTest> tlExtentTest = new ThreadLocal<>();
	
	public static ExtentTest GetExtentTest() {		
		 return tlExtentTest.get();
	}
	
	//Method to set the threadlocal version of extend report
	public static void setExtentTest(ExtentTest test) {
		tlExtentTest.set(test);
	}
	
	public static void unload() {
		tlExtentTest.remove();
	}
	
}
