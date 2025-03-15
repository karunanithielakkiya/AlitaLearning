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
    public void the_user_has_items_in_their_cart() {
        // Assume items are already in the cart
    }

    @When("they click the {string} button")
    public void they_click_the_button(String buttonName) {
        checkoutPage = new CheckoutPage(driver);
        if (buttonName.equals("Checkout")) {
            checkoutPage.clickCheckoutButton();
        }
    }

    @Then("they should be taken to the checkout page")
    public void they_should_be_taken_to_the_checkout_page() {
        // Verify the user is on the checkout page
        // This can be done by checking the URL or a specific element on the page
    }

    @Given("the user is on the checkout page")
    public void the_user_is_on_the_checkout_page() {
        // Assume the user is already on the checkout page
    }

    @When("they enter valid shipping details {string}, {string}, {string} and click {string}")
    public void they_enter_valid_shipping_details_and_click(String firstName, String lastName, String zipCode, String buttonName) {
        checkoutPage.enterShippingDetails(firstName, lastName, zipCode);
        if (buttonName.equals("Continue")) {
            checkoutPage.clickContinueButton();
        }
    }

    @Then("the order should be successfully placed")
    public void the_order_should_be_successfully_placed() {
        // Verify the order is placed successfully
    }

    @Then("they should see a page with order summary \(items, shipping address, payment details)")
    public void they_should_see_a_page_with_order_summary_items_shipping_address_payment_details() {
        // Verify the order summary page is displayed
    }

    @Then("click on Finish to complete the order")
    public void click_on_finish_to_complete_the_order() {
        checkoutPage.clickFinishButton();
    }

    @When("they enter invalid shipping details {string}, {string}, {string} and click {string}")
