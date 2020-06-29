Feature: PostProfile
  Test POST operation using REST-assured library

  @smoke
  Scenario: Verify Post operation for Customer Profile
    Given I Perform POST operation for "/customer_profile" with body
      | id | name | age | character |
      | 5  | Anbu | 28  | good      |
    Then I should see the body has id as "5"