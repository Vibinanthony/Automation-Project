# Mapping: tests.TC07_Kiosk_Info_Page Branding + SecurityPin + TDSettings [@Test priority]
@operator
Feature: TC07 Kiosk Info Page

  Scenario: Kiosk info branding security pin and TD settings
    Given the browser session is started
    When the kiosk info branding flow is executed
    And the kiosk security pin flow is executed
    And the kiosk TD settings flow is executed
    Then the scenario completes successfully
