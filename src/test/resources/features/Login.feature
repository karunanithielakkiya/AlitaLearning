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
      | username   | password     |
      | user1      | ValidPass1!  |
      | user2      | SecurePass2@ |

  @invalidLogin
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user enters an invalid username "<username>"
    Or the user enters an invalid password "<password>"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Invalid username or password."

    Examples:
      | username   | password     |
      | invalidUser| ValidPass1!  |
      | user1      | wrongPass    |
      |            | ValidPass1!  |
      | user1      |              |

  @passwordRequirements
  Scenario Outline: Password requirements validation
    Given the user enters a valid username "<username>"
    And the user enters a password "<password>"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Password must be more than 8 characters and include at least 1 uppercase, 1 lowercase, 1 numeric, and a special character."

    Examples:
      | username | password   |
      | user1    | short1!    |
      | user1    | NoNumber!  |
      | user1    | nonumeric1 |
      | user1    | NoSpecial1 |

  @requiredFields
  Scenario: Required fields validation
    Given the user leaves the username field empty
    Or the user leaves the password field empty
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Both fields are required."

  @loginAttemptLimit
  Scenario: Login attempt limit enforcement
    Given the user enters an invalid username or password
    When the user attempts to login 5 times
    Then an error message should be displayed
    And the error message should read "Too many failed login attempts. Please try again after 30 minutes."

  @positive
  Scenario: Successful login redirect
    Given the user is on the login page
    When the user logs in successfully with username "validUser" and password "validPass123"
    Then the user should be redirected to the dashboard page
    And the dashboard should display personalized content based on the user's profile