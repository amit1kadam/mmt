package com.mmt.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makemytrip.genericPages.FlightTab;
import com.makemytrip.genericPages.MasterPage;

public class FlightBookingTest extends MasterPage {

	FlightTab flight = new FlightTab(driver);

	public FlightBookingTest() throws Exception {
		super();
	}

	@Test(priority = 1)

	public void homePageVerification() {

		Assert.assertTrue(driver
				.findElement(By.xpath("//*[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut']"))
				.isDisplayed());

	}

	@Test(priority = 2)
	public void offerVerify() {

		driver.findElement(By.xpath("//li[@data-cy='ALL']")).click();

		driver.findElement(By.xpath("//li[@data-cy='CABS']")).click();

		driver.findElement(By.xpath("//li[@data-cy='FLIGHTS']")).click();

		driver.findElement(By.xpath("//li[@data-cy='RAILS']")).click();

		driver.findElement(By.xpath("//li[@data-cy='HOLIDAYS']")).click();

		driver.findElement(By.xpath("//li[@data-cy='BANK_OFFERS']")).click();

		driver.findElement(By.xpath("//li[@data-cy='HOTELS']")).click();

		WebElement appLink = driver.findElement(By.xpath("//h3[text()='Download App Now !']"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", appLink);
		driver.findElement(By.xpath("//input[@data-cy='desktopCard_43']")).sendKeys("1234568990");

		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//li[@data-cy='ALL']")));

	}

	@Test(priority = 3)
	public void flightSelectTest() throws Exception {

		flight.selectDep(cprop.getProperty("fromCity"));

		flight.selectArrival(cprop.getProperty("toCity"));
		flight.selectDate();
		flight.selectTraveler();
		flight.selectTravelClass();
		
	}

	@Test(priority = 4)
	public void flightBookingTest() throws Exception {

		//WebElement popup = driver.findElement(By.xpath("//button[normalize-space()='OKAY, GOT IT!']"));

		if (driver.findElement(By.xpath("//button[normalize-space()='OKAY, GOT IT!']")).isDisplayed()) {
			driver.findElement(By.xpath("//button[normalize-space()='OKAY, GOT IT!']")).click();
			System.out.println("PopUp Displayed and Closed");
		} else {
			System.out.println("PopUp Not Displayed");
		}

		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Flights from')]")).isDisplayed(),"You Are Not On FlightFare Page");

		WebElement options = driver.findElement(By.xpath("(//span[@class='linkText pointer'])[1]"));
		options.click();

		WebElement chk = driver.findElement(By.xpath("//p[normalize-space()='AfterNoon Departure']"));
		chk.click();

//		WebElement flt = driver.findElement(By.xpath("(//p[contains(text(),'SpiceJet')])[2]"));
//		Actions act = new Actions(driver);
//		act.scrollToElement(flt);
//		Thread.sleep(6000);
//		flt.click();
	}

}

//	@AfterClass
//	public void tearDown() {
//		driver.quit();
//	}
