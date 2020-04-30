package main;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;


import utilities.MailConstants;
import utilities.MailExcelUtility;
import utilities.MailLinkFramework;


public class MailRegistrationTestUnitPositive {
	private WebDriver driver;
	MailLinkFramework mailFrame;
	private static final Logger log = LogManager.getLogger(MailRegistrationTestUnitPositive.class.getName());



	@BeforeClass
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		mailFrame = new MailLinkFramework (driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(MailConstants.URL);
		log.info("Web application opened");

		MailExcelUtility.setExcelFile(MailConstants.File_Path + MailConstants.File_Name, "RegistrationTests");
		mailFrame.clickMailRegistration();	
	}
	
	
	@DataProvider(name = "registrationDataPositive")
	public Object [][] dataProvider() {
		Object[][] testData = MailExcelUtility.getTestData("positiveTest");
		return testData;
	}
	
	
	@Test(dataProvider = "registrationDataPositive")
	public void mailUsingExcelPositive(String testCaseNumber, String firstName,String lastName, String dateBirth, String gender, String mailName, String mailPassword, String repeatMailPassword, String mailPhone)  throws Exception {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		

		mailFrame.fillFirstName(firstName);
		
		mailFrame.fillLastName(lastName);

		mailFrame.dateMail(dateBirth);

		mailFrame.genderMailChooser(gender);

		mailFrame.fillMailName(mailName);

		mailFrame.fillMailPassword(mailPassword);

		mailFrame.fillMailPassword2(repeatMailPassword);

		mailFrame.fillMailPhone(mailPhone);

		mailFrame.clickMailSubmit();

		mailFrame.mailCountErrorsPositive();
		
		log.info("пройден кейс " + testCaseNumber);


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

	}
	
	

}