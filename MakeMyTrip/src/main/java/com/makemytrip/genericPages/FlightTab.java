package com.makemytrip.genericPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightTab {

	WebDriver driver;
	public Properties cprop;
	
	
	public FlightTab(WebDriver driver) throws Exception {
		this.driver = driver;

		cprop = new Properties();
		File cfile = new File(System.getProperty("user.dir")
				+ ".\\src\\main\\java\\com\\makemytrip\\repository\\configuration.properties");
		FileInputStream cfis = new FileInputStream(cfile);
		cprop.load(cfis);

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='menu_Flights']")
	private WebElement flightMenu;

	@FindBy(id = "fromCity")
	WebElement fromCity;

	@FindBy(xpath = "//*[@id='react-autowhatever-1-section-0-item-0']")
	WebElement selectFrom;

	@FindBy(id = "toCity")
	WebElement toCity;

	@FindBy(xpath = "//*[@id='react-autowhatever-1-section-0-item-0']")
	WebElement selectTo;

	@FindBy(className = "DayPicker-Months")
	WebElement DayPicker;

	@FindBy(xpath = "//span[@aria-label='Next Month']")
	WebElement nextMonthArrow;
	
	@FindBy (xpath="//label[@for='travellers']")
	WebElement travellers;
	
	@FindBy (xpath= "//button[@data-cy='travellerApplyBtn']")
	WebElement travellerApplyBtn;
	
	@FindBy (xpath= "//p[@data-cy=\"submit\"]")
	WebElement submitBtn;

//	 @FindBy(xpath="//p[contains(text(),"+"'"+cprop.getProperty("sDate")+"'"+")])[2]")
//	 WebElement dateSelect;

	

	public void selectDep(String fCity) throws Exception {

		flightMenu.click();
		fromCity.sendKeys(fCity);
		//driver.manage().timeouts().wait(3000);
		Thread.sleep(3000);
		selectFrom.click();
	}

	public void selectArrival(String tCity) throws Exception {

		toCity.sendKeys(tCity);
		//driver.manage().timeouts().wait(3000);
		Thread.sleep(3000);
		selectTo.click();
	}

	public void selectDate() {
		DayPicker.click();
		// driver.findElement(By.xpath("//p[contains(text(),"+"'"+cprop.getProperty("sDate")+"'"+")])[2]")).click();

		// Departure Date Selection
		while (!driver.findElement(By.className("DayPicker-Months")).getText().contains(cprop.getProperty("tMonth"))) {

			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		// driver.findElement(By.xpath("//div[@aria-label="+"'"+cprop.getProperty("tDate")+"']")).click();
		// OR
		driver.findElement(By.xpath("(//p[contains(text()," + "'" + cprop.getProperty("tDate2") + "'" + ")])[2]"))
				.click();

	}
	
	public void selectTraveler() {
		
		travellers.click();
		
		driver.findElement(By.xpath("//li[@data-cy='adults-" + cprop.getProperty("Adult") + "']")).click();

		driver.findElement(By.xpath("//li[@data-cy='children-" + cprop.getProperty("Children") + "']")).click();

		driver.findElement(By.xpath("//li[@data-cy='infants-" + cprop.getProperty("Infant") + "']")).click();

		driver.findElement(By.xpath("//li[text()=" + "'" + cprop.getProperty("TCLASS1") + "']")).click();
		
	}
	
	public void selectTravelClass() {
		
		driver.findElement(By.xpath("//li[text()=" + "'" + cprop.getProperty("TCLASS1") + "']")).click();
		travellerApplyBtn.click();
		submitBtn.click();

	}
	
}
