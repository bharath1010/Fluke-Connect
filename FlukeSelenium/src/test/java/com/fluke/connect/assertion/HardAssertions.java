package com.fluke.connect.assertion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



@SuppressWarnings("unused")
public class HardAssertions {
	
	public static String textassertion(WebElement element){
		
		  
    	String act_res=element.getText();
    	return act_res;
    
  
	}
	

}
