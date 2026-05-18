package stepdefinitions;

import io.cucumber.java.en.When;
import tests.TC10_Report;

public class TC10_ReportSteps {

    @When("the report flow is executed")
    public void theReportFlowIsExecuted() throws Exception {
        StepExecutor.bind(TC10_Report.class).Report();
    }
}
