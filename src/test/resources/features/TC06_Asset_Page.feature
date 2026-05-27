# Mapping: tests.TC06_Asset_Page Opening_Asset_Tab + Validate_Asset_Tab + Validate_Misc_Info [@Test priority]
@operator
Feature: TC06 Asset Page

  Scenario: Asset tab and kiosk info validations
    Given the browser session is started
    When the asset tab is opened for kiosk info
    And the asset tab fields are validated
    And the misc info fields are validated
    Then the scenario completes successfully
