package com.epam.learn.stepdefinition;

import com.epam.learn.pages.CartPage;
import com.epam.learn.pages.ProductListingPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartSteps extends BaseStep {

    private ProductListingPage productListingPage;
    private CartPage cartPage;

    @Given("the user is on the product listing page")
    public void theUserIsOnTheProductListingPage() {
        driver.get("http://example.com/product-listing");
        productListingPage = new ProductListingPage(driver);
    }

    @When("the user clicks the {string} button for a product")
    public void theUserClicksTheButtonForAProduct(String button) {
        if (button.equals("Add to Cart")) {
            productListingPage.clickAddToCart();
        }
    }

    @Then("the product should be added to their shopping cart")
    public void theProductShouldBeAddedToTheirShoppingCart() {
        Assert.assertTrue(productListingPage.getCartItemCount() > 0);
    }

    @And("the cart icon should update to show the number of items in the cart")
    public void theCartIconShouldUpdateToShowTheNumberOfItemsInTheCart() {
        Assert.assertEquals(1, productListingPage.getCartItemCount());
    }

    @Given("the user has added items to the cart")
    public void theUserHasAddedItemsToTheCart() {
        theUserIsOnTheProductListingPage();
        theUserClicksTheButtonForAProduct("Add to Cart");
    }

    @When("the user clicks on the cart icon")
    public void theUserClicksOnTheCartIcon() {
        cartPage = new CartPage(driver);
        // Assuming clicking cart icon navigates to cart page
        driver.get("http://example.com/cart");
    }

    @Then("they should be taken to the cart page")
    public void theyShouldBeTakenToTheCartPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart"));
    }

    // Additional step definitions can be added here
}
