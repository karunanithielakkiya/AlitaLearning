package org.epam.learn.stepdefinition;

import org.epam.learn.pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps() {
        // Initialize WebDriver and LoginPage
        this.driver = Hooks.getDriver();
        this.loginPage = new LoginPage(driver);
    }

    @Given("the login page is displayed")
    public void the_login_page_is_displayed() {
        driver.get("http://example.com/login");
    }

    @When("the user enters a valid username {string} and a valid password {string}")
    public void the_user_enters_a_valid_username_and_a_valid_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user enters an invalid username {string} or an invalid password {string}")
    public void the_user_enters_an_invalid_username_or_an_invalid_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user leaves the username field empty")
    public void the_user_leaves_the_username_field_empty() {
        loginPage.enterUsername("");
    }

    @When("enters a valid password {string}")
    public void enters_a_valid_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("leaves the password field empty")
    public void leaves_the_password_field_empty() {
        loginPage.enterPassword("");
    }

    @When("the user enters invalid credentials {string} and {string} for 5 times")
    public void the_user_enters_invalid_credentials_and_for_5_times(String username, String password) {
        for (int i = 0; i < 5; i++) {
            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();
        }
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the dashboard page")
    public void the_user_should_be_redirected_to_the_dashboard_page() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("/dashboard"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"));
    }

    @Then("the dashboard should display personalized content")
    public void the_dashboard_should_display_personalized_content() {
        // Add verification for personalized content
    }

    @Then("an error message should be displayed with text {string}")
    public void an_error_message_should_be_displayed_with_text(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.getErrorMessage());
    }

    @Then("an error message should be displayed indicating that both fields are required")
    public void an_error_message_should_be_displayed_indicating_that_both_fields_are_required() {
        Assert.assertEquals("Both fields are required.", loginPage.getErrorMessage());
    }
}
