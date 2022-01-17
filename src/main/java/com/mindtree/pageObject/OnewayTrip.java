package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.UIoutStation;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class OnewayTrip extends UIoutStation {
	WebDriver driver;
	Logger log;
	ExtentTest test;

	public OnewayTrip(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	
	public void Outstation(String from1,String to1) throws ReusableComponentException, Exception {
		try {
			WebDriverSupport.click(driver, from, "from", "from", log, test);
			WebDriverSupport.sendKeys(driver, from, "from", "select city from", log, test, from1);
			WebDriverSupport.click(driver, to, "to", "to", log, test);
			WebDriverSupport.sendKeys(driver, to, "to", "select city to", log, test, to1);
			WebDriverSupport.click(driver, desti, "to", "place", log, test);
			WebDriverSupport.click(driver, select, "select", "selected", log, test);
			
			if (driver.findElement(verify).isDisplayed()) {
				ExtentLogUtilities.pass(driver, test, "verified", log);
				WebDriverSupport.click(driver, home, "home page", "home page", log, test);
				Thread.sleep(2000);
			} else {
				ExtentLogUtilities.fail(driver, test, "verification failed", log);
				throw new PageObjectException("verify failed");
			}
			
		}catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}
}
	

