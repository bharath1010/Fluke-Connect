package com.fluke.connect.prepoststeps;

import org.openqa.selenium.support.PageFactory;

import com.fluke.connect.base.SeleniumTestBase;
import com.fluke.connect.pages.LoginPage;

public class LoginApplication extends SeleniumTestBase {

	public static void login(String username, String password) {

		LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);
		login_page.loginFluke(username, password);

	}

}
