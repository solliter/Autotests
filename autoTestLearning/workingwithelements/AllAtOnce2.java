package workingwithelements;


import static org.junit.Assert.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import usefulmethods.GenericMethods;


public class AllAtOnce2 {
	private WebDriver driver;
	private String baseUrl;
	private GenericMethods gm;

	@Before
	public void setUp() throws Exception {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseUrl = "https://letskodeit.teachable.com/p/practice";
		driver.get(baseUrl);
		
	}
		
		
		@Test
		public void testGetText() throws Exception {
			driver.get(baseUrl);
			
			WebElement buttonElement = driver.findElement(By.xpath("//div[@id='radio-btn-example']//label[2]"));
			String elementText = buttonElement.getText();
			
			WebElement buttonElement2 = driver.findElement(By.id("carselect"));
			String elementText2 = buttonElement2.getText();
			
			List<WebElement> elementList = gm.getElementList("carselect", "id");
			
			int size = elementList.size();
			
			System.out.println("Size of the element list is: " + elementList);
			}
			
					
	
			
		

		@After
		public void tearDown() throws Exception {
			Thread.sleep(2000);
			driver.quit();
		}
	}
	