Feature: Login functionality of the saucedemo application

  @positive
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters a valid username and password
    | username  | password  |
    | standard_user | secret_sauce |
    And clicks the login button
    Then the user should be redirected to the dashboard page

  @negative
  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username or password
    | username  | password  |
    | invalid_user | secret_sauce |
    | standard_user | wrong_password |
    And clicks the login button
    Then an error message "Invalid username or password." should be displayed

  @negative
  Scenario Outline: Password requirements validation
    Given the user is on the login page
    When the user enters a password "<password>"
    Then an error message should be displayed indicating password requirements

    Examples:
      | password     |
      | short        | # less than 8 characters
      | lowercase1!  | # without an uppercase letter
      | UPPERCASE1!  | # without a lowercase letter
      | NoNumber!    | # without a numeric character
      | NoSpecial1   | # without a special character

  @negative
  Scenario: Required fields validation
    Given the user is on the login page
    When the user submits the login form with the username field empty
    Then an error message should be displayed indicating that the username is required
    When the user submits the login form with the password field empty
    Then an error message should be displayed indicating that the password is required

  @negative
  Scenario: Lockout after multiple failed login attempts
    Given the user is on the login page
    When the user enters invalid credentials 5 times
    | username  | password  |
    | invalid_user | secret_sauce |
    Then a message "Too many failed login attempts. Please try again after 30 minutes." should be displayed