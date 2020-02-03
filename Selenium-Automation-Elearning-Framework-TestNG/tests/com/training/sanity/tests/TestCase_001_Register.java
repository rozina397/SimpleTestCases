package com.training.sanity.tests;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.training.pom.RegisterPOM;

public class TestCase_001_Register extends AdminLoginLogout{
	

	private RegisterPOM registerPOM;
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	} 
	

	
	@Test(priority=2,dependsOnMethods="adminLogin")                                           //create a new user
	public void registerNewUser() throws InterruptedException, IOException {
		registerPOM=new RegisterPOM(driver);
		
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
	
}
