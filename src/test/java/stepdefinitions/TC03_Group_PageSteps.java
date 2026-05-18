package stepdefinitions;

import io.cucumber.java.en.When;
import tests.TC03_Group_Page;

public class TC03_Group_PageSteps {

    @When("the kiosk group page flow is executed")
    public void theKioskGroupPageFlowIsExecuted() {
        StepExecutor.bind(TC03_Group_Page.class).TC03_Group_page();
    }
}
