package com.makemytrip.genericPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods extends MasterPage {

	public CommonMethods() throws Exception {
		super();

	}

	// Click Method
	public void click(WebElement xpathkey) {

		//driver.findElement(By.xpath(xpathkey)).click();
		xpathkey.click();
		
	}

	// Enter Dynamic Data
	public void enterDynamicData(WebElement fromCity, String testData) {

		fromCity.sendKeys(testData);
	}

}
