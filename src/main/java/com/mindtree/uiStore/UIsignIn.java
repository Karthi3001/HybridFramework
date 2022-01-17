package com.mindtree.uiStore;

import org.openqa.selenium.By;

public class UIsignIn {

	
	public static By button= By.xpath("//span[contains(text(),'Sign In')]");
	public static By id= By.xpath("//body/app-root[@id='approot']/app-navbar[1]/div[2]/div[1]/div[2]/form[1]/input[1]");
	public static By pwd= By.xpath("//body/app-root[@id='approot']/app-navbar[1]/div[2]/div[1]/div[2]/form[1]/input[2]");
	public static By login= By.xpath("//span[contains(text(),'Login')]");
	public static By name= By.xpath("//span[contains(text(),'Hi, Karthik')]");
		
}

