Feature: Checkout and Payment

  As a user,
  I want to be able to complete my purchase by checking out and providing payment details,
  So that I can place my order and receive my items.

  @positive
  Scenario: User checks out with items in cart
    Given the user has items in their cart
    When they click the "Checkout" button
    Then they should be taken to the checkout page

  @positive
  Scenario Outline: User enters valid shipping details and places order
    Given the user is on the checkout page
    When they enter valid shipping details "<FirstName>", "<LastName>", "<ZipCode>"
    And click "Continue"
    Then the order should be successfully placed
    And they should see a page with order summary (items, shipping address, payment details)
    And click on "Finish" to complete the order

    Examples:
      | FirstName | LastName | ZipCode |
      | John      | Doe      | 12345   |
      | Jane      | Smith    | 67890   |

  @negative
  Scenario Outline: User enters invalid shipping details
    Given the user is on the checkout page
    When they enter invalid shipping details "<FirstName>", "<LastName>", "<ZipCode>"
    And click "Continue"
    Then they should see an error message "{{message}}"

    Examples:
      | FirstName | LastName | ZipCode | message                          |
      |           | Doe      | 12345   | "First name is required"         |
      | John      |          | 12345   | "Last name is required"          |
      | John      | Doe      |         | "Zip/Postal code is required"    |
      | John      | Doe      | abcde   | "Invalid Zip/Postal code format" |

  @negative
  Scenario: User tries to checkout with an empty cart
    Given the user has an empty cart
    When they click the "Checkout" button
    Then they should see an error message "Your cart is empty"