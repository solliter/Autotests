package BasicWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverWindows {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\kelir\\.eclipse\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String baseURL = "http://learn.letskodeit.com";
		driver.get(baseURL);

	}
}