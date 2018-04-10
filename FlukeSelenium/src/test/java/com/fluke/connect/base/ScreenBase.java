package com.fluke.connect.base;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ScreenBase {
	
	
	public static AppiumDriver<MobileElement> driver;
	public WebDriverWait wait;
	
	
	public void waitForElementPresent(long duration,String locator){
	
		
		wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
	}
	
	public ScreenBase(AppiumDriver<MobileElement> driver){
		
		ScreenBase.driver = driver;
		
	}
	
	
	public void hideKeyboard(){
		
		driver.hideKeyboard();
		
	}
	

}
