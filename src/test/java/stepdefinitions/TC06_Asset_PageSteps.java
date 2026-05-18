package stepdefinitions;

import io.cucumber.java.en.When;
import tests.TC06_Asset_Page;

public class TC06_Asset_PageSteps {

    private TC06_Asset_Page test;

    @When("the asset tab is opened for kiosk info")
    public void theAssetTabIsOpenedForKioskInfo() throws Exception {
        test = StepExecutor.bind(TC06_Asset_Page.class);
        test.Opening_Asset_Tab();
    }

    @When("the asset tab fields are validated")
    public void theAssetTabFieldsAreValidated() throws Exception {
        test.Validate_Asset_Tab();
    }

    @When("the misc info fields are validated")
    public void theMiscInfoFieldsAreValidated() throws Exception {
        test.Validate_Misc_Info();
    }
}
