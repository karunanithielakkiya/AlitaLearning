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
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.getErrorMessage());
    }

    @Then("an error message should be displayed indicating that the username is required")
    public void an_error_message_should_be_displayed_indicating_that_the_username_is_required() {
        Assert.assertEquals("Username is required", loginPage.getErrorMessage());
    }

    @Then("an error message should be displayed indicating that the password is required")
    public void an_error_message_should_be_displayed_indicating_that_the_password is_required() {
        Assert.assertEquals("Password is required", loginPage.getErrorMessage());
    }

    @Then("the user should be locked out with a message {string}")
    public void the_user_should_be_locked_out_with_a_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.getErrorMessage());
    }
}