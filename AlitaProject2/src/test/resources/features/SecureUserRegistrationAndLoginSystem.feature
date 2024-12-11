Feature: User Registration and Security Features
   In order to ensure secure and successful user registration and login
   As a user
   I want to register, verify my email, reset my password, and set up MFA securely

Background:
   Given the user is on the registration page

Scenario: User Registration with Valid Credentials
   When the user enters a valid email address
   And the user enters a secure password
   And the user clicks on the "Register" button
   Then the user should receive a verification email
   And a success message should be displayed

Scenario: Password Encryption in the Database
   When the user registers a new account
   Then the password should be stored in an encrypted format in the database

Scenario: Email Verification Process
   When the user registers a new account
   And the user checks the email for a verification link
   And the user clicks on the verification link
   Then the user account should be activated
   And a confirmation message should be displayed

Scenario: Password Reset Functionality
   When the user clicks on "Forgot Password" link
   And the user enters the registered email address
   And the user checks the email for a password reset link
   And the user clicks on the reset link and enters a new password
   Then the password should be successfully reset
   And the user should be able to log in with the new password

Scenario: Multi-Factor Authentication Setup Instructions
   Given the user is logged in for the first time
   When the user follows the instructions to set up MFA
   Then MFA should be set up successfully
   And the user should receive a confirmation

Scenario: Multi-Factor Authentication During Login
   Given the user has set up MFA
   When the user logs in to the account
   And the user enters the MFA code received via email or phone
   Then the user should be successfully logged in after entering the correct MFA code

Scenario: Security Measures During Registration and Login
   When the user attempts SQL injection on the registration page
   Then the system should block the attempt
   And an error message should be displayed
   When the user attempts cross-site scripting (XSS) on the login page
   Then the system should block the attempt
   And an error message should be displayed