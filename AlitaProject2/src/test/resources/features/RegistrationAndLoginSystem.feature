Feature: User Registration and Login System
   In order to access personalized services
   As a new user
   I want to register an account, validate my password strength, receive a confirmation email, and have limited login attempts

Background:
   Given the user is on the registration page

Scenario: Successful User Registration
   When the user enters valid registration details
   And the password meets the strength criteria
   And the user submits the registration form
   Then the user should receive a registration confirmation email
   And the user account should be created successfully

Scenario Outline: Password Strength Validation
   When the user enters a password "<password>"
   And the user submits the registration form
   Then the system should validate the password strength
   And the user should receive a message "<message>"

Examples:
   | password         | message                              |
   | weakpass         | "Password is too weak"               |
   | StrongPass123!   | "Password strength is sufficient"    |

Scenario: Registration Confirmation Email
   When the user completes the registration process
   Then the user should receive a confirmation email
   And the email should contain a verification link

Scenario: Login Attempt Limitation
   Given the user is on the login page
   When the user enters incorrect login details
   And the user attempts to log in "<attempts>" times
   Then the user should receive a message "<error_message>"
   But the user account should be temporarily locked after 5 failed attempts

Examples:
   | attempts | error_message                      |
   | 3        | "Invalid username or password"     |
   | 5        | "Account temporarily locked"       |

Scenario: Successful Login After Registration
   Given the user has completed registration
   And the user has verified their email
   When the user enters correct login details
   And the user clicks on the login button
   Then the user should be logged in successfully
   And redirected to the user dashboard