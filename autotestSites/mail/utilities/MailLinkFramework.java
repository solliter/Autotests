package utilities;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MailLinkFramework {
	WebDriver driver;
	private static final Logger log = LogManager.getLogger(MailLinkFramework.class.getName());
	
	//link Factory
	
	@FindBy(id="signup")
	WebElement mailRegistrationLink;
	
	@FindBy(xpath = "//input[@id='fname']")
	WebElement firstNameLink;
	
	@FindBy(xpath = "//input[@id='lname']")
	WebElement lastNameLink;
	
	@FindBy(xpath = "//span[contains(text(), 'День' )]")
	WebElement dateDayLink;
	
	@FindBy(xpath = "//span[contains(text(), 'Месяц' )]")
	WebElement dateMonthLink;
	
	@FindBy(xpath = "//span[contains(text(), 'Год' )]")
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
	
	@FindBy(xpath = "//span[contains(text(), 'Зарегистрироваться')]  ")
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
		log.info("Filling first name");
	}
	
	public void fillLastName(String lastName) {
		lastNameLink.sendKeys(lastName);
		log.info("Filling last name");
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
		log.info("Filling mail name");
	}
	
	public void fillMailPassword(String mailPassword) {
		mailPasswordLink.sendKeys(mailPassword);
		log.info("Filling mail password");
	}
	
	public void fillMailPassword2(String repeatMailPassword) {
		mailPassword2Link.sendKeys(repeatMailPassword);
		log.info("Reapeat mail password");
	}
	
	public void fillMailPhone(String mailPhone) {
		mailPhoneLink.sendKeys(mailPhone);;
		log.info("Filling mail phone number");
	}
	
	public void clickMailSubmit() {
		mailSubmitLink.click();
		log.info("Submit test");
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
		log.info("Filling date birth");
		

	}

	public void mailCountErrorsPositive() {
		List<WebElement> errors = driver.findElements(By.xpath("//*[@data-test-id='error-footer-text']"));
		Integer i = 0;
		for(WebElement error: errors) {
			++i;
			if ( i > 0) {
				log.warn("Ошибка, " + error.getText());
			}
			}
	}
	
	public void mailCountErrorsNegative() {
		List<WebElement> errors = driver.findElements(By.xpath("//*[@data-test-id='error-footer-text']"));
		Integer i = 0;
		for(WebElement error: errors) {
			++i;
			if ( i > 1) {
				log.warn("Ошибка, " + error.getText());
			}
			}
	}
	
	public void genderMailChooser (String gender) {
		if(gender.equals("men")) {
			clickManRadio();
		} else if (gender.equals("woman")) {
			clickWomanRadio();
		}
		log.info("Choosing gender");
	}
}
