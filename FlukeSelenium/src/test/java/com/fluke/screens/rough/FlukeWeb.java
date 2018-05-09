package com.fluke.screens.rough;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FlukeWeb {
	WebDriver driver;
	WebDriverWait wait;
	String loginURL = "https://connect.fluke.com/en/login";
	String browserName = "chrome";
	static String curURL;
	List<String> MeasureIDs;
	List<WebElement> MeasurementList;
	static String status = "";

	@Test(priority = 0)
	public void Launch() {
		driver = Setup.StartUp(browserName, 10);
		driver.get(loginURL);
	}

	@Test(priority = 1, dataProvider = "LoginInputs", dataProviderClass = InputData.class, enabled = false)
	public void ValidateLogin(String login, String passwd) throws InterruptedException {
		PageObjects.Login(driver, loginURL, login, passwd);
		if (status.equals("Login Sucess")) {
			PageObjects.SignOut(driver);
		}
	}

	@Test(priority = 2)
	public void Measurement() throws InterruptedException {
		PageObjects.Login(driver, loginURL, "sudhakar@falconnecttech.com", "Fluke$2018");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='store-header-tab-anchor'][text()='Measurements']")).click();
		if (driver.findElements(By.className("measUsername")).size() != 0) {
			System.out.println("Measurement captured from the Mobile are available");
		}
	}

	@Test(dependsOnMethods = "Measurement")
	public void DeleteMeasurement() throws InterruptedException {
		Thread.sleep(2000);
		MeasurementList = driver.findElements(By.cssSelector(".measurements.measurement-group.measWrpr"));
		System.out.println("Sizie of arru" + MeasurementList.size());
		MeasureIDs = new ArrayList<String>(MeasurementList.size());

		for (WebElement SingleMeasure : MeasurementList) {
			MeasureIDs.add(SingleMeasure.getAttribute("data-model-id"));
			System.out.println("data-model-id : " + SingleMeasure.getAttribute("data-model-id"));
		}

		MeasurementList.get(0).findElement(By.cssSelector(".measurementSelect.sprite.check-box")).click();
		driver.findElement(By.cssSelector(".iconDelete.new-tooltip")).click();
		System.out.println("Dialog Box :" + driver.findElement(By.cssSelector(".dialog>p")).getText());
		driver.findElement(By.id("dialog_ok")).click();
		if (!driver.findElement(By.xpath("//div[@data-model-id='" + MeasureIDs.get(0) + "']")).isDisplayed()) {
			System.out.println("data-model-id: " + MeasureIDs.get(0));
			System.out.println("is Deleted by Single-Select Measurement");
			MeasurementList.remove(0);
			MeasureIDs.remove(0);
		}

		Thread.sleep(3000);
		MeasurementList.get(0).findElement(By.cssSelector(".measurementSelect.sprite.check-box")).click();
		MeasurementList.get(1).findElement(By.cssSelector(".measurementSelect.sprite.check-box")).click();
		driver.findElement(By.cssSelector(".iconDelete.new-tooltip")).click();
		System.out.println("Dialog Box :" + driver.findElement(By.cssSelector(".dialog>p")).getText());
		driver.findElement(By.id("dialog_ok")).click();
		if (!driver.findElement(By.xpath("//div[@data-model-id='" + MeasureIDs.get(0) + "']")).isDisplayed()
				&& !driver.findElement(By.xpath("//div[@data-model-id='" + MeasureIDs.get(1) + "']")).isDisplayed()) {
			System.out.println("data-model-id: " + MeasureIDs.get(0));
			System.out.println("data-model-id: " + MeasureIDs.get(1));
			System.out.println("are Deleted by Multi-Select Measurement");
			MeasurementList.remove(0);
			MeasureIDs.remove(0);
			MeasurementList.remove(1);
			MeasureIDs.remove(1);
		}
	}

}
