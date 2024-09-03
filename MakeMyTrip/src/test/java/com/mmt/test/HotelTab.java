package com.mmt.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.makemytrip.genericPages.MasterPage;

public class HotelTab extends MasterPage {

	public HotelTab() throws Exception {
		super();

	}

	@Test(priority = 1)
	public void hotelHome() {

		driver.findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chHotels']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Rooms & Guests')]")).isDisplayed(),
				"You Are Not On Hotel Page");
	}

	@Test(priority = 2)
	public void bookRoom() throws Exception {

//		List<WebElement> allElements = driver.findElements(By.xpath("//ul[@class='recentSearchWidget recentSearches']"));
//	    System.out.println("Recent Search : "+allElements);

//	    Select s = new Select(driver.findElement(By.xpath("//ul[@class='recentSearchWidget recentSearches']")));
//	      // getting the list of options in the dropdown with getOptions()
//	      List <WebElement> op = s.getOptions();
//	      int size = op.size();
//	      for(int i =0; i<size ; i++){
//	         String options = op.get(i).getText();
//	         System.out.println(options);
//	      }

		driver.findElement(By.xpath("//div[@data-cy='HotelSearchWidget_316']")).click();

		driver.findElement(By.xpath("//input[@title='Where do you want to stay?']")).sendKeys(cprop.getProperty("toCity"));

		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']")).click();

	}

	@Test(priority = 3, enabled = true)
	public void selectCheckInOut() {

		// Departure Date Selection
		while (!driver.findElement(By.className("DayPicker-Months")).getText().contains(cprop.getProperty("tMonth"))) {

			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}

		driver.findElement(By.xpath("//div[@aria-label=" + "'" + cprop.getProperty("ciDate") + "']")).click();

		driver.findElement(By.xpath("//div[@aria-label=" + "'" + cprop.getProperty("coDate") + "']")).click();

		// Select Adult
		driver.findElement(By.xpath("//div[@class='rmsGst__body']//div[1]//div[2]//div[1]")).click();
		driver.findElement(By.xpath("//li[normalize-space()=" + "'" + cprop.getProperty("HAdult") + "']")).click();

		// Select Room
		driver.findElement(By.xpath("(//div[@class='gstSlctCont'])[1]")).click();
		driver.findElement(By.xpath("//li[normalize-space()=" + "'" + cprop.getProperty("HRoom") + "']")).click();
		driver.findElement(By.xpath("//button[@class='primaryBtn btnApplyNew pushRight capText']")).click();

		// Select Price per Night
		driver.findElement(By.xpath("(//p[@class='font14 greyText'])[1]")).click();
		driver.findElement(By.xpath("//li[contains(text()," + "'" + cprop.getProperty("pSort4") + "')]")).click();

		driver.findElement(By.id("hsw_search_button")).click();
	}
	
	

}
