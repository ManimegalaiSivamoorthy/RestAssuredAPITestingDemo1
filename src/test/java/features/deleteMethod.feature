
Feature: DeletePosts
  Test the delete operation

  Scenario: Verify DELETE operation after POST
    Given I ensure to Perform POST operation for "/customer_profile" with body as
      | id | name   | age | character |
      | 6  | Megala | 29  | good      |
    And  I Perform DELETE operation for "/customer_profile/{id}"
      | id |
      | 6  |
    And I perform GET operation with path parameter for "/customer_profile/{id}"
      | id |
      | 6  |
    Then I should not see the body with customer name as "Megala"