package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VillasTabPOM {
	
	public WebDriver driver;
	
	public VillasTabPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Villas")
	private WebElement villasTab;
	
//	@FindBy()
//	private WebElement 
//	
//	
//	public void clickVillasTab() {
//		this.villasTab.click();
//	}

}
