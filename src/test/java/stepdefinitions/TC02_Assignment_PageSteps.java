package stepdefinitions;

import io.cucumber.java.en.When;
import tests.TC02_Assignment_Page;

/**
 * BDD mapping for tests.TC02_Assignment_Page — same session, two @Test methods as two When steps.
 */
public class TC02_Assignment_PageSteps {

    private TC02_Assignment_Page test;

    @When("the operator is assigned to the kiosk")
    public void theOperatorIsAssignedToTheKiosk() throws Exception {
        test = StepExecutor.bind(TC02_Assignment_Page.class);
        test.Assigning_operator();
    }

    @When("the assigned operator placement history is validated")
    public void theAssignedOperatorPlacementHistoryIsValidated() {
        test.Validate_Assigned_Operator();
    }
}
