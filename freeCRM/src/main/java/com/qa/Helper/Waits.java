package com.qa.Helper;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.TestBase.TestBase;

public class Waits extends TestBase{
	static long explicitWaitTimeout = Long.parseLong(prop.getProperty("EXPLICIT_WAIT_TIMEOUT"));
	public static WebDriverWait explicitWait = new WebDriverWait(driver, explicitWaitTimeout);

}
