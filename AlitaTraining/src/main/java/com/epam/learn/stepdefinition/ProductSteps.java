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

    @Given("the user is on the product listing page")
    public void theUserIsOnTheProductListingPage() {
        driver.get("http://example.com/product-listing");
    }

    @When("the user clicks the {string} button for a product")
    public void theUserClicksTheButtonForAProduct(String buttonName) {
        if (buttonName.equals("Add to Cart")) {
            productPage.clickAddToCart();
        }
    }

    @Then("the product should be added to their shopping cart")
    public void theProductShouldBeAddedToTheirShoppingCart() {
        // Implement verification logic
    }

    @Then("the cart icon should update to show the number of items in the cart")
    public void theCartIconShouldUpdateToShowTheNumberOfItemsInTheCart() {
        // Implement verification logic
    }

    @Given("the user has added items to the cart")
    public void theUserHasAddedItemsToTheCart() {
        // Implement logic to ensure items are added to the cart
    }

    @When("the user clicks on the cart icon")
    public void theUserClicksOnTheCartIcon() {
        productPage.clickCartIcon();
    }

    @Then("they should be taken to the cart page")
    public void theyShouldBeTakenToTheCartPage() {
        // Implement verification logic
    }

    @Then("they can see the details of their items, including product names and prices")
    public void theyCanSeeTheDetailsOfTheirItemsIncludingProductNamesAndPrices() {
        // Implement verification logic
    }

    @Given("the user is on the cart page")
    public void theUserIsOnTheCartPage() {
        driver.get("http://example.com/cart");
    }

    @When("the user clicks the {string} button next to a product")
    public void theUserClicksTheButtonNextToAProduct(String buttonName) {
        if (buttonName.equals("Remove")) {
            productPage.clickRemoveButton();
        }
    }

    @Then("that item should be removed from the cart")
    public void thatItemShouldBeRemovedFromTheCart() {
        // Implement verification logic
    }

    @Then("the total price should update accordingly")
    public void theTotalPriceShouldUpdateAccordingly() {
        // Implement verification logic
    }

    @Given("the user is not on the product listing page")
    public void theUserIsNotOnTheProductListingPage() {
        driver.get("http://example.com/another-page");
    }

    @When("the user attempts to click the {string} button")
    public void theUserAttemptsToClickTheButton(String buttonName) {
        if (buttonName.equals("Add to Cart")) {
            productPage.clickAddToCart();
        }
    }

    @Then("the product should not be added to the cart")
    public void theProductShouldNotBeAddedToTheCart() {
        // Implement verification logic
    }

    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String errorMessage) {
        Assert.assertEquals(errorMessage, productPage.getErrorMessage());
    }
}
