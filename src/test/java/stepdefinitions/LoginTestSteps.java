package stepdefinitions;

import base.TestContext;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.ConfigReader;

/**
 * BDD mapping for tests.LoginTest — reuses LoginPage and ConfigReader (no BaseTest).
 */
public class LoginTestSteps {

    @When("the global user login is verified")
    public void theGlobalUserLoginIsVerified() {
        ConfigReader configReader = TestContext.getConfigReader();
        LoginPage loginPage = TestContext.getLoginPage();
        loginPage.login(configReader.getUsername(), configReader.getPassword());
        loginPage.clickherebutton();
        loginPage.verifyLogin();
    }
}
