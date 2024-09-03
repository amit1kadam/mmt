package com.makemytrip.genericPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends CommonMethods{
	
	HomePage hp = new HomePage();
	public HomePage() throws Exception {
		super();
	}
	
	@FindBy (xpath="//a[@class='mmtLogo makeFlex']")
	WebElement mmtLogo;
	
	@FindBy (xpath="//li[@class='menu_Flights']")
	WebElement flightTab;
	
	@FindBy (id="fromCity")
	WebElement fromCity;
	
	@FindBy (xpath="//*[@id=\"react-autowhatever-1-section-0-item-0\"]")
	WebElement dynamic1;
	
	@FindBy (id="toCity")
	WebElement toCity;
	
	@FindBy (xpath="//*[@id=\"react-autowhatever-1-section-0-item-1\"]")
	WebElement dynamic2;

	
	public void flightBook() {
		
		hp.click(flightTab);
		hp.click(fromCity);
		hp.enterDynamicData(fromCity, "DEL");
	}
	
	
	
	
}

