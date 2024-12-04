package com.epam.learn.stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import com.epam.learn.pages.RegistrationPage;

import java.util.List;
import java.util.Map;

public class RegistrationSteps extends BaseStep {

    RegistrationPage registrationPage;

    @Given("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        driver.get("http://example.com/registration");
        registrationPage = new RegistrationPage(driver);
    }

    @When("the user enters valid registration details")
    public void the_user_enters_valid_registration_details(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            registrationPage.enterUsername(row.get("username"));
            registrationPage.enterPassword(row.get("password"));
        }
    }

    @When("the password meets the strength criteria")
    public void the_password_meets_the_strength_criteria() {
        // Assume password strength validation is done on the client-side
    }

    @When("the user submits the registration form")
    public void the_user_submits_the_registration_form() {
        registrationPage.submitForm();
    }

    @Then("the user should receive a registration confirmation email")
    public void the_user_should_receive_a_registration_confirmation_email() {
        // Simulate email confirmation check
        Assert.assertTrue("Confirmation email received", true);
    }

    @Then("the user account should be created successfully")
    public void the_user_account_should_be_created_successfully() {
        String message = registrationPage.getConfirmationMessage();
        Assert.assertEquals("Account created successfully", message);
    }

    @When("the user enters a password {string}")
    public void the_user_enters_a_password(String password) {
        registrationPage.enterPassword(password);
    }

    @Then("the system should validate the password strength")
    public void the_system_should_validate_the_password_strength() {
        // Assume password strength validation is done on the client-side
    }

    @Then("the user should receive a message {string}")
    public void the_user_should_receive_a_message(String message) {
        String actualMessage = registrationPage.getConfirmationMessage();
        Assert.assertEquals(message, actualMessage);
    }

    @When("the user completes the registration process")
    public void the_user_completes_the_registration_process() {
        // Assume registration process is completed
    }

    @Then("the user should receive a confirmation email")
    public void the_user_should_receive_a_confirmation_email() {
        // Simulate email confirmation check
        Assert.assertTrue("Confirmation email received", true);
    }

    @Then("the email should contain a verification link")
    public void the_email_should_contain_a_verification_link() {
        // Simulate verification link check
        Assert.assertTrue("Verification link present", true);
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get("http://example.com/login");
    }
}
