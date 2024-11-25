Feature: Login functionality for SauceDemo application

  As a user, I want to be able to log in to the “https://www.saucedemo.com/” application with my valid credentials (username and password), so that I can access the features and products available on the website.

  @positive
  Scenario: Successful login with valid credentials
    Given the user is on the SauceDemo login page
    When the user enters a valid username "standard_user" and password "secret_sauce"
    And the user clicks on the Login button
    Then the user should be redirected to the Inventory dashboard

  @negative
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user is on the SauceDemo login page
    When the user enters an invalid username "<username>" and a valid password "<password>"
    And the user clicks on the Login button
    Then the system should display an error message "<error_message>"

    Examples:
      | username      | password     | error_message                                      |
      | invalid_user  | secret_sauce | Epic sadface: Username and password do not match   |
      | standard_user | wrong_pass   | Epic sadface: Username and password do not match   |

  @negative
  Scenario: Unsuccessful login with both fields empty
    Given the user is on the SauceDemo login page
    When the user leaves both username and password fields empty
    And the user clicks on the Login button
    Then the system should display an error message "Epic sadface: Username is required"

  @negative
  Scenario: Unsuccessful login with empty username
    Given the user is on the SauceDemo login page
    When the user leaves the username field empty and enters a valid password "secret_sauce"
    And the user clicks on the Login button
    Then the system should display an error message "Epic sadface: Username is required"

  @negative
  Scenario: Unsuccessful login with empty password
    Given the user is on the SauceDemo login page
    When the user enters a valid username "standard_user" and leaves the password field empty
    And the user clicks on the Login button
    Then the system should display an error message "Epic sadface: Password is required"