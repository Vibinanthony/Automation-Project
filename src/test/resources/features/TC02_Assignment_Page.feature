# Mapping: tests.TC02_Assignment_Page Assigning_operator + Validate_Assigned_Operator [@Test priority/dependsOn]
@global
Feature: TC02 Assignment Page

  Scenario: Assign operator and validate assignment history
    Given the browser session is started
    When the operator is assigned to the kiosk
    And the assigned operator placement history is validated
    Then the scenario completes successfully
