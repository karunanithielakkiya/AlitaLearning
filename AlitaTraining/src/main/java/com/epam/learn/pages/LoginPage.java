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

    @FindBy(css = ".error-message-container")
    private WebElement errorMessageContainer;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessageContainer.getText();
    }

    Wait<WebDriver> wait = null;


}
