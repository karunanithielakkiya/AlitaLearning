Feature: Login functionality of saucedemo application

  @positive
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters a valid username and password
      | username | password  |
      | standard_user | secret_sauce |
    And clicks the login button
    Then the user should be redirected to the dashboard page

  @negative
  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username or password
      | username | password  |
      | invalid_user | secret_sauce |
      | standard_user | wrong_pass  |
    And clicks the login button
    Then an error message "Invalid username or password." should be displayed

  @negative
  Scenario: Password validation
    Given the user is on the login page
    When the user enters a password with less than 8 characters
      | username | password |
      | standard_user | short |
    Then an error message "Password must be at least 8 characters long." should be displayed
    When the user enters a password without an uppercase letter
      | username | password |
      | standard_user | secret123! |
    Then an error message "Password must contain at least one uppercase letter." should be displayed
    When the user enters a password without a lowercase letter
      | username | password |
      | standard_user | SECRET123! |
    Then an error message "Password must contain at least one lowercase letter." should be displayed
    When the user enters a password without a numeric character
      | username | password |
      | standard_user | Secret! |
    Then an error message "Password must contain at least one numeric character." should be displayed
    When the user enters a password without a special character
      | username | password |
      | standard_user | Secret123 |
    Then an error message "Password must contain at least one special character." should be displayed

  @negative
  Scenario: Required fields validation
    Given the user is on the login page
    When the user submits the login form with an empty username
      | username | password  |
      |          | secret_sauce |
    Then an error message "Username is required." should be displayed
    When the user submits the login form with an empty password
      | username | password  |
      | standard_user |       |
    Then an error message "Password is required." should be displayed

  @negative
  Scenario: Login attempt limit
    Given the user is on the login page
    When the user enters invalid credentials 5 times
      | username | password  |
      | invalid_user | wrong_pass |
    Then a message "Too many failed login attempts. Please try again after 30 minutes." should be displayed