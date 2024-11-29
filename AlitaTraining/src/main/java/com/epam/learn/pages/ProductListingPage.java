package com.epam.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductListingPage {
    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Add to Cart')]")
    private List<WebElement> addToCartButtons;

    @FindBy(id = "cart-icon")
    private WebElement cartIcon;

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addProductsToCart(List<String> productNames) {
        for (String productName : productNames) {
            for (WebElement button : addToCartButtons) {
                if (button.getText().contains(productName)) {
                    button.click();
                    break;
                }
            }
        }
    }

    public void clickCartIcon() {
        cartIcon.click();
    }
}
