package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ChangePasswordPOM;
import com.training.pom.HyperLinkPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC005_PasswordChange {
	public WebDriver driver;
	public String baseUrl;
	public LoginPOM loginPOM;
	private HyperLinkPOM hyperLinkPOM;
	private ChangePasswordPOM changePasswordPOM;
	public static Properties properties;
	public ScreenShot screenShot;
	
	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		hyperLinkPOM=new HyperLinkPOM(driver);
		changePasswordPOM = new ChangePasswordPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();                                  			//close browser
	}
	
	@Test(priority=1)
	public void Login() {                                           //login  in to application as a user
		loginPOM.clickRigisterLoginBtn();
		loginPOM.sendUserName("rozina");
		loginPOM.sendPassword("abcd1234");
		loginPOM.clickLoginBtn();
	}
	
	@Test(priority=2,dependsOnMethods="Login")
	public void ChangePassword() throws IOException {
		hyperLinkPOM.clickBookmark();     						 //click on Bookmark link
		hyperLinkPOM.clickMyProfile();     						//click on Myprofile link
		hyperLinkPOM.clickChangePassword();						//click on change password link
		changePasswordPOM.sendCurrentPassword("abcd1234");
		changePasswordPOM.sendNewPassword("abcd12345");
		changePasswordPOM.sendConfirmPassword("abcd12345");
		changePasswordPOM.clickSaveChanges();
		//screenshot
		screenShot.captureScreenShot("TC005");
		changePasswordPOM.printMessage();
	}

	@Test(priority=3,dependsOnMethods="Login")                  //log out from the application
		public void userLogOut() {
		hyperLinkPOM.clickLogOut();
	}
}
