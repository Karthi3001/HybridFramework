package com.mindtree.pageObject;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.UIccRental;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class CCRental extends UIccRental {

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public CCRental(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	public void CarRental(String nam,String comnam,String email,String phn)throws ReusableComponentException, Exception{
		try {
			WebDriverSupport.click(driver, carrental, "rental", "car rental", log, test);
			
			Set<String>ids=driver.getWindowHandles();
			Iterator<String> it=ids.iterator();
			String parentid=it.next();
			String childid=it.next();
			Thread.sleep(2000);
			driver.switchTo().window(childid);
			WebDriverSupport.click(driver, Name, "name", "clicked the name", log, test);
			WebDriverSupport.sendKeys(driver, Name, "name", "entered name", log, test,nam);
			WebDriverSupport.click(driver, companyName, "compname", "clicked company name", log, test);
			WebDriverSupport.sendKeys(driver, companyName, "compname", "entered company name", log, test,comnam);
			WebDriverSupport.click(driver, Email, "email", "clicked email", log, test);
			WebDriverSupport.sendKeys(driver, Email, "email", "entered email", log, test,email);
			WebDriverSupport.click(driver, phoneno, "phoneno", "clicked phone no", log, test);
			WebDriverSupport.sendKeys(driver, phoneno, "phoneno", "entered phone no", log, test,phn);
			Select bv=new Select(driver.findElement(businessvolume));
			bv.selectByValue("100000to500000");
			Thread.sleep(2000);
			WebDriverSupport.click(driver, submit, "submit", "cilcked submit", log, test);
			Thread.sleep(3000);
			
			
			 if (driver.findElement(Result).isDisplayed()) {
					ExtentLogUtilities.pass(driver, test, "result detail shown ", log);
					driver.close();
					
				} else {
					ExtentLogUtilities.fail(driver, test, " result detail not shown", log);
					throw new PageObjectException("verify failed");
				}
	            
	            driver.switchTo().window(parentid);
				WebDriverSupport.click(driver, home, "home page", "home page", log, test);

			
		}catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}
		
	}

