package utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class MailExtentFactory {
	public static ExtentReports getInstance() {
		ExtentReports extent;
		String Path = "C:\\Users\\kelir\\eclipse-workspace\\SeleniumWDTutorial\\mail\\logs\\MailRegTest.html";
		extent = new ExtentReports(Path, true);
		extent
	     .addSystemInfo("Selenium Version", "2.52")
	     .addSystemInfo("Platform", "WIN10");

		return extent;
	}
}