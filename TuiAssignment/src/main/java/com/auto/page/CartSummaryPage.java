package com.auto.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage {
	
	WebDriver driver;
	PageHeader pageHeader;
	CartSummaryFooter cartSummaryFooter;

	public CartSummaryPage(WebDriver driver) {
		this.driver = driver;
		this.pageHeader = new PageHeader(this.driver);
		this.cartSummaryFooter = new CartSummaryFooter(this.driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how=How.CSS, using="p[class*='alert-warning']")
	private WebElement shoppingCartEmptyMessage;
	
	public PageHeader getPageHeader() {
		return this.pageHeader;
	}
	
	public CartSummaryFooter getCartSummaryFooter() {
		return this.cartSummaryFooter;
	}
	
	public String getShoppingCartEmptyMessage(WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOf(shoppingCartEmptyMessage));
		return shoppingCartEmptyMessage.getText();
	}
	
	public String getNumberOfAddedDressToCart(String dressName, String price) {
		WebElement element = driver.findElement(By.xpath(
				"//a[text()='"+dressName+"']/ancestor::tr/td[@class='cart_unit']/span/span[contains(@class, 'special-price')][contains(text(),'"+price+"')]/ancestor::tr//td[contains(@class, 'cart_quantity')]/input[@type='hidden']"));
		return element.getAttribute("value");
	}
	
	public void increaseDressQuantity(String dressName, String price) {
		WebElement addQunatity =  driver.findElement(By.xpath("//a[text()='Printed Summer Dress']/ancestor::tr/td[@class='cart_unit']/span/span[contains(@class, 'special-price')][contains(text(),'$28.98')]/ancestor::tr//td[contains(@class, 'cart_quantity')]//a[@title='Add']"));
		addQunatity.click();
	}

	public void clickOnEmptyIcon(String dressName, String price) {
		WebElement addQunatity =  driver.findElement(By.xpath("//a[text()='"+dressName+"']/ancestor::tr/td[@class='cart_unit']/span/span[contains(@class, 'special-price')][contains(text(),'"+price+"')]/ancestor::tr//a[@title='Delete']"));
		addQunatity.click();
	}

}
