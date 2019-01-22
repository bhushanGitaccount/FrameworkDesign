package com.qa.Helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.TestBase.TestBase;

public class CaptureSreenshots extends TestBase {

	public static String takeScreenShots(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir")
				+ "/SS/"
				+ System.currentTimeMillis()+".jpg";
		File destination = new File(path);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}
		return path;
	}
}
