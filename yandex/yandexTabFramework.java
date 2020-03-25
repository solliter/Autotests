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
	
	@FindBy(xpath = "//a[contains(text(), '�����')]")
	WebElement videoTab;

	@FindBy(xpath = "//a[contains(text(), '��������')]")
	WebElement imagesTab;
	
	@FindBy(xpath = "//a[contains(text(), '�������')]")
	WebElement newsTab;
	
	@FindBy(xpath = "//a[contains(text(), '�����')]")
	WebElement mapsTab;
	
	@FindBy(xpath = "//a[contains(text(), '������')]")
	WebElement marketTab;
	
	@FindBy(xpath = "//a[contains(text(), '����������')]")
	WebElement translateTab;
	
	@FindBy(xpath = "//a[contains(text(), '������')]")
	WebElement musicTab;
	
	@FindBy(xpath = "//a[contains(text(), '����')]")
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
		hashmap.put("yandex.ru/efir", "������.����");
		hashmap.put("music.yandex", "������.������");
		hashmap.put("translate.yandex", "������.����������");
		hashmap.put("market.yandex", "������.������");
		hashmap.put("yandex.ru/maps", "������.�����");
		hashmap.put("yandex.ru/news", "������.�������");
		hashmap.put("yandex.ru/images", "������.��������");
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
				System.out.println("��� " + driver.getTitle() + " ������ � ��������, ���� ���� �" + ++i);
					if(i == 7) {
						System.out.println("��� " + i + " ���� ����� ��������");}
					else {
						System.out.println("�������� ������ "+ i + " ������");
				
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
//		    	System.out.println("������� ���� ���� "+ i);
//		 
//		    		if(i == 7) {
//		    			System.out.println("��� ���� ����� ��������, ��������� ����: �����, ��������, �������, �����, ������, ����������, ������, ����");
//		    	}
//		    }
//		    
//		}
		
//		for (String handle : driver.getWindowHandles()) {
//		    driver.switchTo().window(handle);
//		    System.out.println(driver.getCurrentUrl());
//		    if (driver.getCurrentUrl().contains(("yandex.ru/efir")) && driver.getTitle().contains("������.����")) {
//				System.out.println("��� " + driver.getTitle() + " ������ � ��������, ���� ���� �" + ++i);
//		    }
//		    else if (driver.getCurrentUrl().contains(("music.yandex")) && driver.getTitle().contains("������.������")) {
//		    	System.out.println("��� " + driver.getTitle() + " ������ � ��������, ���� ���� �"+ ++i);
//		    	}
//		    else if (driver.getCurrentUrl().contains(("translate.yandex")) && driver.getTitle().contains("������.����������")) {
//		    	System.out.println("��� " + driver.getTitle() + " ������ � ��������, ���� ���� �"+ ++i);
//		    }  	
//		    else if (driver.getCurrentUrl().contains(("market.yandex")) && driver.getTitle().contains("������.������")) {
//		    	System.out.println("��� " + driver.getTitle() + " ������ � ��������, ���� ���� �"+ ++i);
//		    	}
//		    else if (driver.getCurrentUrl().contains(("yandex.ru/maps")) && driver.getTitle().contains("������.�����")) {
//		    	System.out.println("��� " + driver.getTitle() + " ������ � ��������, ���� ���� �"+ ++i);
//		    }
//		    else if (driver.getCurrentUrl().contains(("yandex.ru/news")) && driver.getTitle().contains("������.�������")) {
//		    	System.out.println("��� " + driver.getTitle() + " ������ � ��������, ���� ���� �"+ ++i);}
//		    
//		    else if (driver.getCurrentUrl().contains(("yandex.ru/images")) && driver.getTitle().contains("������.��������")) {
//		    	System.out.println("��� " + driver.getTitle() + " ������ � ��������, ���� ���� �"+ ++i);
//		    }
//		    		if(i == 7) {
//		    			System.out.println("��� ���� ����� ��������");
//		    		}
		
		    			
		    	
		

}
}

	
	
	
	


