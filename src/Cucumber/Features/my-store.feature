Feature: Adding and checking new address to my store

  Scenario Outline: logging to my store, adding and checking new address
    Given new web
    When login to my store
    Then navigate to create new address view
    And fill and add new alias <alias>
    And fill and add new address <address>
    And fill and add new city <city>
    And fill and add new zip <zip>
    And fill and add new phone <phone>
    And click save
    And wait and check if data in new address is correct
    Examples:
      |alias|address|city|zip|phone|
      |Alias|Address|City|Zip|500500500|