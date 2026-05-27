# Mapping: tests.LoginTest.verifyValidLogin() [@Test @BeforeMethod/@AfterMethod per method]
@global
Feature: Login Test

  Scenario: Verify valid global user login
    Given the browser session is started
    When the global user login is verified
    Then the scenario completes successfully
