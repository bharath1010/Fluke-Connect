package com.fluke.connect.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ActiveSession {
	WebDriver driver;
	public ActiveSession(WebDriver driver) {
		this.driver = driver;

	}
	@FindAll(@FindBy(how = How.CLASS_NAME, using = "highcharts-point highcharts-color-0"))
	List<WebElement> graph;

	@FindBy(how = How.XPATH, using = "//div[@class='sessionGatewayName']")
	WebElement session;

	
	@FindBy(how = How.XPATH, using = "//div[@class='sessionMaxValue sessionValueParam']")
	WebElement max;
	
	
	
		public List<WebElement> graphView() {

			return graph;

		}

		public void lableSession() {

			session.click();

		}
		
		public WebElement max() {
			return max;
		}
		

}