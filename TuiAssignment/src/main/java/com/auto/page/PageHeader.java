package com.auto.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(how = How.ID, using= "search_query_top")
	private WebElement searchBox;
	
	@FindBy(how = How.NAME, using= "submit_search")
	private WebElement searchButton;
	
	@FindBy(how = How.CSS, using= "div[class='ac_results']")
	private WebElement searchResultDropdown;
	
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
}
