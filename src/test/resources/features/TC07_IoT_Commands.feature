# Mapping: tests.TC07_IoT_Commands.IoT_Commands() [@Test]
@operator
Feature: TC07 IoT Commands

  Scenario: IoT commands on kiosk asset
    Given the browser session is started
    When the IoT commands flow is executed
    Then the scenario completes successfully
