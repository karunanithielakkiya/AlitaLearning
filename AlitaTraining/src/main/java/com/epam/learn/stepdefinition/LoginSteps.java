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
        // Initialize WebDriver
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("the user enters a valid username and password")
    public void the_user_enters_a_valid_username_and_password(io.cucumber.datatable.DataTable dataTable) {
        String username = dataTable.cell(1, 0);
        String password = dataTable.cell(1, 1);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user enters an invalid username or password")
    public void the_user_enters_an_invalid_username_or_password(io.cucumber.datatable.DataTable dataTable) {
        for (int i = 1; i < dataTable.height(); i++) {
            String username = dataTable.cell(i, 0);
            String password = dataTable.cell(i, 1);
            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();
        }
    }

    @When("the user enters a password with less than 8 characters")
    public void the_user_enters_a_password_with_less_than_8_characters(io.cucumber.datatable.DataTable dataTable) {
        String password = dataTable.cell(1, 0);
        loginPage.enterPassword(password);
    }

    @When("the user enters a password without an uppercase letter")
    public void the_user_enters_a_password_without_an_uppercase_letter(io.cucumber.datatable.DataTable dataTable) {
        String password = dataTable.cell(1, 0);
        loginPage.enterPassword(password);
    }

    @When("the user enters a password without a lowercase letter")
    public void the_user_enters_a_password_without_a_lowercase_letter(io.cucumber.datatable.DataTable dataTable) {
        String password = dataTable.cell(1, 0);
        loginPage.enterPassword(password);
    }

    @When("the user enters a password without a numeric character")
    public void the_user_enters_a_password_without_a_numeric_character(io.cucumber.datatable.DataTable dataTable) {
        String password = dataTable.cell(1, 0);
        loginPage.enterPassword(password);
    }

    @When("the user enters a password without a special character")
    public void the_user_enters_a_password_without_a_special_character(io.cucumber.datatable.DataTable dataTable) {
        String password = dataTable.cell(1, 0);
        loginPage.enterPassword(password);
    }

    @When("the user submits the login form with an empty username")
    public void the_user_submits_the_login_form_with_an_empty_username(io.cucumber.datatable.DataTable dataTable) {
        String username = dataTable.cell(1, 0);
        String password = dataTable.cell(1, 1);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @When("the user submits the login form with an empty password")
    public void the_user_submits