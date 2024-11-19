package com.saucedemo.automation.stepdefinition;

import com.saucedemo.automation.pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("the user enters a valid username and password")
    public void the_user_enters_a_valid_username_and_password() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
    }

    @When("the user enters an invalid username or password")
    public void the_user_enters_an_invalid_username_or_password() {
        loginPage.enterUsername("invalid_user");
        loginPage.enterPassword("invalid_pass");
    }

    @When("the user enters a password with less than 8 characters")
    public void the_user_enters_a_password_with_less_than_8_characters() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("short");
    }

    @When("the user submits the login form with empty username or password")
    public void the_user_submits_the_login_form_with_empty_username_or_password() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
    }

    @When("the user fails to login 5 times")
    public void the_user_fails_to_login_5_times() {
        for (int i = 0; i < 5; i++) {
            loginPage.enterUsername("invalid_user");
            loginPage.enterPassword("invalid_pass");
            loginPage.clickLoginButton();
        }
    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("clicks the login button")
    public void clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the dashboard page")
    public void the_user_should_be_redirected_to_the_dashboard_page() {
        // Implement dashboard page verification
    }

    @Then("the dashboard should display personalized content")
    public void the_dashboard_should_display_personalized_content() {
        // Implement personalized content verification
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid username or password."));
    }

    @Then("the error message should read {string}")
    public void the_error_message_should_read(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.getErrorMessage());
    }

    @Then("the error message should indicate password requirements")
    public void the_error_message_should_indicate_password_requirements() {
        // Implement password requirements verification
    }
}

// Additional methods or updates can be added here if needed