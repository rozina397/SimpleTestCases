package com.training.sanity.tests;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.training.pom.AddAndViewPropertyPOM;

public class TC0031_AddProperty_Medium extends AdminLoginLogout{
	private AddAndViewPropertyPOM addAndViewPropertyPOM;
	public ExtentReports extent;
	public ExtentTest logger;

	@Test(priority=2)
	public void addProperty() throws InterruptedException{
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/TC031.html",true);
		extent.loadConfig(new File(System.getProperty("user-dir")+"\\extent-config.xml"));
		logger=extent.startTest("Add new property");
		
		addAndViewPropertyPOM=new AddAndViewPropertyPOM(driver);
		addAndViewPropertyPOM.mouseHoverProperties();
		addAndViewPropertyPOM.clikAddNewLink();
		Thread.sleep(3000);
		addAndViewPropertyPOM.sendTitle("new launch1");
		addAndViewPropertyPOM.writeIntoTextbox("new launch1");
		addAndViewPropertyPOM.sendPrice("50000.00");
		addAndViewPropertyPOM.sendPricePerSq("200.00");
		
		addAndViewPropertyPOM.clickMainDetails();
		addAndViewPropertyPOM.sendStatus("New");
		addAndViewPropertyPOM.sendLocation("Electronic city");
		addAndViewPropertyPOM.sendPossession("immediate");
		
		addAndViewPropertyPOM.clickLocationTab();
		addAndViewPropertyPOM.sendAddress("yeshwanthapur");
		addAndViewPropertyPOM.sendMapAddress("yeshwanthapur");
		addAndViewPropertyPOM.sendLatitude("120");
		addAndViewPropertyPOM.sengLongitude("56");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		addAndViewPropertyPOM.clickDetailsTab();
		addAndViewPropertyPOM.sendStorageRoom("2");
		js.executeScript("window.scrollTo(0,200)");                //scroll up
	    addAndViewPropertyPOM.selectRegion();                       //select Central Bangalore checkBox  inside KeywordTgs
		addAndViewPropertyPOM.clickPublish();
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}

}
