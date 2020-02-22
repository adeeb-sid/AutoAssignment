package com.auto.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {
	
	WebDriver driver;
	PageHeader pageHeader;

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		this.pageHeader = new PageHeader(this.driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using="//a[@class='account']/span")
	private WebElement userName;
	
	@FindBy(how = How.XPATH, using="//div[contains(@class, 'alert-danger')]//li")
	private WebElement errorMessage;
	
	public PageHeader getPageHeader() {
		return this.pageHeader;
	}
	
	public String getUserName() {
		return userName.getText();
	}
	
	public String getErrorMessage() {
		return errorMessage.getText();
	}
}
