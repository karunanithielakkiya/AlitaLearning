package com.epam.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    WebDriver driver;

    @FindBy(css = ".product-list .add-to-cart")
    private WebElement addToCartButton;

    @FindBy(css = ".cart-icon")
    private WebElement cartIcon;

    @FindBy(css = ".cart-page")
    private WebElement cartPage;

    @FindBy(css = ".remove-button")
    private WebElement removeButton;

    @FindBy(css = ".error-message")
    private WebElement errorMessage;

    public ShoppingCartPage(WebDriver driver) {
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

    public boolean isCartPageDisplayed() {
        return cartPage.isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public int getCartItemCount() {
        // Implement logic to return the number of items in the cart
        return 0; // Placeholder
    }
}