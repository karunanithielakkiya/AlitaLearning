package com.saucedemo.automation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("the user is on the login page {string}")
    public void the_user_is_on_the_login_page(String url) {
        driver = new ChromeDriver();
        driver.get(url);
        loginPage = new LoginPage(driver);
    }

    @Given("the user enters a valid username {string}")
    public void the_user_enters_a_valid_username(String username) {
        loginPage.enterUsername(username);
    }

    @Given("the user enters a valid password {string}")
    public void the_user_enters_a_valid_password(String password) {
        loginPage.enterPassword(password);
    }

    @Given("the user enters an invalid username {string}")
    public void the_user_enters_an_invalid_username(String username) {
        loginPage.enterUsername(username);
    }

    @Given("the user enters an invalid password {string}")
    public void the_user_enters_an_invalid_password(String password) {
        loginPage.enterPassword(password);
    }

    @Given("the user leaves the username field empty")
    public void the_user_leaves_the_username_field_empty() {
        loginPage.enterUsername("");
    }

    @Given("the user leaves the password field empty")
    public void the_user_leaves_the_password_field_empty() {
        loginPage.enterPassword("");
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @When("the user attempts to login {int} times")
    public void the_user_attempts_to_login_times(int attempts) {
        for (int i = 0; i < attempts; i++) {
            loginPage.clickLoginButton();
        }
    }

    @Then("the user should be redirected to the dashboard page")
    public void the_user_should_be_redirected_to_the_dashboard_page() {
        Assert.assertEquals("http://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Then("the dashboard should display personalized content")
    public void the_dashboard_should_display_personalized_content() {
        Assert.assertTrue(driver.getPageSource().contains("Welcome"));
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        Assert.assertTrue(loginPage.getErrorMessage().length() > 0);
    }

    @Then("the error message should read {string}")
    public void the_error_message_should_read(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.getErrorMessage());
    }
}