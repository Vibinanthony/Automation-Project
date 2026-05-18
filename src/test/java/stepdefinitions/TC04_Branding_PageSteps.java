package stepdefinitions;

import io.cucumber.java.en.When;
import tests.TC04_Branding_Page;

public class TC04_Branding_PageSteps {

    @When("the kiosk branding change flow is executed")
    public void theKioskBrandingChangeFlowIsExecuted() {
        StepExecutor.bind(TC04_Branding_Page.class).TC04_Branding_page();
    }
}
