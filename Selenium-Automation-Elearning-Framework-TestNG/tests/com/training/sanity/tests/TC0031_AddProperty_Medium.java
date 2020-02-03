package com.training.sanity.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import com.training.pom.AddAndViewPropertyPOM;

public class TC0031_AddProperty_Medium extends AdminLoginLogout{
	private AddAndViewPropertyPOM addAndViewPropertyPOM;
	
/*	@BeforeClass
	public void setUpBeforeTest() {
		addAndViewPropertyPOM=new addAndViewPropertyPOM(driver);
	}*/
	
	
	@Test(priority=2)
	public void addProperty() throws InterruptedException{
		
		addAndViewPropertyPOM=new AddAndViewPropertyPOM(driver);
		addAndViewPropertyPOM.mouseHoverProperties();
		addAndViewPropertyPOM.clikAddNewLink();
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
		//js.executeScript("window.scrollTo(0,document.body.scrollToHeight)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		addAndViewPropertyPOM.clickDetailsTab();
		addAndViewPropertyPOM.sendStorageRoom("2");
		js.executeScript("window.scrollTo(0,200)");                //scroll up
	    addAndViewPropertyPOM.selectRegion();                       //select Central Bangalore checkBox  inside KeywordTgs
		addAndViewPropertyPOM.clickPublish();
	}

}
