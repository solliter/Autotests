package yandex;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class yandexTabTestUnit {
	private WebDriver driver;
	private String baseUrl;
	yandexTabFramework yandexTab;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://yandex.ru/";
		
		yandexTab = new yandexTabFramework(driver);
		
//		Maximize the browser's window
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);			
	}


	@Test
	public void test() {
		yandexTab.clickVideoTab();
		yandexTab.clickImagesTab();
		yandexTab.clickNewsTab();
		yandexTab.clickMapsTab();
		yandexTab.clickMarketTab();
		yandexTab.clickTranslateTab();
		yandexTab.clickMusicTab();
		yandexTab.clickAirTab();
		yandexTab.tabTest();
		


	}
	
	@After
	public void tearDown() throws Exception {
	}

}
