package hooks;

import base.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Cucumber lifecycle hooks replacing TestNG @BeforeClass / @AfterClass on BaseTest.
 *
 * What changed: Browser start/stop moved from BaseTest to Hooks for BDD execution.
 * Why: Cucumber runs scenarios, not TestNG test classes; one browser session per scenario
 *      matches one TestNG test class with its @BeforeClass/@AfterClass pair.
 * Mapping:
 *   @BeforeClass setUp()  → @Before startBrowserSession()
 *   @AfterClass tearDown() → @After closeBrowserSession()
 *   reset to home         → navigateToHomeIfLoggedIn() before each scenario when session exists
 */
public class Hooks {

    private static final Logger log = LogManager.getLogger(Hooks.class);

    @Before
    public void startBrowserSession(Scenario scenario) {
        TestContext.setCucumberManaged(true);
        TestContext.initializeIfNeeded();
        TestContext.navigateToHomeIfLoggedIn();
        log.info("Cucumber scenario started: {}", scenario.getName());
    }

    @After
    public void closeBrowserSession(Scenario scenario) throws InterruptedException {
        log.info("Cucumber scenario finished: {} (status: {})", scenario.getName(), scenario.getStatus());
        TestContext.tearDown();
        TestContext.setCucumberManaged(false);
    }
}
