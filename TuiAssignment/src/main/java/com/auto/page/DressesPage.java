package com.auto.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DressesPage {
	
	WebDriver driver;
	PageHeader pageHeader;

	public DressesPage(WebDriver driver) {
		this.driver = driver;
		this.pageHeader = new PageHeader(this.driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS, using="ul[class*='product_list']")
	private WebElement productList;
	
	@FindBy(how=How.CSS, using="a[title='Proceed to checkout']")
	private WebElement proceedToCheckout;

	public int getNumberOfProductsShown(WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOf(productList));
		return productList.findElements(By.xpath("li")).size();
	}

	public void addDressToCart(String dressName, String shownPrice, WebDriverWait wait) {
		WebElement dressElement =  productList.findElement(By.xpath("//a[@title='"+dressName+"']/following-sibling::div[@class='content_price']/span[@class='price product-price'][contains(text(),'"+shownPrice+"')]/ancestor::li"));	
		Actions acions = new Actions(driver);
		acions.moveToElement(dressElement).perform();
		
		WebElement addToCart  = driver.findElement(By.xpath("//a[@title='"+dressName+"']/following-sibling::div[@class='content_price']/span[@class='price product-price'][contains(text(),'"+shownPrice+"')]/ancestor::li//a[@title='Add to cart']"));
		wait.until(ExpectedConditions.elementToBeClickable(addToCart));
		addToCart.click();
		
		wait.until(ExpectedConditions.visibilityOf(dressElement.findElement(By.xpath("//div[@id='layer_cart'][contains(@style, 'display: block')]"))));
		proceedToCheckout.click();
	}
	
}
