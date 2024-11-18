Feature: User Login Functionality for Saucedemo

  Background:
    Given the user is on the Saucedemo login page

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