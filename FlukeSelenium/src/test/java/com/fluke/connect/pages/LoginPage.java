package com.fluke.connect.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(id = "emailAddr")

	WebElement username;

	@FindBy(how = How.CSS, using = "input#password")
	WebElement password;

	@FindBy(how = How.XPATH, using = "//div//input[@value='Sign in']")

	WebElement submit;

	public void loginFluke(String uid, String pass) {

		username.sendKeys(uid);
		password.sendKeys(pass);
		submit.click();

	}

}
