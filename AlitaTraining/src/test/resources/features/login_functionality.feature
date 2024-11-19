Feature: Login functionality of saucedemo application

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
    Then an error message "Invalid username or password." should be displayed

  @negative
  Scenario: Password validation
    Given the user is on the login page
    When the user enters a password "short" with less than 8 characters
    Then an error message "Password must be at least 8 characters long." should be displayed
    When the user enters a password "nouppercase1!" without an uppercase letter
    Then an error message "Password must contain at least one uppercase letter." should be displayed
    When the user enters a password "NOLOWERCASE1!" without a lowercase letter
    Then an error message "Password must contain at least one lowercase letter." should be displayed
    When the user enters a password "NoSpecialChar" without a special character
    Then an error message "Password must contain at least one special character." should be displayed
    When the user enters a password "NoNumber!" without a numeric character
    Then an error message "Password must contain at least one numeric character." should be displayed

  @negative
  Scenario: Required fields validation
    Given the user is on the login page
    When the user submits the login form with empty username or password
    Then an error message "Both username and password are required." should be displayed

  @negative
  Scenario: Lockout after multiple failed login attempts
    Given the user is on the login page
    When the user enters invalid credentials 5 times
    Then a message "Too many failed login attempts. Please try again after 30 minutes." should be displayed