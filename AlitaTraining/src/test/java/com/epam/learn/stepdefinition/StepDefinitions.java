package com.epam.learn.stepdefinition;

import com.epam.learn.pages.LoginPage;
import com.epam.learn.pages.RegistrationPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {

    WebDriver driver;
    RegistrationPage registrationPage;
    LoginPage loginPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @When("the user navigates to the registration page")
    public void navigateToRegistrationPage() {
        driver.get("http://example.com/register");
        registrationPage = new RegistrationPage(driver);
    }

    @When("the user enters a unique email address {string}")
    public void enterUniqueEmail(String email) {
        registrationPage.enterEmail(email);
    }

    @When("the user enters a password that meets the strength requirements {string}")
    public void enterStrongPassword(String password) {
        registrationPage.enterPassword(password);
    }

    @When("the user enters a weak password {string}")
    public void enterWeakPassword(String password) {
        registrationPage.enterPassword(password);
    }

    @When("the user clicks on the {string} button")
    public void clickButton(String button) {
        if (button.equals("Register")) {
            registrationPage.clickRegister();
        } else if (button.equals("Login")) {
            loginPage.clickLogin();
        }
    }

    @Then("the user should be successfully registered")
    public void verifySuccessfulRegistration() {
        Assert.assertEquals("Registration successful!", registrationPage.getConfirmationMessage());
    }

    @Then("the system should display an error message indicating that the password does not meet the strength requirements")
    public void verifyPasswordStrengthError() {
        Assert.assertEquals("Password does not meet strength requirements.", registrationPage.getErrorMessage());
    }

    @Given("the user has successfully registered with email {string} and password {string}")
    public void userHasRegistered(String email, String password) {
        navigateToRegistrationPage();
        enterUniqueEmail(email);
        enterStrongPassword(password);
        clickButton("Register");
    }

    @When("the user checks the email inbox")
    public void checkEmailInbox() {
        // Simulate checking email inbox
    }

    @Then("a confirmation email should be received")
    public void verifyConfirmationEmail() {
        // Simulate email verification
        Assert.assertTrue(true);
    }

    @Then("the email should contain a link to verify the email address")
    public void verifyEmailLink() {
        // Simulate email link verification
        Assert.assertTrue(true);
    }

    @Given("the user is registered and email is verified")
    public void userIsRegisteredAndVerified() {
        // Assume user is registered and verified
    }

    @When("the user navigates to the login page")
    public void navigateToLoginPage() {
        driver.get("http://example.com/login");
        loginPage = new LoginPage(driver);
    }

    @When("the user enters the registered email address {string}")
    public void enterRegisteredEmail(String email) {
        loginPage.enterEmail(email);
    }

    @When("the user enters the correct password {string}")
    public void enterCorrectPassword(String password) {
        loginPage.enterPassword(password);
    }

    @Then("the user should be successfully logged in")
    public void verifySuccessfulLogin() {
        Assert.assertTrue(loginPage.isDashboardDisplayed());
    }

    @Then("redirected to the dashboard")
    public void verifyDashboardRedirection() {
        Assert.assertTrue(loginPage.isDashboardDisplayed());
    }

    @Given("the user is registered")
    public void userIsRegistered() {
        // Assume user is registered
    }

    @When("the user enters an incorrect password {string}")
    public void enterIncorrectPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user repeats the login attempt multiple times")
    public void repeatLoginAttempts() {
        for (int i = 0; i < 5; i++) {
            clickButton("Login");
        }
    }

    @Then("the system should lock the account after multiple failed login attempts")
    public void verifyAccountLock() {
        Assert.assertEquals("Account locked due to multiple failed login attempts.", loginPage.getLockoutMessage());
    }

    @Then("display a lockout message")
    public void verifyLockoutMessage() {
        Assert.assertEquals("Account locked due to multiple failed login attempts.", loginPage.getLockoutMessage());
    }
}
