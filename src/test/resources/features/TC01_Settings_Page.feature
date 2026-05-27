# Mapping: tests.TC01_Settings_Page.Kiosk_Settings() [@Test]
@global
Feature: TC01 Settings Page

  Scenario: Kiosk settings upload logs command
    Given the browser session is started
    When the kiosk settings upload logs flow is executed
    Then the scenario completes successfully
