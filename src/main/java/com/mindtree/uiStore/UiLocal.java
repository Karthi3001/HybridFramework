package com.mindtree.uiStore;

import org.openqa.selenium.By;

public class UiLocal {
	
	public static By local = By.xpath("//span[contains(text(),'Local')]");
	public static By select = By.xpath("//button[contains(text(),'Select Car')]");
	public static By selectcar= By.xpath("//button[contains(text(),'Select')]");
	public static By bookingdetail = By.xpath("//div[@class='card ng-star-inserted']");
	public static By home = By.xpath("//header/div[1]/div[1]/a[1]/img[1]");
}
