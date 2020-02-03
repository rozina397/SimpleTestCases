package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CommercialTabPOM {
	
	private WebDriver driver;
	
	public CommercialTabPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Commercial")
	private WebElement commercialLink;
	
	@FindBy(id="keyword_search")
	private WebElement address;
	
	@FindBy(xpath="//button[@class='button fullwidth']")
	private WebElement searchButton;
	
	@FindBy(xpath="//h1[contains(text(),'Nothing Found')]")
	private WebElement message;
	
	@FindBy(xpath="//a[@class='button fullwidth margin-top-20']")
	private WebElement dropLine;
	
	@FindBy(name="name")
	private WebElement yourName;
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="subject")
	private WebElement subject;
	
	@FindBy(xpath="//textarea[@placeholder='Message']")
	private WebElement messageText;
	
	
	@FindBy(xpath="//*[@type='submit']")
	private WebElement send;
	
	@FindBy(xpath="//input[@type=\"submit\"]/parent::p/following-sibling::div")
	private WebElement alert;
	
	@FindBy(xpath="//ul//li/child::a[contains(text(),'Villas')]")
	private WebElement villasTab;
	
	public void clickCommercialTab() {
		this.commercialLink.click();
	}
	
	public void eneterAddress(String address) {
		this.address.clear();
		this.address.sendKeys(address);
	}
	
	public void clcikSearchButton() throws InterruptedException {
		//Thread.sleep(3000);
		this.searchButton.click();
		System.out.println(this.message.getText());
	}
	
	public void clickDropLine() {
		this.dropLine.click();
	}
	
	public void sendName(String yourName) {
		this.yourName.clear();
		this.yourName.sendKeys(yourName);
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendSubject(String subject) {
		this.subject.clear();
		this.subject.sendKeys(subject);
	}
	
	public void sendMessage(String messageText) {
		this.messageText.clear();
		this.messageText.sendKeys(messageText);
	}
	
	public void clcikSend() throws InterruptedException {
		this.send.click();
		Thread.sleep(3000);
		Assert.assertEquals(this.alert.getText(), "There was an error trying to send your message. Please try again later.");
		System.out.println(this.alert.getText());
	}
	
	public void clickVillasTab() {
		this.villasTab.click();
	}
}
