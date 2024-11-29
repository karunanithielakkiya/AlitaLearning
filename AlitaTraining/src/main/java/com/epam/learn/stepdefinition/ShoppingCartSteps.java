package com.epam.learn.stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import com.epam.learn.pages.ProductListingPage;
import com.epam.learn.pages.CartPage;

import java.util.List;

public class ShoppingCartSteps extends BaseStep {
    private ProductListingPage productListingPage;
    private CartPage cartPage;

    @Given("the user is on the product listing page")
    public void theUserIsOnTheProductListingPage() {
        driver.get("http://example.com/product-listing");
        productListingPage = new ProductListingPage(driver);
    }

    @When("they click the {string} button for the following products:")
    public void theyClickTheAddToCartButtonForTheFollowingProducts(String button, DataTable dataTable) {
        List<String> productNames = dataTable.asList(String.class);
        productListingPage.addProductsToCart(productNames);
    }

    @Then("the products should be added to their shopping cart")
    public void theProductsShouldBeAddedToTheirShoppingCart() {
        productListingPage.clickCartIcon();
        cartPage = new CartPage(driver);
        // Additional assertions can be added here
    }
}
