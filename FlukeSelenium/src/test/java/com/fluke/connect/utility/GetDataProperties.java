package com.fluke.connect.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class GetDataProperties {


	
	public static String getConfData(String var) 
	{
		try {
		
		File file = new File (System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\conf.properties");
		
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		return prop.getProperty(var);
		
		}
		
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
		
		
		//ResourceBundle rb = ResourceBundle.getBundle("H:\\Workspace_selenium\\naukri_selenium\\src\\main\\java\\conf");
		
		
		//return  rb.getString(var);
		
	}
	


}
