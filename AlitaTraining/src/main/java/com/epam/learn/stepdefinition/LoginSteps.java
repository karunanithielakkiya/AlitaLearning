package com.epam.learn.stepdefinition;

import com.epam.learn.pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        // Initialize WebDriver (Assuming ChromeDriver is set in the system path)
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("the user is on the SauceDemo login page")
    public void theUserIsOnTheSauceDemoLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("the user enters a valid username {string} and password {string}")
    public void theUserEntersAValidUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user enters an invalid username {string} and a valid password {string}")
    public void theUserEntersAnInvalidUsernameAndAValidPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user leaves both username and password fields empty")
    public void theUserLeavesBothUsernameAndPasswordFieldsEmpty() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
    }

    @When("the user leaves the username field empty and enters a valid password {string}")
    public void theUserLeavesTheUsernameFieldEmptyAndEntersAValidPassword(String password) {
        loginPage.enterUsername("");
        loginPage.enterPassword(password);
    }

    @When("the user enters a valid username {string} and leaves the password field empty")
    public void theUserEntersAValidUsernameAndLeavesThePasswordFieldEmpty(String username) {
        loginPage.enterUsername(username);
        loginPage.enterPassword("");
    }

    @When("the user clicks on the Login button")
    public void theUserClicksOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the Inventory dashboard")
    public void theUserShouldBeRedirectedToTheInventoryDashboard() {
        // Assuming the URL changes to indicate successful login
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @Then("the system should display an error message {string}")
    public void theSystemShouldDisplayAnErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}
