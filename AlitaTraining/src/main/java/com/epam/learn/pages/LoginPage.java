package com.epam.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

public class LoginPage {

    @FindBy(id = "login_credentials")
    public WebElement loginIds;

    @FindBy(className = "login_password")
    public WebElement loginPwd;

    @FindBy(id = "user-name")
    private WebElement loginUser;

    @FindBy(id = "password")
    private WebElement loginPassword;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement logoutBtn;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement logoutMenu;

    @FindBy(xpath = "//div[text()='Swag Labs']")
    public WebElement homePageValidation;

    @FindBy(xpath = "//span[text()='Products']")
    public WebElement welcomePageText;

    Wait<WebDriver> wait = null;


public void enterUsername(String username) {
        loginUser.clear();
        loginUser.sendKeys(username);
    }

    public void enterPassword(String password) {
        loginPassword.clear();
        loginPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        loginBtn.click();
    }

    public String getErrorMessage() {
        // Implement logic to get error message
        return errorMessageContainer.getText();
    }

    public boolean isDashboardDisplayed() {
        // Implement logic to verify if the dashboard is displayed
        return dashboardContent.isDisplayed();
    }

    public boolean isPersonalizedContentDisplayed() {
        // Implement logic to verify if personalized content is displayed
        return dashboardContent.isDisplayed();
    }
}
