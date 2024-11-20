package com.epam.learn.stepdefinition;

import com.epam.learn.pages.SauceDemoLoginPage;
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

public class SauceDemoLoginSteps {

    private WebDriver driver;
    private SauceDemoLoginPage loginPage;

    @Before
    public void setUp() {
        // Initialize WebDriver (Assuming ChromeDriver is set in system path)
        driver = new ChromeDriver();
        loginPage = new SauceDemoLoginPage(driver);
    }

    @After
    public void tearDown() {
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

    @When("the user enters an invalid username {string} and a valid password {string}")
    public void the_user_enters_an_invalid_username_and_a_valid_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user enters a valid username {string} and an invalid password {string}")
    public void the_user_enters_a_valid_username_and_an_invalid_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user leaves both username and password fields empty")
    public void the_user_leaves_both_username_and_password_fields_empty() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("clicks the Login button")
    public void clicks_the_Login_button() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the Inventory dashboard")
    public void the_user_should_be_redirected_to_the_Inventory_dashboard() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("User is not redirected to the Inventory dashboard", currentUrl.contains("inventory.html"));
    }

    @Then("the system should display an error message {string}")
    public void the_system_should_display_an_error_message(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals("Error message does not match", expectedErrorMessage, actualErrorMessage);
    }
}
