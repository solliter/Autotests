package BasicWeb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstXPATHUsingMail {

	public static void main(String[] args) throws InterruptedException {
		String baseURL = "https://mail.ru/";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
		driver.findElement(By.name("login")).sendKeys("keliran");
	   //make sure name unique, find //*[@name='q']	
		driver.findElement(By.xpath("//input[@class='o-control']")).click();
		 //make sure name unique, find //input[@id='search:submit']
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("password")).sendKeys("пароль");
		   //make sure name unique, find //*[@name='q']	
		driver.findElement(By.xpath("//input[@class='o-control']")).click();
		 //make sure name unique, find //input[@id='search:submit']
		
	}
	
}
