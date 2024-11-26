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
    public void the_user_has_items_in_their_cart() {
        // Assume user has items in cart
    }

    @When("they click the {string} button")
    public void they_click_the_button(String buttonName) {
        if (buttonName.equals("Checkout")) {
            checkoutPage.clickCheckoutButton();
        }
    }

    @Then("they should be taken to the checkout page")
    public void they_should_be_taken_to_the_checkout_page() {
        // Verify navigation to checkout page
    }

    @Given("the user is on the checkout page")
    public void the_user_is_on_the_checkout_page() {
        // Assume user is on checkout page
    }

    @When("they enter valid shipping details {string}, {string}, {string}")
    public void they_enter_valid_shipping_details(String firstName, String lastName, String zipCode) {
        checkoutPage.enterShippingDetails(firstName, lastName, zipCode);
    }

    @When("they enter invalid shipping details {string}, {string}, {string}")
    public void they_enter_invalid_shipping_details(String firstName, String lastName, String zipCode) {
        checkoutPage.enterShippingDetails(firstName, lastName, zipCode);
    }

    @When("click {string}")
    public void click(String buttonName) {
        if (buttonName.equals("Continue")) {
            checkoutPage.clickContinue();
        }
    }

    @Then("they should see an error message {string}")
    public void they_should_see_an_error_message(String message) {
        Assert.assertEquals(message, checkoutPage.getErrorMessage());
    }
}