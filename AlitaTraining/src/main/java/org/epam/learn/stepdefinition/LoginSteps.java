package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("the user enters a valid username {string} and password {string}")
    public void the_user_enters_a_valid_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the dashboard page")
    public void the_user_should_be_redirected_to_the_dashboard_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        driver.quit();
    }

    @When("the user enters an invalid username {string} or password {string}")
    public void the_user_enters_an_invalid_username_or_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.getErrorMessage());
        driver.quit();
    }

    @When("the user enters a password with less than 8 characters {string}")
    public void the_user_enters_a_password_with_less_than_8_characters(String password) {
        loginPage.enterPassword(password);
    }

    @When("enters a valid username {string}")
    public void enters_a_valid_username(String username) {
        loginPage.enterUsername(username);
    }

    @Then("an error message should be displayed indicating password requirements")
    public void an_error_message_should_be_displayed_indicating_password_requirements() {
        Assert.assertTrue(loginPage.getErrorMessage().contains("password requirements"));
        driver.quit();
    }

    @When("the user submits the login form with empty username or password")
    public void the_user_submits_the_login_form_with_empty_username_or_password() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
    }

    @Then("an error message should be displayed indicating that both fields are required")
    public void an_error_message_should_be_displayed_indicating_that_both_fields_are_required() {
        Assert.assertTrue(loginPage.getErrorMessage().contains("both fields are required"));
        driver.quit();
    }

    @When("the user enters invalid credentials 5 times with username {string} and password {string}")
    public void the_user_enters_invalid_credentials_5_times_with_username_and_password(String username, String password) {
        for (int i = 0; i < 5; i++) {
            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();
        }
    }

    @Then("a message {string} should be displayed")
    public void a_message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.getErrorMessage());
        driver.quit();
    }
}
