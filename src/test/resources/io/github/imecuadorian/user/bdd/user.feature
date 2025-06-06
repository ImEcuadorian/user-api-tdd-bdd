Feature: User management

  Scenario: Check unregistered user
    Given I have a user with email "maria@example.com"
    When I check if the user exists
    Then the result should be false

  Scenario: Check registered user
    Given I have a user with email "juan@example.com"
    And I register the user
    When I check if the user exists
    Then the result should be true
