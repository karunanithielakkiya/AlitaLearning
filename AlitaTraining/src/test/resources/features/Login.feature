Feature: User Login Functionality for www.example.com

  Background:
    Given the user is on the login page

  @validLogin
  Scenario Outline: Successful login with valid credentials
    Given the user enters a valid username "<username>"
    And the user enters a valid password "<password>"
    When the user clicks the login button
    Then the user should be redirected to the dashboard page
    And the dashboard should display personalized content

    Examples:
      | username   | password        |
      | user1      | ValidPass1!     |
      | user2      | AnotherPass2@   |

  @invalidLogin
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user enters an invalid username "<username>"
    Or the user enters an invalid password "<password>"
    When the user clicks the login button
    Then an error message should be displayed: "Invalid username or password."

    Examples:
      | username   | password        |
      | invalid1   | ValidPass1!     |
      | user1      | wrongPass       |
      | invalid2   | AnotherPass2@   |
      | user2      | short1!         |
      | user3      | NoSpecialChar1  |

  @requiredFields
  Scenario: Error message for empty required fields
    Given the user leaves the username field empty
    Or the user leaves the password field empty
    When the user clicks the login button
    Then an error message should be displayed: "Both fields are required."

  @loginAttemptLimit
  Scenario: Lockout after too many failed login attempts
    Given the user enters invalid credentials
    When the user attempts to login 5 times
    Then a message should be displayed: "Too many failed login attempts. Please try again after 30 minutes."

  @passwordValidation
  Scenario Outline: Password validation rules
    Given the user enters a valid username "<username>"
    And the user enters a password "<password>"
    When the user clicks the login button
    Then an error message should be displayed: "Invalid username or password."

    Examples:
      | username | password    |
      | user1    | short1!     |
      | user2    | NoUppercase1|
      | user3    | NOLOWERCASE1|
      | user4    | NoNumber!   |
      | user5    | NoSpecial1  |
