package com.fluke.screens.rough;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase_FlukeWebInvite {
WebDriver driver;
WebDriverWait wait;
String URL = "https://connect.fluke.com/en/login";
String userName = "sudhakar@falconnecttech.com";
String passWord = "Fluke$2018";
String error = "";


	@BeforeClass
	public void Setup() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		PageFactory.initElements(driver, PageObjects.class);
	}	

	@Test(priority = 1)
	public void LoginFluke() throws InterruptedException {
	PageObjects.Login(driver, URL, userName , passWord);
	}
	
	@Test(dependsOnMethods = "LoginFluke", dataProvider="inviteList", dataProviderClass=InputData.class, enabled = false)
	public void Invite(String emailID) throws InterruptedException  {
	PageObjects.inviteTeam(driver, emailID);
	}
	
	@AfterClass
	public void closeDriver() throws InterruptedException {
	Thread.sleep(5000);
	PageObjects.SignOut(driver);
	driver.close();
	}
}
