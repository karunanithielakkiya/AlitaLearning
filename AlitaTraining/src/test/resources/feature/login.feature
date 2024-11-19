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
    Then an error message "Invalid username or password." should be displayed

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
    Then an error message "<message>" should be displayed

    Examples:
      | password   | message                                      |
      | short1!    | "Password must be more than 8 characters."   |
      | NoNumber!  | "Password must contain at least 1 numeric."  |
      | nonumber1! | "Password must contain at least 1 uppercase."|
      | NONUMBER1! | "Password must contain at least 1 lowercase."|
      | ValidPass1!| "Invalid username or password."              |

  @requiredFields
  Scenario: Required fields validation
    Given the user leaves the username field empty
    And the user leaves the password field empty
    When the user clicks the login button
    Then an error message "Both fields are required." should be displayed

  @loginAttemptLimit
  Scenario: Login attempt limit enforcement
    Given the user enters an invalid username "wrong_user"
    And the user enters an invalid password "WrongPass1!"
    When the user clicks the login button 5 times
    Then an error message "Too many failed login attempts. Please try again after 30 minutes." should be displayed
