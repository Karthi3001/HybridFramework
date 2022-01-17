package com.mindtree.runner;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.mindtree.pageObject.*;
import com.mindtree.exceptions.*;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.GetProperties;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class MainRunner extends Base {
	static Logger log;
	static ExtentTest test;
	static ExtentReports report;

	public MainRunner() throws UtilityException, Exception {
		super();
	}

	@BeforeTest()
	public void initializeDriver() throws ApplicationException {
		try {
			report = new ExtentReports(System.getProperty("user.dir") + "\\reports\\" + "ExtentReportResults-"
					+ System.currentTimeMillis() + "-.html");
			log = Logger.getLogger(MainRunner.class.getName());
			driver = initialize();
			test = report.startTest("Home Page");
			driver.get(GetProperties.get.getProperty("url"));
			driver.manage().window().maximize();
			ExtentLogUtilities.pass(driver, test, "URL Opened", log);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	@Test(priority = 1, dataProvider = "getTitle")
	public void validateTitle(String title) throws ApplicationException {
		test = report.startTest("Validate Title");
		try {
			new Validation(driver, log, test).validate(title);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}

	@DataProvider
	public Object[] getTitle() {
		Object data[] = new Object[1];
		data[0] = get.getProperty("title");
		return data;
	}
	@Test(priority = 2, dataProvider = "signin")
	public void signin(String uid,String pw) throws ApplicationException {
		test = report.startTest("sign in");
		try {
			new Signin(driver, log, test).Button(uid, pw);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}

	@DataProvider
	public Object[] signin() {
		Object data[][] = new Object[1][2];
		data[0][0] = excelData.get("id");
		data[0][1] = excelData.get("pwd");
		return data;
	}
	@Test(priority = 3)
	public void app() throws ApplicationException {
		test = report.startTest("app");
		try {
			new ApplicationDownload(driver, log, test).App();
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@Test(priority = 4, dataProvider = "getData1")
	public void outStation(String from1, String to1) throws ApplicationException {
		test = report.startTest("outStation");
		try {
			new OnewayTrip(driver, log, test).Outstation(from1, to1);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}

	@DataProvider
	public Object[] getData1() {
		Object data[][] = new Object[1][2];
		data[0][0] = excelData.get("from1");
		data[0][1] = excelData.get("to1");
		return data;
	}

	@Test(priority = 5, dataProvider = "getData2")
	public void Airport(String Add) throws ApplicationException {
		test = report.startTest("Airport");
		try {
			new Airportbooking(driver, log, test).Airport(Add);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}

	@DataProvider
	public Object[] getData2() {
		Object val[][] = new Object[1][1];
		val[0][0] = excelData.get("Add");
		return val;
	}
	@Test(priority = 6)
	public void trip() throws ApplicationException {
		test = report.startTest("roundTrip");
		try {
			new Roundtrip(driver, log, test).roundTrip();
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@Test(priority = 7)
	public void Local() throws ApplicationException {
		test = report.startTest("local");
		try {
			new LocalBooking(driver, log, test).Local();
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
}
	@Test(priority = 8, dataProvider = "getData3")
	public void CarRental(String nam,String comnam,String email,String phn) throws ApplicationException {
		test = report.startTest("Car Rental");
		try {
			new CCRental(driver, log, test).CarRental(nam,comnam,email,phn);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}

	@DataProvider
	public Object[] getData3() {
		Object val[][] = new Object[1][4];
		val[0][0] = excelData.get("nam");
		val[0][1] = excelData.get("comnam");
		val[0][2] = excelData.get("email");
		val[0][3] = excelData.get("phn");
		return val;
	}
	
	@Test(priority = 10)
	public void instgram() throws ApplicationException {
		test = report.startTest("instaagram");
		try {
			new instaGram(driver, log, test).inst();
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@Test(priority = 9)
	public void signOuts() throws ApplicationException {
		test = report.startTest("logout");
		try {
			new Signout(driver, log, test).signout();
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	
	@AfterTest
	public void closeInstance() {
		driver.quit();
	}



}
