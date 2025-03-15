package com.epam.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Remove') and @data-product-name='Laptop']")
    private WebElement removeLaptopButton;

    @FindBy(xpath = "//div[@id='cart-message']")
    private WebElement cartMessage;

    @FindBy(id = "total-price")
    private WebElement totalPrice;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void removeProductFromCart(String productName) {
        if (productName.equalsIgnoreCase("Laptop")) {
            removeLaptopButton.click();
        }
    }

    public String getCartMessage() {
        return cartMessage.getText();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }
}
