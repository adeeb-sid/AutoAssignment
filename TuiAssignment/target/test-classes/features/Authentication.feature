@Login
Feature: Login functionality
  As a customer
  In order to use automationpractice
  I want to login with email and password

  Background: I navigates to automationpractice login page
    Given I enter the url "http://automationpractice.com/index.php" in the browser
    And I click on the sign in button on landing page
    Then I am on authentication page
    And I should see "Authentication" message

  Scenario: Logging in with valid credentials
    When I fill in email with "masidd@gmaill.com"
    And I fill in password with "auto1"
    And I click on the sign in button on authentication page
    Then I am on accounts page
    And  I am logged in as "Auto Test"
    
Scenario Outline: Failed login using wrong credentials
		When I fill in email with "<email>"
    And I fill in password with "<password>"
    And I click on the sign in button on authentication page
    And I should see error "<error>" message
    Examples:
      | email               | password   | error                      |
      | masidd@gmail.com    | !auto1     | Authentication failed.     |
      | masidd@gmail.com    |            | Password is required.      |
      |                     |  auto1     | An email address required. |      


