package com.auto.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage {
	
	//li[contains(@class,'step_current')]/span
	
	WebDriver driver;
	
	public AddressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//li[contains(@class,'step_current')]/span")
	private WebElement title;
	
	@FindBy(how=How.NAME, using="processAddress")
	private WebElement proceedToCheckOutButton;
	
	public boolean isAddressTabShowing(WebDriverWait wait, String tabTitle) {
		wait.until((d)->title.getText().trim().contains("Address"));
		return title.getText().trim().contains("Address");
	}
	
	public void clickProceedToCheckOutBtn() {
		proceedToCheckOutButton.click();
	}
}
