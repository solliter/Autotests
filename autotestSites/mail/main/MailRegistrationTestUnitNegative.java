package main;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.AfterClass;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import utilities.MailConstants;
import utilities.MailExcelUtility;
import utilities.MailExtentFactory;
import utilities.MailLinkFramework;


public class MailRegistrationTestUnitNegative {
	private WebDriver driver;
	MailLinkFramework mailFrame;
	ExtentReports report;
	ExtentTest test;



	@BeforeClass
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		mailFrame = new MailLinkFramework (driver);
		report = MailExtentFactory.getInstance();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test = report.startTest("Registration test start");
		driver.get(MailConstants.URL);
		test.log(LogStatus.INFO, "Web application opened");

		MailExcelUtility.setExcelFile(MailConstants.File_Path + MailConstants.File_Name, "RegistrationTests");
		mailFrame.clickMailRegistration();	
	}
	
	
	@DataProvider(name = "registrationDataNegative")
	public Object [][] dataProvider2() {
		Object[][] testData = MailExcelUtility.getTestData("negativetest");
		return testData;
	}
	
	
	@Test(dataProvider = "registrationDataNegative")
	public void mailUsingExcelNegative(String firstName, String lastName, String dateBirth, String gender, String mailName, String mailPassword, String repeatMailPassword, String mailPhone)  throws Exception {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		
		}
		try {
			mailFrame.fillFirstName(firstName);
			test.log(LogStatus.INFO, "Filling first name");
			mailFrame.fillLastName(lastName);
			test.log(LogStatus.INFO, "Filling last name");
			mailFrame.dateMail(dateBirth);
			test.log(LogStatus.INFO, "Filling date birth");
			mailFrame.genderMailChooser(gender);
			test.log(LogStatus.INFO, "Choosing gender");
			mailFrame.fillMailName(mailName);
			test.log(LogStatus.INFO, "Filling mail name");
			mailFrame.fillMailPassword(mailPassword);
			test.log(LogStatus.INFO, "Filling mail password");
			mailFrame.fillMailPassword2(repeatMailPassword);
			test.log(LogStatus.INFO, "Reapeat mail password");
			mailFrame.fillMailPhone(mailPhone);
			test.log(LogStatus.INFO, "Filling mail phone number");
			mailFrame.clickMailSubmit();
			test.log(LogStatus.INFO, "Submit test");
		mailFrame.mailCountErrorsNegative();
		} catch (NoSuchElementException e) { System.out.println(e.getMessage());}

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F5);
		robot.keyRelease(KeyEvent.VK_F5);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}

}