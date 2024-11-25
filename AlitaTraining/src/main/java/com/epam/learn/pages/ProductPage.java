package com.epam.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;

    @FindBy(css = ".add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(css = ".cart-icon")
    private WebElement cartIcon;

    @FindBy(css = ".remove-button")
    private WebElement removeButton;

    @FindBy(css = ".login-prompt")
    private WebElement loginPrompt;

    @FindBy(css = ".error-message")
    private WebElement errorMessage;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public void clickCartIcon() {
        cartIcon.click();
    }

    public void clickRemoveButton() {
        removeButton.click();
    }

    public boolean isLoginPromptDisplayed() {
        return loginPrompt.isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public int getCartItemCount() {
        // Assume there's a method to extract the number of items from the cart icon
        return Integer.parseInt(cartIcon.getText());
    }
}