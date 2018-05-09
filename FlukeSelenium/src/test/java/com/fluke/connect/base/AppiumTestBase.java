package com.fluke.connect.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import com.fluke.connect.utility.CommonUtils;
import com.fluke.connect.utility.ExcelReader;
import com.fluke.connect.utility.ExtentManager;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@SuppressWarnings("unused")
public class AppiumTestBase {

	public static final Logger log = Logger.getLogger(AppiumTestBase.class.getName());

	public static AppiumDriver<MobileElement> driver;
	public static String loadPropertyFile = "IOS_careapp.properties";
	// public static String loadPropertyFile = "ios_careapp.properties";
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "/src/test/resources/testdata/testdata.xlsx");

	public static ExtentReports extent;
	public static ExtentTest test;
	public ITestResult result;
	public static String newFileName;
	public ExtentReports reo = ExtentManager.getInstance();
	public static ExtentTest tst;

	public void setUp() throws IOException {

		if (driver == null) {

			if (loadPropertyFile.startsWith("Android")) {

				// AppiumServer.start();
				log.debug("Appium server started");
				CommonUtils.loadAndroidConfProp(loadPropertyFile);
				CommonUtils.setAndroidCapabilities();
				driver = CommonUtils.getAndroidDriver();

			} else if (loadPropertyFile.startsWith("IOS")) {

				CommonUtils.loadIOSConfProp(loadPropertyFile);
				CommonUtils.setIOSCapabilities();
				driver = CommonUtils.getIOSDriver();

			}

		}

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\Android.html",
				true, DisplayOrder.OLDEST_FIRST);
		extent.loadConfig(new File(
				System.getProperty("user.dir") + "\\src\\test\\java\\com\\fluke\\connect\\utility\\ReportsConfig.xml"));
		System.out.println("Before suite");

	}

	public String captureScreen(String fileName) {
		if (fileName == "") {
			fileName = "blank";
		}
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory = new File(System.getProperty("user.dir")) + "\\target\\surefire-reports\\html\\";

			destFile = new File(
					(String) reportDirectory + fileName + "_" + formater.format(calendar.getTime()) + ".png");
			newFileName = fileName + "_" + formater.format(calendar.getTime()) + ".png";
			FileUtils.copyFile(scrFile, destFile);
			Reporter.log("<a href='" + destFile + "'> <img src='" + "_" + fileName + formater.format(calendar.getTime())
					+ ".png" + "' height='100' width='100'/> </a>");

		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return destFile.toString();
	}

	public void getresult(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() + " test is pass");
			captureScreen("");
			test.log(LogStatus.PASS, test.addScreenCapture(newFileName));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP,
					result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
			captureScreen("");
			test.log(LogStatus.SKIP, test.addScreenCapture(newFileName));
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.ERROR, result.getName() + " test is failed" + result.getThrowable());
			captureScreen("");
			test.log(LogStatus.FAIL, test.addScreenCapture(newFileName));
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getInstanceName() + "   test is started" + result.getThrowable());

		}

		extent.endTest(test);
		extent.flush();

	}

	@AfterSuite
	public void tearDown() throws InterruptedException {

		Thread.sleep(3000);
		if (loadPropertyFile.startsWith("Android")) {
			driver.quit();
			log.debug("Appium server stopped");
		} else {

			driver.quit();
		}

	}
}
