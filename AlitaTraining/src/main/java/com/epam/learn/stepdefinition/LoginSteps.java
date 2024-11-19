package com.epam.learn.stepdefinition;

import com.epam.learn.pages.LoginPage;
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

    @When("the user enters a valid username {string} and password {string}")
    public void theUserEntersAValidUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user enters an invalid username {string} or password {string}")
    public void theUserEntersAnInvalidUsernameOrPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user enters a password {string} with less than 8 characters")
    public void theUserEntersAPasswordWithLessThan8Characters(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user enters a password {string} without an uppercase letter")
    public void theUserEntersAPasswordWithoutAnUppercaseLetter(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user enters a password {string} without a lowercase letter")
    public void theUserEntersAPasswordWithoutALowercaseLetter(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user enters a password {string} without a special character")
    public void theUserEntersAPasswordWithoutASpecialCharacter(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user enters a password {string} without a numeric character")
    public void theUserEntersAPasswordWithoutANumericCharacter(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user submits the login form with empty username or password")
    public void theUserSubmitsTheLoginFormWithEmptyUsernameOrPassword() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
    }

    @When("the user enters invalid credentials 5 times")
    public void theUserEntersInvalidCredentials5Times() {
        for (int i = 0; i < 5; i++) {
            loginPage.enterUsername("invalid_user");
            loginPage.enterPassword("wrong_password");
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
    public void anErrorMessageShouldBeDisplayed(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.getErrorMessage());
    }
}