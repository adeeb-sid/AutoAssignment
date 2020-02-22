package com.auto.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage {
	
	WebDriver driver;
	PageHeader pageHeader;
	
	public AuthenticationPage(WebDriver driver) {
		this.driver = driver;
		this.pageHeader = new PageHeader(this.driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using="email")
	private WebElement emailTextBox;
	
	@FindBy(how=How.ID, using="passwd")
	private WebElement passwordTextBox;
	
	@FindBy(how=How.ID, using="SubmitLogin")
	private WebElement signInButton;
	
	@FindBy(how=How.CSS, using="h1[class='page-heading']")
	private static WebElement pageHeading;
	
	public PageHeader getPageHeader() {
		return this.pageHeader;
	}
	
	public void enterEmail(String email) {
		emailTextBox.clear();
		emailTextBox.sendKeys(email);;
	}
	
	public void enterPassword(String password) {
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);;
	}
	
	public void clickSignInButton() {
		signInButton.click();
	}
	
	public String getPageHeading() {
		return pageHeading.getText();
	}
	
	public void doLogin(String email, String password) {
		this.enterEmail(email);
		this.enterPassword(password);
		this.clickSignInButton();
	}
}
