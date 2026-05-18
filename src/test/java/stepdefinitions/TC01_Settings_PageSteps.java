package stepdefinitions;

import io.cucumber.java.en.When;
import tests.TC01_Settings_Page;

/**
 * BDD mapping for tests.TC01_Settings_Page — delegates to existing Kiosk_Settings() logic unchanged.
 */
public class TC01_Settings_PageSteps {

    @When("the kiosk settings upload logs flow is executed")
    public void theKioskSettingsUploadLogsFlowIsExecuted() throws Exception {
        StepExecutor.bind(TC01_Settings_Page.class).Kiosk_Settings();
    }
}
