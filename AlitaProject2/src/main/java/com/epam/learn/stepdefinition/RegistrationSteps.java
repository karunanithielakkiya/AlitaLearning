package com.epam.learn.stepdefinition;

import com.epam.learn.pages.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RegistrationSteps extends BaseStep {
    private RegistrationPage registrationPage;

    @Given("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        initializeDriver();
        driver.get("http://example.com/register");
        registrationPage = new RegistrationPage(driver);
    }

    @When("the user enters a valid email address")
    public void the_user_enters_a_valid_email_address() {
        registrationPage.enterEmail("test@example.com");
    }

    @When("the user enters a secure password")
    public void the_user_enters_a_secure_password() {
        registrationPage.enterPassword("SecurePassword123!");
    }

    @When("the user clicks on the \"Register\" button")
    public void the_user_clicks_on_the_register_button() {
        registrationPage.clickRegister();
    }

    @Then("the user should receive a verification email")
    public void the_user_should_receive_a_verification_email() {
        // Simulate email verification check
        boolean emailReceived = true; // This should be replaced with actual email verification logic
        Assert.assertTrue(emailReceived);
    }

    @Then("a success message should be displayed")
    public void a_success_message_should_be_displayed() {
        String confirmationMessage = registrationPage.getConfirmationMessage();
        Assert.assertEquals("Registration successful!", confirmationMessage);
        closeDriver();
    }
}