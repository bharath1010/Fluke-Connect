package com.fluke.connect.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import com.fluke.connect.exception.SeleniumException;

@SuppressWarnings("unused")
public class GetDataProperties {

	/**
	 * Purpose : Loads .properties file
	 * 
	 * @throws SeleniumException
	 */

	public static String getConfData(String var) throws SeleniumException {
		try {

			File file = new File(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\conf.properties");

			FileInputStream fileInput = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fileInput);
			return prop.getProperty(var);

		}

		catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

}
