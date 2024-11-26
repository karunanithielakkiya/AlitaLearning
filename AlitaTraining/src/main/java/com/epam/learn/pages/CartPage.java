package com.epam.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    @FindBy(css = ".remove-button")
    private WebElement removeButton;

    @FindBy(css = ".total-price")
    private WebElement totalPrice;

    @FindBy(css = ".error-message")
    private WebElement errorMessage;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRemoveButton() {
        removeButton.click();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
