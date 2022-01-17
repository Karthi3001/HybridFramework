package com.mindtree.uiStore;

import org.openqa.selenium.By;

public class UiAirport {

	   public static By airport = By.xpath("//span[contains(text(),'Airport')]");
	   public static By trip = By.xpath("//select[@formcontrolname='frmLocalSubTripType']");
	   public static By addresstype = By.xpath("//body/app-root[@id='approot']/mat-sidenav-container[1]/mat-sidenav-content[1]/app-home[1]/div[1]/app-home-container[1]/div[1]/div[1]/div[2]/app-local[1]/div[1]/form[1]/div[3]/div[1]/div[1]/ng4geo-autocomplete[1]/div[1]/ul[1]/li[1]/a[1]");
	   public static By address = By.xpath("//input[@id='search_places']");
	   public static By select = By.xpath("//button[contains(text(),'Select Car')]");
		public static By selectcar= By.xpath("//button[contains(text(),'Select')]");
		public static By bookingdetail = By.xpath("//div[@class='card ng-star-inserted']");
		public static By home = By.xpath("//header/div[1]/div[1]/a[1]/img[1]");
}
