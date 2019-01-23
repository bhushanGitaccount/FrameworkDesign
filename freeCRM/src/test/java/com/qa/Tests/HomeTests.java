package com.qa.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.MediaEntityBuilder;
import com.qa.Helper.CaptureSreenshots;
import com.qa.Pages.HomePageObjects;
import com.qa.Pages.LoginPageObjects;
import com.qa.TestBase.TestBase;

public class HomeTests extends TestBase {

	LoginPageObjects login;
	HomePageObjects hpo;

	public HomeTests() {
		super();
	}

	@BeforeSuite
	public void initReports() {
		extent = setReports();
	}

	@BeforeMethod
	public void setUp(String browser) throws Exception {
		//initBrowser(browser);
		login = new LoginPageObjects();
		hpo = login.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void verifyUsernameAfterLogin() {
		test = extent.createTest("Verify Username from home page after user logs in");
		driver.switchTo().frame("mainpanel");
		String usernameafterlogin = hpo.validateUsername();
		Assert.assertEquals(usernameafterlogin, "  User:Test QA",
				"AssertFailed because username after login does not match.");

	}

	@Test
	public void verifyHomePageTitle() {
		test = extent.createTest("Verify Home page Title after uesr logs in");
		driver.switchTo().frame("mainpanel");
		String homepagetitle = hpo.validateHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO", "AssertFailed because homepage title does not match.");
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {

			String temppath = CaptureSreenshots.takeScreenShots(driver);
			test.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(temppath).build());
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
