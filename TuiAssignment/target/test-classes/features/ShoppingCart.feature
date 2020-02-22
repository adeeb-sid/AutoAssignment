@ShoppingCart
Feature: Shopping Cart functionality
  As a customer of automation practice
  I want to add items to the shopping cart

  Background: I navigates to automation practice  page
	  Given I am logged into automation practice with email and password
	  |url 																		 | email 							 | password |
	  |http://automationpractice.com/index.php | masidd@gmaill.com   | auto1    |
	  And I am on accounts page
	  

	Scenario Outline:: Add items to carts
	  When I click on woman link
	  And I click on summer dresses
	  And I add dress to the cart "<name>" "<price>"
	  Then I see dress is added to cart "<name>" "<price>"
	  Examples:
	  |name                 |price  |
	  |Printed Summer Dress |$28.98 |
	  
	  