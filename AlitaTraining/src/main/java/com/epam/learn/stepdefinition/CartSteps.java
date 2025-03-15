package com.epam.learn.stepdefinition;

import com.epam.learn.pages.CartPage;
import com.epam.learn.pages.ProductListingPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class CartSteps extends BaseStep {
    private ProductListingPage productListingPage;
    private CartPage cartPage;

    @Given("the user is on the product listing page")
    public void theUserIsOnTheProductListingPage() {
        driver.get("http://example.com/product-listing");
        productListingPage = new ProductListingPage(driver);
    }

    @When("the user clicks the {string} button for the product {string}")
    public void theUserClicksTheAddToCartButtonForTheProduct(String button, String productName) {
        productListingPage.addProductToCart(productName);
    }

    @Then("the product {string} should be added to their shopping cart")
    public void theProductShouldBeAddedToTheirShoppingCart(String productName) {
        // Verification logic for product added to cart
    }

    @And("the cart icon should update to show the number of items in the cart")
    public void theCartIconShouldUpdateToShowTheNumberOfItemsInTheCart() {
        // Verification logic for cart icon update
    }

    @When("the user clicks the {string} button for the products")
    public void theUserClicksTheAddToCartButtonForTheProducts(Data
