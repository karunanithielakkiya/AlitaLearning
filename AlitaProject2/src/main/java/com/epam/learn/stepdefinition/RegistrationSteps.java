package com.epam.learn.stepdefinition;

import com.epam.learn.pages.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class RegistrationSteps {
    private WebDriver driver;
    private RegistrationPage registrationPage;

    @Given("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        driver = new ChromeDriver();
        driver.get("http://example.com/register");
        registrationPage = new RegistrationPage(driver);
    }

    @When("the user enters a valid email and a secure password")
    public void the_user_enters_a_valid_email_and_a_secure_password() {
        registrationPage.enterEmail("test@example.com");
        registrationPage.enterPassword("SecurePassword123!");
    }

    @When("the user submits the registration form")
    public void the_user_submits_the_registration_form() {
        registrationPage.submitRegistration();
    }

    @Then("the user should receive a confirmation message")
    public void the_user_should_receive_a_confirmation_message() {
        String message = registrationPage.getConfirmationMessage();
        assertEquals("Registration successful!", message);
        driver.quit();
    }
}
