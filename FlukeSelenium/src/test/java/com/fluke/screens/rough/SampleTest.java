package com.fluke.screens.rough;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

@SuppressWarnings("unused")
public class SampleTest {
	
	public static AndroidDriver<AndroidElement> driver;
	static String node ="C:\\Program Files\\nodejs\\node.exe";
	static String appiumMain="C:\\Users\\DELL\\AppData\\Local\\Programs\\appium-desktop\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
	static AppiumDriverLocalService services;
	static SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	static String LogFile="C:\\Users\\DELL\\eclipse-workspace\\AutomationFramework\\Appium.log";
	@BeforeTest
	public void startService()
	{
		services=AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File(node))
				.withAppiumJS(new File(appiumMain)).withIPAddress("127.0.0.1")
				.usingPort(4723)
				.withLogFile(new File(LogFile)));
		services.start();
	}
	@Test
	public void test() throws MalformedURLException {
		DesiredCapabilities  cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
		cap.setCapability("appPackage", "com.fluke.deviceApp");
		cap.setCapability("appActivity", "com.fluke.deviceApp.LoginActivity");
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(20l, TimeUnit.SECONDS);
		
		driver.findElement(By.id("com.fluke.deviceApp:id/login_name")).clear();
		driver.findElement(By.id("com.fluke.deviceApp:id/login_name")).sendKeys("sudhakar@falconnecttech.com");
		driver.findElement(By.id("com.fluke.deviceApp:id/login_password")).clear();
		driver.findElement(By.id("com.fluke.deviceApp:id/login_name")).sendKeys("Fluke$2018");
		driver.findElement(By.id("com.fluke.deviceApp:id/login_button")).click();

	}
	@AfterTest
	public void stopService() throws MalformedURLException {
		services.stop();
	}

}
