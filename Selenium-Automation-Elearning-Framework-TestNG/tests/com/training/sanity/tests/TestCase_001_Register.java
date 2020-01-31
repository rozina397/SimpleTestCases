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
import com.training.pom.AdminLogoutPOM;
import com.training.pom.LoginPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestCase_001_Register{
	

	public WebDriver driver;
	public String baseUrl;
	public LoginPOM loginPOM;
	public static Properties properties;
	public ScreenShot screenShot;
	private RegisterPOM registerPOM;
	private AdminLogoutPOM logoutPOM ;
	//ExtentReports extent;
	//ExtentTest logger;
	
	
	
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
		logoutPOM=new AdminLogoutPOM(driver);
		registerPOM=new RegisterPOM(driver);
		registerPOM = new RegisterPOM(driver); 
		
		// open the browser 
		driver.get(baseUrl);
		
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	} 
	
	@Test(priority=1)      											//log in as a admin
	public void adminLogin() {
		loginPOM.clickRigisterLoginBtn();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		
	}
	
	@Test(priority=2,dependsOnMethods="adminLogin")                                           //create a new user
	public void registerNewUser() throws InterruptedException, IOException {
		registerPOM.clickOnUsers();
		registerPOM.clickAddNewUsers();
		registerPOM.sendUserName("rozina");
		registerPOM.sendEmail("rozina@gmail.com");
		registerPOM.sendFirstName("rozina");
		registerPOM.sendLastNmae("khatun");
		registerPOM.clickShowPassword();
		registerPOM.sendPassword("abcd1234");
		registerPOM.clickCheckBox();  
		JavascriptExecutor js=(JavascriptExecutor)driver;                   
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");		//scroll down
		registerPOM.clickToselectRole();
		registerPOM.clickSubmitBtn();
		//screenshot
		screenShot.captureScreenShot("First");
		
	}
	
	
	@Test(priority=3,dependsOnMethods="adminLogin")               //log out from the application
	public void LogOut() {
		logoutPOM.mouseHoverOnHowdyAdmin();
		logoutPOM.clickLogOut();
	}
}
