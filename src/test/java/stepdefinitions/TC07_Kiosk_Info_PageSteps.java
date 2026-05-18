package stepdefinitions;

import io.cucumber.java.en.When;
import tests.TC07_Kiosk_Info_Page;

public class TC07_Kiosk_Info_PageSteps {

    private TC07_Kiosk_Info_Page test;

    @When("the kiosk info branding flow is executed")
    public void theKioskInfoBrandingFlowIsExecuted() throws Exception {
        test = StepExecutor.bind(TC07_Kiosk_Info_Page.class);
        test.Branding();
    }

    @When("the kiosk security pin flow is executed")
    public void theKioskSecurityPinFlowIsExecuted() throws Exception {
        test.SecurityPin();
    }

    @When("the kiosk TD settings flow is executed")
    public void theKioskTdSettingsFlowIsExecuted() throws Exception {
        test.TDSettings();
    }
}
