package workingwithelements;



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





public class AllAttOnce {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseUrl = "https://letskodeit.teachable.com/p/practice";
		driver.get(baseUrl);

	}


	@Test
	public void test() throws Exception {
		boolean isChecked = false;
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[contains(@type,'radio') and contains(@name,'cars')]"));
		int size = radioButtons.size();
		
		WebElement element = driver.findElement(By.id("carselect"));
		Select sel = new Select(element);
		
		List<WebElement> checkButtons = driver.findElements(By.xpath("//input[contains(@type,'checkbox') and contains(@name,'cars')]"));
		
		
		for (int i=0; i<size; i++) {
			isChecked = radioButtons.get(i).isSelected();
			
			if (!isChecked)  {
				radioButtons.get(i).click();
				checkButtons.get(i).click();
				sel.selectByIndex(i);
				Thread.sleep(2000);
										
				
	}
	}
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
