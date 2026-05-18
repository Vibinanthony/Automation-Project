package stepdefinitions;

import io.cucumber.java.en.When;
import tests.TC07_IoT_Commands;

public class TC07_IoT_CommandsSteps {

    @When("the IoT commands flow is executed")
    public void theIoTCommandsFlowIsExecuted() throws Exception {
        StepExecutor.bind(TC07_IoT_Commands.class).IoT_Commands();
    }
}
