package stepdefinitions;

import io.cucumber.java.en.When;
import tests.TC08_Hot_Button_Functionality;

public class TC08_Hot_Button_FunctionalitySteps {

    @When("the hot button functionality flow is executed")
    public void theHotButtonFunctionalityFlowIsExecuted() throws Exception {
        StepExecutor.bind(TC08_Hot_Button_Functionality.class).IoT_Commands();
    }
}
