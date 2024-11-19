Feature: Login functionality of saucedemo application

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
    Then an error message "Invalid username or password." should be displayed

    Examples:
      | username       | password     |
      | invalid_user   | secret_sauce |
      | standard_user  | wrong_pass   |
      | invalid_user   | wrong_pass   |

  @negative
  Scenario Outline: Password validation
    Given the user is on the login page
    When the user enters a password "<password>"
    And clicks the login button
    Then an error message "<message>" should be displayed

    Examples:
      | password       | message                                      |
      | short          | "Password must be at least 8 characters."    |
      | noUppercase1!  | "Password must include an uppercase letter." |
      | NOLOWERCASE1!  | "Password must include a lowercase letter."  |
      | NoNumber!      | "Password must include a numeric character." |
      | NoSpecial1     | "Password must include a special character." |

  @negative
  Scenario Outline: Required fields validation
    Given the user is on the login page
    When the user submits the login form with an empty "<field>"
    Then an error message "<message>" should be displayed

    Examples:
      | field    | message                        |
      | username | "Username is required."        |
      | password | "Password is required."        |

  @negative
  Scenario: Login attempt limit
    Given the user is on the login page
    When the user enters invalid credentials 5 times
    Then a message "Too many failed login attempts. Please try again after 30 minutes." should be displayed