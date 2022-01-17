package com.mindtree.pageObject;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.UIappDownload;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class ApplicationDownload extends UIappDownload {
	WebDriver driver;
	Logger log;
	ExtentTest test;

	public ApplicationDownload(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	public void App()throws ReusableComponentException, Exception{
		try {
			WebDriverSupport.click(driver, app, "playstore", "playstore", log, test);
			
			Set<String>ids=driver.getWindowHandles();
			Iterator<String> it=ids.iterator();
			String parentid=it.next();
			String childid=it.next();
			Thread.sleep(2000);
			driver.switchTo().window(childid);
			Thread.sleep(2000);
			
            if (driver.findElement(playstore).isDisplayed()) {
				ExtentLogUtilities.pass(driver, test, "went to download page", log);
				driver.close();
				
			} else {
				ExtentLogUtilities.fail(driver, test, "download page error", log);
				throw new PageObjectException("verify failed");
			}
            
            driver.switchTo().window(parentid);
			WebDriverSupport.click(driver, home, "home page", "back to homepage", log, test);

			
		}catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}
}
	
