package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginButton");
    private By errorMessage = By.id("errorMessage");
    private By dashboardContent = By.id("dashboardContent");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Action Methods
    public void enterUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Verification Methods
    public boolean isErrorMessageDisplayed(String expectedMessage) {
        return driver.findElement(errorMessage).getText().equals(expectedMessage);
    }

    public boolean isDashboardDisplayed() {
        return driver.findElement(dashboardContent).isDisplayed();
    }
}
