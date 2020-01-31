package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.ChangeProfileDetailsPOM;
import com.training.pom.HyperLinkPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC004_ChangeProfileDetails{
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenshot;
	private ChangeProfileDetailsPOM changeProfileDetailsPOM;
	private HyperLinkPOM hyperLinkPOM;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		hyperLinkPOM=new HyperLinkPOM(driver);
		changeProfileDetailsPOM=new ChangeProfileDetailsPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenshot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();                            //close browser
	}
	
	@Test(priority=1)
	public void Login() {                                            //log in as a user
		loginPOM.clickRigisterLoginBtn();
		loginPOM.sendUserName("rozina");
		loginPOM.sendPassword("abcd1234");
		loginPOM.clickLoginBtn();
	}
	
	@Test(priority=2,dependsOnMethods="Login")
	public void changeProfileDetails() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");                    //scroll the page down
		hyperLinkPOM.clickBookmark(); 									//click on Bookmark link
		hyperLinkPOM.clickMyProfile();                                 //click on MyProfile link
		js.executeScript("window.scrollBy(0,300)");                    //scroll down
		changeProfileDetailsPOM.sendAgentTitle("xyz");
		changeProfileDetailsPOM.sendPhoneNo("1234567890");
		changeProfileDetailsPOM.clickSaveChanges();
		//screenshot
			screenshot.captureScreenShot("TC004");
	}
	
	@Test(priority=3,dependsOnMethods="Login")                       //log out from the application
	public void userLogOut() {
		hyperLinkPOM.clickLogOut();
	}
	
}
