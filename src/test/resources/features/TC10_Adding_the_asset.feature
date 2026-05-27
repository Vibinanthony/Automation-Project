# Mapping: tests.TC10_Adding_the_asset Adding_the_Asset + Removing_the_Asset [@Test priority]
@operator
Feature: TC10 Adding the Asset

  Scenario: Add and remove non-vending asset
    Given the browser session is started
    When the non-vending asset is added
    And the non-vending asset is removed
    Then the scenario completes successfully
