Feature: User Authentication on SauceDemo Login Page

  Background:
    Given the user is on the login page "http://www.saucedemo.com"

  @positive @valid-credentials
  Scenario Outline: Successful login with valid credentials
    Given the user enters a valid username "<username>"
    And the user enters a valid password "<password>"
    When the user clicks the login button
    Then the user should be redirected to the dashboard page
    And the dashboard should display personalized content

    Examples:
      | username     | password        |
      | standard_user| ValidPass1!     |
      | locked_user  | ValidPass2@     |

  @negative @invalid-credentials
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user enters an invalid username "<username>"
    And the user enters an invalid password "<password>"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Invalid username or password."

    Examples:
      | username     | password        |
      | wrong_user   | WrongPass1!     |
      | standard_user| wrongpass       |
      |              | ValidPass1!     |
      | standard_user|                 |

  @negative @required-fields
  Scenario: Error message for empty required fields
    Given the user leaves the username field empty
    And the user leaves the password field empty
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Both fields are required."

  @negative @login-attempt-limit
  Scenario: Lockout after too many failed login attempts
    Given the user enters an invalid username "standard_user"
    And the user enters an invalid password "WrongPass1!"
    When the user clicks the login button 5 times
    Then an error message should be displayed
    And the error message should read "Too many failed login attempts. Please try again after 30 minutes."

  @positive @successful-login-redirect
  Scenario: Successful login redirects to dashboard
    Given the user enters a valid username "standard_user"
    And the user enters a valid password "ValidPass1!"
    When the user clicks the login button
    Then the user should be redirected to the dashboard page
    And the dashboard should display personalized content