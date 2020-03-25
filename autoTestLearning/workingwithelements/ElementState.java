package workingwithelements;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementState {
	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://www.google.com";
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
		Thread.sleep(2000);
	}

	@Test
	public void test() {
		//WebElement e1 = driver.findElement(By.id("gs_htif0"));
		//System.out.println("E1 is Enabled? " + e1.isEnabled());
		//WebElement e2 = driver.findElement(By.id("gs_taif0"));
		//System.out.println("E2 is Enabled? " + e2.isEnabled());
		//WebElement e3 = driver.findElement(By.id("lst-ib"));
		//System.out.println("E3 is Enabled? " + e3.isEnabled());
		
		//code is out of date, only for example
		
		
		WebElement e4 = driver.findElement(By.name("q"));
		WebElement e5 = driver.findElement(By.name("btnK"));
		e4.sendKeys("letskodeit");
		e5.click();
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}