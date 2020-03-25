package BasicWeb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise {

	public static void main(String[] args) throws InterruptedException {
		String baseURL = "https://dhtmlx.com/docs/products/dhtmlxGrid/";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
		driver.findElement(By.xpath("//div[contains(text(),'Jose Morales')]//parent::div//following-sibling::div[2]/div[@class='dhx_cell-content']")).click();
		 //make sure name unique, find //input[@id='search:submit']
		
		
	}
	
}
