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
		
		Assert.assertEquals(cartSummaryPage.getShoppingCartEmptyMessage(wait), config.get("shopping.cart.empty.message"));
		
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
	public void i_see_dress_is_added_to_cart(String dressName, String price) {
		log.debug("Executing Step : I see dress is added to cart");
		createScenarioDefNode("Then", "I see dress is added to cart");
		
		Assert.assertEquals("1", cartSummaryPage.getNumberOfAddedDressToCart(dressName, price));
		
		log.debug("Finish Executing Step");	
		
	}
	
	@When("I add women dress {string} {string}")
	public void i_add_women_dress(String dressName, String price) {
		log.debug("Executing Step : I add women dress");
		createScenarioDefNode("When", "I add women dress");
		
		accountsPage.getPageHeader().getCategoryMenu().moveToWomenCategory();
		accountsPage.getPageHeader().getCategoryMenu().clickOnSummerDresses(wait);
		Assert.assertTrue(dressesPage.getNumberOfProductsShown(wait)>0, "No dresses found");
				
		dressesPage.addDressToCart(dressName, price, wait);		
		
		log.debug("Finish Executing Step");		
	}

	@When("I am on cart summary page")
	public void i_am_on_cart_summary_page() {
		log.debug("Executing Step : I am on cart summary page");
		createScenarioDefNode("When", "I am on cart summary page");
		
		Assert.assertEquals(getTitle(), config.get("summary.page.title"));
		
		log.debug("Finish Executing Step");		
	}

	@When("I see added dress  {string} {string} qunatity one")
	public void i_see_added_dress_qunatity_one(String dressName, String price) {
		log.debug("Executing Step : I see added dress " + dressName);
		createScenarioDefNode("When", "I see added dress " + dressName);
		
		Assert.assertEquals("1", cartSummaryPage.getNumberOfAddedDressToCart(dressName, price));
		
		log.debug("Finish Executing Step");	
	}

	@When("I click to increase the quantity by one {string} {string}")
	public void i_click_to_increase_the_quantity_by_one(String dressName, String price) {
		log.debug("Executing Step : I click to increase the quantity by one");
		createScenarioDefNode("When", "I click to increase the quantity by one ");
		
		cartSummaryPage.increaseDressQuantity(dressName, price);
		
		log.debug("Finish Executing Step");	
	}

	@Then("Qunatity is increase by one")
	public void qunatity_is_increase_by_one() {
		log.debug("Executing Step : Qunatity is increase by one ");
		createScenarioDefNode("Then", "Qunatity is increase by one ");
		
		Assert.assertTrue( cartSummaryPage.getPageHeader().isCartQuantityEquals(wait, "2"), "Cart qunatity not increased");
		
		log.debug("Finish Executing Step");
	}
	
	@Then("Total cost of items is")
	public void total_cost_of_items_is( DataTable dataTable) {
		List<Map<String, String>> total = dataTable.asMaps(String.class, String.class);
		String totalPrice = total.get(0).get("total");
		
		log.debug("Executing Step :  total_cost_of_items_is " + totalPrice);
		createScenarioDefNode("Then", "Qunatity is increase by one " + totalPrice);
		
		Assert.assertTrue(cartSummaryPage.getPageHeader().isTotalCartPriceEquals(wait, totalPrice), "Total price do not match");
		
		log.debug("Finish Executing Step");
	}
	
	@When("I add item to the cart {string} {string}")
	public void i_add_item_to_the_cart(String dressName, String price) {
		log.debug("Executing Step : I add item to the cart " + dressName);
		createScenarioDefNode("When", "I add item to the cart " + dressName);
		
		accountsPage.getPageHeader().getCategoryMenu().moveToWomenCategory();
		accountsPage.getPageHeader().getCategoryMenu().clickOnSummerDresses(wait);
		Assert.assertTrue(dressesPage.getNumberOfProductsShown(wait)>0, "No dresses found");
		
		dressesPage.addDressToCart(dressName, price, wait);
		
		log.debug("Finish Executing Step");
	}

	@When("I click on empty icon {string} {string}")
	public void i_click_on_empty_icon(String dressName, String price) {
		log.debug("Executing Step : I add item to the cart " + dressName);
		createScenarioDefNode("When", "I add item to the cart " + dressName);
		
		cartSummaryPage.clickOnEmptyIcon(dressName, price);
		
		log.debug("Finish Executing Step");
	}
	
	@Then("Cart is empty")
	public void cart_is_empty() {
		log.debug("Executing Step : Cart is empty");
		createScenarioDefNode("Then", "Cart is empty");
		
		Assert.assertEquals(cartSummaryPage.getShoppingCartEmptyMessage(wait), config.get("shopping.cart.empty.message"));
	}
}
