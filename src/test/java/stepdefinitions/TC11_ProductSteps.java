package stepdefinitions;

import io.cucumber.java.en.When;
import tests.TC11_Product;

public class TC11_ProductSteps {

    @When("the product flow is executed")
    public void theProductFlowIsExecuted() throws Exception {
        StepExecutor.bind(TC11_Product.class).Product();
    }
}
