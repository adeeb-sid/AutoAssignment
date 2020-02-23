package com.auto.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryFooter {
	
	WebDriver driver;

	public CartSummaryFooter(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS, using="a[class*='standard-checkout']")
	private WebElement proceedToCheckout;
	
	public void clickOnCheckoutButton(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout));
		proceedToCheckout.click();
	}

	
	
}
