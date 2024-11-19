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
      | user1      | wrongPass2@    |
      | invalid2   | ValidPass1!    |

  @emptyFields
  Scenario: Attempt to login with empty username and password fields
    Given the user leaves the username field empty
    And the user leaves the password field empty
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Both fields are required."

  @passwordValidation
  Scenario Outline: Password validation for login
    Given the user enters a valid username "<username>"
    And the user enters an invalid password "<password>"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Invalid username or password."

    Examples:
      | username | password   |
      | user1    | short1!    |
      | user2    | NoSpecial1 |
      | user3    | noUpper1!  |
      | user4    | NOLOWER1!  |
      | user5    | NoNumber!  |

  @loginAttemptLimit
  Scenario: Exceeding login attempt limit
    Given the user enters an invalid username "invalidUser"
    And the user enters an invalid password "wrongPass1!"
    When the user attempts to login 5 times
    Then an error message should be displayed
    And the error message should read "Too many failed login attempts. Please try again after 30 minutes."

  @positive
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters a valid username and password
    And clicks the login button
    Then the user should be redirected to the dashboard page

  @negative
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid <username> or <password>
    And clicks the login button
    Then an error message "<message>" should be displayed

    Examples:
      | username   | password   | message                          |
      | invalidUser| validPass  | Invalid username or password.    |
      | validUser  | invalidPass| Invalid username or password.    |
      | invalidUser| invalidPass| Invalid username or password.    |

  @negative
  Scenario Outline: Password validation
    Given the user is on the login page
    When the user enters a password "<password>"
    Then an error message "<message>" should be displayed indicating password requirements

    Examples:
      | password   | message                                      |
      | short      | Password must be at least 8 characters long. |
      | noUpper    | Password must contain at least one uppercase letter. |
      | noLower    | Password must contain at least one lowercase letter. |
      | noNumber   | Password must contain at least one numeric character. |
      | noSpecial  | Password must contain at least one special character. |

  @negative
  Scenario: Required fields validation
    Given the user is on the login page
    When the user attempts to submit the login form with an empty username
    Then an error message should be displayed indicating that the username is required
    When the user attempts to submit the login form with an empty password
    Then an error message should be displayed indicating that the password is required

  @negative
  Scenario: Login attempt limit
    Given the user is on the login page
    When the user enters invalid credentials 5 times
    Then the user should be locked out with a message "Too many failed login attempts. Please try again after 30 minutes."

  @positive
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters a valid username and password
    And clicks the login button
    Then the user should be redirected to the dashboard page

  @negative
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid <username> or <password>
    And clicks the login button
    Then an error message "<message>" should be displayed

    Examples:
      | username   | password   | message                          |
      | invalidUser| validPass  | Invalid username or password.    |
      | validUser  | invalidPass| Invalid username or password.    |
      | invalidUser| invalidPass| Invalid username or password.    |

  @negative
  Scenario Outline: Password validation
    Given the user is on the login page
    When the user enters a password "<password>"
    Then an error message "<message>" should be displayed indicating password requirements

    Examples:
      | password   | message                                      |
      | short      | Password must be at least 8 characters long. |
      | noUpper    | Password must contain at least one uppercase letter. |
      | noLower    | Password must contain at least one lowercase letter. |
      | noNumber   | Password must contain at least one numeric character. |
      | noSpecial  | Password must contain at least one special character. |

  @negative
  Scenario: Required fields validation
    Given the user is on the login page
    When the user attempts to submit the login form with an empty username
    Then an error message should be displayed indicating that the username is required
    When the user attempts to submit the login form with an empty password
    Then an error message should be displayed indicating that the password is required

  @negative
  Scenario: Login attempt limit
    Given the user is on the login page
    When the user enters invalid credentials 5 times
    Then the user should be locked out with a message "Too many failed login attempts. Please try again after 30 minutes."

  @validLogin
  Scenario Outline: Successful login with valid credentials
    Given the user enters a valid username "<username>"
    And the user enters a valid password "<password>"
    When the user clicks the login button
    Then the user should be redirected to the dashboard page
    And the dashboard should display personalized content

    Examples:
      | username     | password       |
      | validUser1   | ValidPass1!    |
      | validUser2   | ValidPass2@    |

  @invalidLogin
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user enters an invalid username "<username>"
    And the user enters an invalid password "<password>"
    When the user clicks the login button
    Then an error message should be displayed
    And the error message should read "Invalid username or password."

    Examples:
      | username     | password       |
      | invalidUser1 | invalidPass1   |
      | validUser1   | invalidPass2   |
      | invalidUser2 | ValidPass1!    |

  @requiredFields
  Scenario: Attempt to login with empty required fields
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
      | username   | password     |
      | validUser1 | short1!      |
      | validUser1 | NoSpecial1   |
      | validUser1 | nospecial!1  |
      | validUser1 | NOLOWERCASE1!|

  @loginAttemptLimit
  Scenario: Exceeding login attempt limit
    Given the user enters an invalid username "invalidUser"
    And the user enters an invalid password "invalidPass"
    When the user attempts to login 5 times
    Then the user should be locked out
    And a message should be displayed
    And the message should read "Too many failed login attempts. Please try again after 30 minutes."