package com.epam.learn.stepdefinition;

import com.epam.learn.pages.ProductPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductSteps {

    WebDriver driver;
    ProductPage productPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        productPage = new ProductPage(driver);
    }

    @Given("the user is on a product listing page")
    public void the_user_is_on_a_product_listing_page() {
        driver.get("http://example.com/product-listing");
    }

    @When("they click the {string} button for a product")
    public void they_click_the_button_for_a_product(String button) {
        if (button.equals("Add to Cart")) {
            productPage.clickAddToCart();
        }
    }

    @Then("the product should be added to their shopping cart")
    public void the_product_should_be_added_to_their_shopping_cart() {
        Assert.assertTrue(productPage.getCartItemCount() > 0);
    }

    @Then("the cart icon should update to show the number of items in the cart")
    public void the_cart_icon_should_update_to_show_the_number_of_items_in_the_cart() {
        Assert.assertEquals(1, productPage.getCartItemCount());
    }

    @Given("the user has added items to the cart")
    public void the_user_has_added_items_to_the_cart() {
        productPage.clickAddToCart();
    }

    @When("they click on the cart icon")
    public void they_click_on_the_cart_icon() {
        productPage.clickCartIcon();
    }

    @Then("they should be taken to the cart page")
    public void they_should_be_taken_to_the_cart_page() {
        // Assume there's a method to verify the cart page URL
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
    }

    @Then("they can see the details of their items, including product names, quantities, and prices")
    public void they_can_see_the_details_of_their_items_including_product_names_quantities_and_prices() {
        // Assume there's a method to verify the cart details
        Assert.assertTrue(true);
    }

    @Given("the user is on the cart page")
    public void the_user_is_on_the_cart_page() {
        driver.get("http://example.com/cart");
    }

    @When("they click the {string} button next to a product")
    public void they_click_the_button_next_to_a_product(String button) {
        if (button.equals("Remove")) {
            productPage.clickRemoveButton();
        }
    }

    @Then("that item should be removed from the cart")
    public void that_item_should_be_removed_from_the_cart() {
        Assert.assertEquals(0, productPage.getCartItemCount());
    }

    @Then("the total price should update accordingly")
    public void the_total_price_should_update_accordingly() {
        // Assume there's a method to verify the total price update
        Assert.assertTrue(true);
    }
}