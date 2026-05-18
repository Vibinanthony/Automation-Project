package stepdefinitions;

import base.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Shared Gherkin steps for all features.
 * Mapping: documents that Hooks perform former BaseTest @BeforeClass browser launch.
 */
public class CommonSteps {

    @Given("the browser session is started")
    public void theBrowserSessionIsStarted() {
        Assert.assertNotNull(TestContext.getDriver(), "Browser session should be initialized by Hooks");
    }

    @Then("the scenario completes successfully")
    public void theScenarioCompletesSuccessfully() {
        Assert.assertNotNull(TestContext.getDriver(), "Browser session should remain active until scenario ends");
    }
}
