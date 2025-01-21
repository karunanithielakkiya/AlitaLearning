package com.epam.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListingPage {
    WebDriver driver;

    @FindBy(css = "button.add-to-cart")
    private WebElement addToCartButton;

    @FindBy(css = "span.cart-icon")
    private WebElement cartIcon;

    @FindBy(css = "div.out-of-stock")
    private WebElement outOfStockMessage;

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public boolean isOutOfStock() {
        return outOfStockMessage.isDisplayed();
    }

    public int getCartItemCount() {
        String itemCountText = cartIcon.getText();
        return Integer.parseInt(itemCountText);
    }
}