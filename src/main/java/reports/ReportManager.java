package reports;

import com.aventstack.extentreports.ExtentTest;

public class ReportManager {
	
	private ReportManager () {}

	private static ThreadLocal<ExtentTest> xtnttest = new ThreadLocal<>();
	
	public static ExtentTest getExtentTest() {
		return xtnttest.get();
	}
	
	public static void setExtentTest(ExtentTest extentTest) {
		xtnttest.set(extentTest);
	}

	public static void removeExtentTest() {
		xtnttest.remove();
	}

}
