package com.epam.learn.stepdefinition;

import com.epam.learn.pages.CartPage;
import com.epam.learn.pages.ProductListingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartSteps {
    private WebDriver driver;
    private ProductListingPage productListingPage;
    private CartPage cartPage;

    @Given("the user is on a product listing page")
    public void theUserIsOnAProductListingPage() {
        driver = new ChromeDriver();
        driver.get("http://example.com/product-listing");
        productListingPage = new ProductListingPage(driver);
    }

    @When("they click the {string} button for a product")
    public void theyClickTheButtonForAProduct(String button) {
        if (button.equals("Add to Cart")) {
            productListingPage.clickAddToCart();
        }
    }

    @Then("the product should be added to their shopping cart")
    public void theProductShouldBeAddedToTheirShoppingCart() {
        // Verification logic for product added to cart
    }

    @Then("the cart icon should update to show the number of items in the cart")
    public void theCartIconShouldUpdateToShowTheNumberOfItemsInTheCart() {
        // Verification logic for cart icon update
    }

    @Given("the user has added items to the cart")
    public void theUserHasAddedItemsToTheCart() {
        // Logic to ensure items are added to the cart
    }

    @When("they click on the cart icon")
    public void theyClickOnTheCartIcon() {
        productListingPage.clickCartIcon();
    }

    @Then("they should be taken to the cart page")
    public void theyShouldBeTakenToTheCartPage() {
        // Verification logic for navigation to cart page
    }

    @Then("they can see the details of their items, including product names and prices")
    public void theyCanSeeTheDetailsOfTheirItemsIncludingProductNamesAndPrices() {
        // Verification logic for item details
    }

    @Given("the user is on the cart page")
    public void theUserIsOnTheCartPage() {
        cartPage = new CartPage(driver);
    }

    @When("they click the {string} button next to a product")
    public void theyClickTheButtonNextToAProduct(String button) {
        if (button.equals("Remove")) {
            cartPage.clickRemoveButton();
        }
    }

    @Then("that item should be removed from the cart")
    public void thatItemShouldBeRemovedFromTheCart() {
        // Verification logic for item removal
    }

    @Then("the total price should update accordingly")
    public void theTotalPriceShouldUpdateAccordingly() {
        // Verification logic for total price update
    }

    @Given("the user is not logged in")
    public void theUserIsNotLoggedIn() {
        // Logic to ensure user is not logged in
    }

    @Then("the user should be prompted to log in or create an account")
    public void theUserShouldBePromptedToLogInOrCreateAnAccount() {
        // Verification logic for login prompt
    }

    @Then("an error message should be displayed saying {string}")
    public void anErrorMessageShouldBeDisplayedSaying(String message) {
        Assert.assertEquals(message, cartPage.getErrorMessage());
    }
}
