@ShoppingCart
Feature: Shopping Cart functionality
  As a customer of automation practice
  I want to add items to the shopping cart

  Background: I navigates to automation practice  page
	  Given I am logged into automation practice with email and password
	  |url 																		 | email 							 | password |
	  |http://automationpractice.com/index.php | masidd@gmaill.com   | auto1    |
	  And I am on accounts page
	  
	Scenario: Verify shopping cart is empty
	  When I click on cart link
	  And I am on shopping cart summary page
	  Then I see shopping cart is empty
	  
	Scenario Outline: Add items to carts
	  When I click on woman link
	  And I click on summer dresses
	  And I add dress to the cart "<name>" "<price>"
	  Then I see dress is added to cart "<name>" "<price>"
	  Examples:
	  |name                  |price  |
	  |Printed Summer Dress  |$28.98 |
	  |Printed Chiffon Dress |$16.40 |
	  
	Scenario Outline: Increase the item count in the cart
	  When I add women dress "<name>" "<price>"
	  And I am on cart summary page 
	  And I see added dress  "<name>" "<price>" qunatity one
	  And I click to increase the quantity by one "<name>" "<price>"
	  Then Qunatity is increase by one
	  And Total cost of items is
	  |total   |
	  |$59.96 |
	  Examples:
	  |name                  |price  |
	  |Printed Summer Dress  |$28.98 |
	 
	Scenario Outline: Empty cart
	  When I add item to the cart "<name>" "<price>"
	  And I am on cart summary page 
	  And I click on empty icon "<name>" "<price>"
	  Then Cart is empty
	  Examples:
	  |name                  |price  |
	  |Printed Summer Dress  |$28.98 |
	  	 
	  

	  
	  
	  