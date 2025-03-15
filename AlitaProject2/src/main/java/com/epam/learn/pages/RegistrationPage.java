package com.epam.learn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By registerButton = By.id("register");
    private By confirmationMessage = By.id("confirmation");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void submitRegistration() {
        driver.findElement(registerButton).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }
}
