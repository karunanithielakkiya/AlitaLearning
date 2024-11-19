package com.saucedemo.automation.steps;

import com.saucedemo.automation.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @When("the user enters an invalid {string} or {string}")
    public void the_user_enters_an_invalid_username_or_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user enters a password {string}")
    public void the_user_enters_a_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the dashboard page")
    public void the_user_should_be_redirected_to_the_dashboard_page() {
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.getErrorMessage());
    }

    @Then("an error message {string} should be displayed indicating password requirements")
    public void an_error_message_should_be_displayed_indicating_password_requirements(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.getErrorMessage());
    }

    @When("the user attempts to submit the login form with an empty username")
    public void the_user_attempts_to_submit_the_login_form_with_an_empty_username() {
        loginPage.enterUsername("");
        loginPage.clickLoginButton();
    }

    @Then("an error message should be displayed indicating that the username is required")
    public void an_error_message_should_be_displayed_indicating_that_the_username_is_required() {
        Assert.assertEquals("Username is required", loginPage.getErrorMessage());
    }

    @When("the user attempts to submit the login form with an empty password")
    public void the_user_attempts_to_submit_the_login_form_with_an_empty_password() {
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
    }

    @Then("an error message should be displayed indicating that the password is required")
    public void an_error_message_should_be_displayed_indicating_that_the_password_is_required() {
        Assert.assertEquals("Password is required", loginPage.getErrorMessage());
    }
}