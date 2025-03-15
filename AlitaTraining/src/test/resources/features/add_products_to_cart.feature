Feature: Add products to cart

  @positive
  Scenario: Add a specific product to the cart from the product listing page
    Given the user is on the product listing page
    When the user clicks the "Add to Cart" button for the product "Laptop"
    Then the product "Laptop" should be added to their shopping cart
    And the cart icon should update to show the number of items in the cart

  @positive
  Scenario: Add multiple products to the cart
    Given the user is on the product listing page
    When the user clicks the "Add to Cart" button for the products "Laptop" and "Smartphone"
    Then the products "Laptop" and "Smartphone" should be added to their shopping cart
    And the cart icon should update to show the number of items in the cart

  @positive
  Scenario: View cart details after adding items
    Given the user has added items to the cart
    When the user clicks on the cart icon
    Then they should be taken to the cart page
    And they should see the details of their items including product names, quantities, and prices

  @positive
  Scenario: Remove a specific product from the cart
    Given the user is on the cart page with products "Laptop" and "Smartphone"
    When the user clicks the "Remove" button next to the product "Laptop"
    Then the product "Laptop" should be removed from the cart
    And the total price should update accordingly

  @negative
  Scenario: Attempt to view cart with no items added
    Given the user is on the product listing page
    When the user clicks on the cart icon without adding any items
    Then they should be taken to the cart page
    And they should see a message "Your cart is empty"

  @negative
  Scenario: Attempt to remove a product not in the cart
    Given the user is on the cart page with no items
    When the user attempts to click the "Remove" button next to a non-existent product
    Then no action should be taken
    And they should see a message "No items to remove"