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
      | username     | password         |
      | validUser1   | ValidPass1!      |
      | validUser2   | AnotherPass2@    |

  @invalidLogin
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user enters an invalid username "<username>"
    Or the user enters an invalid password "<password>"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Invalid username or password."

    Examples:
      | username     | password         |
      | invalidUser  | ValidPass1!      |
      | validUser1   | wrongPass        |
      |              | ValidPass1!      |
      | validUser1   |                  |

  @requiredFields
  Scenario: Attempt to login with empty required fields
    Given the user leaves the username field empty
    Or the user leaves the password field empty
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Both fields are required."

  @passwordValidation
  Scenario Outline: Password validation rules
    Given the user enters a valid username "<username>"
    And the user enters a password "<password>"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Invalid username or password."

    Examples:
      | username   | password     |
      | validUser1 | short1!      |
      | validUser1 | NoSpecialChar1 |
      | validUser1 | noUppercase1! |
      | validUser1 | NOLOWERCASE1! |
      | validUser1 | NoNumber!    |

  @loginAttemptLimit
  Scenario: Exceeding login attempt limit
    Given the user enters an invalid username or password
    When the user clicks the login button 5 times
    Then an error message should be displayed
    And the error message should read "Too many failed login attempts. Please try again after 30 minutes."