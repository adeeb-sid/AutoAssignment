package stepDefinitions;

import org.testng.Assert;

import com.auto.page.InitializePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckOutCartsStep extends InitializePage{
	
	@When("I see item is added to the cart {string} {string}")
	public void i_see_item_is_added_to_the_cart(String dressName, String price) {
		
		log.debug("Executing Step : I see item is added to the cart : " + dressName);
		createScenarioDefNode("Then", "I see item is added to the cart : " + dressName);
		
		Assert.assertEquals("1", cartSummaryPage.getNumberOfAddedDressToCart(dressName, price));
		
		log.debug("Finish Executing Step");	
	}

	@When("I click Proceed to checkout button")
	public void i_click_Proceed_to_checkout_button() {
		log.debug("Executing Step : I click Proceed to checkout button");
		createScenarioDefNode("When", "I click Proceed to checkout button");
		
		cartSummaryPage.getCartSummaryFooter().clickOnCheckoutButton(wait);
		
		log.debug("Finish Executing Step");
	}

	@When("I am on Address page")
	public void i_am_on_Address_page_and_address_is_correct() {
		log.debug("Executing Step : I am on Address page");
		createScenarioDefNode("When", "I am on Address page");
		
		Assert.assertTrue(addresspage.isAddressTabShowing(wait, (String)config.get("address.tab.title")), "Not on Address tab");
		
		log.debug("Finish Executing Step");
	}
	
	@When("I click Proceed to checkout button on address page")
	public void i_click_Proceed_to_checkout_button_on_address_page() {
		log.debug("Executing Step : I click Proceed to checkout button on address page");
		createScenarioDefNode("When", "I click Proceed to checkout button on address page");
		
		addresspage.clickProceedToCheckOutBtn();
		
		log.debug("Finish Executing Step");
	}

	@When("Iam on shipping and I agree with terms of service")
	public void iam_on_shipping_and_I_agree_with_terms_of_service() {
		log.debug("Executing Step : Iam on shipping and I agree with terms of service");
		createScenarioDefNode("When", "Iam on shipping and I agree with terms of service");
		
		Assert.assertTrue(shippingPage.isShippingTabShowing(wait, (String)config.get("shipping.tab.title")));
		shippingPage.clickTermsOfServiceCheckBox();
		
		log.debug("Finish Executing Step");
	}
	
	
	@When("I click Proceed to checkout button on shipping page")
	public void i_click_Proceed_to_checkout_button_on_shipping_page() {
		log.debug("Executing Step : I click Proceed to checkout button on shipping page");
		createScenarioDefNode("When", "I click Proceed to checkout button on shipping page");
		
		shippingPage.clickProceedToCheckOutBtn();
		
		log.debug("Finish Executing Step");
	}	

	@When("I am on payment page and verify the product {string} {string} and choose pay by check")
	public void i_am_on_payment_page_and_verify_the_product_and_choose_pay_by_check(String dressName, String price) {
		log.debug("Executing Step : I am on payment page and verify the product and choose pay by check");
		createScenarioDefNode("When", "I am on payment page and verify the product and choose pay by check");
		
		Assert.assertTrue(paymentPage.isPaymentTabShowing(wait,  (String)config.get("payment.tab.title")));
		
		Assert.assertEquals(paymentPage.getDressName(), dressName);
		
		Assert.assertEquals(paymentPage.getDressPrice(), price);
		
		paymentPage.clickOnPayByChequeLink();
		
		log.debug("Finish Executing Step");
	}	


	@When("I click confirm my order")
	public void i_click_confirm_my_order() {
		log.debug("Executing Step : I click confirm my order");
		createScenarioDefNode("When", "I click confirm my order");
		
		paymentPage.clickOnConfirmOrderButton();
		
		log.debug("Finish Executing Step");
	}

	@Then("I see complete order message")
	public void i_see_complete_order_message() {
		log.debug("Executing Step : I see complete order message");
		createScenarioDefNode("When", "I see complete order message");
		
		Assert.assertTrue(paymentPage.isOrderConfirmationMessageShown(wait, (String)config.get("order.confirm.message")));
		
		log.debug("Finish Executing Step");
	}
}
