package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.training.pom.AddAndViewPropertyPOM;

public class TC0033_ViewAddedPropertyDetails  extends AdminLoginLogout{
	
	private AddAndViewPropertyPOM addAndViewPropertyPOM;
	
	@Test(priority=2)
	public void viewPropertyDeatils() {
		//String propertyTitle="new launch2";
		logger=extent.startTest("TO verify whether application allows admin to view added property details in All Properties window");
		addAndViewPropertyPOM=new AddAndViewPropertyPOM(driver);
		addAndViewPropertyPOM.mouseHoverProperties();
		logger.log(LogStatus.INFO,"adding new property");
		addAndViewPropertyPOM.clikAddNewLink();
		addAndViewPropertyPOM.sendTitle("new launch2");
		addAndViewPropertyPOM.writeIntoTextbox("new launch2");
		addAndViewPropertyPOM.clickPublish();
		addAndViewPropertyPOM.clickAllPropertiesLink();
		addAndViewPropertyPOM.searchProperty("new launch2");
		
		//screenShot.captureScreenShot("view added property");
		if(addAndViewPropertyPOM.isViewAddedProperty("new launch2"))
		{
			logger.log(LogStatus.PASS, "found adder property");
		}
		else {
			logger.log(LogStatus.FAIL, "not found added property");
		}
		
		extent.endTest(logger);
		//screenshot
		screenShot.captureScreenShot("TC0033");
	}

}
