Feature: Add Products to Cart

  @positive
  Scenario: Add a product to the cart
    Given the user is on the product listing page
    When the user clicks the "Add to Cart" button for a product
    Then the product should be added to their shopping cart
    And the cart icon should update to show the number of items in the cart

  @positive
  Scenario: View cart details
    Given the user has added items to the cart
    When the user clicks on the cart icon
    Then they should be taken to the cart page
    And they can see the details of their items, including product names and prices

  @positive
  Scenario: Remove a product from the cart
    Given the user is on the cart page
    When the user clicks the "Remove" button next to a product
    Then that item should be removed from the cart
    And the total price should update accordingly

  @negative
  Scenario: Add a product to the cart without being on the product listing page
    Given the user is not on the product listing page
    When the user attempts to click the "Add to Cart" button
    Then the product should not be added to the cart
    And an error message "Please select a product from the listing page" should be displayed

  @negative
  Scenario: Remove a product from an empty cart
    Given the user is on the cart page with no items
    When the user clicks the "Remove" button next to a product
    Then no action should be taken
    And an error message "No items to remove" should be displayed