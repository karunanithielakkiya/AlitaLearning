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
      | username   | password       |
      | user1      | ValidPass1!    |
      | user2      | AnotherPass2@  |

  @invalidLogin
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user enters an invalid username "<username>"
    And the user enters an invalid password "<password>"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Invalid username or password."

    Examples:
      | username   | password       |
      | invalid1   | wrongPass1!    |
      | user2      | wrongPass2@    |

  @passwordValidation
  Scenario Outline: Password validation requirements
    Given the user enters a valid username "<username>"
    And the user enters a password "<password>"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "<message>"

    Examples:
      | username | password    | message                                      |
      | user1    | short1!     | "Password must be more than 8 characters."   |
      | user2    | NoNumber!   | "Password must include at least 1 numeric."  |
      | user3    | nonumber1!  | "Password must include at least 1 uppercase."|
      | user4    | NONUMBER1!  | "Password must include at least 1 lowercase."|
      | user5    | NoSpecial1  | "Password must include a special character." |

  @requiredFields
  Scenario: Required fields validation
    Given the user leaves the username field empty
    And the user enters a valid password "ValidPass1!"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Both fields are required."

    Given the user enters a valid username "user1"
    And the user leaves the password field empty
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Both fields are required."

  @loginAttemptLimit
  Scenario: Login attempt limit enforcement
    Given the user enters an invalid username "invalid1"
    And the user enters an invalid password "wrongPass1!"
    When the user clicks the login button 5 times
    Then an error message should be displayed
    And the error message should read "Too many failed login attempts. Please try again after 30 minutes."