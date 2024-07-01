@activity4
Feature: Data driven test without Example

Scenario: Testing with correct Data from inputs
    Given User is on the Login page
    When User enters "admin" and "password"
    Then get the conformation text and verify message as"Welocme back admin"
    