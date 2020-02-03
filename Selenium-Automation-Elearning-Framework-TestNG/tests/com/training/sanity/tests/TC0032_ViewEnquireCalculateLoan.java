package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.ViewEnquireCalculateLoanPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC0032_ViewEnquireCalculateLoan {
	
	public WebDriver driver;
	public String baseUrl;
	public static Properties properties;
	public ScreenShot screenShot;
	public ViewEnquireCalculateLoanPOM viewEnquireCalculateLoanPOM;
		
	
	@BeforeClass
	public void setUpBeforeTest() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		//create object
		viewEnquireCalculateLoanPOM=new ViewEnquireCalculateLoanPOM(driver);
		//open url
		driver.get(baseUrl);
		
	}
	
	@Test(priority=1)
	public void mouseHoverOnNewLaunch() throws InterruptedException {
		viewEnquireCalculateLoanPOM.mouseHoverNewLaunch();
		viewEnquireCalculateLoanPOM.clicknullamApartLink();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,200)");
		viewEnquireCalculateLoanPOM.clickNextImage();
		viewEnquireCalculateLoanPOM.sendName("rozina");
		viewEnquireCalculateLoanPOM.sendEmail("rozina@gmail.com");
		viewEnquireCalculateLoanPOM.sendSubject("Apartment");
		viewEnquireCalculateLoanPOM.sendMessage("looking for apartment");
		viewEnquireCalculateLoanPOM.clicksend();
		viewEnquireCalculateLoanPOM.sendSalePrice("40000");
		viewEnquireCalculateLoanPOM.sendDownPayment("2000");
		viewEnquireCalculateLoanPOM.sendYear("2");
		viewEnquireCalculateLoanPOM.sendInterestRate("5");
		viewEnquireCalculateLoanPOM.clickCalculate();
		viewEnquireCalculateLoanPOM.successMessage();
	}

}
