package com.saucedemo.automation.stepdefinition;

import com.saucedemo.automation.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        // Initialize WebDriver (Assuming ChromeDriver is set in system path)
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

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("the user enters a valid username and password")
    public void theUserEntersAValidUsernameAndPassword() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
    }

    @When("the user enters an invalid username or password")
    public void theUserEntersAnInvalidUsernameOrPassword() {
        loginPage.enterUsername("invalid_user");
        loginPage.enterPassword("invalid_password");
    }

    @When("the user enters a password {string}")
    public void theUserEntersAPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user submits the login form with the {string} field empty")
    public void theUserSubmitsTheLoginFormWithTheFieldEmpty(String field) {
        if (field.equals("username")) {
            loginPage.enterUsername("");
            loginPage.enterPassword("some_password");
        } else if (field.equals("password")) {
            loginPage.enterUsername("some_user");
            loginPage.enterPassword("");
        }
    }

    @When("the user enters invalid credentials {int} times")
    public void theUserEntersInvalidCredentialsTimes(int times) {
        for (int i = 0; i < times; i++) {
            loginPage.enterUsername("invalid_user");
            loginPage.enterPassword("invalid_password");
            loginPage.clickLoginButton();
        }
    }

    @When("clicks the login button")
    public void clicksTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the dashboard page")
    public void theUserShouldBeRedirectedToTheDashboardPage() {
        // Assuming the dashboard page URL is known
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, loginPage.getErrorMessage());
    }
}
