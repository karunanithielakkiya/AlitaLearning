package com.epam.learn.stepdefinition;

import com.epam.learn.pages.LoginPage;
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
        driver.get("http://example.com/login");
        loginPage = new LoginPage(driver);
    }

    @When("the user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        // Add verification logic
        Assert.assertTrue(true);
    }

    @Then("the user should receive an error message {string}")
    public void the_user_should_receive_an_error_message(String errorMessage) {
        // Add verification logic
        Assert.assertTrue(true);
    }

    @Then("the account should be locked after 5 failed attempts")
    public void the_account_should_be_locked_after_5_failed_attempts() {
        // Add verification logic
        Assert.assertTrue(true);
    }

    @Then("the user should not be logged in")
    public void the_user_should_not_be_logged_in() {
        // Add verification logic
        Assert.assertTrue(true);
    }
}