package com.auto.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	PageHeader pageHeader;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		this.pageHeader = new PageHeader(this.driver);
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(how = How.CSS, using= "a[class=login]")
	private WebElement signInLink;
	 
	public void clickSignInLink() {
		signInLink.click();
	}
		
	public PageHeader getPageHeader() {
		return this.pageHeader;
	}
	
}
