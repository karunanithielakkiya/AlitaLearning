Feature: User Login to SauceDemo Application

  @positive
  Scenario: Successful login with valid credentials
    Given the user is on the login page at "https://www.saucedemo.com/"
    When the user enters a valid username "standard_user" and a valid password "secret_sauce"
    And the user clicks on the Login button
    Then the user should be redirected to the Inventory dashboard

  @negative
  Scenario: Login attempt with missing username
    Given the user is on the login page at "https://www.saucedemo.com/"
    When the user leaves the username field empty
    And the user enters a valid password "secret_sauce"
    And the user clicks on the Login button
    Then the user should see an error message "Epic sadface: Username is required"

  @negative
  Scenario: Login attempt with missing password
    Given the user is on the login page at "https://www.saucedemo.com/"
    When the user enters a valid username "standard_user"
    And the user leaves the password field empty
    And the user clicks on the Login button
    Then the user should see an error message "Epic sadface: Password is required"

  @negative
  Scenario: Login attempt with invalid credentials
    Given the user is on the login page at "https://www.saucedemo.com/"
    When the user enters an invalid username "invalid_user" and an invalid password "invalid_pass"
    And the user clicks on the Login button
    Then the user should see an error message "Epic sadface: Username is required"

  @negative
  Scenario: Login attempt with both fields empty
    Given the user is on the login page at "https://www.saucedemo.com/"
    When the user leaves both username and password fields empty
    And the user clicks on the Login button
    Then the user should see an error message "Epic sadface: Username is required"