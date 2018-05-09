package com.fluke.connect.winium_sikuli.testcases;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.sikuli.script.Screen;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fluke.connect.base.SeleniumTestBase;
import com.fluke.connect.winium_sikuli.Screenshort;
import com.fluke.connect.winium_sikuli.Wdriver;
import com.fluke.connect.winium_sikuli.WiniumMethods;
import com.fluke.connect.winium_sikuli.sikulli;
import com.relevantcodes.extentreports.LogStatus;


/*
 *  Making login
 *  Go to  tools tab check that we are in tools page or not.
 *  Go to  Measurements tab check that we are in measurement page or not.
 *   Go to  Assert tab check that we are in Assert page or not.
 *   Go to  Report tab check that we are in Report page or not.
 *   Go to  logout tab check that we are in logout page or not.
 * 
 */

@SuppressWarnings("unused")
public class TestByWinium {

	public static WiniumDriver driver;
	sikulli sik;
	Screenshort screenshort;
	WiniumMethods winium;

	@Test
	public void applicationLaunch() {
		try {
			Wdriver.launchApplication();
			Thread.sleep(5000);
			driver = Wdriver.winiumgetdriver();
			sik = new sikulli();
			screenshort = new Screenshort();
			winium = new WiniumMethods();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "static-access", "unused" })
	@Test
	public void testCases() {
		try {
			boolean login = winium.winElementPresent("Forgot Password");
			if (login == true) {

				Reporter.log("login page is displaying");
				screenshort.capturescreenshortpassed("1)login page ");
			} else {
				Reporter.log("login page is not displaying");
				screenshort.capturescreenshortFailed("1)login page");
			}

			winium.wElsimplexpath("sk@falconnecttech.com",1);
			//WebElement ww2 = driver.findElementByName("Password");
			winium.wElsimplexpath("Fluke$2018",2);

			//driver.findElementByXPath("(//*[@LocalizedControlType='edit'])[2]").sendKeys("Fluke$2018");
			driver.findElementByName("SIGN IN").click();

			Thread.sleep(10000);
			/*
			 * Login
			 */
			boolean tools = winium.winElementPresent("Fluke Connect Tools");
			if (tools == true) {
				Reporter.log("logedin  and  tools page is displaying");
				screenshort.capturescreenshortpassed("2)tools page ");
			} else {
				Reporter.log("logedin  and  tools page is not displaying");
				screenshort.capturescreenshortFailed("2)tools page");
			}

			driver.findElementByName("Measurements").click();
			boolean Measurements = winium.winElementPresent("ADD MEASUREMENTS");
			if (Measurements == true) {
				Reporter.log("Measurements page is displaying");
				screenshort.capturescreenshortpassed("3)Measurement ");
			} else {
				Reporter.log("Measurements page is not displaying");
				screenshort.capturescreenshortFailed("3)Measurements");
			}

			driver.findElementByName("Assets").click();
			boolean Assets = winium.winElementPresent("REFRESH");
			if (Assets == true) {
				Reporter.log("Assets  and  tools page is displaying");
				screenshort.capturescreenshortpassed("4)Assets page ");
			} else {
				Reporter.log("logedin  and  tools page is not displaying");
				screenshort.capturescreenshortFailed("4)aSSETS page");
			}

			driver.findElementByName("Reports").click();
			boolean Reports = winium.winElementPresent("CREATE REPORT");
			if (Reports == true) {
				Reporter.log("logedin  and  tools page is displaying");
				screenshort.capturescreenshortpassed("5)reports page ");
			} else {
				Reporter.log("logedin  and  tools page is not displaying");
				screenshort.capturescreenshortFailed("5)reports page");
			}

			sik.sClick("logoutImages");
			driver.findElementByName("Sign Out").click();

			winium.wClick("Yes");
			Thread.sleep(4000);
			boolean logout = winium.winElementPresent("Forgot Password");
			if (logout == true) {
				Reporter.log("loged out  and login page is displaying");
				screenshort.capturescreenshortpassed("6)logout page ");
			} else {
				Reporter.log("loged out and logon page is not displaying");
				screenshort.capturescreenshortFailed("6)logout page");
			}
			Thread.sleep(4000);

		sik.closeApplication();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}