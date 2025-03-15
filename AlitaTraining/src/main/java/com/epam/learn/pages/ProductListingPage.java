package com.epam.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListingPage {
    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Add to Cart') and @data-product-name='Laptop']")
    private WebElement addToCartLaptopButton;

    @FindBy(xpath = "//button[contains(text(),'Add to Cart') and @data-product-name='Smartphone']")
    private WebElement addToCartSmartphoneButton;

    @FindBy(id = "cart-icon")
    private WebElement cartIcon;

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addProductToCart(String productName) {
        if (productName.equalsIgnoreCase("Laptop")) {
            addToCartLaptopButton.click();
        } else if (productName.equalsIgnoreCase("Smartphone")) {
            addToCartSmartphoneButton.click();
        }
    }

    public void clickCartIcon() {
        cartIcon.click();
    }
}
