package com.fluke.screens.rough;

import org.testng.annotations.DataProvider;

public class InputData {
	
	@DataProvider(name="LoginInputs")
	public Object[][] data(){
		return new Object[][] {
			{"wrongmail@mail.com", "wongpassword"},
			{"sudhakar@falconnecttech.com", "Fluke$2018"},
			{"wrongmail@mail.com", "Fluke$2018"},
			{"sudhakar@falconnecttech.com", "wongpassword"},
		};
	}
	
	@DataProvider(name="inviteList")
	public Object[] inviteList(){
		return new Object[] {
			"anbumaran@hotmail.com",
			"sudhakar@falconnecttech.com",
			"dummy1@mail.com",
		};
	}

}
