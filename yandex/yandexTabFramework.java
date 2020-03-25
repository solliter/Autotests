package yandex;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class yandexTabFramework {
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
		    System.out.println(driver.getCurrentUrl());
		    if (flag && flag2)   {
				System.out.println("Таб " + driver.getTitle() + " открыт и проверен, тест кейс №" + ++i);
					if(i == 7) {
						System.out.println("Все " + i + " тест кейсы пройдены");}
					else {
						System.out.println("Пройдены только "+ i + " кейсов");
				
	    		}
		    }
		}
	
		
	
//	

//	
	
//		for (String handle : driver.getWindowHandles()) {
//		    driver.switchTo().window(handle);
//		    System.out.println(driver.getCurrentUrl());
//		    if (driver.getCurrentUrl().contains(("yandex.ru/efir"))||driver.getCurrentUrl().contains(("music.yandex"))||driver.getCurrentUrl().contains(("translate.yandex"))
//		    		||driver.getCurrentUrl().contains(("market.yandex"))||driver.getCurrentUrl().contains(("yandex.ru/maps"))||driver.getCurrentUrl().contains(("yandex.ru/news"))
//		    		||driver.getCurrentUrl().contains(("yandex.ru/images"))) {
//		    	++i;
//		    	System.out.println("Пройден тест кейс "+ i);
//		 
//		    		if(i == 7) {
//		    			System.out.println("Все тест кейсы пройдены, проверены табы: Видео, Картинки, Новости, Карты, Маркет, Переводчик, Музыка, Эфир");
//		    	}
//		    }
//		    
//		}
		
//		for (String handle : driver.getWindowHandles()) {
//		    driver.switchTo().window(handle);
//		    System.out.println(driver.getCurrentUrl());
//		    if (driver.getCurrentUrl().contains(("yandex.ru/efir")) && driver.getTitle().contains("Яндекс.Эфир")) {
//				System.out.println("Таб " + driver.getTitle() + " открыт и проверен, тест кейс №" + ++i);
//		    }
//		    else if (driver.getCurrentUrl().contains(("music.yandex")) && driver.getTitle().contains("Яндекс.Музыка")) {
//		    	System.out.println("Таб " + driver.getTitle() + " открыт и проверен, тест кейс №"+ ++i);
//		    	}
//		    else if (driver.getCurrentUrl().contains(("translate.yandex")) && driver.getTitle().contains("Яндекс.Переводчик")) {
//		    	System.out.println("Таб " + driver.getTitle() + " открыт и проверен, тест кейс №"+ ++i);
//		    }  	
//		    else if (driver.getCurrentUrl().contains(("market.yandex")) && driver.getTitle().contains("Яндекс.Маркет")) {
//		    	System.out.println("Таб " + driver.getTitle() + " открыт и проверен, тест кейс №"+ ++i);
//		    	}
//		    else if (driver.getCurrentUrl().contains(("yandex.ru/maps")) && driver.getTitle().contains("Яндекс.Карты")) {
//		    	System.out.println("Таб " + driver.getTitle() + " открыт и проверен, тест кейс №"+ ++i);
//		    }
//		    else if (driver.getCurrentUrl().contains(("yandex.ru/news")) && driver.getTitle().contains("Яндекс.Новости")) {
//		    	System.out.println("Таб " + driver.getTitle() + " открыт и проверен, тест кейс №"+ ++i);}
//		    
//		    else if (driver.getCurrentUrl().contains(("yandex.ru/images")) && driver.getTitle().contains("Яндекс.Картинки")) {
//		    	System.out.println("Таб " + driver.getTitle() + " открыт и проверен, тест кейс №"+ ++i);
//		    }
//		    		if(i == 7) {
//		    			System.out.println("Все тест кейсы пройдены");
//		    		}
		
		    			
		    	
		

}
}

	
	
	
	


