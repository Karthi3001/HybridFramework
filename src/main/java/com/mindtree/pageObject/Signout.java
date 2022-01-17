package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.UIsignOut;
import com.relevantcodes.extentreports.ExtentTest;

public class Signout extends UIsignOut{

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public Signout(WebDriver driver, Logger log, ExtentTest test) throws Exception {
	
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
		this.log = log;
	
	}

	public void signout() throws ReusableComponentException,Exception{
		
		try {
			WebDriverSupport.click(driver,icon, "clickbutton","clickbutton", log, test);
			WebDriverSupport.click(driver,outclick, "done","done", log, test);
			
		} catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}

}

