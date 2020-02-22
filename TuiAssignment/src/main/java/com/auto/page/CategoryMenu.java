package com.auto.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryMenu {
	
	WebDriver driver;

	public CategoryMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS, using="a[title='Women']")
	private WebElement womenMenu;
	
	@FindBy(how=How.CSS, using="a[title='Dresses']")
	private WebElement dressesMenu;
	
	@FindBy(how=How.CSS, using="a[title='T-shirts']")
	private WebElement tshirtsMenu;
	
	@FindBy(how=How.CSS, using="a[title='Summer Dresses']")
	private WebElement summerDressesLink;
	
	public void moveToWomenCategory() {
		Actions acions = new Actions(driver);
		acions.moveToElement(womenMenu).perform();
	}
	
	public void clickOnSummerDresses(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(summerDressesLink));
		summerDressesLink.click();
	}
	
	
}
