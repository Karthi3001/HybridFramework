package com.mindtree.pageObject;


import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.UIinstaGram;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class instaGram extends UIinstaGram {
	WebDriver driver;
	Logger log;
	ExtentTest test;


	public instaGram(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}

	public void inst() throws ReusableComponentException, Exception {
		try {
			WebDriverSupport.click(driver, instaClick , "insta is clicked", "insta is clicked", log, test);
			Set<String>ids=driver.getWindowHandles();
			Iterator<String> it=ids.iterator();
			String parentid=it.next();
			String childid=it.next();
			Thread.sleep(2000);
			driver.switchTo().window(childid);
			Thread.sleep(3000);
			 if (driver.findElement(instaTitle).isDisplayed()) {
					ExtentLogUtilities.pass(driver, test, "page displayed", log);
					driver.close();
					
				} else {
					ExtentLogUtilities.fail(driver, test, "page not displayed", log);
					throw new PageObjectException("verify failed");
				}
	            
	            driver.switchTo().window(parentid);
		}catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}
		
	}

	

