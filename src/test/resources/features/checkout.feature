Feature:

  Scenario Outline: Checkout with data from Excel
    Given I load checkout data
    And I use checkout data from row <rowNum>
    When I login using data from excel
    And I add product to cart
    And I navigate to the cart page
    And I click the checkout button
    When I fill personal information from excel
    And I click the continue button
    Then I should see the checkout overview page
    And I validate the checkout overview
    And I click the finish button
    Then I should see the confirmation message Thank you for your order!

    Example:
      |rowNum|
      | 1    |
      | 2    |