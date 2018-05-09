package com.fluke.screens.android;

import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;

public class Android_PageObjects {
	@FindBy(id = "com.fluke.deviceApp:id/dialog_ok")
	WebElement okBtn;

	@FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	WebElement allowBtn;

	@FindBy(id = "com.fluke.deviceApp:id/login_name")
	WebElement loginNm;

	@FindBy(id = "com.fluke.deviceApp:id/login_password")
	WebElement passWd;

	@FindBy(id = "com.fluke.deviceApp:id/login_button")
	WebElement signIn;

	@FindBy(id = "com.fluke.deviceApp:id/menu_icon")
	WebElement menuIcon;

	@FindBy(id = "com.fluke.deviceApp:id/signout")
	WebElement signOutBtn;

	@FindBy(id = "com.fluke.deviceApp:id/status_grid")
	WebElement measureMenu;

	@FindBy(id = "com.fluke.deviceApp:id/sortB")
	WebElement sortBtn;

	@FindBy(id = "com.fluke.deviceApp:id/filter_by_measurements_only")
	WebElement filterMeasurements;

	@FindBy(id = "com.fluke.deviceApp:id/filter_by_thermal_images_only")
	WebElement filterThermal;

	@FindBy(id = "com.fluke.deviceApp:id/filter_by_three_phase_only")
	WebElement filterTreePhase;

	@FindBy(id = "com.fluke.deviceApp:id/action_bar_item_menu_text")
	WebElement doneBtn;

	@FindBy(id = "android:id/button1")
	WebElement confirmOk;

	@FindBy(id = "android:id/button2")
	WebElement confirmCancel;

	@FindBy(id = "com.fluke.deviceApp:id/measurement_device")
	List<WebElement> measureDeviceName;

	public Android_PageObjects(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

	public void Login(String userName, String passWord) throws MalformedURLException, InterruptedException {
		Thread.sleep(5000);
		// okBtn.click();
		// allowBtn.click();
		loginNm.sendKeys(userName);
		passWd.sendKeys(passWord);
		signIn.click();
	}

	public void Measurements() {
		menuIcon.click();
		measureMenu.click();
	}

	public String MeasureFilter(String option) {
		sortBtn.click();
		if (option.equalsIgnoreCase("Measurements")) {
			filterMeasurements.click();
		} else if (option.equalsIgnoreCase("Thermal")) {
			filterThermal.click();
		} else if (option.equalsIgnoreCase("ThreePhase")) {
			filterTreePhase.click();
		}
		doneBtn.click();

		try {
			System.out.println(measureDeviceName.size() + " Images found for : " + option + " Filter "
					+ measureDeviceName.get(0).getText());
			return measureDeviceName.get(0).getText();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("0 Images found for : " + option);
			return "";
		}
	}

	public void SignOut() {
		menuIcon.click();
		signOutBtn.click();
		confirmOk.click();
	}
}
