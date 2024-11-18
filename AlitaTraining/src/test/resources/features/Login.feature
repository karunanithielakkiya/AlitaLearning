Feature: User Login Functionality

  Background:
    Given the user is on the login page of "www.example.com"

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
      | user2      | ValidPass2@  |

  @invalidLogin
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user enters an invalid username "<username>"
    Or the user enters an invalid password "<password>"
    When the user clicks the login button
    Then an error message should be displayed: "Invalid username or password."

    Examples:
      | username   | password     |
      | invalid1   | ValidPass1!  |
      | user1      | invalidPass  |
      | invalid2   | invalidPass  |

  @requiredFields
  Scenario: Error message for empty required fields
    Given the user leaves the username field empty
    Or the user leaves the password field empty
    When the user clicks the login button
    Then an error message should be displayed indicating that both fields are required

  @passwordValidation
  Scenario Outline: Password validation rules
    Given the user enters a valid username "<username>"
    And the user enters a password "<password>"
    When the user clicks the login button
    Then an error message should be displayed: "Invalid username or password."

    Examples:
      | username | password    |
      | user1    | short1!     |
      | user1    | NoSpecial1  |
      | user1    | nospecial!1 |
      | user1    | NOLOWER!1   |

  @loginAttemptLimit
  Scenario: Lockout after too many failed login attempts
    Given the user enters an invalid username "user1"
    And the user enters an invalid password "invalidPass"
    When the user clicks the login button 5 times
    Then a message should be displayed: "Too many failed login attempts. Please try again after 30 minutes."