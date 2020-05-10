package aviasales;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageFactory {
	WebDriver driver;
	
	@FindBy(id = "origin")
	WebElement originCity;
	
	@FindBy(id = "destination")
	WebElement destinationCity;
	
	@FindBy(xpath = "//input[@div='trip-duration__input-wrapper --departure']")
	WebElement dateStart;
	
	@FindBy(xpath = "//input[@placeholder='Обратно']")
	WebElement dateReturn;
	
	@FindBy(xpath = "//div[@class='of_main_form__submit-wrap --mobile-search']//button[@class='of_main_form__submit']")
	WebElement searchButton;
	
	public SearchPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setOrigin(String origin) {
		originCity.clear();
		originCity.click();
		originCity.sendKeys(origin);
	}
	
	public void setDestination(String destination) {
		originCity.click();
		destinationCity.sendKeys(destination);
	}
	
	public void setdateStart() {
		dateStart.click();
		
	}
	
	public void setdateReturn() {
		dateReturn.click();
	}
	
	public void clicksearchButton() {
		searchButton.click();
	}

	}

