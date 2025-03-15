Feature: Shopping Cart Management
  As a customer, I want to be able to add products to my cart, so that I can review my items before proceeding to checkout.

  @positive
  Scenario: Add a product to the shopping cart
    Given the user is on the product listing page
    When they click the "Add to Cart" button for a product from the list
    Then the product should be added to their shopping cart
    And the cart icon should update to show the number of items in the cart

  @positive
  Scenario: View items in the shopping cart
    Given the user has added items to the cart
    When they click on the cart icon
    Then they should be taken to the cart page
    And they can see the details of their items
      | Product Name | Price |
      | Example 1    | $10   |
      | Example 2    | $20   |

  @positive
  Scenario: Remove a product from the shopping cart
    Given the user is on the cart page
    When they click the "Remove" button next to a product from the list
    Then that item should be removed from the cart
    And the total price should update accordingly

  @negative
  Scenario: Add a product to the cart without selecting a product
    Given the user is on the product listing page
    When they click the "Add to Cart" button without selecting a product
    Then an error message should be displayed
    And the cart icon should not update

  @negative
  Scenario: Remove a product that is not in the cart
    Given the user is on the cart page
    When they click the "Remove" button for a product not in the cart
    Then an error message should be displayed
    And the cart contents should remain unchanged