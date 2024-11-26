package com.epam.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListingPage {
    WebDriver driver;

    @FindBy(css = ".add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(css = ".cart-icon")
    private WebElement cartIcon;

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public void clickCartIcon() {
        cartIcon.click();
    }
}
