package com.epam.learn.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("the user is on the login page of {string}")
    public void the_user_is_on_the_login_page_of(String url) {
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

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the dashboard page")
    public void the_user_should_be_redirected_to_the_dashboard_page() {
        Assert.assertTrue(loginPage.isDashboardDisplayed());
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        Assert.assertFalse(loginPage.getErrorMessage().isEmpty());
    }

    @Then("the error message should read {string}")
    public void the_error_message_should_read(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.getErrorMessage());
    }

    // Additional step definitions for other scenarios can be added here

    // Cleanup
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}