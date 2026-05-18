package stepdefinitions;

import base.BaseTest_Operator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Migrated from tests.LogoutTest — operator login prerequisite + logout flow.
 */
public class LogoutTestSteps extends BaseTest_Operator {

    private static final Logger log = LogManager.getLogger(LogoutTestSteps.class);

    @Given("the operator user is logged in")
    public void theOperatorUserIsLoggedIn() {
        syncFromTestContext();
        performOperatorLogin();
    }

    @When("the logout flow is executed")
    public void LogoutTest() {
        syncFromTestContext();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String current_url = driver.getCurrentUrl();

        if (current_url.equals("https://pwa.devconnecthq.live/home")) {

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"profile\"]/button/div[1]/div[1]/span"))).click();
            log.info("User Profile has been clicked");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"logout\"]/button/span"))).click();
            log.info("The Logout has been Done");
        } else {
            log.info("The URL is invalid, Skipping the logout.....................");
        }
    }
}
