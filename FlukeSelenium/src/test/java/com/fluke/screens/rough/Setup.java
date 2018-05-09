package com.fluke.screens.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Setup {
static WebDriver driver;
public static WebDriver StartUp(String driverName, int impWaitTime) {
		if(driverName.equalsIgnoreCase("chrome")){
		driver = new ChromeDriver();
		} else if (driverName.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();			
		} else if (driverName.equalsIgnoreCase("ie")) {
		driver = new InternetExplorerDriver();	
		}
		else if (driverName.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(impWaitTime, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}
