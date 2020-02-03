package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.CommercialTabPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC0034_CommercialTab {
	
	public WebDriver driver;
	public String baseUrl;
	public static Properties properties;
	public ScreenShot screenShot;
	public CommercialTabPOM commercialTabPOM;	
	
	@BeforeClass
	public void setUpBeforeTest() throws IOException {
		ExtentReports extent;
        ExtentTest logger;
        extent=new ExtentReports(System.getProperty("user.dir")+"//test-output/TC0034.html");
        extent.loadConfig(new File(System.getProperty("user.dir")+"//extent-config.xml"));
		
		
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		logger = extent.startTest("Launch Browser");
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		//create object
		commercialTabPOM=new CommercialTabPOM(driver);
		//open url
		driver.get(baseUrl);
		
		logger.log(LogStatus.PASS, baseUrl);
        extent.endTest(logger);
		
	}
	
	
	@Test
	public void commercialTab() throws InterruptedException {
		commercialTabPOM.clickCommercialTab();
		commercialTabPOM.eneterAddress("Nullam hendrerit apartment");
		commercialTabPOM.clcikSearchButton();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,200)");
		commercialTabPOM.clickDropLine();
		commercialTabPOM.sendName("rozina");
		commercialTabPOM.sendEmail("rozina@gmail.com");
		commercialTabPOM.sendSubject("apartment");
		commercialTabPOM.sendMessage("looking for apartment");
		commercialTabPOM.clcikSend();
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
