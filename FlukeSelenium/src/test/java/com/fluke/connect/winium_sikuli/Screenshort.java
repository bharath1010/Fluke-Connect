package com.fluke.connect.winium_sikuli;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.winium.WiniumDriver;

public class Screenshort {
	public static void capturescreenshortpassed(String nameOfScreenshort){
		WiniumDriver driver;
		try {
			driver = Wdriver.winiumgetdriver();
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourceFile=ts.getScreenshotAs(OutputType.FILE);
			File destFile=new File(Global.passedscreeshortpath.concat(nameOfScreenshort+".png"));
			FileUtils.copyFile(sourceFile,destFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	
	
	
	
	public static void capturescreenshortFailed(String nameOfScreenshort){
		WiniumDriver driver;
		try {
			driver = Wdriver.winiumgetdriver();
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourceFile=ts.getScreenshotAs(OutputType.FILE);
			File destFile=new File(Global.failedscreenshortpath.concat(nameOfScreenshort+".png"));
			FileUtils.copyFile(sourceFile,destFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
