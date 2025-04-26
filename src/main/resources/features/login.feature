Feature: Login

  Scenario Outline : Login test with valid and invalid credentials
    Given I am on the login page for "<testType>" test
    When I enter "<username>" and password "<password>"
    And I click the login button
    Then I should see "<expectedResult>"

    Examples:
      | testType | username        | password      | expectedResult                                                              |
      | positive | standard_user   | secret_sauce  | Products                                                                    |
      | negative | wrong_user      | secret_sauce  | Epic sadface: Username and password do not match any user in this service   |
      | negative | standard_user   | wrong_sauce   | Epic sadface: Username and password do not match any user in this service   |
      | negative |                 | secret_sauce  | Epic sadface: Username is required                                          |
      | negative | standard_user   |               | Epic sadface: Password is required                                          |
      | negative |                 |               | Epic sadface: Username is required