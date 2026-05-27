# Mapping: tests.TC07_Kiosk_Info_Page_Discount.Discount() [@Test]
@operator
Feature: TC07 Kiosk Info Page Discount

  Scenario: Kiosk discount type change
    Given the browser session is started
    When the kiosk discount flow is executed
    Then the scenario completes successfully
