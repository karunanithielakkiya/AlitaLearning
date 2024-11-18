Feature: User Login Functionality for Saucedemo Application

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
      | username     | password       |
      | standard_user| ValidPass1!    |
      | locked_user  | ValidPass2@    |

  @invalidLogin
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user enters an invalid username "<username>"
    Or the user enters an invalid password "<password>"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Invalid username or password."

    Examples:
      | username     | password       |
      | wrong_user   | ValidPass1!    |
      | standard_user| wrongPass      |
      | wrong_user   | wrongPass      |

  @emptyFields
  Scenario: Attempt to login with empty required fields
    Given the user leaves the username field empty
    Or the user leaves the password field empty
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Both fields are required."

  @passwordValidation
  Scenario Outline: Password validation rules
    Given the user enters a valid username "standard_user"
    And the user enters a password "<password>"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Invalid username or password."

    Examples:
      | password       |
      | short1!        | # Less than 8 characters
      | noUppercase1!  | # No uppercase letter
      | NOLOWERCASE1!  | # No lowercase letter
      | NoNumber!      | # No numeric character
      | NoSpecialChar1 | # No special character

  @loginAttemptLimit
  Scenario: Exceeding login attempt limit
    Given the user enters an invalid username "standard_user"
    And the user enters an invalid password "wrongPass"
    When the user clicks the login button 5 times
    Then an error message should be displayed
    And the error message should read "Too many failed login attempts. Please try again after 30 minutes."