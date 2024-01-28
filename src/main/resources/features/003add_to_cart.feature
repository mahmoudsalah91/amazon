Feature: Adding Products to Shopping Cart

  Scenario: Add a product to the shopping cart

    When User searches for product"laptop"
    And User selects the first available "laptop"
    And User adds the "laptop" to the shopping cart
    Then "Laptop" should be added to the shopping cart


    Given User is on the Amazon shopping cart page
    When User updates the quantity of the first item to "2"
    Then Quantity in the shopping cart should be updated to "2"