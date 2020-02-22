package com.auto.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartSummaryPage {
	
	WebDriver driver;
	PageHeader pageHeader;

	public CartSummaryPage(WebDriver driver) {
		this.driver = driver;
		this.pageHeader = new PageHeader(this.driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS, using="p[class*='alert-warning']")
	private WebElement shoppingCartEmptyMessage;
	
	public String getShoppingCartEmptyMessage() {
		return shoppingCartEmptyMessage.getText();
	}
	
	public String getNumberOfAddedDressToCart(String dressName, String price) {
		WebElement element = driver.findElement(By.xpath(
				"//a[text()='"+dressName+"']/ancestor::tr//span/span[@class='price'][contains(text(),'"+price+"')]/ancestor::tr//td[contains(@class, 'cart_quantity')]/input[@type='hidden']"));
		return element.getAttribute("value");
	}

}
