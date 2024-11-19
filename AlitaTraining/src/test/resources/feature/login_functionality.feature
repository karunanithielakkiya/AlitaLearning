Feature: User Login Functionality for SauceDemo Application

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
    And the user enters an invalid password "<password>"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Invalid username or password."

    Examples:
      | username     | password       |
      | wrong_user   | WrongPass1!    |
      | standard_user| wrongpass      |
      |              | ValidPass1!    |
      | standard_user|                |

  @passwordValidation
  Scenario Outline: Password validation rules
    Given the user enters a valid username "standard_user"
    And the user enters a password "<password>"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Invalid username or password."

    Examples:
      | password     |
      | short1!      | # Less than 8 characters
      | NoNumber!    | # No numeric character
      | nonumber1    | # No special character
      | NONUMBER1!   | # No lowercase character
      | nonumber1!   | # No uppercase character

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
    And the user enters an invalid password "WrongPass1!"
    When the user clicks the login button 5 times
    Then an error message should be displayed
    And the error message should read "Too many failed login attempts. Please try again after 30 minutes."