package com.qa.TestBase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestBase {

	public WebDriver driver;
	public static Properties prop;
	protected static ExtentHtmlReporter htmlreporter;
	protected static ExtentReports extent;
	protected static ExtentTest test;

	public TestBase() {

		try {
			prop = new Properties();
//			FileInputStream fis = new FileInputStream(".\\Config\\config.properties");
//			prop.load(fis);
//			System.out.println("Test(s) running in : " + prop.getProperty("browserName"));
		} catch (Exception e) {
			System.out.println("===== Exception caught ===== " + e.getMessage());
		}

	}

	@Parameters({ "browser" })
	@BeforeTest
	public void initBrowser(String browser) {
		System.out.println("inside TestBase/initbrowser ");

		// fetching browsername from property file
		// String browser = prop.getProperty("browserName");

		// initialize driver based on value in property file
		if (browser.toLowerCase().contains("chr")) {
			System.setProperty("webdriver.chrome.driver", ".\\Resources\\WinDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.toLowerCase().contains("fire")) {
			System.setProperty("webdriver.gecko.driver", ".\\Resources\\WinDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		// Fetching Wait properties
		// long pageloadTimeout = Long.parseLong(prop.getProperty("PAGE_LOAD_TIMEOUT"));
		// long implicitWaitTimeout =
		// Long.parseLong(prop.getProperty("IMPLICIT_WAIT_TIMEOUT"));

		// managing driver window and timeouts
		driver.manage().window().maximize();
		// driver.manage().timeouts().pageLoadTimeout(pageloadTimeout,
		// TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(implicitWaitTimeout,
		// TimeUnit.SECONDS);
		// driver.get(prop.getProperty("AppURL"));
		System.out.println(browser);
		driver.get("https://www.freecrm.com");

	}

	public ExtentReports setReports() {

		htmlreporter = new ExtentHtmlReporter("./test-output/Extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		return extent;
	}

}
