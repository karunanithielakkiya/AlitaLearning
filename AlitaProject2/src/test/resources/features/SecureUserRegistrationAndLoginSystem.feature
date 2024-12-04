Feature: User Registration and Security Features
   In order to create a secure and functional user account system
   As a new user and system administrator
   I want to ensure user registration, password encryption, email verification, password reset, and MFA setup are implemented effectively

Background:
   Given the user is on the registration page

Scenario: User Registration with Secure Password
   When the user enters a valid email and a secure password
   And the user submits the registration form
   Then the user should receive a confirmation message
   And the account should be created successfully

Scenario: Password Encryption
   When the user registers with a password
   Then the system should encrypt the password before storing it in the database
   And the encrypted password should not be retrievable in plain text

Scenario: Email Verification
   When the user completes the registration process
   Then the system should send a verification email to the user's email address
   And the email should contain a verification link
   But the account should remain inactive until the email is verified

Scenario: Password Reset via Secure Email Link
   When the user requests a password reset
   And the user provides a registered email address
   Then the system should send a password reset link to the user's email
   And the link should allow the user to set a new password securely

Scenario: MFA Setup Instructions
   When the user navigates to the security settings page
   Then the user should see clear instructions for setting up Multi-Factor Authentication (MFA)
   And the instructions should be easy to follow

Scenario: MFA Support
   When the user enables Multi-Factor Authentication (MFA)
   Then the system should support MFA for additional security
   And the user should be prompted for a second factor during login

Scenario: Basic Security Measures for Registration and Login
   When the user registers or logs in
   Then the system should implement basic security measures
   And the user should be protected from common security threats
   But the user experience should not be negatively impacted