package com.fluke.connect.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

@SuppressWarnings("unused")
public class AndroidSetup {
	static String appPkg = "com.fluke.deviceApp";
	static String appAct = "com.fluke.deviceApp.LoginActivity";
	static String device = "Galaxy Note3";
	static String Url = "http://127.0.0.1:4723/wd/hub";

	public static AndroidDriver<WebElement> startUp(AndroidDriver<WebElement> driver) throws MalformedURLException {
		DesiredCapabilities ds = new DesiredCapabilities();
		ds.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		ds.setCapability("appPackage", appPkg);
		ds.setCapability("appActivity", appAct);
		ds.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		driver = new AndroidDriver<WebElement>(new URL(Url), ds);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
}
