Feature: User Login Functionality

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
      | username     | password     |
      | validUser1   | ValidPass1!  |
      | validUser2   | ValidPass2@  |

  @invalidLogin
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user enters an invalid username "<username>"
    And the user enters an invalid password "<password>"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Invalid username or password."

    Examples:
      | username     | password     |
      | invalidUser1 | InvalidPass1 |
      | validUser1   | InvalidPass2 |
      | invalidUser2 | ValidPass1!  |

  @passwordRequirements
  Scenario Outline: Password requirements validation
    Given the user enters a valid username "validUser1"
    And the user enters a password "<password>"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Password does not meet the requirements."

    Examples:
      | password     |
      | short1!      |
      | NoNumber!    |
      | nonumeric1   |
      | NOLOWERCASE1!|
      | nouppercase1!|

  @requiredFields
  Scenario: Required fields validation
    Given the user leaves the username field empty
    And the user enters a valid password "ValidPass1!"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Both fields are required."

    Given the user enters a valid username "validUser1"
    And the user leaves the password field empty
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Both fields are required."

  @loginAttemptLimit
  Scenario: Login attempt limit enforcement
    Given the user enters an invalid username "invalidUser1"
    And the user enters an invalid password "InvalidPass1"
    When the user clicks the login button 5 times
    Then an error message should be displayed
    And the error message should read "Too many failed login attempts. Please try again after 30 minutes."