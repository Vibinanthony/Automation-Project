# Mapping: tests.LogoutTest.LogoutTest() [@Test] — expects existing home session
@operator
Feature: Logout Test

  Scenario: Logout from application home
    Given the browser session is started
    And the operator user is logged in
    When the logout flow is executed
    Then the scenario completes successfully
