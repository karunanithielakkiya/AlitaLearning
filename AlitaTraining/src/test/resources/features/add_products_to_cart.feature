Feature: Add products to cart

  @positive
  Scenario: Add a product to the cart from the product listing page
    Given the user is on the product listing page
    When the user clicks the "Add to Cart" button for a product
    Then the product should be added to their shopping cart
    And the cart icon should update to show the number of items in the cart

  @positive
  Scenario: View cart details after adding items
    Given the user has added items to the cart
    When the user clicks on the cart icon
    Then they should be taken to the cart page
    And they can see the details of their items
      | Product Name | Quantity | Price |
      | Example 1    | 1        | $10   |
      | Example 2    | 2        | $20   |

  @positive
  Scenario: Remove a product from the cart
    Given the user is on the cart page
    When the user clicks the "Remove" button next to a product
    Then that item should be removed from the cart
    And the total price should update accordingly

  @negative
  Scenario: Attempt to add a product to the cart with no stock
    Given the user is on the product listing page
    And the product is out of stock
    When the user clicks the "Add to Cart" button for the product
    Then an error message should be displayed
    And the cart icon should not update

  @negative
  Scenario: View cart with no items
    Given the user has not added any items to the cart
    When the user clicks on the cart icon
    Then they should be taken to the cart page
    And a message should be displayed saying "Your cart is empty"