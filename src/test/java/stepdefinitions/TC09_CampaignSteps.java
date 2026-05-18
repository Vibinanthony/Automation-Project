package stepdefinitions;

import io.cucumber.java.en.When;
import tests.TC09_Campaign;

public class TC09_CampaignSteps {

    @When("the campaign flow is executed")
    public void theCampaignFlowIsExecuted() throws Exception {
        StepExecutor.bind(TC09_Campaign.class).Campaign();
    }
}
