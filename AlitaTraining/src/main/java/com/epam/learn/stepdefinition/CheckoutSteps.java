package com.epam.learn.stepdefinition;

import com.epam.learn.pages.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutSteps {
    WebDriver driver = new ChromeDriver();
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @Given("the user has items in their cart")
    public void theUserHasItemsInTheirCart() {
        // Assume items are already in the cart
    }

    @When("they click the {string} button")
    public void theyClickTheButton(String buttonName) {
        if (buttonName.equals("Checkout")) {
            checkoutPage.clickCheckout();
        }
    }

    @Then("they should be taken to the checkout page")
    public void theyShouldBeTakenToTheCheckoutPage() {
        // Verify the user is on the checkout page
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        // Navigate to the checkout page
    }

    @When("they enter valid shipping details {string}, {string}, {string}")
    public void theyEnterValidShippingDetails(String firstName, String lastName, String zipCode) {
        checkoutPage.enterShippingDetails(firstName, lastName, zipCode);
    }

    @Then("the order should be successfully placed")
    public void theOrderShouldBeSuccessfullyPlaced() {
        // Verify the order is placed successfully
    }

    @Then("they should see a page with order summary")
    public void theyShouldSeeAPageWithOrderSummary() {
        // Verify the order summary page is displayed
    }

    @When("they enter invalid shipping details {string}, {string}, {string}")
    public void theyEnterInvalidShippingDetails(String firstName, String lastName, String zipCode) {
        checkoutPage.enterShippingDetails(firstName, lastName, zipCode);
    }

    @Then("they should see an error message {string}")
    public void theyShouldSeeAnErrorMessage(String message) {
        Assert.assertEquals(message, checkoutPage.getErrorMessage());
    }
}
