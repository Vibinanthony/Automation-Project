package stepdefinitions;

import base.TestContext;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.LoginPage;
import utils.ConfigReader;

/**
 * Migrated from tests.Operator_LoginTest — full operator login verification logic.
 */
public class Operator_LoginTestSteps {

    private static final Logger log = LogManager.getLogger(Operator_LoginTestSteps.class);

    @When("the operator user login is verified")
    public void verifyOperatorLogin() {
        ConfigReader configReader = TestContext.getConfigReader();
        LoginPage operatorLoginPage = TestContext.getLoginPage();

        System.out.println(configReader.getOperatorUsername());
        System.out.println(configReader.getOperatorPassword());

        operatorLoginPage.login(
                configReader.getOperatorUsername(),
                configReader.getOperatorPassword()
        );

        operatorLoginPage.clickherebutton();
        operatorLoginPage.verifyLogin();

        log.info("Operator Login Test Executed Successfully");
    }
}
