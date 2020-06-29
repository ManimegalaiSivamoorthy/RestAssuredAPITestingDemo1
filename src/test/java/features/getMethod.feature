Feature: GETPosts
  Verify GET operations using REST-assured

  Scenario: Verify one name of the customer profile
    Given I perform GET operation for "/customer_profile/1"
    Then I should see the customer name as "Velayudham Kumar"
