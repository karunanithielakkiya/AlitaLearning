Feature: Add Products to Cart

  As a customer,
  I want to be able to add products to my cart,
  So that I can review my items before proceeding to checkout.

  @positive
  Scenario: Add a product to the cart
    Given the user is on a product listing page
    When they click the "Add to Cart" button for a product
    Then the product should be added to their shopping cart
    And the cart icon should update to show the number of items in the cart

  @positive
  Scenario: View cart details
    Given the user has added items to the cart
    When they click on the cart icon
    Then they should be taken to the cart page
    And they can see the details of their items, including product names and prices

  @positive
  Scenario: Remove a product from the cart
    Given the user is on the cart page
    When they click the "Remove" button next to a product
    Then that item should be removed from the cart
    And the total price should update accordingly

  @negative
  Scenario: Add a product to the cart without being logged in
    Given the user is on a product listing page
    And the user is not logged in
    When they click the "Add to Cart" button for a product
    Then the user should be prompted to log in or create an account

  @negative
  Scenario: Remove a product from an empty cart
    Given the user is on the cart page
    And the cart is empty
    When they attempt to remove a product
    Then an error message should be displayed saying "No items to remove"

  @boundary
  Scenario Outline: Add multiple products to the cart
    Given the user is on a product listing page
    When they click the "Add to Cart" button for <quantity> products
    Then the cart icon should update to show <quantity> items in the cart

    Examples:
      | quantity |
      | 1        |
      | 5        |
      | 10       |
      | 50       |