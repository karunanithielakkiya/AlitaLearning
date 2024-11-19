package com.epam.learn.stepdefinition;

import com.epam.learn.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
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

    @When("the user enters a password {string}")
    public void theUserEntersAPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user submits the login form with an empty {string}")
    public void theUserSubmitsTheLoginFormWithAnEmptyField(String field) {
        if (field.equals("username")) {
            loginPage.enterUsername("");
        } else if (field.equals("password")) {
            loginPage.enterPassword("");
        }
        loginPage.clickLoginButton();
    }

    @When("clicks the login button")
    public void clicksTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the dashboard page")
    public void theUserShouldBeRedirectedToTheDashboardPage() {
        Assert.assertTrue("User is not on the dashboard page", loginPage.isOnDashboardPage());
    }

    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals("Error message does not match", expectedMessage, actualMessage);
    }

    @When("the user enters invalid credentials 5 times")
    public void theUserEntersInvalidCredentialsFiveTimes() {
        for (int i = 0; i < 5; i++) {
            loginPage.enterUsername("invalid_user");
            loginPage.enterPassword("wrong_pass");
            loginPage.clickLoginButton();
        }
    }

    @Then("a message {string} should be displayed")
    public void aMessageShouldBeDisplayed(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals("Message does not match", expectedMessage, actualMessage);
    }
}
