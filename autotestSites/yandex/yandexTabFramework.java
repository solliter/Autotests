package yandex;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class yandexTabFramework {
	private static final Logger log = LogManager.getLogger(yandexTabFramework.class.getName());
	
	WebDriver driver;

// Search factory
	
	@FindBy(xpath = "//a[contains(text(), 'Видео')]")
	WebElement videoTab;

	@FindBy(xpath = "//a[contains(text(), 'Картинки')]")
	WebElement imagesTab;
	
	@FindBy(xpath = "//a[contains(text(), 'Новости')]")
	WebElement newsTab;
	
	@FindBy(xpath = "//a[contains(text(), 'Карты')]")
	WebElement mapsTab;
	
	@FindBy(xpath = "//a[contains(text(), 'Маркет')]")
	WebElement marketTab;
	
	@FindBy(xpath = "//a[contains(text(), 'Переводчик')]")
	WebElement translateTab;
	
	@FindBy(xpath = "//a[contains(text(), 'Музыка')]")
	WebElement musicTab;
	
	@FindBy(xpath = "//a[contains(text(), 'Эфир')]")
	WebElement airTab;
	
	public yandexTabFramework(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
// Click factory
	public void clickVideoTab() {
		videoTab.click();
	}
	
	public void clickImagesTab() {
		imagesTab.click();
	}
	
	public void clickNewsTab() {
		newsTab.click();
	}
	
	public void clickMapsTab() {
		mapsTab.click();
	}
	
	public void clickMarketTab() {
		marketTab.click();
	}
	
	public void clickTranslateTab() {
		translateTab.click();
	}
	
	public void clickMusicTab() {
		musicTab.click();
	}
	
	public void clickAirTab() {
		airTab.click();
	}
	
//	Testing that tabs is open 
	
	public void tabTest() {
		
		Map<String, String> hashmap = new HashMap<String, String>();
		hashmap.put("https://yandex.ru/portal/video", "Фильмы");
		hashmap.put("yandex.ru/efir", "Яндекс.Эфир");
		hashmap.put("music.yandex", "Яндекс.Музыка");
		hashmap.put("translate.yandex", "Яндекс.Переводчик");
		hashmap.put("market.yandex", "Яндекс.Маркет");
		hashmap.put("yandex.ru/maps", "Яндекс.Карты");
		hashmap.put("yandex.ru/news", "Яндекс.Новости");
		hashmap.put("yandex.ru/images", "Яндекс.Картинки");
		boolean flag;
		boolean flag2;
		int	i = 0;
		for (String handle : driver.getWindowHandles()) {
			flag = false;	
			flag2 = false;
			driver.switchTo().window(handle);
			 for (String str: hashmap.keySet()) {
	               if (driver.getCurrentUrl().contains(str)) {
	                      flag = true;}}
			 for (String str: hashmap.values()) {
	               if (driver.getTitle().contains(str)) {
	                      flag2 = true;}}
			log.info("Открыт " + driver.getCurrentUrl());
		    if (flag && flag2)   {
		    	log.info("Таб " + driver.getTitle() + " открыт и проверен, тест кейс №" + ++i);
	    		}
		    }
			if(i == 8) {
				log.info("Все " + i + " тест кейсы пройдены");
}
			else {
				log.error("Пройдены только "+ i + " кейсов");
		}
}
	
}

	
	
	
	


