package com.fluke.connect.winium_sikuli.testcases;

import java.net.URL;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
public class TestBySikuli {

	public static WiniumDriver driver;
	sikulli sik;
	Screenshort screenshort;
	WiniumMethods winium;

	@BeforeClass
	public void applicationLaunch() {
		try {
			Wdriver.launchApplication();
			//Thread.sleep(5000);
			driver = Wdriver.winiumgetdriver();
			sik = new sikulli();
			screenshort = new Screenshort();
			winium = new WiniumMethods();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	@Test
	public void testCases() {
		try {
			boolean login = sik.isImageExist("flukeconneclogin");
			if (login == true) {
				Reporter.log("login page is displaying");
				screenshort.capturescreenshortpassed("1)Slogin page ");
			} else {
				Reporter.log("login page is not displaying");
				screenshort.capturescreenshortFailed("1)Slogin page");
			}
			sik.sSetValue("email", "sk@falconnecttech.com");
			sik.sSetValue("password", "Fluke$2018");
			sik.sClick("sinin");
			//Thread.sleep(5000);
			////////////// loged in/////////////////////////////
			boolean tools = sik.isImageExist("flookconnecttool");
			if (tools == true) {
				Reporter.log("logedin  and  tools page is displaying");
				screenshort.capturescreenshortpassed("2)Swtools page ");
			} else {
				Reporter.log("logedin  and  tools page is not displaying");
				screenshort.capturescreenshortFailed("2)Swtools page");
			}
			sik.sClick("mesurements");

			boolean Measurements = sik.isImageExist("mesurementsimage");
			if (Measurements == true) {
				Reporter.log("Measurements page is displaying");
				screenshort.capturescreenshortpassed("3)SMeasurement ");
			} else {
				Reporter.log("Measurements page is not displaying");
				screenshort.capturescreenshortFailed("3)SMeasurements");
			}

			sik.sClick("asserts");
			boolean Assets = sik.isImageExist("assetsimage");
			if (Assets == true) {
				Reporter.log("Assets  and  tools page is displaying");
				screenshort.capturescreenshortpassed("4)SAssets page ");
			} else {
				Reporter.log("logedin  and  tools page is not displaying");
				screenshort.capturescreenshortFailed("4)SASSETS page");
			}
			sik.sClick("reports");
			boolean Reports =sik.isImageExist("createreport");
			if (Reports == true) {
				Reporter.log("logedin  and  tools page is displaying");
				screenshort.capturescreenshortpassed("5)Sreports page ");
			} else {
				Reporter.log("logedin  and  tools page is not displaying");
				screenshort.capturescreenshortFailed("5)Sreports page");
			}

			sik.sClick("logoutImages");

			sik.sClick("sinout");
			sik.sClick("yes");

			boolean logout = sik.isImageExist("flukeconneclogin");
			if (logout == true) {
				Reporter.log("loged out  and login page is displaying");
				screenshort.capturescreenshortpassed("6)Slogout page ");
			} else {
				Reporter.log("loged out and logon page is not displaying");
				screenshort.capturescreenshortFailed("6)Slogout page");
			}
			//Thread.sleep(5000);
			sik.closeApplication();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
