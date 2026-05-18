package stepdefinitions;

import base.TestContext;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.LoginPage;
import utils.ConfigReader;

/**
 * Migrated from tests.LoginTest — full global login verification logic.
 */
public class LoginTestSteps {

    private static final Logger log = LogManager.getLogger(LoginTestSteps.class);

    @When("the global user login is verified")
    public void verifyValidLogin() {
        ConfigReader configReader = TestContext.getConfigReader();
        LoginPage loginPage = TestContext.getLoginPage();

        loginPage.login(
                configReader.getUsername(),
                configReader.getPassword()
        );

        loginPage.clickherebutton();
        loginPage.verifyLogin();
        log.info("Login Test Executed Successfully");
    }
}
