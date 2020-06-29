Feature: PUTPost
  Verify put post operation

  Scenario: Verify PUT operation after POST
    Given I ensure to Perform POST operation for "/customer_profile" with body as
      | id | name   | age | character |
      | 6  | Megala | 29  | good      |
    And  I Perform PUT operation for "/update/{id}"
      | id | name   | age | character |
      | 6  | Mani | 29  | good      |
    And I perform GET operation with path parameter for "/customer_profile/{id}"
      | id |
      | 6  |
    Then I should see the body with customer name as "Mani"