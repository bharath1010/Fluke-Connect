package com.fluke.connect.utility;

public class Configration {

	public static String testsite = "https://connect.fluke.com/en/login\r\n";

	
	/*
	 * Credentials 
	 */
	public static final String email = "sudhakar@falconnecttech.com";
	public static final String password = "Fluke$2018";
	
	
	/*
	 * application path 
	 */
	
	public static final String  nodePath ="C:\\Program Files\\nodejs\\node.exe";
	public static final String appiumMainPath="C:\\Users\\User\\AppData\\Local\\appium-desktop\\app-1.5.0\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
	public static final String  LogFilePath="D:\\FlukeFramework\\Appium.log";

	/*
	 * test base path
	 */
	
	public static final String  ExtentReportsPath ="\\target\\surefire-reports\\html\\extent.html";
	public static final String ReportsConfig = "\\src\\test\\java\\com\\fluke\\connect\\utility\\ReportsConfig.xml";
	public static final String chromedriver ="\\src\\test\\resources\\drivers\\" + "chromedriver.exe";
	public static final String geckodriver ="\\src\\test\\resources\\drivers\\" + "geckodriver.exe";
	public static final String IEDriverServer ="\\src\\test\\resources\\drivers\\" + "IEDriverServer.exe";
	public static final String testdata ="\\src\\test\\resources\\testdata\\";
	public static final String screenshotsPath ="\\src\\test\\java\\com\\fluke\\connect\\screenshot\\";
	
	
	
	public static final String deleteButton ="span.button.deleteBtn";
	public static final String graph ="highcharts-point highcharts-color-0";
	public static final String session ="#remoteMonitoringListContainer_0 > div.session-header-part > div > div > div.sessionGatewaycontainer > div:nth-child(1) > div.sessionGatewayName";
	public static final String max ="#sessionMaxValueda8d4f7f-0f32-425a-ba2f-9701055e9687THERMAL_IMAGE0";
	public static final String email1 ="emailAddr";
	public static final String pswd ="input#password";
	public static final String submit ="#loginForm > div > div:nth-child(5) > input";

	
	public static final String measurementtext ="h1#middle-section";
	public static final String images = "measDetailImg";
	public static final String allimages = "allimages";
	public static final String checkboxes = "div.measurementSelect.sprite.check-box";
	public static final String okbutton = "a#dialog_ok";
	public static final String activesession = "#measurementsToolbar > div.right-menu-navigation-tabs > a:nth-child(1)";
}
