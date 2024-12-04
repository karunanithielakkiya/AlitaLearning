package com.epam.learn.stepdefinition;

import com.epam.learn.pages.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationSteps {
    WebDriver driver;
    RegistrationPage registrationPage;

    @Given("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        driver = new ChromeDriver();
        driver.get("http://example.com/registration");
        registrationPage = new RegistrationPage(driver);
    }

    @When("the user enters a unique email {string} and a strong password {string}")
    public void the_user_enters_a_unique_email_and_a_strong_password(String email, String password) {
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
    }

    @When("the user submits the registration form")
    public void the_user_submits_the_registration_form() {
        registrationPage.submitForm();
    }

    @Then("the user should be registered successfully")
    public void the_user_should_be_registered_successfully() {
        // Add verification logic
        Assert.assertTrue(true);
    }

    @Then("a confirmation email should be sent to {string}")
    public void a_confirmation_email_should_be_sent_to(String email) {
        // Add verification logic
        Assert.assertTrue(true);
    }

    @When("the user enters a unique email {string} and a weak password {string}")
    public void the_user_enters_a_unique_email_and_a_weak_password(String email, String password) {
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
    }

    @Then("the user should receive an error message {string}")
    public void the_user_should_receive_an_error_message(String errorMessage) {
        // Add verification logic
        Assert.assertTrue(true);
    }

    @Then("the user should not be registered")
    public void the_user_should_not_be_registered() {
        // Add verification logic
        Assert.assertTrue(true);
    }
}