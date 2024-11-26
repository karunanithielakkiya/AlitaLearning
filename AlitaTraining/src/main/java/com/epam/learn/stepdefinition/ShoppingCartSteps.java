package com.epam.learn.stepdefinition;

import com.epam.learn.pages.ShoppingCartPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ShoppingCartSteps extends BaseStep {

    private ShoppingCartPage shoppingCartPage;

    @Given("the user is on the product listing page")
    public void theUserIsOnTheProductListingPage() {
        // Navigate to product listing page
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @When("they click the {string} button for a product from the list")
    public void theyClickTheButtonForAProductFromTheList(String button) {
        shoppingCartPage.clickAddToCart();
    }

    @Then("the product should be added to their shopping cart")
    public void theProductShouldBeAddedToTheirShoppingCart() {
        Assert.assertTrue(shoppingCartPage.getCartItemCount() > 0);
    }

    @Then("the cart icon should update to show the number of items in the cart")
    public void theCartIconShouldUpdateToShowTheNumberOfItemsInTheCart() {
        Assert.assertEquals(1, shoppingCartPage.getCartItemCount());
    }

    @Given("the user has added items to the cart")
    public void theUserHasAddedItemsToTheCart() {
        shoppingCartPage.clickAddToCart();
    }

    @When("they click on the cart icon")
    public void theyClickOnTheCartIcon() {
        shoppingCartPage.clickCartIcon();
    }

    @Then("they should be taken to the cart page")
    public void theyShouldBeTakenToTheCartPage() {
        Assert.assertTrue(shoppingCartPage.isCartPageDisplayed());
    }

    @Then("they can see the details of their items")
    public void theyCanSeeTheDetailsOfTheirItems(DataTable dataTable) {
        // Implement logic to verify item details
    }

    @Given("the user is on the cart page")
    public void theUserIsOnTheCartPage() {
        shoppingCartPage.clickCartIcon();
    }

    @When("they click the {string} button next to a product from the list")
    public void theyClickTheButtonNextToAProductFromTheList(String button) {
        shoppingCartPage.clickRemoveButton();
    }

    @Then("that item should be removed from the cart")
    public void thatItemShouldBeRemovedFromTheCart() {
        // Implement logic to verify item removal
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        Assert.assertTrue(shoppingCartPage.isErrorMessageDisplayed());
    }
}