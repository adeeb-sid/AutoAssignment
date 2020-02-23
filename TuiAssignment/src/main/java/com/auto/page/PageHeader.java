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

public class PageHeader {
	
	WebDriver driver;
	CategoryMenu categoryMenu;

	public PageHeader(WebDriver driver) {
		this.driver = driver;
		this.categoryMenu = new CategoryMenu(this.driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS, using= "a[title*='shopping cart']")
	private WebElement cartLink;
	
	@FindBy(how = How.CSS, using= "div[class='shopping_cart']")
	private WebElement cart;
	
	@FindBy(how = How.ID, using= "search_query_top")
	private WebElement searchBox;
	
	@FindBy(how = How.NAME, using= "submit_search")
	private WebElement searchButton;
	
	@FindBy(how = How.CSS, using= "div[class='ac_results']")
	private WebElement searchResultDropdown;
	
	@FindBy(how = How.XPATH, using= "//div[@class='shopping_cart']//span[@class='ajax_cart_quantity']")
	private WebElement cartQuantity;
	
	@FindBy(how = How.XPATH, using= "//div[@class='cart-prices-line last-line']/span[contains(@class, 'ajax_block_cart_total')]")
	private WebElement totalCartPrice;
	
	public void clickOnCartLink() {
		this.cartLink.click();
	}
	
	public void enterSearch(String searchText) {
		searchBox.clear();
		searchBox.sendKeys(searchText);
	}
	
	public CategoryMenu getCategoryMenu() {
		return this.categoryMenu;
	}
	
	public boolean isCartQuantityEquals(WebDriverWait wait, String value) {
		wait.until(ExpectedConditions.textToBePresentInElement(cartQuantity, value));
		
		if(value.equals(cartQuantity.getText())){
			return true;
		}
		
		return false;
	}
	
	public void moveToCart() {
		Actions actions = new Actions(driver);
		actions.moveToElement(this.cartLink).perform();
	}
	
	public boolean isTotalCartPriceEquals(WebDriverWait wait, String value) {
		this.moveToCart();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'exclusive')][contains(@style, 'display: block')]"))));
		wait.until(ExpectedConditions.textToBePresentInElement(totalCartPrice, value));
		
		if(value.equals(totalCartPrice.getText())) {
			return true;
		}
		
		return false;
	}
}
