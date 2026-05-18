package stepdefinitions;

import io.cucumber.java.en.When;
import tests.TC07_Kiosk_Info_Page_Discount;

public class TC07_Kiosk_Info_Page_DiscountSteps {

    @When("the kiosk discount flow is executed")
    public void theKioskDiscountFlowIsExecuted() throws Exception {
        StepExecutor.bind(TC07_Kiosk_Info_Page_Discount.class).Discount();
    }
}
