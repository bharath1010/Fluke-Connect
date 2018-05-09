package com.fluke.connect.test_cases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fluke.connect.assertion.HardAssertions;
import com.fluke.connect.base.SeleniumTestBase;
import com.fluke.connect.pages.ActiveSession;
import com.fluke.connect.pages.LoginPage;
import com.fluke.connect.pages.MeasurementsPage;
import com.fluke.connect.pages.TopHeadersPage;
import com.fluke.connect.prepoststeps.LoginApplication;
import com.fluke.connect.utility.GetDataProperties;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.mail.imap.Utility.Condition;

@SuppressWarnings("unused")
public class MeasurementScreenTest extends SeleniumTestBase {

	TopHeadersPage header;
	MeasurementsPage measurment;
	ActiveSession active;
	
	@BeforeMethod
	public void setUp(){
		WindowsUtils.killByName("chromedriver.exe");
		init();
		LoginApplication.login(GetDataProperties.getConfData("username"),GetDataProperties.getConfData("password") );
	}
	
	@Test(priority = 0)
	public void verifyMeasurements() {

		try {
			test = extent.startTest("verify Measurements");
			test.log(LogStatus.INFO, "logged in application");
			log("waiting to load page ");
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("List")));
			header = PageFactory.initElements(driver, TopHeadersPage.class);
			measurment = PageFactory.initElements(driver, MeasurementsPage.class);
			header.clickMeasurements();
			test.log(LogStatus.INFO, "clicked on Measurment page ");
		}

		catch (Exception e) {
			log("found exception  " + e);

			test.log(LogStatus.FAIL, e.toString(), test.addScreenCapture(newFileName));
		}

		try {
			String act_text = HardAssertions.textassertion(measurment.leftCornerText());
			Assert.assertEquals(act_text, "MEASUREMENTS");
			test.log(LogStatus.INFO, "MEASUREMENTS text verified ");
		}

		catch (Exception e) {
			String screen = captureScreen("");
			test.log(LogStatus.FAIL, "MEASUREMENTS text no matched ", test.addScreenCapture(newFileName));

		}

		log("total number of images are present" + measurment.getallimage().size());
		Assert.assertEquals(measurment.getimagetitle(), "Click the image to view the measurement details");

	}

	@Test(priority = 1)
	public void deleteMeasurements() throws InterruptedException {
		int imagecount = 0;

		test = extent.startTest("Delete Measurments");
		test.log(LogStatus.INFO, "Open  connect.fluke.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("List")));
		header = PageFactory.initElements(driver, TopHeadersPage.class);
		measurment = PageFactory.initElements(driver, MeasurementsPage.class);
		header.clickMeasurements();
		test.log(LogStatus.INFO, "Measurements clicked");
		imagecount = measurment.getallimage().size();
		log("total imgae before deletion is " + " " + imagecount);
		if (imagecount == 0) {

			test.log(LogStatus.INFO, "No image present");

		}

		else {

			System.out.println("total number of image present" + measurment.getallimage().size());
			measurment.getallcheckbox().get(0).click();

			measurment.clickDeleteButton();
			test.log(LogStatus.INFO, "delete button cliked");
			measurment.okButton();
			test.log(LogStatus.INFO, "Ok delete button clicked");
			int imagecountafterdelete = measurment.getallimage().size();
			Assert.assertEquals(imagecountafterdelete, imagecount );
			log("image remaining after deletion 1 image   " + imagecountafterdelete);

		}

		imagecount = measurment.getallimage().size();

		if (imagecount >= 2) {

			log("total number of image present" + imagecount);
			measurment.getallcheckbox().get(0).click();
			measurment.getallcheckbox().get(1).click();
			measurment.clickDeleteButton();
			measurment.okButton();
			test.log(LogStatus.INFO, "two image deleted");
			int imagecountafterdelete = measurment.getallimage().size();
			Assert.assertEquals(imagecountafterdelete, imagecount - 2);
			log("image remaining after deletion  " + " " + imagecountafterdelete);

		}

		else {

			log("b  "
					+ ""
					+ ""
					+ "upload more images ");
			test.log(LogStatus.INFO, "Please upload more image");

		}

	}	
		@Test(priority = 2)
		public void activeSessions() {
		try {
			test = extent.startTest("verify Measurements");
			test.log(LogStatus.INFO, "logged in application");
			log("waiting to load page ");
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("List")));
			header = PageFactory.initElements(driver, TopHeadersPage.class);
			measurment = PageFactory.initElements(driver, MeasurementsPage.class);
			header.clickMeasurements();
			test.log(LogStatus.INFO, "clicked on Measurment page ");
			measurment.activeSession();
			active = PageFactory.initElements(driver, ActiveSession.class);
			active.lableSession();
			active.graphView().get(0).click();
			active.graphView().get(1).click();
		}

		catch (Exception e) {
			log("found exception  " + e);

			test.log(LogStatus.FAIL, e.toString(), test.addScreenCapture(newFileName));
		}

		try {
			String act_text = HardAssertions.textassertion(active.max());
			Assert.assertEquals(act_text, act_text);
			test.log(LogStatus.INFO, "ACTIVE SESSIONS text verified ");
		}

		catch (Exception e) {
			String screen = captureScreen("");
			test.log(LogStatus.FAIL, "ACTIVE SESSIONS text no matched ", test.addScreenCapture(newFileName));

		}
		
		
	}

}
