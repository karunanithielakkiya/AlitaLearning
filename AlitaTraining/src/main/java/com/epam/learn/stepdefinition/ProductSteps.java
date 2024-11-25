package com.epam.learn.stepdefinition;

import com.epam.learn.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class ProductSteps {
    WebDriver driver;
    ProductPage productPage;

    @Given("the user is on a product listing page")
    public void the_user_is_on_a_product_listing_page() {
        driver = new ChromeDriver();
        driver.get("http://example.com/product-listing");
        productPage = new ProductPage(driver);
    }

    @When("they click the {string} button for a product")
    public void they_click_the_button_for_a_product(String buttonName) {
        if (buttonName.equals("Add to Cart")) {
            productPage.clickAddToCart();
        }
    }

    @Then("the product should be added to their shopping cart")
    public void the_product_should_be_added_to_their_shopping_cart() {
        // Verification logic for product added to cart
    }

    @Then("the cart icon should update to show the number of items in the cart")
    public void the_cart_icon_should_update_to_show_the_number_of_items_in_the_cart() {
        // Verification logic for cart icon update
    }

    @Given("the user has added items to the cart")
    public void the_user_has_added_items_to_the_cart() {
        // Logic to ensure items are added to the cart
    }

    @When("they click on the cart icon")
    public void they_click_on_the_cart_icon() {
        productPage.clickCartIcon();
    }

    @Then("they should be taken to the cart page")
    public void they_should_be_taken_to_the_cart_page() {
        // Verification logic for navigation to cart page
    }

    @Then("they can see the details of their items, including product names, quantities, and prices")
    public void they_can_see_the_details_of_their_items_including_product_names_quantities_and_prices() {
        // Verification logic for item details
    }

    @Given("the user is on the cart page")
    public void the_user_is_on_the_cart_page() {
        driver.get("http://example.com/cart");
    }

    @When("they click the {string} button next to a product")
    public void they_click_the_button_next_to_a_product(String buttonName) {
        if (buttonName.equals("Remove")) {
            productPage.clickRemoveButton();
        }
    }

    @Then("that item should be removed from the cart")
    public void that_item_should_be_removed_from_the_cart() {
        // Verification logic for item removal
    }

    @Then("the total price should update accordingly")
    public void the_total_price_should_update_accordingly() {
        // Verification logic for total price update
    }

    @Given("the user is not logged in")
    public void the_user_is_not_logged_in() {
        // Logic to ensure user is not logged in
    }

    @Then("the user should be prompted to log in or create an account")
    public void the_user_should_be_prompted_to_log_in_or_create_an_account() {
        // Verification logic for login prompt
    }

    @Given("the cart is empty")
    public void the_cart_is_empty() {
        // Logic to ensure cart is empty
    }
}
