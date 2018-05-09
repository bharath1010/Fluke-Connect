package com.fluke.connect.assertion;

import org.openqa.selenium.WebElement;

public class HardAssertions {

	public static String textassertion(WebElement element) {

		String act_res = element.getText();
		return act_res;

	}

}
