package com.mindtree.uiStore;

import org.openqa.selenium.By;

public class UIccRental {
	
	public static By carrental = By.xpath("//a[contains(text(),'Corporate Car Rental')]");
	public static By Name = By.xpath("//input[@formcontrolname='corpRegNameControl']");
	public static By companyName = By.xpath("//input[@formcontrolname='corpRegCompanyControl']");
	public static By Email = By.xpath("//input[@formcontrolname='corpRegEmailControl']");
	public static By phoneno = By.xpath("//input[@formcontrolname='corpRegPhoneControl']");
	public static By businessvolume = By.xpath("//select[@formcontrolname='corpRegmonthlyRentalRequirementControl']");
	public static By submit = By.xpath("//span[contains(text(),'Submit')]");
	public static By Result = By.xpath("//div[contains(text(),'Thank You for Enquiring with us! Our Representativ')]");
	public static By home = By.xpath("//header/div[1]/div[1]/a[1]/img[1]");

}
