package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.pom.AddAndViewPropertyPOM;

public class TC0033_ViewAddedPropertyDetails  extends AdminLoginLogout{
	
	private AddAndViewPropertyPOM addAndViewPropertyPOM;
	
	@Test(priority=2)
	public void viewPropertyDeatils() {
		addAndViewPropertyPOM=new AddAndViewPropertyPOM(driver);
		addAndViewPropertyPOM.mouseHoverProperties();
		addAndViewPropertyPOM.clikAddNewLink();
		addAndViewPropertyPOM.sendTitle("new launch2");
		addAndViewPropertyPOM.writeIntoTextbox("new launch2");
		addAndViewPropertyPOM.clickPublish();
		addAndViewPropertyPOM.clickAllPropertiesLink();
		
		
	}

}
