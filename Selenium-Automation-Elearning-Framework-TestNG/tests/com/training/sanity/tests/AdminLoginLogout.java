package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLogoutPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminLoginLogout {
	
	public WebDriver driver;
	public String baseUrl;
	public static Properties properties;
	public ScreenShot screenShot;
	public LoginPOM loginPOM;
	public AdminLogoutPOM adminLogoutPOM;
		
	
	@BeforeTest
	public void setUpBeforeTest() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		//create objects for POM files
		loginPOM = new LoginPOM(driver); 
		adminLogoutPOM=new AdminLogoutPOM(driver);
		// open the browser 
		driver.get(baseUrl);
		
	}
   
	@Test(priority=1)      											//log in as a admin
	public void adminLogin() {
		loginPOM.clickRigisterLoginBtn();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		
	}
	
	@Test(priority=3)               //log out from the application
	public void LogOut() {
		adminLogoutPOM.mouseHoverOnHowdyAdmin();
		adminLogoutPOM.clickLogOut();
	}
	
	@AfterTest
	public void closeBroser() {
		driver.close();
	}
}
