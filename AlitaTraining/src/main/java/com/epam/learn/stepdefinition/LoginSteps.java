package com.epam.learn.stepdefinition;

import com.epam.learn.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        // Initialize WebDriver (Assuming ChromeDriver is set in system properties)
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("the user is on the SauceDemo login page")
    public void the_user_is_on_the_SauceDemo_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("the user enters a valid username {string} and password {string}")
    public void the_user_enters_a_valid_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user enters an invalid username {string} or password {string}")
    public void the_user_enters_an_invalid_username_or_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user leaves the username field empty")
    public void the_user_leaves_the_username_field_empty() {
        loginPage.enterUsername("");
    }

    @When("the user leaves the password field empty")
    public void the_user_leaves_the_password_field_empty() {
        loginPage.enterPassword("");
    }

    @When("the user clicks the Login button")
    public void the_user_clicks_the_Login_button() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the Inventory dashboard")
    public void the_user_should_be_redirected_to_the_Inventory_dashboard() {
        // Add verification logic for successful login
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @Then("the system should display an error message {string}")
    public void the_system_should_display_an_error_message(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}
