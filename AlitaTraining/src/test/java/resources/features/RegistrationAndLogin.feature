Feature: User Registration and Login Functionality
   In order to access the system
   As a new or registered user
   I want to register with a unique email and password and log in securely

Scenario: User Registration with Unique Email and Password
   When the user navigates to the registration page
   And the user enters a unique email address "user@example.com"
   And the user enters a password that meets the strength requirements "StrongPass123!"
   And the user clicks on the "Register" button
   Then the user should be successfully registered
   And a confirmation message should be displayed

Scenario: Password Strength Validation
   When the user navigates to the registration page
   And the user enters a unique email address "user@example.com"
   And the user enters a weak password "12345"
   And the user clicks on the "Register" button
   Then the system should display an error message indicating that the password does not meet the strength requirements

Scenario: Registration Confirmation Email
   Given the user has successfully registered with email "user@example.com" and password "StrongPass123!"
   When the user checks the email inbox
   Then a confirmation email should be received
   And the email should contain a link to verify the email address

Scenario: Login with Security Measures
   Given the user is registered and email is verified
   When the user navigates to the login page
   And the user enters the registered email address "user@example.com"
   And the user enters the correct password "StrongPass123!"
   And the user clicks on the "Login" button
   Then the user should be successfully logged in
   And redirected to the dashboard

Scenario: Brute Force Attack Prevention
   Given the user is registered
   When the user navigates to the login page
   And the user enters the registered email address "user@example.com"
   And the user enters an incorrect password "WrongPass"
   And the user repeats the login attempt multiple times
   Then the system should lock the account after multiple failed login attempts
   And display a lockout message