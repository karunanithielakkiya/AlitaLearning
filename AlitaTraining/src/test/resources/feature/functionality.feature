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
      | username   | password        |
      | user1      | ValidPass1!     |
      | user2      | AnotherPass2@   |

  @invalidLogin
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user enters an invalid username "<username>"
    And the user enters an invalid password "<password>"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Invalid username or password."

    Examples:
      | username   | password        |
      | invalid1   | wrongPass1!     |
      | user1      | wrongPass2@     |
      | invalid2   | ValidPass1!     |

  @emptyFields
  Scenario: Attempt to login with empty username and password fields
    Given the user leaves the username field empty
    And the user leaves the password field empty
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
      | username | password   |
      | user1    | short1!    |
      | user1    | NoNumber!  |
      | user1    | nonumber1  |
      | user1    | NOLOWER1!  |
      | user1    | noupper1!  |

  @loginAttemptLimit
  Scenario: Exceeding login attempt limit
    Given the user enters an invalid username "user1"
    And the user enters an invalid password "wrongPass1!"
    When the user clicks the login button 5 times
    Then an error message should be displayed
    And the error message should read "Too many failed login attempts. Please try again after 30 minutes."

  @valid-credentials
  Scenario Outline: Successful login with valid credentials
    Given the user enters a valid username "<username>"
    And the user enters a valid password "<password>"
    When the user clicks the login button
    Then the user should be redirected to the dashboard page
    And the dashboard should display personalized content

    Examples:
      | username     | password     |
      | standard_user| Secret_sauce1! |

  @invalid-credentials
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user enters an invalid username "<username>"
    Or the user enters an invalid password "<password>"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Invalid username or password."

    Examples:
      | username     | password     |
      | wrong_user   | Secret_sauce1! |
      | standard_user| wrong_pass    |

  @password-requirements
  Scenario Outline: Password requirements validation
    Given the user enters a valid username "standard_user"
    And the user enters a password "<password>"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Invalid username or password."

    Examples:
      | password     |
      | short1!      |
      | NoSpecialChar1 |
      | noUppercase1! |
      | NOLOWERCASE1! |

  @required-fields
  Scenario: Required fields validation
    Given the user leaves the username field empty
    Or the user leaves the password field empty
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Both fields are required."

  @login-attempt-limit
  Scenario: Login attempt limit enforcement
    Given the user enters an invalid username "standard_user"
    And the user enters an invalid password "wrong_pass"
    When the user clicks the login button 5 times
    Then an error message should be displayed
    And the error message should read "Too many failed login attempts. Please try again after 30 minutes."

  @validLogin
  Scenario Outline: Successful login with valid credentials
    Given the login page is displayed
    When the user enters a valid username "<username>" and a valid password "<password>"
    And clicks the login button
    Then the user should be redirected to the dashboard page
    And the dashboard should display personalized content

    Examples:
      | username     | password       |
      | validUser1   | ValidPass1!    |
      | validUser2   | ValidPass2@    |

  @invalidLogin
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the login page is displayed
    When the user enters an invalid username "<username>" or an invalid password "<password>"
    And clicks the login button
    Then an error message should be displayed with text "Invalid username or password."

    Examples:
      | username     | password       |
      | invalidUser  | ValidPass1!    |
      | validUser1   | invalidPass    |
      | validUser2   | short1!        |
      | validUser3   | NoSpecialChar1 |

  @requiredFields
  Scenario: Error message for empty required fields
    Given the login page is displayed
    When the user leaves the username field empty
    And enters a valid password "ValidPass1!"
    And clicks the login button
    Then an error message should be displayed indicating that both fields are required

    When the user enters a valid username "validUser1"
    And leaves the password field empty
    And clicks the login button
    Then an error message should be displayed indicating that both fields are required

  @loginAttemptLimit
  Scenario: Lockout after too many failed login attempts
    Given the login page is displayed
    When the user enters invalid credentials "<username>" and "<password>" for 5 times
    And clicks the login button
    Then a message should be displayed with text "Too many failed login attempts. Please try again after 30 minutes."

    Examples:
      | username     | password       |
      | invalidUser  | invalidPass    |

  @successfulRedirect
  Scenario: Successful login redirects to dashboard
    Given the login page is displayed
    When the user enters a valid username "validUser1" and a valid password "ValidPass1!"
    And clicks the login button
    Then the user should be redirected to the dashboard page
    And the dashboard should display personalized content