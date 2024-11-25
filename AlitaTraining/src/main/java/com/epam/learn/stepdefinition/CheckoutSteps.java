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
        // Assume user has items in cart
    }

    @When("they click the {string} button")
    public void theyClickTheButton(String buttonName) {
        if (buttonName.equals("Checkout")) {
            checkoutPage.clickCheckoutButton();
        }
    }

    @Then("they should be taken to the checkout page")
    public void theyShouldBeTakenToTheCheckoutPage() {
        // Verify navigation to checkout page
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        // Assume user is on checkout page
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
        // Verify order placement
    }

    @Then("they should see a page with order summary \(items, shipping address, payment details)")
    public void theyShouldSeeAPageWithOrderSummaryItems() {
        // Verify order summary page
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
