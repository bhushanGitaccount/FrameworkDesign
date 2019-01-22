package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;

public class LoginPageObjects extends TestBase{

	
	public LoginPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;
	
	public String validateLoginPageTitile() {
		return driver.getTitle();
	}
	
	public HomePageObjects login(String un, String pw) throws Exception {
		
		//Enter username and password 
		username.sendKeys(un);
		password.sendKeys(pw);
		
		//wait till the login button gets clickable
//		WebDriverWait explicitWait= new WebDriverWait(driver, 20);
		Thread.sleep(2000);
//		explicitWait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
		loginButton.click();
		//This will call the constructor of HomePage and it will initialize all the properties of homePage
		return new HomePageObjects();
	}
}
