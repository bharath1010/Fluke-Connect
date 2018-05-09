package com.fluke.connect.utility;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServer {

	public static AppiumDriverLocalService service;

	public static void start() {

		/*
		 * Start Appium Server
		 */
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File(
						"C:\\Users\\DELL\\AppData\\Local\\Programs\\appium-desktop\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723)
				.withLogFile(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\Appium.log")));

		service.start();

	}

	public static void stop() {

		service.stop();

	}

}
