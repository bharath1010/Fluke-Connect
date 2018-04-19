package com.fluke.connect.winium_sikuli;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;

public class WiniumMethods {
	
	public WiniumDriver driver;
	public WiniumMethods() {
		 driver=Wdriver.winiumgetdriver();
	}
	
	public boolean winElementPresent(String expectedWindoworElementName)
	{
		boolean flag = false;
	    List<WebElement> lst=null;
		try
		{
			lst= driver.findElements(By.name(expectedWindoworElementName));
			int len=lst.size();
			if(len>=1)
			{
				flag = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	
	public boolean isEqulsText(String expectedText,String actualText){
		
		boolean flag = false;
		try
		{
			if(expectedText.equals(actualText))
			{
				flag = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}


	public boolean isSelected(String nameOftheElement){
		
		boolean flag = false;
		try
		{
		  WebElement webel=driver.findElement(By.name(nameOftheElement));
			if(webel.isSelected())
			{
				flag = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}	
	 public  void wClick(String nameOfWindowsElement)
		{
			
			try
			{
				WebElement name=driver.findElement(By.name(nameOfWindowsElement));
				name.click();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
	public void wDoubleClick(String nameOfWindowsElement)
	{
		
		try
		{
			WebElement name=driver.findElement(By.name(nameOfWindowsElement));
			name.click();
			name.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
