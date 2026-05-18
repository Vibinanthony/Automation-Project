package stepdefinitions;

import io.cucumber.java.en.When;
import tests.TC07_Kiosk_Info_Page_Settings;

public class TC07_Kiosk_Info_Page_SettingsSteps {

    private TC07_Kiosk_Info_Page_Settings test;

    @When("the low data mode flow is executed")
    public void theLowDataModeFlowIsExecuted() throws Exception {
        test = StepExecutor.bind(TC07_Kiosk_Info_Page_Settings.class);
        test.LowDataMode();
    }

    @When("the QR code visibility flow is executed")
    public void theQrCodeVisibilityFlowIsExecuted() throws Exception {
        test.QRCodeVisibility();
    }
}
