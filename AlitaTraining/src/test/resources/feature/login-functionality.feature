Feature: Login functionality of the saucedemo application

  @positive
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters a valid username and password
    And clicks the login button
    Then the user should be redirected to the dashboard page
    And the dashboard should display personalized content

  @negative
  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username or password
    And clicks the login button
    Then an error message should be displayed
    And the error message should read "Invalid username or password."

  @negative
  Scenario: Password requirements validation
    Given the user is on the login page
    When the user enters a password with less than 8 characters
    And clicks the login button
    Then an error message should be displayed
    And the error message should indicate password requirements

  @negative
  Scenario: Required fields validation
    Given the user is on the login page
    When the user submits the login form with empty username or password
    Then an error message should be displayed
    And the error message should indicate that both fields are required

  @negative
  Scenario: Lockout after multiple failed login attempts
    Given the user is on the login page
    When the user fails to login 5 times
    Then the user should be locked out
    And a message should read "Too many failed login attempts. Please try again after 30 minutes."

  @negative
  Scenario Outline: Login with various invalid credentials
    Given the user is on the login page
    When the user enters <username> and <password>
    And clicks the login button
    Then an error message should be displayed
    And the error message should read "Invalid username or password."

    Examples:
      | username      | password    |
      | invalidUser   | validPass   |
      | validUser     | invalidPass |
      | invalidUser   | invalidPass |
      | empty         | validPass   |
      | validUser     | empty       |
      | empty         | empty       |