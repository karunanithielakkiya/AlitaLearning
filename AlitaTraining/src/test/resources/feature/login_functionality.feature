Feature: Login functionality of the saucedemo application

  @positive
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters a valid username "standard_user" and password "secret_sauce"
    And clicks the login button
    Then the user should be redirected to the dashboard page

  @negative
  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username "invalid_user" or password "wrong_password"
    And clicks the login button
    Then an error message should be displayed
    And the error message should read "Invalid username or password."

  @negative
  Scenario: Password requirements validation
    Given the user is on the login page
    When the user enters a password with less than 8 characters "short"
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
    When the user enters invalid credentials 5 times
    Then the user should be locked out
    And a message should read "Too many failed login attempts. Please try again after 30 minutes."