package com.epam.learn.stepdefinition;

import com.epam.learn.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        // Initialize WebDriver (e.g., ChromeDriver)
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("the user enters a valid username and password")
    public void theUserEntersAValidUsernameAndPassword(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> credential : credentials) {
            loginPage.enterUsername(credential.get("username"));
            loginPage.enterPassword(credential.get("password"));
        }
    }

    @When("the user enters an invalid username or password")
    public void theUserEntersAnInvalidUsernameOrPassword(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> credential : credentials) {
            loginPage.enterUsername(credential.get("username"));
            loginPage.enterPassword(credential.get("password"));
        }
    }

    @When("the user enters a password {string}")
    public void theUserEntersAPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user submits the login form with an empty username")
    public void theUserSubmitsTheLoginFormWithAnEmptyUsername() {
        loginPage.enterUsername("");
        loginPage.clickLoginButton();
    }

    @When("the user submits the login form with an empty password")
    public void theUserSubmitsTheLoginFormWithAnEmptyPassword() {
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
    }

    @When("the user enters invalid credentials 5 times")
    public void theUserEntersInvalidCredentials5Times(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < 5; i++) {
            for (Map<String, String> credential : credentials) {
                loginPage.enterUsername(credential.get("username"));
                loginPage.enterPassword(credential.get("password"));
                loginPage.clickLoginButton();
            }
        }
    }

    @Then("the user should be redirected to the dashboard page")
    public void theUserShouldBeRedirectedToTheDashboardPage() {
        assertTrue(driver.getCurrentUrl().contains("/dashboard"));
    }

    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String expectedMessage) {
        assertEquals(expectedMessage, loginPage.getErrorMessage());
    }

    @Then("a message {string} should be displayed")
    public void aMessageShouldBeDisplayed(String expectedMessage) {
        assertEquals(expectedMessage, loginPage.getErrorMessage());
    }
}
