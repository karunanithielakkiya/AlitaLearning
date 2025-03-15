Feature: Shopping Cart Management
  As a customer, I want to be able to add products to my cart, so that I can review my items before proceeding to checkout.

  @positive
  Scenario: Add multiple products to the cart
    Given the user is on the product listing page
    When they click the "Add to Cart" button for the following products:
      | Product Name |
      | Product A    |
      | Product B    |
      | Product C    |
    Then the products should be added to their shopping cart
    And the cart icon should update to show the number of items in the cart

  @positive
  Scenario: View cart details
    Given the user has added items to the cart
    When they click on the cart icon
    Then they should be taken to the cart page
    And they can see the details of their items including product names, quantities, and prices

  @positive
  Scenario: Remove multiple products from the cart
    Given the user is on the cart page
    When they click the "Remove" button for the following products:
      | Product Name |
      | Product A    |
      | Product B    |
    Then those items should be removed from the cart
    And the total price should update accordingly

  @negative
  Scenario: Add a product to the cart without selecting a product
    Given the user is on the product listing page
    When they click the "Add to Cart" button without selecting a product
    Then an error message should be displayed saying "Please select a product to add to the cart"

  @negative
  Scenario: View cart details with an empty cart
    Given the user has not added any items to the cart
    When they click on the cart icon
    Then they should be taken to the cart page
    And a message should be displayed saying "Your cart is empty"

  @negative
  Scenario: Remove a product from the cart that is not present
    Given the user is on the cart page with no items
    When they click the "Remove" button next to a non-existent product
    Then an error message should be displayed saying "No such product in the cart to remove"