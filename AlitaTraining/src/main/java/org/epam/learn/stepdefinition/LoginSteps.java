package org.epam.learn.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.epam.learn.pages.LoginPage;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("the user is on the Saucedemo login page")
    public void the_user_is_on_the_saucedemo_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
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

    @When("the user clicks the login button {int} times")
    public void the_user_clicks_the_login_button_times(Integer times) {
        for (int i = 0; i < times; i++) {
            loginPage.clickLoginButton();
        }
    }

    @Then("the user should be redirected to the dashboard page")
    public void the_user_should_be_redirected_to_the_dashboard_page() {
        Assert.assertTrue(loginPage.isDashboardDisplayed());
    }

    @Then("the dashboard should display personalized content")
    public void the_dashboard_should_display_personalized_content() {
        // Implement verification for personalized content
    }

    @Then("an error message should be displayed with text {string}")
    public void an_error_message_should_be_displayed_with_text(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.getErrorMessage());
    }

    @Then("an error message should be displayed indicating that both fields are required")
    public void an_error_message_should_be_displayed_indicating_that_both_fields_are_required() {
        String expectedMessage = "Both fields are required"; // Placeholder
        Assert.assertEquals(expectedMessage, loginPage.getErrorMessage());
    }
}
