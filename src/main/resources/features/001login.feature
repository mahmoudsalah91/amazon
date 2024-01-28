Feature: User Login

  Scenario: User logs in with invalid credentials
    When user logs in with invalid credentials
    Then login should fail with an error message

  Scenario: User logs in with valid credentials
    When user logs in with valid credentials
    Then login should be successful

