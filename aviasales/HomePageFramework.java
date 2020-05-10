package aviasales;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageFramework {
	public static WebElement element = null; 
	
//	Flight origin section
	
//	Returns the flight origin text box element
	
	public static WebElement originTextBox(WebDriver driver) {
		element = driver.findElement(By.id("origin"));
		return element;
		
	}
	
//	fill the flight origin text box element
	
	public static void fillOriginTextBox(WebDriver driver, String origin) {
		element = originTextBox(driver);
		element.clear();
		element.sendKeys(origin);	
	}
		
//	Flight destination section
	
//	Returns the flight origin text box element
	
	public static WebElement destinationTextBox(WebDriver driver) {
		element = driver.findElement(By.id("destination"));
		return element;
	}

//	fill the destination section text box element
	
	public static void fillDestinationTextBox(WebDriver driver, String origin) {
		element = destinationTextBox(driver);
		element.clear();
		element.sendKeys(origin);
		
	}
	
//	Date section
	
//	Start date text box
	
	public static WebElement startDate(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@placeholder='Туда'])"));
		return element;
	}
	
//	Fill start date text box
	
	public static void fillStartDate(WebDriver driver, String origin) {
		element = startDate(driver);
		element.clear();
		element.sendKeys(origin);
	}

//	Return date text box
	
	public static WebElement returnDate(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@placeholder='Обратно']"));
		return element;
	}
	
//	Fill return date text box
	
	public static void fillreturnDate(WebDriver driver, String origin) {
		element = returnDate(driver);
		element.clear();
		element.sendKeys(origin);
	}

//	Search button section 
	
//  Return the search button
	
	public static WebElement searchButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='of_main_form__submit-wrap --mobile-search']//button[@class='of_main_form__submit']"));
		return element;
	}
	
//	Click on search button
	
	public static void clickSearchButton(WebDriver driver) {
		element = searchButton(driver);
		element.clear();
		element.click();
	}
	
}