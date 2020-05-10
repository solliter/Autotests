package aviasales;

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


public class homePageTestUnit {
	private WebDriver driver;
	private String baseUrl;
	SearchPageFactory searchPage;
	

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://www.skyscanner.ru/";
		
		searchPage = new SearchPageFactory(driver);
				
//		Maximize the browser's window
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
		
	}


	@Test
	public void test() throws Exception {

		String textToSelect = "�������";
		searchPage.setOrigin("�����");	
		
		List<WebElement> dropDown = driver.findElements(By.xpath("//div[@class = 'autocomplete__dropdown']//*"));
		
		for(WebElement option : dropDown){
		    System.out.println(option);
		    if(option.getText().contains(textToSelect)) {
		        System.out.println("Trying to select: "+textToSelect);
		        option.click();
		        break;
		    }
		}
		

	}

	
	@After
	public void tearDown() throws Exception {
	}

}
