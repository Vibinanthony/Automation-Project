package stepdefinitions;

import io.cucumber.java.en.When;
import tests.TC05_Dashboard_page;

public class TC05_Dashboard_pageSteps {

    @When("the kiosk dashboard data flow is executed")
    public void theKioskDashboardDataFlowIsExecuted() throws InterruptedException {
        StepExecutor.bind(TC05_Dashboard_page.class).TC05_Dashboard_page();
    }
}
