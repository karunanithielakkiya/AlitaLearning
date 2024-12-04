package com.epam.learn.stepdefinition;

import com.epam.learn.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class LoginSteps extends BaseStep {

    private LoginPage loginPage;

    @Given("the user is on the SauceDemo login page")
    public void theUserIsOnTheSauceDemoLoginPage() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("the user enters a valid username and password")
    public void theUserEntersAValidUsernameAndPassword(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> credential : credentials) {
            loginPage.enterUsername(credential.get("username"));
            loginPage.enterPassword(credential.get("password"));
        }
    }

    @When("the user enters an invalid username and a valid password")
    public void theUserEntersAnInvalidUsernameAndAValidPassword(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> credential : credentials) {
            loginPage.enterUsername(credential.get("username"));
            loginPage.enterPassword(credential.get("password"));
        }
    }

    @When("the user enters a valid username and an invalid password")
    public void theUserEntersAValidUsernameAndAnInvalidPassword(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> credential : credentials) {
            loginPage.enterUsername(credential.get("username"));
            loginPage.enterPassword(credential.get("password"));
        }
    }

    @When("the user leaves both username and password fields empty")
    public void theUserLeavesBothUsernameAndPasswordFieldsEmpty() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
    }

    @When("the user enters {string} and {string}")
    public void theUserEntersAnd(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user clicks the Login button")
    public void theUserClicksTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the Inventory dashboard")
    public void theUserShouldBeRedirectedToTheInventoryDashboard() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("User is not on the Inventory dashboard", currentUrl.contains("inventory"));
    }

    @Then("the system should display an error message {string}")
    public void theSystemShouldDisplayAnErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals("Error message is not as expected", expectedErrorMessage, actualErrorMessage);
    }
}
