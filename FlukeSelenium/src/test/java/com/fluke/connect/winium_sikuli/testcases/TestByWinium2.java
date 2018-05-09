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

@SuppressWarnings("unused")

/*
 *  Making login
 *  Go to  tools tab check that we are in tools page or not.
 *  Go to  Measurements tab check that we are in measurement page or not.
 *   Go to  Assert tab check that we are in Assert page or not.
 *   Go to  Report tab check that we are in Report page or not.
 *   Go to  logout tab check that we are in logout page or not.
 * 
 */

public class TestByWinium2 {

	public static WiniumDriver driver;
	sikulli sik;
	Screenshort screenshort;
	WiniumMethods winium;

	@Test
	public void applicationLaunch() {
		try {
			Wdriver.launchApplication();
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
			boolean login = winium.winElementPresentById("UI_SignInControl");
			if (login == true) {

				Reporter.log("login page is displaying");
				screenshort.capturescreenshortpassed("1)login page ");
			} else {
				Reporter.log("login page is not displaying");
				screenshort.capturescreenshortFailed("1)login page");
			}
			
			winium.wSendDataById("UI_TextBox_Email","sk@falconnecttech.com");
			winium.wSendDataById("UI_PasswordBox_Password","Fluke$2018");
				winium.wClickById("UI_Button_SignIn");





		
			/*
			 * Login
			 */
			boolean tools = winium.winElementPresentById("UI_ToolsTab");
			if (tools == true) {
				Reporter.log("logedin  and  tools page is displaying");
				screenshort.capturescreenshortpassed("2)tools page ");
			} else {
				Reporter.log("logedin  and  tools page is not displaying");
				screenshort.capturescreenshortFailed("2)tools page");
			}
				
				
			winium.wClickById("UI_TabItem_Measurements");
			boolean Measurements = winium.winElementPresentById("UI_MeasurementsTab");
			if (Measurements == true) {
				Reporter.log("Measurements page is displaying");
				screenshort.capturescreenshortpassed("3)Measurement ");
			} else {
				Reporter.log("Measurements page is not displaying");
				screenshort.capturescreenshortFailed("3)Measurements");
			}

			winium.wClickById("UI_TabItem_Assets");
			boolean Assets = winium.winElementPresentById("UI_Asset_Refresh_Button");
			if (Assets == true) {
				Reporter.log("Assets  and  tools page is displaying");
				screenshort.capturescreenshortpassed("4)Assets page ");
			} else {
				Reporter.log("logedin  and  tools page is not displaying");
				screenshort.capturescreenshortFailed("4)aSSETS page");
			}

			
			winium.wClickById("UI_TabItem_Reports");
			boolean Reports = winium.winElementPresentById("Btn_Create_Report");
			if (Reports == true) {
				Reporter.log("logedin  and  tools page is displaying");
				screenshort.capturescreenshortpassed("5)reports page ");
			} else {
				Reporter.log("logedin  and  tools page is not displaying");
				screenshort.capturescreenshortFailed("5)reports page");
			}

			sik.sClick("logoutImages");
			winium.wClickById("UI_MenuItem_SignOut");
			winium.wClickById("UI_Button_Yes");

			boolean logout = winium.winElementPresentById("UI_SignInControl");
			if (logout == true) {
				Reporter.log("loged out  and login page is displaying");
				screenshort.capturescreenshortpassed("6)logout page ");
			} else {
				Reporter.log("loged out and logon page is not displaying");
				screenshort.capturescreenshortFailed("6)logout page");
			}
	

		     sik.closeApplication();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}