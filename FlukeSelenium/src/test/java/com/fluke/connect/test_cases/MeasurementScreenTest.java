package com.fluke.connect.test_cases;

import static org.testng.Assert.expectThrows;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fluke.connect.assertion.HardAssertions;
import com.fluke.connect.base.TestBase;
import com.fluke.connect.pages.LoginPage;
import com.fluke.connect.pages.MeasurementsPage;
import com.fluke.connect.pages.TopHeadersPage;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.mail.imap.Utility.Condition;

public class MeasurementScreenTest extends TestBase{
	
	TopHeadersPage header;
	MeasurementsPage measurment;
	
	 //public static final Logger log = Logger.getLogger( MeasurementScreenTest.class.getName());
	//@Test(priority=0)
	public void verifyMeasurements() {
		
		try {
		test = extent.startTest("verify Measurements");
		test.log(LogStatus.INFO, "logged in application" );
		log("waiting to load page ");
	   wait.until(ExpectedConditions.elementToBeClickable(By.linkText("List")));
		 header=  PageFactory.initElements(driver, TopHeadersPage.class);
		 measurment=  PageFactory.initElements(driver, MeasurementsPage.class);
		header.clickMeasurements();
		test.log(LogStatus.INFO, "clicked on Measurment page " );
		}
		
		catch(Exception e)
		{
			log("found exception  " +e );
			
			test.log(LogStatus.FAIL, e.toString() , test.addScreenCapture(newFileName));
		}
		
		
		try {
			String act_text =HardAssertions.textassertion(measurment.leftCornerText());
	   Assert.assertEquals(act_text, "MEASUREMENTS");
	   test.log(LogStatus.INFO, "MEASUREMENTS text verified " );
		}
		
		catch(Exception e)
		{
			captureScreen("");
			test.log(LogStatus.FAIL,"MEASUREMENTS text no matched " , test.addScreenCapture(newFileName));
			
		}
	   
		log("total number of images are present" + measurment.getallimage().size());
	   Assert.assertEquals(measurment.getimagetitle(), "Click the image to view the measurement details");		
	    
	   
	}
	
	
	@Test(priority=1)
	public void deleteMeasurements() {
		int imagecount=0;
		try {
		test = extent.startTest("Delete Measurments");
		test.log(LogStatus.INFO, "Open  connect.fluke.com" );
	    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("List")));
	    header=  PageFactory.initElements(driver, TopHeadersPage.class);
		measurment=  PageFactory.initElements(driver, MeasurementsPage.class);
		header.clickMeasurements();
		test.log(LogStatus.INFO, "Measurements clicked" );
		 imagecount =measurment.getallimage().size();
		 log("total imgae before deletion"+ imagecount );
		if(measurment.getallimage().size()==0) {
			
			//logs
			test.log(LogStatus.INFO, "No image present" );
			
		}
		
		else {
			
			System.out.println("total number of image present" + measurment.getallimage().size());
			measurment.getallcheckbox().get(0).click();
			measurment.clickDeleteButton();
			test.log(LogStatus.INFO, "delete button cliked" );
			measurment.okButton();
			test.log(LogStatus.INFO, "Ok delete button clicked" );
			
		}
		
         if(measurment.getallimage().size()==0) {
			
			//logs
        	 test.log(LogStatus.INFO, "No image present now" );
			
		}
		
         else {
 			
 			System.out.println("total number of image present" + measurment.getallimage().size());
 			measurment.getallcheckbox().get(1).click();
 			measurment.getallcheckbox().get(2).click();
 			measurment.clickDeleteButton();
 			measurment.okButton();
 			
 			test.log(LogStatus.INFO, "two image deleted" );
 			
 		}
         
		}
		
		catch(Exception e)
		{
			captureScreen("");
			log("found exception  " +e );
			test.log(LogStatus.FAIL, e.toString() , test.addScreenCapture(newFileName));
			
		}
		
		
		int imagecountafterdelete=measurment.getallimage().size();
		Assert.assertEquals(imagecountafterdelete, imagecount-3);
		log("image remaining after deletion  "  +imagecountafterdelete);
		
		 
         
         
  }
	
	
	

}
