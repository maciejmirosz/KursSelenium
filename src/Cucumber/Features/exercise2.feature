Feature: make an order in my store

  Scenario: make an order in my store
    Given an open browser with my store
    When log in to my store
    Then navigate to clothes page
    And navigate to Hummingbird Printed Sweater
    And choose size
    And choose quantity
    And add product to cart
    And go to checkout
    And confirm address
    And choose delivery method
    And choose payment option
    And make an order
    And take screenshot