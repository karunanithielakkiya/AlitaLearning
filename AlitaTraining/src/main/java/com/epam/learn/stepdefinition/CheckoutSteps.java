package com.epam.learn.stepdefinition;

import com.epam.learn.pages.CheckoutPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class CheckoutSteps {

    private WebDriver driver;
    private CheckoutPage checkoutPage;

    @Given("the user has items in their cart")
    public void theUserHasItemsInTheirCart() {
        // Assume items are added to the cart
    }

    @When("they click the {string} button")
    public void theyClickTheButton(String buttonName) {
        checkoutPage = new CheckoutPage(driver);
        if (buttonName.equals("Checkout")) {
            checkoutPage.clickCheckout();
        } else if (buttonName.equals("Continue")) {
            checkoutPage.clickContinue();
        } else if (buttonName.equals("Finish")) {
            checkoutPage.clickFinish();
        }
    }

    @Then("they should be taken to the checkout page")
    public void theyShouldBeTakenToTheCheckoutPage() {
        // Verify navigation to checkout page
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        // Assume user is on the checkout page
    }

    @When("they enter valid shipping details {string}, {string}, {string}")
    public void theyEnterValidShippingDetails(String firstName, String lastName, String zipCode) {
        checkoutPage.enterShippingDetails(firstName, lastName, zipCode);
    }

    @Then("the order should be successfully placed")
    public void theOrderShouldBeSuccessfullyPlaced() {
        // Verify order placement
    }

    @Then("they should see a page with order summary")
    public void theyShouldSeeAPageWithOrderSummary(DataTable dataTable) {
        // Verify order summary page
    }

    @When("they enter invalid shipping details {string}, {string}, {string}")
    public void theyEnterInvalidShippingDetails(String firstName, String lastName, String zipCode) {
        checkoutPage.enterShippingDetails(firstName, lastName, zipCode);
    }

    @Then("they should see an error message {string}")
    public void theyShouldSeeAnErrorMessage(String expectedMessage) {
        String actualMessage = checkoutPage.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Given("the user has no items in their cart")
    public void theUserHasNoItemsInTheirCart() {
        // Assume cart is empty
    }

    @Then("they should see an error message {string}")
    public void theyShouldSeeAnErrorMessageForEmptyCart(String expectedMessage) {
        String actualMessage = checkoutPage.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
