package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;

public class HomePageObjects extends TestBase {

	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tr/td[@align=\"left\" and @class=\"headertext\"]")
	WebElement usernameafterlogin;

	@FindBy(xpath = "//td[@class='logo_text']")
	WebElement crmpro_title;

	public String validateUsername() {
		return usernameafterlogin.getText();
	}

	public String validateHomePageTitle() {
		return crmpro_title.getText();
	}
}
