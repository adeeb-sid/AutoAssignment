@Checkout
Feature: Checkout functionality
  As a customer of automation practice
  I want to add the item shopping cart and
  then buy the item in the shopping cart

  Background: I navigates to automation practice  page
	  Given I am logged into automation practice with email and password
	  |url 																		 | email 							 | password |
	  |http://automationpractice.com/index.php | masidd@gmaill.com   | auto1    |
	  And I am on accounts page

	Scenario Outline: Checkout and buy item in the cart
	  When I add item to the cart "<name>" "<price>"
	  And I am on cart summary page 
	  And I see item is added to the cart "<name>" "<price>"
	  And I click Proceed to checkout button
	  And I am on Address page
	  And  I click Proceed to checkout button on address page
	  And Iam on shipping and I agree with terms of service
	  And I click Proceed to checkout button on shipping page
	  And I am on payment page and verify the product "<name>" "<price>" and choose pay by check
	  And I click confirm my order
	  Then I see complete order message
	  Examples:
	  |name                  |price  |
	  |Printed Summer Dress  |$28.98 |