package techQuestEmpl;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import usefulmethods.GenericMethods;
import utilities.WaitTypes;

public class sberBank {
	private WebDriver driver;
	private String baseUrl;
	private GenericMethods gm;
	private JavascriptExecutor js;
	WaitTypes wt;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://ipoteka.domclick.ru/mland/calculator";
		gm = new GenericMethods(driver);
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		wt = new WaitTypes(driver);
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);

		WebElement chooseTarget2 = driver
				.findElement(By.xpath("//input[@class='dcCalc_textfield__input' and not(@id)]"));
		chooseTarget2.click();
		Thread.sleep(1000);
		wt.waitForElement(By.xpath("//div[normalize-space(text()) = 'Покупка готового жилья']"), 3).click();

		Thread.sleep(1000);
		// Choose of type of credit

		WebElement moneyChoose = driver.findElement(By.xpath("//input[@id='estateCost']"));
		moneyChoose.click();
		moneyChoose.clear();
		moneyChoose.sendKeys("1666000");
		Thread.sleep(1200);
		// input of money

		WebElement moneyHave = driver.findElement(By.xpath("//input[@id='initialFee']"));
		moneyHave.click();
		moneyHave.clear();
		moneyHave.sendKeys("350000");
		Thread.sleep(1200);
		// input of customers money

		WebElement chooseYears = driver.findElement(By.xpath("//input[@id='creditTerm']"));
		chooseYears.click();
		chooseYears.clear();
		chooseYears.sendKeys("3");
		Thread.sleep(1200);
		// input of credit years

		js.executeScript("window.scrollBy(0, 300);");
		Thread.sleep(2000);
//
//		WebElement switch1 = driver
//				.findElement(By.xpath("//div[@class='dcCalc_frame__discounts']//div[1]//div[2]//label[1]//span[1]"));
//		if (switch1.isSelected()) {
//		} else {
//			switch1.click();
//
//		}
//		
//		WebElement switch2 = driver
//				.findElement(By.xpath("//div[@class='dcCalc_frame__discounts']//div[2]//div[2]//label[1]"));
//		if (switch2.isSelected()) {
//		} else {
//			switch2.click();
//
//		}
//		
//		WebElement switch3 = driver
//				.findElement(By.xpath("//div[@class='dcCalc_frame__discounts']//div[3]//div[2]//label[1]"));
//		if (switch3.isSelected()) {
//		} else {
//			switch3.click();
//
//		}
//		
//		WebElement switch4 = driver
//				.findElement(By.xpath("//div[@class='dcCalc_frame__discounts']//div[4]//div[2]//label[1]"));
//		if (switch4.isSelected()) {
//		} else {
//			switch4.click();
//
//		}
//		
//		WebElement resultEnd = driver.findElement(By.xpath("//span[@data-test-id = 'monthlyPayment']"));
//		String resultNumber = resultEnd.getText();
//		System.out.println(resultNumber);

		
		
		  
		  
		 List<WebElement> switchList = gm.getElementList("//label[not(contains(@class, \"checked\"))]/span[contains(@class,'dcCalc_switch__control')]","xpath");		  
		 for (WebElement switchOnly : switchList) { 
				 switchOnly.click();
				 Thread.sleep(1000); } 
		
		 
//		 Thread.sleep(2000);
//		 List<WebElement> switchList = driver.findElements(By.xpath("//span[contains(@class,\"dcCalc_switch__control\")]/.."));
//		 while (!switchList.isEmpty()) {
//		     WebElement switchOnly = switchList.remove(0);
//		     if (!switchOnly.getAttribute("class").contains("checked"))
//		     {
//		         switchOnly.click();
//		         switchList = driver.findElements(By.xpath("//span[contains(@class,\"dcCalc_switch__control\")]/.."));
//		         Thread.sleep(1000);
//		     }
//		 }
//		 Thread.sleep(5000);
	
	
		WebElement mounthlyPayment = driver.findElement(By.xpath("//div[@class = 'dcCalc_calcResult_layout']//span[@data-test-id = 'monthlyPayment']"));
		
		if (mounthlyPayment.getText().equals("41 543 ₽")) {
		
		System.out.println("Автотест пройдент корректно " + mounthlyPayment.getText());}
		
		else
		{
			System.out.println("Автотест пройдент некорректно " + mounthlyPayment.getText());	
		}
		
	}
		
		


	@After
	public void tearDown() throws Exception {
	}

}
