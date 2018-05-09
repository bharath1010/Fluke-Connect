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
/////////////////////////////////////////////////////////////////////////////
	public boolean winElementPresentById(String expectedWindoworElementId)
	{
		boolean flag = false;
	    List<WebElement> lst=null;
		try
		{
			lst= driver.findElements(By.id(expectedWindoworElementId));
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
		 WebElement name=driver.findElement(By.name(nameOfWindowsElement));
			name.click();
			
		}
	 

	 public  void wClickById(String idOfWindowsElement)
		{
		 WebElement id=driver.findElement(By.id(idOfWindowsElement));
			id.click();
			
		}
	 
	 
	 public  void wSendDataById(String idOfWindowsElement ,String data)
		{
		driver.findElement(By.id(idOfWindowsElement)).sendKeys(data);
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
	
	//////////////////////////////////
	public void wClickByNName(String name) throws Exception{
		WebElement ww=null;
		for(int i=0;i<=10;i++)
		{
			try{
			ww=driver.findElementByName(name);
			break;
			}
			catch(Exception e){
				Thread.sleep(1000);
			    }	
		}
		for(int j=0;j<=10;j++)
		{
		@SuppressWarnings("unused")
		Exception ee=null;	
		
			try{
			if(ww.isEnabled()==true){
				ww.click();
			    break;
			}
			}
			
			catch(Exception e){
				Thread.sleep(1000);
			    }	
		}
}

@SuppressWarnings("unused")
public String wGetAtributekBycomplexXpath(String NameOfTheElement, String locllaisedControlType,int index) throws Exception
{
	String text=null;
	WebElement ww=null;
	for(int i=0;i<=10;i++)
	{
		try{
	
		ww= driver.findElement(By.xpath("(//*[@Name='"+NameOfTheElement+"']//following::*[@LocalizedControlType='"+locllaisedControlType+"'])["+index+"]"));
		break;
		}
		catch(Exception e){
			Thread.sleep(1000);
		    }	
	}
	for(int j=0;j<=10;j++)
	{
	Exception ee=null;	
	
		try{
		if(ww.isEnabled()==true){
			ww.click();
			text=ww.getAttribute("Name");
		break;
		}
		}
		catch(Exception e){
			Thread.sleep(1000);
		    }	
	}

return text;
}
////////////////////////////////////////////////////////////////////

@SuppressWarnings("unused")
public String wElsimplexpath(String data,int index) throws Exception
{
	String text=null;
	WebElement ww=null;
	for(int i=0;i<=10;i++)
	{
		try{
	
		ww= driver.findElement(By.xpath("(//*[@LocalizedControlType='edit'])["+index+"]"));
		break;
		}
		catch(Exception e){
			Thread.sleep(1000);
		    }	
	}
	for(int j=0;j<=10;j++)
	{
	Exception ee=null;	
	
		try{
		if(ww.isEnabled()==true){
			ww.click();
		 ww.sendKeys(data);
		break;
		}
		}
		catch(Exception e){
			Thread.sleep(1000);
		    }	
	}

return text;
}
}