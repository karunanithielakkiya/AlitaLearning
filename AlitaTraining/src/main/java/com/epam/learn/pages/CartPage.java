package com.epam.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    @FindBy(css = "button.remove")
    private WebElement removeButton;

    @FindBy(css = "div.total-price")
    private WebElement totalPrice;

    @FindBy(css = "div.cart-empty-message")
    private WebElement cartEmptyMessage;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRemove() {
        removeButton.click();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public boolean isCartEmptyMessageDisplayed() {
        return cartEmptyMessage.isDisplayed();
    }
}