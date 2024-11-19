Feature: Login functionality of saucedemo application

  @positive
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters a valid username and password
    And clicks the login button
    Then the user should be redirected to the dashboard page

  @negative
  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username or password
    And clicks the login button
    Then an error message "Invalid username or password." should be displayed

  @negative
  Scenario Outline: Password requirements validation
    Given the user is on the login page
    When the user enters a password "<password>"
    Then an error message "<error_message>" should be displayed

    Examples:
      | password          | error_message                                      |
      | short             | "Password must be at least 8 characters long."     |
      | noUppercase       | "Password must contain at least one uppercase letter." |
      | noLowercase       | "Password must contain at least one lowercase letter." |
      | noNumeric         | "Password must contain at least one numeric character." |
      | noSpecialChar     | "Password must contain at least one special character." |

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