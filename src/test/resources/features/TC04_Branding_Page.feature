# Mapping: tests.TC04_Branding_Page.TC04_Branding_page() [@Test]
@global
Feature: TC04 Branding Page

  Scenario: Change kiosk branding
    Given the browser session is started
    When the kiosk branding change flow is executed
    Then the scenario completes successfully
