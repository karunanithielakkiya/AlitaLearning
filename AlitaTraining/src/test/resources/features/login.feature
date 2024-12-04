Feature: Login functionality for SauceDemo application

  @positive
  Scenario: Successful login with valid credentials
    Given the user is on the SauceDemo login page
    When the user enters a valid username and password
    And the user clicks the Login button
    Then the user should be redirected to the Inventory dashboard

  @negative
  Scenario: Unsuccessful login with invalid username
    Given the user is on the SauceDemo login page
    When the user enters an invalid username and a valid password
    And the user clicks the Login button
    Then the system should display an error message "Epic sadface: Username and password do not match any user in this service"

  @negative
  Scenario: Unsuccessful login with invalid password
    Given the user is on the SauceDemo login page
    When the user enters a valid username and an invalid password
    And the user clicks the Login button
    Then the system should display an error message "Epic sadface: Username and password do not match any user in this service"

  @negative
  Scenario: Unsuccessful login with both fields empty
    Given the user is on the SauceDemo login page
    When the user leaves both username and password fields empty
    And the user clicks the Login button
    Then the system should display an error message "Epic sadface: Username is required"

  @negative
  Scenario Outline: Unsuccessful login with missing credentials
    Given the user is on the SauceDemo login page
    When the user enters <username> and <password>
    And the user clicks the Login button
    Then the system should display an error message <error_message>

    Examples:
      | username       | password       | error_message                                           |
      | ""             | "secret_sauce" | "Epic sadface: Username is required"                    |
      | "standard_user"| ""             | "Epic sadface: Password is required"                    |