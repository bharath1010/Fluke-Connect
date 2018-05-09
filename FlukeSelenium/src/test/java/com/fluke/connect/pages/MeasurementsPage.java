package com.fluke.connect.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.fluke.connect.base.SeleniumTestBase;

public class MeasurementsPage extends SeleniumTestBase{

	WebDriver driver;

	public MeasurementsPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(how = How.CSS, using = "h1#middle-section")
	WebElement measurementtext;

	@FindBy(how = How.CLASS_NAME, using = "measDetailImg")
	WebElement images;

	@FindAll(@FindBy(how = How.CLASS_NAME, using = "measDetailImg"))
	List<WebElement> allimages;

	@FindAll(@FindBy(how = How.CSS, using = "div.measurementSelect.sprite.check-box"))
	List<WebElement> checkboxes;

	@FindBy(how = How.CSS, using = "span.button.deleteBtn")
	WebElement delete_button;

	@FindBy(how = How.CSS, using = "a#dialog_ok")
	WebElement okbutton;
	
	@FindBy(how = How.XPATH, using = "//a[@href='/remote-monitoring']")
	WebElement activesession;

	public WebElement leftCornerText() {

		return measurementtext;

	}

	public String getimagetitle() {

		if (images == null) {

			return null;
		}

		return images.getAttribute("title");

	}

	public List<WebElement> getallimage() {

		return allimages;

	}

	public List<WebElement> getallcheckbox() {

		return checkboxes;

	}

	public void clickDeleteButton() {

		delete_button.click();

	}

	public void okButton() {

		okbutton.click();

	}
	
	public void activeSession() {

		activesession.click();

	}

}
