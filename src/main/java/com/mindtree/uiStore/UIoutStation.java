package com.mindtree.uiStore;

import org.openqa.selenium.By;

public class UIoutStation {
	
	public static By from = By.xpath("//input[@id='fromCityList']");
	public static By to = By.xpath("//input[@placeholder='Start typing city - e.g. Mysore']");
	public static By desti = By.xpath("//span[contains(text(),'Chennai Central, Chennai')]");
	public static By select = By.xpath("//button[contains(text(),'Select Car')]");
	public static By verify = By.xpath("//header/div[1]/div[2]/div[1]/div[1]");
	public static By home = By.xpath("//header/div[1]/div[1]/a[1]/img[1]");

}
