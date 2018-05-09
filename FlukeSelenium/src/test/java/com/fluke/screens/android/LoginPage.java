package com.fluke.screens.android;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.fluke.connect.base.ScreenBase;
import com.fluke.connect.utility.Configration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends ScreenBase {

	@AndroidFindBy(id = "com.fluke.deviceApp:id/dialog_ok")
	public WebElement dilogBox;

	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	public WebElement permission;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/login_name")
	public WebElement email;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/login_password")
	public WebElement password;

	@AndroidFindBy(id = "com.fluke.deviceApp:id/login_button")
	public WebElement signin;

	public LoginPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);

	}

	public void dilogBox() {

		dilogBox.click();

	}

	public void allowPermission() {

		permission.click();

	}

	public void emaIl() {

		email.sendKeys(Configration.email);

	}

	public void passwoRd() {

		password.sendKeys(Configration.password);

	}

	public void signIN() {

		signin.click();

	}

}
