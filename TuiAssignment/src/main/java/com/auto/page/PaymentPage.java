package com.auto.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
	
	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//li[contains(@class,'step_current')]/span")
	private WebElement title;
	
	@FindBy(how = How.XPATH, using = "//p[@class='product-name']/a")
	private WebElement dressName;
	
	@FindBy(how = How.XPATH, using = "//td[@class='cart_total']/span")
	private WebElement dressPrice;
	
	@FindBy(how = How.CSS, using = "a[title='Pay by check.']")
	private WebElement payByChequeLink;
		
	@FindBy(how = How.XPATH, using = "//span[text()='I confirm my order']/parent::button")
	private WebElement clickConfirmOrderButton;
	
	@FindBy(how=How.XPATH, using="//p[contains(@class,'alert-success')]")
	private WebElement orderConfirmationMessage;
	
	public boolean isPaymentTabShowing(WebDriverWait wait, String tabTitle) {
		wait.until((d) -> title.getText().trim().contains(tabTitle));
		return title.getText().trim().contains(tabTitle);
	}
	
	public void clickOnPayByChequeLink() {
		payByChequeLink.click();
	}
	
	public String getDressName() {
		return dressName.getText();
	}
	
	public String getDressPrice() {
		return dressPrice.getText();
	}
	
	public void clickOnConfirmOrderButton() {
		clickConfirmOrderButton.click();
	}

	public boolean isOrderConfirmationMessageShown(WebDriverWait wait, String value) {
		wait.until(ExpectedConditions.textToBePresentInElement(orderConfirmationMessage, value));
		
		if(value.equals(orderConfirmationMessage.getText())){
			return true;
		}
		
		return false;
	}
	
}
