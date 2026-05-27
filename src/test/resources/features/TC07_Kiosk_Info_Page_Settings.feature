# Mapping: tests.TC07_Kiosk_Info_Page_Settings LowDataMode + QRCodeVisibility [@Test priority]
@operator
Feature: TC07 Kiosk Info Page Settings

  Scenario: Low data mode and QR code visibility
    Given the browser session is started
    When the low data mode flow is executed
    And the QR code visibility flow is executed
    Then the scenario completes successfully
