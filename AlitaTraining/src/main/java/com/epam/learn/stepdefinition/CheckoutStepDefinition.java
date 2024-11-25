package com.epam.learn.stepdefinition;

import com.epam.learn.pages.CheckoutPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class CheckoutStepDefinition extends BaseStep {

    private CheckoutPage checkoutPage;

    @Given("the user has items in their cart")
    public void theUserHasItemsInTheirCart() {
        // Assume items are already in the cart
    }

    @When("they click the {string} button")
    public void theyClickTheButton(String buttonName) {
        checkoutPage = new CheckoutPage(driver);
        if (buttonName.equals("Checkout")) {
            checkoutPage.clickCheckoutButton();
        }
    }

    @Then("they should be taken to the checkout page")
    public void theyShouldBeTakenToTheCheckoutPage() {
        // Verify the user is on the checkout page
        // This can be done by checking the URL or a specific element on the page
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        // Assume the user is already on the checkout page
    }

    @When("they enter valid shipping details {string}, {string}, {string}")
    public void theyEnterValidShippingDetails(String firstName, String lastName, String zipCode) {
        checkoutPage.enterShippingDetails(firstName, lastName, zipCode);
    }

    @When("click {string}")
    public void click(String buttonName) {
        if (buttonName.equals("Continue")) {
            checkoutPage.clickContinue();
        } else if (buttonName.equals("Finish")) {
            checkoutPage.clickFinish();
        }
    }

    @Then("the order should be successfully placed")
    public void theOrderShouldBeSuccessfullyPlaced() {
        // Verify the order is placed successfully
    }

    @Then("they should see a page with order summary \\(items, shipping address, payment details)")
    public void theyShouldSeeAPageWithOrderSummaryItemsShippingAddressPaymentDetails() {
        // Verify the order summary page is displayed
    }

    @When("they enter invalid shipping details {string}, {string}, {string}")
    public void theyEnterInvalidShippingDetails(String firstName, String lastName, String zipCode) {
        checkoutPage.enterShippingDetails(firstName, lastName, zipCode);
    }

    @Then("they should see an error message {string}")
    public void theyShouldSeeAnErrorMessage(String expectedMessage) {
        Assert.assertEquals(expectedMessage, checkoutPage.getErrorMessage());
    }

    @Given("the user has an empty cart")
    public void theUserHasAnEmptyCart() {
        // Assume the cart is empty
    }

    @Then("they should see an error message \"Your cart is empty\"")
    public void theyShouldSeeAnErrorMessageYourCartIsEmpty() {
        Assert.assertEquals("Your cart is empty", checkoutPage.getErrorMessage());
    }
}
