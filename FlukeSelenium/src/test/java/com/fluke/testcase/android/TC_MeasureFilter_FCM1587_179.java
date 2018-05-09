package com.fluke.testcase.android;

import java.net.MalformedURLException;

import org.junit.AfterClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fluke.connect.utility.AndroidSetup;
import com.fluke.connect.utility.AppiumServer;
import com.fluke.screens.android.Android_PageObjects;

import io.appium.java_client.android.AndroidDriver;

public class TC_MeasureFilter_FCM1587_179 {
	Android_PageObjects aPO;
	static AndroidDriver<WebElement> driver;
	String userName = "sudhakar@falconnecttech.com";
	String passWord = "Fluke$2018";
	String result;
	String appPkg = "com.fluke.deviceApp";
	String appAct = "com.fluke.deviceApp.LoginActivity";
	String Url = "http://127.0.0.1:4723/wd/hub";

	static AppiumServer aS;

	@SuppressWarnings("static-access")
	@BeforeClass
	public void startUp() throws MalformedURLException {
		aS.start();
		driver = AndroidSetup.startUp(driver);

	}

	@SuppressWarnings("static-access")
	@AfterClass
	public void close() {
		driver.quit();
		aS.stop();
	}

	@Test(priority = 0)
	public void Login() throws MalformedURLException, InterruptedException {
		aPO = new Android_PageObjects(driver);
		aPO.Login(userName, passWord);
	}

	@Test(priority = 1)
	public void measureFilterOps() {
		aPO.Measurements();
		aPO.MeasureFilter("Measurements");
		aPO.MeasureFilter("Thermal");
		aPO.MeasureFilter("ThreePhase");
	}

	@Test(priority = 2)
	public void SignOutMobile() {
		aPO.SignOut();
	}
}
