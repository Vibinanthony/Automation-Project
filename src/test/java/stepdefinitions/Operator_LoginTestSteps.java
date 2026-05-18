package stepdefinitions;

import base.TestContext;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.ConfigReader;

/**
 * BDD mapping for tests.Operator_LoginTest — reuses LoginPage and ConfigReader (no BaseTest).
 */
public class Operator_LoginTestSteps {

    @When("the operator user login is verified")
    public void theOperatorUserLoginIsVerified() {
        ConfigReader configReader = TestContext.getConfigReader();
        LoginPage loginPage = TestContext.getLoginPage();
        loginPage.login(configReader.getOperatorUsername(), configReader.getOperatorPassword());
        loginPage.clickherebutton();
        loginPage.verifyLogin();
    }
}
