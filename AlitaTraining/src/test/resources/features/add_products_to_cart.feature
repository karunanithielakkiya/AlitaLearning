Feature: Add Products to Cart

  @positive
  Scenario: Add Product to Cart
    Given the user is on a product listing page
    When they click the "Add to Cart" button for a product
    Then the product should be added to their shopping cart
    And the cart icon should update to show the number of items in the cart

  @positive
  Scenario: View Cart Details
    Given the user has added items to the cart
    When they click on the cart icon
    Then they should be taken to the cart page
    And they can see the details of their items, including product names and prices

  @positive
  @negative
  Scenario Outline: Remove Product from Cart
    Given the user is on the cart page
    When they click the "Remove" button next to a product
    Then that item should be removed from the cart
    And the total price should update accordingly
    And the cart icon should update to show the number of items in the cart

    Examples:
      | productName  | initialTotalPrice | expectedTotalPrice |
      | Product A    | $40               | $20                |
      | Product B    | $20               | $0                 |
      | Product C    | $60               | $40                |