package com.auto.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingPage {

	WebDriver driver;

	public ShippingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//li[contains(@class,'step_current')]/span")
	private WebElement title;
	
	@FindBy(how = How.ID, using = "cgv")
	private WebElement termsOfService;

	@FindBy(how = How.NAME, using = "processCarrier")
	private WebElement proceedToCheckOutButton;

	public boolean isShippingTabShowing(WebDriverWait wait, String tabTitle) {
		wait.until((d) -> title.getText().trim().contains(tabTitle));
		return title.getText().trim().contains(tabTitle);
	}

	public void clickProceedToCheckOutBtn() {
		proceedToCheckOutButton.click();
	}
	
	public void clickTermsOfServiceCheckBox() {
		termsOfService.click();
	}

}
