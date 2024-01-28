
Feature: Amazon Search Functionality

  Scenario: Search for a laptop on Amazon

    When User searches for "laptop"
    Then Search results are displayed
    Then the search results should match the search criteria

  Scenario: Search for a non-existent item

    When User searches for "@@@@@@@#$$$$$$$$$$$$$%4444434365655"
    Then No search results are displayed

  Scenario: Measure response time and relevance for laptop search

    When User searches for "laptop"
    Then Search results are displayed with response time and relevance
