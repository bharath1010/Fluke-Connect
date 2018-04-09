package com.fluke.connect.prepoststeps;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.fluke.connect.base.TestBase;
import com.fluke.connect.pages.LoginPage;

public class LoginApplication extends TestBase {
	
	
public  static void login(String username , String password) {
		
	
	LoginPage login_page=  PageFactory.initElements(driver, LoginPage.class);
	login_page.loginFluke(username, password);
		
	
}

}
