package stepDefinitions;

import org.testng.Assert;

import com.auto.page.InitializePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthenticationStep extends InitializePage{

	@Given("I enter the url {string} in the browser")
	public void i_enter_the_url_in_the_browser(String url) {
		log.debug("Executing Step : Given I enter the url: " + url);
		createScenarioDefNode("Given", "I enter the automation practice url " + url +"in the browser");
	    driver.get(url);
	    Assert.assertEquals(getTitle(), config.get("landing.page.title"));
	    log.debug("Finish Executing Step");
	}

	@Given("I click on the sign in button on landing page")
	public void i_click_on_the_sign_in_button_on_landing_page() {
		log.debug("Executing Step : Given I click on the sign in button on landing page");
		createScenarioDefNode("Given", "I click on the sign in button on landing page");
	    landingPage.clickSignInLink();
	    log.debug("Finish Executing Step");
	}

	@Then("I am on authentication page")
	public void i_am_on_authentication_page() {
		log.debug("Executing Step : Then I am on authentication page");
		createScenarioDefNode("Then", "I am on authentication page");
		Assert.assertEquals(getTitle(), config.get("authentication.page.title"));
		log.debug("Finish Executing Step");
	}

	@Then("I should see {string} message")
	public void i_should_see_message(String message) {
		log.debug("Executing Step : I should see message : " + message);
		createScenarioDefNode("Then", "I should see message : " + message);
		Assert.assertEquals(authenticationPage.getPageHeading().toUpperCase(), message.toUpperCase());
		log.debug("Finish Executing Step");
	}

	@When("I fill in email with {string}")
	public void i_fill_in_email_with(String email) {
		log.debug("Executing Step : I fill in email with: " + email);
		createScenarioDefNode("When", "I fill in email with: " + email);
		authenticationPage.enterEmail(email);
		log.debug("Finish Executing Step");
	}

	@When("I fill in password with {string}")
	public void i_fill_in_password_with(String password) {
		log.debug("Executing Step : I fill in password with: " + password);
		createScenarioDefNode("When", "I fill in password with: " + password);
		authenticationPage.enterPassword(password);
		log.debug("Finish Executing Step");
	}

	@When("I click on the sign in button on authentication page")
	public void i_click_on_the_sign_in_button_on_authentication_page() {
		log.debug("Executing Step : I click on the sign in button on authentication page");
		createScenarioDefNode("When", "I click on the sign in button on authentication page");
		authenticationPage.clickSignInButton();
		log.debug("Finish Executing Step");
	}

	@Then("I am on accounts page")
	public void i_am_on_accounts_page() {
		log.debug("Executing Step : I am on accounts page");
		createScenarioDefNode("Then", "I am on accounts page");
		Assert.assertEquals(getTitle(), config.get("account.page.title"));
		log.debug("Finish Executing Step");
	}

	@Then("I am logged in as {string}")
	public void i_am_logged_in_as(String username) {
		log.debug("Executing Step : I am logged in as : " + username);
		createScenarioDefNode("Then", "I am on accounts page");
		Assert.assertEquals(accountsPage.getUserName(), username);
		log.debug("Finish Executing Step");
	}

	@When("I should see error {string} message")
	public void i_should_see_error_message(String errorMessage) {
		log.debug("Executing Step : I should see error message : " + errorMessage);
		createScenarioDefNode("Then", "I should see error message : " + errorMessage);
		Assert.assertEquals(accountsPage.getErrorMessage(), errorMessage);
		log.debug("Finish Executing Step");
	}
	
}
