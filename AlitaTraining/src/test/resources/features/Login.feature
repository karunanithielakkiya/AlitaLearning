Feature: User Login Functionality for Saucedemo Application

  Background:
    Given the user is on the Saucedemo login page

  @validLogin
  Scenario Outline: Successful login with valid credentials
    Given the user enters a valid username "<username>"
    And the user enters a valid password "<password>"
    When the user clicks the login button
    Then the user should be redirected to the dashboard page
    And the dashboard should display personalized content

    Examples:
      | username   | password     |
      | standard_user | Secret_sauce1! |

  @invalidLogin
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user enters an invalid username "<username>"
    And the user enters an invalid password "<password>"
    When the user clicks the login button
    Then an error message should be displayed with text 'Invalid username or password.'

    Examples:
      | username       | password     |
      | invalid_user   | Secret_sauce1! |
      | standard_user  | wrongpass    |
      | invalid_user   | wrongpass    |

  @requiredFields
  Scenario: Error message for empty username and password fields
    Given the user leaves the username field empty
    And the user leaves the password field empty
    When the user clicks the login button
    Then an error message should be displayed indicating that both fields are required

  @passwordValidation
  Scenario Outline: Password validation for login
    Given the user enters a valid username "standard_user"
    And the user enters a password "<password>"
    When the user clicks the login button
    Then an error message should be displayed with text 'Invalid username or password.'

    Examples:
      | password     |
      | short1!      | # Less than 8 characters
      | noUppercase1!| # No uppercase letter
      | NOLOWERCASE1!| # No lowercase letter
      | NoNumber!    | # No numeric character
      | NoSpecial1   | # No special character

  @loginAttemptLimit
  Scenario: Lockout after too many failed login attempts
    Given the user enters an invalid username "invalid_user"
    And the user enters an invalid password "wrongpass"
    When the user attempts to login 5 times
    Then a message should be displayed with text 'Too many failed login attempts. Please try again after 30 minutes.'
