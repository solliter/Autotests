package utilities;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MailLinkFramework {
	WebDriver driver;
	
	
	//link Factory
	
	@FindBy(id="signup")
	WebElement mailRegistrationLink;
	
	@FindBy(xpath = "//input[@id='fname']")
	WebElement firstNameLink;
	
	@FindBy(xpath = "//input[@id='lname']")
	WebElement lastNameLink;
	
	@FindBy(xpath = "//span[contains(text(), '����' )]")
	WebElement dateDayLink;
	
	@FindBy(xpath = "//span[contains(text(), '�����' )]")
	WebElement dateMonthLink;
	
	@FindBy(xpath = "//span[contains(text(), '���' )]")
	WebElement dateYearLink;
	
	@FindBy(xpath = "//*[@data-test-id='gender-male']")
	WebElement manRadioLink;
	
	@FindBy(xpath = "//*[@data-test-id='gender-female']")
	WebElement womanRadioLink;
	
	@FindBy(xpath = "//input[@id='aaa__input']")
	WebElement mailNameLink;
	
	@FindBy(xpath = "//input[@id='passwordField']")
	WebElement mailPasswordLink;
	
	@FindBy(xpath = "//input[@id='repeatPasswordField']")
	WebElement mailPassword2Link;
	
	@FindBy(xpath = "//input[@id='phone-number__phone-input']")
	WebElement mailPhoneLink;
	
	@FindBy(xpath = "//span[contains(text(), '������������������')]  ")
	WebElement mailSubmitLink;
	
	public MailLinkFramework(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Click/send keys Factory
	
	public void clickMailRegistration() {
		mailRegistrationLink.click();
	}
	
	public void fillFirstName(String firstName) {
		firstNameLink.sendKeys(firstName);
	}
	
	public void fillLastName(String lastName) {
		lastNameLink.sendKeys(lastName);
	}
	
	public void fillDateDay() {
		dateDayLink.click();
//		dateDayLink.sendKeys(UserDateDay);
	}
	
	public void fillDateMonth() {
		dateMonthLink.click();
//		sendKeys(UserDateMont);
	}
	
	public void fillDateYear() {
		dateYearLink.click();
//		dateYearLink.sendKeys(UserDateYear);
	}
	
	
	public void clickManRadio() {
		manRadioLink.click();
	}
	
	public void clickWomanRadio() {
		womanRadioLink.click();
	}
	
	public void fillMailName(String mailName) {
		mailNameLink.sendKeys(mailName);
	}
	
	public void fillMailPassword(String mailPassword) {
		mailPasswordLink.sendKeys(mailPassword);
	}
	
	public void fillMailPassword2(String repeatMailPassword) {
		mailPassword2Link.sendKeys(repeatMailPassword);
	}
	
	public void fillMailPhone(String mailPhone) {
		mailPhoneLink.sendKeys(mailPhone);;
	}
	
	public void clickMailSubmit() {
		mailSubmitLink.click();
	}
	
	public void dateMail(String dateBirth) {

		WebDriverWait wait = new WebDriverWait(driver, 3);
		
		String[] parts = dateBirth.split("/");
		int month = Integer.parseInt(parts[0]);
		int day = Integer.parseInt(parts[1]);
		int year = Integer.parseInt(parts[2]);
		
		fillDateDay();
		WebElement dayMail = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@data-test-id='select-value:" + day + "']"))));
		dayMail.click();
		

		fillDateMonth();
		WebElement mounthMail = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@data-test-id='select-value:" + month + "']"))));
		mounthMail.click();


		fillDateYear();
		WebElement yearMail = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@data-test-id='select-value:20" + year + "']"))));
		yearMail.click();
		

	}

	public void mailCountErrorsPositive() {
		List<WebElement> errors = driver.findElements(By.xpath("//*[@data-test-id='error-footer-text']"));
		Integer i = 0;
		for(WebElement error: errors) {
			++i;
			if ( i > 0) {
				System.out.println("������, " + error.getText());
			}
			}
	}
	
	public void mailCountErrorsNegative() {
		List<WebElement> errors = driver.findElements(By.xpath("//*[@data-test-id='error-footer-text']"));
		Integer i = 0;
		for(WebElement error: errors) {
			++i;
			if ( i > 1) {
				System.out.println("������, " + error.getText());
			}
			}
	}
	
	public void genderMailChooser (String gender) {
		if(gender.equals("men")) {
			clickManRadio();
		} else if (gender.equals("woman")) {
			clickWomanRadio();
		}
	}
}
