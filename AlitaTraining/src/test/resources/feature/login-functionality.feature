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
  Scenario Outline: Password requirements validation
    Given the user is on the login page
    When the user enters a password "<password>"
    And clicks the login button
    Then an error message should be displayed indicating password requirements

    Examples:
      | password          |
      | short             | # less than 8 characters
      | noUppercase1!     | # without an uppercase letter
      | NOLOWERCASE1!     | # without a lowercase letter
      | NoNumber!         | # without a numeric character
      | NoSpecialChar1    | # without a special character

  @negative
  Scenario Outline: Required fields validation
    Given the user is on the login page
    When the user attempts to submit the login form with an empty "<field>"
    Then an error message should be displayed indicating that the "<field>" is required

    Examples:
      | field    |
      | username |
      | password |

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