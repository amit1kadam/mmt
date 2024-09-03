package com.makemytrip.genericPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MasterPage {

	public static WebDriver driver;

	public Properties cprop;

	public MasterPage() throws Exception {
		cprop = new Properties();
		File cfile = new File(System.getProperty("user.dir")
				+ ".\\src\\main\\java\\com\\makemytrip\\repository\\configuration.properties");
		FileInputStream cfis = new FileInputStream(cfile);

		cprop.load(cfis);

		if (cprop.getProperty("browser").equalsIgnoreCase("chrome")) {
			
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("disable-notifications");
			opt.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			driver = new ChromeDriver(opt);
			
			//driver = new ChromeDriver();
			
			
		} else if (cprop.getProperty("browser").equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else if (cprop.getProperty("browser").equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		} else {

			System.out.println("Use Proper Driver");
		}
		driver.manage().deleteAllCookies();
		driver.get(cprop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		// to Handle iFrame

		boolean shouldCloseIframe = true;

		if (shouldCloseIframe) {
			WebElement iframeElement = driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));

			driver.switchTo().frame(iframeElement);
			driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
			System.out.println("First iFrame Handled");

			driver.switchTo().defaultContent();
			
		}else if (shouldCloseIframe) {
			WebElement iframeElement2= driver.findElement(By.name("notification-frame-b8a5ca96"));

			driver.switchTo().frame(iframeElement2);
			driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
			System.out.println("Second iFrame Handled");

			driver.switchTo().defaultContent();
			
		} else {
			System.out.println("No iFrame Displayed");
		}

//		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
//		driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
//		System.out.println("iFrame Handled");
//		driver.switchTo().defaultContent();

	}

}
