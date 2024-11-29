package com.epam.learn.stepdefinition;

import com.epam.learn.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class LoginSteps extends BaseStep {
    private LoginPage loginPage;

    @Given("the user is on the login page at {string}")
    public void the_user_is_on_the_login_page_at(String url) {
        driver.get(url);
        loginPage = new LoginPage(driver);
    }

    @When("the user enters a valid username {string} and a valid password {string}")
    public void the_user_enters_a_valid_username_and_a_valid_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user leaves the username field empty")
    public void the_user_leaves_the_username_field_empty() {
        loginPage.enterUsername("");
    }

    @When("the user enters a valid password {string}")
    public void the_user_enters_a_valid_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user leaves the password field empty")
    public void the_user_leaves_the_password_field_empty() {
        loginPage.enterPassword("");
    }

    @When("the user enters an invalid username {string} and an invalid password {string}")
    public void the_user_enters_an_invalid_username_and_an_invalid_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user leaves both username and password fields empty")
    public void the_user_leaves_both_username_and_password_fields_empty() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
    }

    @When("the user clicks on the Login button")
    public void the_user_clicks_on_the_Login_button() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the Inventory dashboard")
    public void the_user_should_be_redirected_to_the_Inventory_dashboard() {
        // Implement the verification logic for redirection to the Inventory dashboard
        // Example: Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Then("the user should see an error message {string}")
    public void the_user_should_see_an_error_message(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
