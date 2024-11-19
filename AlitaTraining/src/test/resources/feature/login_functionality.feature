Feature: User Authentication on Login Page

  Background:
    Given the user is on the login page at "http://www.saucedemo.com"

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

  @requiredFields
  Scenario: Attempt to login with empty required fields
    Given the user leaves the username field empty
    And the user leaves the password field empty
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
      | password    |
      | short1!     |
      | NoNumber!   |
      | nonumber1!  |
      | NOLOWER1!   |
      | noupper1!   |
      | ValidPass1! |

  @loginAttemptLimit
  Scenario: Exceeding login attempt limit
    Given the user enters an invalid username "standard_user"
    And the user enters an invalid password "WrongPass1!"
    When the user clicks the login button 5 times
    Then an error message should be displayed
    And the error message should read "Too many failed login attempts. Please try again after 30 minutes."

  @positive
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters a valid username "standard_user" and password "secret_sauce"
    And clicks the login button
    Then the user should be redirected to the dashboard page

  @negative
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username "<username>" or password "<password>"
    And clicks the login button
    Then an error message "<message>" should be displayed

    Examples:
      | username       | password       | message                           |
      | invalid_user   | secret_sauce   | Invalid username or password.     |
      | standard_user  | wrong_password | Invalid username or password.     |
      | invalid_user   | wrong_password | Invalid username or password.     |

  @negative
  Scenario Outline: Password validation
    Given the user is on the login page
    When the user enters a password "<password>"
    Then an error message "<message>" should be displayed

    Examples:
      | password       | message                                          |
      | short          | Password must be at least 8 characters long.     |
      | noUppercase1!  | Password must contain at least one uppercase.    |
      | NOLOWERCASE1!  | Password must contain at least one lowercase.    |
      | NoNumber!      | Password must contain at least one numeric.      |
      | NoSpecial1     | Password must contain at least one special char. |

  @negative
  Scenario: Required fields validation
    Given the user is on the login page
    When the user submits the login form with empty username or password
    Then an error message "Username and password are required." should be displayed

  @negative
  Scenario: Login attempt limit
    Given the user is on the login page
    When the user enters invalid credentials 5 times
    Then the user should be locked out with a message "Too many failed login attempts. Please try again after 30 minutes."