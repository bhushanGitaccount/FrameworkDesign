package com.qa.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.qa.Helper.CaptureSreenshots;
import com.qa.Pages.HomePageObjects;
import com.qa.Pages.LoginPageObjects;
import com.qa.TestBase.TestBase;

public class LoginTests extends TestBase {

	LoginPageObjects loginpageobjects;
	HomePageObjects homepageobjects;

//	public LoginTests() {
//		super();
//
//	}

	@BeforeSuite
	public void initReports() {
		extent = setReports();
	}

	@BeforeMethod
	public void setUp() {
		initBrowser();
		loginpageobjects = new LoginPageObjects();

	}

	@Test()
	public void verifyLoginPageTitile() {
		String title = loginpageobjects.validateLoginPageTitile();
		test = extent.createTest("Verify Title of login page");
		
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}

	@Test()
	public void login() throws Exception {
		test = extent.createTest("Check login functionality with correct UN and PW");
		homepageobjects = loginpageobjects.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			String temppath = CaptureSreenshots.takeScreenShots(driver);
			test.fail(result.getTestName(), MediaEntityBuilder.createScreenCaptureFromPath(temppath).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass(result.getName() + ": Passed");
		}
		driver.close();
	}

	@AfterSuite
	public void tearReports() {
		extent.flush();
	}
}
