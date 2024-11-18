Feature: User Login Functionality

  Background:
    Given the user is on the login page "http://www.saucedemo.com"

  @validLogin
  Scenario Outline: Successful login with valid credentials
    Given the user enters a valid username "<username>"
    And the user enters a valid password "<password>"
    When the user clicks the login button
    Then the user should be redirected to the dashboard page
    And the dashboard should display personalized content

    Examples:
      | username     | password     |
      | standard_user| ValidPass1!  |
      | locked_user  | ValidPass2@  |

  @invalidLogin
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user enters an invalid username "<username>"
    And the user enters an invalid password "<password>"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Invalid username or password."

    Examples:
      | username     | password     |
      | wrong_user   | ValidPass1!  |
      | standard_user| wrongPass    |
      | wrong_user   | wrongPass    |

  @passwordValidation
  Scenario Outline: Password validation rules
    Given the user enters a valid username "standard_user"
    And the user enters a password "<password>"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Invalid username or password."

    Examples:
      | password     |
      | short1!      |
      | NoNumber!    |
      | nonumber1!   |
      | NOLOWERCASE1!|
      | nouppercase1!|

  @requiredFields
  Scenario: Required fields validation
    Given the user leaves the username field empty
    And the user enters a valid password "ValidPass1!"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Both fields are required."

    Given the user enters a valid username "standard_user"
    And the user leaves the password field empty
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Both fields are required."

  @loginAttemptLimit
  Scenario: Login attempt limit enforcement
    Given the user enters an invalid username "wrong_user"
    And the user enters an invalid password "wrongPass"
    When the user clicks the login button 5 times
    Then an error message should be displayed
    And the error message should read "Too many failed login attempts. Please try again after 30 minutes."

  @positive
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters a valid username "standard_user" and password "secret_sauce"
    And clicks the login button
    Then the user should be redirected to the dashboard page

  @negative
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username "<username>" or password "<password>"
    And clicks the login button
    Then an error message "Invalid username or password." should be displayed
    Examples:
      | username       | password     |
      | invalid_user   | secret_sauce |
      | standard_user  | wrong_pass   |
      | invalid_user   | wrong_pass   |

  @negative
  Scenario: Password requirements validation
    Given the user is on the login page
    When the user enters a password with less than 8 characters "short"
    And enters a valid username "standard_user"
    And clicks the login button
    Then an error message should be displayed indicating password requirements

  @negative
  Scenario: Required fields validation
    Given the user is on the login page
    When the user submits the login form with empty username or password
    Then an error message should be displayed indicating that both fields are required

  @negative
  Scenario: Lockout after multiple failed login attempts
    Given the user is on the login page
    When the user enters invalid credentials 5 times with username "standard_user" and password "wrong_pass"
    Then a message "Too many failed login attempts. Please try again after 30 minutes." should be displayed

  @positive
  Scenario: Successful login redirect
    Given the user is on the login page
    When the user logs in successfully with username "standard_user" and password "secret_sauce"
    Then the dashboard should display personalized content based on the user's profile