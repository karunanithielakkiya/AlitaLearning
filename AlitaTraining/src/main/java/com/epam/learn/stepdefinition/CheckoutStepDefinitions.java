package com.epam.learn.stepdefinition;

import com.epam.learn.pages.CheckoutPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class CheckoutStepDefinitions {

    private WebDriver driver;
    private CheckoutPage checkoutPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        checkoutPage = new CheckoutPage(driver);
    }

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
        // Assume the user is already on the checkout page
    }

    @When("they enter valid shipping details {string}, {string}, {string}")
    public void theyEnterValidShippingDetails(String firstName, String lastName, String zipCode) {
        checkoutPage.enterShippingDetails(firstName, lastName, zipCode);
    }

    @Then("the order should be successfully placed")
    public void theOrderShouldBeSuccessfullyPlaced() {
        // Verify the order is placed
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
    public void theyShouldSeeAnErrorMessage(String expectedMessage) {
        String actualMessage = checkoutPage.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Given("the user has an empty cart")
    public void theUserHasAnEmptyCart() {
        // Assume the cart is empty
    }

    @Then("they should see an error message {string}")
    public void theyShouldSeeAnErrorMessageForEmptyCart(String expectedMessage) {
        String actualMessage = checkoutPage.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("click {string}")
    public void clickButton(String buttonName) {
        if (buttonName.equals("Finish")) {
            checkoutPage.clickFinish();
        }
    }
}
