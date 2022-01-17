package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.UiAirport;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class Airportbooking extends UiAirport {
	WebDriver driver;
	Logger log;
	ExtentTest test;

	public Airportbooking(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	public void Airport(String Add) throws ReusableComponentException, Exception {
		try {
			WebDriverSupport.click(driver, airport , "airport", "airport", log, test);
			Select tb=new Select(driver.findElement(trip));
			tb.selectByValue("pick_airport");
			WebDriverSupport.click(driver, address, "address", "select city box", log, test);
			WebDriverSupport.sendKeys(driver, address, "address", "city selected", log, test, Add);
			WebDriverSupport.click(driver, addresstype, "address", "select pickup address", log, test);
			WebDriverSupport.click(driver, select, "select", "selected", log, test);
			Thread.sleep(2000);
			WebDriverSupport.click(driver, selectcar, "select", "select car", log, test);
			
			if (driver.findElement(bookingdetail).isDisplayed()) {
				ExtentLogUtilities.pass(driver, test, "booking detail displayed ", log);
				WebDriverSupport.click(driver, home, "home page", "home page", log, test);
			} else {
				ExtentLogUtilities.fail(driver, test, " booking detail is not displayed", log);
				throw new PageObjectException("verify failed");
			}
			
		}catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}
	
		
	
}


