@Firstexample
Feature: FirstTest

@Firstscenario @smoketest
Scenario: Opening a webpage using Selenium
    Given User is on the TS Home Page
    When User clicks on the about Us link
    Then the user is redirected to the page
    