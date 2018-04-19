package com.fluke.connect.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TopHeadersPage {

	WebDriver driver;

	public TopHeadersPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(how = How.XPATH, using = "//div//a[text()='Measurements']")
	WebElement measurements;

	public void clickMeasurements() {

		measurements.click();
	}

}
