# Mapping: tests.Operator_LoginTest.verifyOperatorLogin() [@Test]
@operator
Feature: Operator Login Test

  Scenario: Verify valid operator user login
    Given the browser session is started
    When the operator user login is verified
    Then the scenario completes successfully
