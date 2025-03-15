package com.epam.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    private List<WebElement> removeButtons;

    @FindBy(xpath = "//div[@class='cart-item']")
    private List<WebElement> cartItems;

    @FindBy(id = "total-price")
    private WebElement totalPrice;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void removeProductsFromCart(List<String> productNames) {
        for (String productName : productNames) {
            for (WebElement item : cartItems) {
                if (item.getText().contains(productName)) {
                    item.findElement(removeButtons).click();
                    break;
                }
            }
        }
    }

    public boolean isProductInCart(String productName) {
        for (WebElement item : cartItems) {
            if (item.getText().contains(productName)) {
                return true;
            }
        }
        return false;
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }
}
