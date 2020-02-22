package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.auto.page.InitializePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingCartStep extends InitializePage{
	
	@Given("I am logged into automation practice with email and password")
	public void i_am_logged_into_automation_practice_with_email_and_password(DataTable dataTable) {
		log.debug("Executing Step : I am logged into automation practice with email and password");
		createScenarioDefNode("Given", "i_am_logged_into_trello_with_email_and_password");
		
		List<Map<String, String>> loginDetails = dataTable.asMaps(String.class, String.class);
		driver.get(loginDetails.get(0).get("url"));
		landingPage.clickSignInLink();
		authenticationPage.doLogin(loginDetails.get(0).get("email"), loginDetails.get(0).get("password"));
		
		log.debug("Finish Executing Step");
	}

	@When("I click on cart link")
	public void i_click_on_cart_link() {
		log.debug("Executing Step : I click on cart link");
		createScenarioDefNode("When", "I click on cart link");
		
	    accountsPage.getPageHeader().clickOnCartLink();
	    
	    log.debug("Finish Executing Step");
	}

	@When("I am on shopping cart summary page")
	public void i_am_on_shopping_cart_summary_page() {
		log.debug("Executing Step : I am on shopping cart summary page");
		createScenarioDefNode("When", "I am on shopping cart summary page");
		
		Assert.assertEquals(getTitle(), config.get("summary.page.title"));
		
		log.debug("Finish Executing Step");
	}

	@Then("I see shopping cart is empty")
	public void i_see_shopping_cart_is_empty() {
		log.debug("Executing Step : I see shopping cart is empty");
		createScenarioDefNode("Then", "I see shopping cart is empty");
		
		Assert.assertEquals(cartSummaryPage.getShoppingCartEmptyMessage(), config.get("shopping.cart.empty.message"));
		
		log.debug("Finish Executing Step");
	}
	
	@When("I click on woman link")
	public void i_click_on_woman_link() {
		log.debug("Executing Step : I click on woman link");
		createScenarioDefNode("When", "I click on woman link");
		
		accountsPage.getPageHeader().getCategoryMenu().moveToWomenCategory();
		
		log.debug("Finish Executing Step");
	}

	@When("I click on summer dresses")
	public void i_click_on_summer_dresses() {
		log.debug("Executing Step : I click on summer dresses");
		createScenarioDefNode("When", "I click on summer dresses");
		
		accountsPage.getPageHeader().getCategoryMenu().clickOnSummerDresses(wait);
		Assert.assertTrue(dressesPage.getNumberOfProductsShown(wait)>0, "No dresses found");
		
		log.debug("Finish Executing Step");
	}
	
	@When("I add dress to the cart {string} {string}")
	public void i_add_dress_to_the_cart(String dressName, String price) {
		log.debug("Executing Step : I add dress to the cart");
		createScenarioDefNode("When", "I add dress to the cart");
		
		dressesPage.addDressToCart(dressName, price, wait);
		Assert.assertEquals(getTitle(), config.get("summary.page.title"));
		
		log.debug("Finish Executing Step");
	}

	@Then("I see dress is added to cart {string} {string}")
	public void i_see_dress_is_added_to_cart(String name, String price) {
		log.debug("Executing Step : I see dress is added to cart");
		createScenarioDefNode("Then", "I see dress is added to cart");
		
		
		log.debug("Finish Executing Step");	
		
	}
}
