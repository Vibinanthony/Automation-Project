package stepdefinitions;

import base.BaseTest_Operator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import tests.LogoutTest;

public class LogoutTestSteps {

    @Given("the operator user is logged in")
    public void theOperatorUserIsLoggedIn() {
        BaseTest_Operator operatorBase = StepExecutor.bind(BaseTest_Operator.class);
        operatorBase.performOperatorLogin();
    }

    @When("the logout flow is executed")
    public void theLogoutFlowIsExecuted() {
        StepExecutor.bind(LogoutTest.class).LogoutTest();
    }
}
