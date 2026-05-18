package stepdefinitions;

import io.cucumber.java.en.When;
import tests.TC10_Adding_the_asset;

public class TC10_Adding_the_assetSteps {

    private TC10_Adding_the_asset test;

    @When("the non-vending asset is added")
    public void theNonVendingAssetIsAdded() throws Exception {
        test = StepExecutor.bind(TC10_Adding_the_asset.class);
        test.Adding_the_Asset();
    }

    @When("the non-vending asset is removed")
    public void theNonVendingAssetIsRemoved() throws Exception {
        test.Removing_the_Asset();
    }
}
