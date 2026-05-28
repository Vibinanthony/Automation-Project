package base; // Package name

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; // Import Selenium WebDriver
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.LoginPage; // Import LoginPage class
import utils.ConfigReader; // Import ConfigReader class
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.time.Duration;
import java.util.List;

public class BaseTest { // Parent class for all test classes

    public WebDriver driver; // WebDriver variable declaration
    public ConfigReader configReader; // ConfigReader object declaration
    public LoginPage loginPage; // LoginPage object declaration
    private static final Logger log = LogManager.getLogger(BaseTest.class);

    /**
     * BDD bridge: wires legacy test class fields from TestContext after Cucumber Hooks start the browser.
     * Mapping: replaces implicit dependency on @BeforeClass when tests are invoked from step definitions.
     */
    public void syncFromTestContext() {
        this.driver = TestContext.getDriver();
        this.configReader = TestContext.getConfigReader();
        this.loginPage = TestContext.getLoginPage();
        DriverFactory.driver = this.driver;
    }

    @BeforeClass // This method runs before the test (TestNG-only; skipped when Cucumber manages lifecycle)
    public void setUp() {

        if (TestContext.isCucumberManaged()) {
            syncFromTestContext();
            return;
        }

        driver = DriverFactory.initializeDriver(); // Launch browser and store driver object
        configReader = new ConfigReader(); // Create object of ConfigReader class
        driver.get(configReader.getUrl()); // Open application URL from config.properties
        loginPage = new LoginPage(driver); // Create LoginPage object and pass driver
        }

            public void loginAsGlobalUser() {

                loginPage.login(
                        configReader.getUsername(),
                        configReader.getPassword()
                );
                loginPage.clickherebutton();
                loginPage.verifyLogin();
            }

            public void loginAsOperatorUser() {

                loginPage.login(
                        configReader.getOperatorUsername(),
                        configReader.getOperatorPassword()
                );
                loginPage.clickherebutton();
                loginPage.verifyLogin();
            }
            public void waitForLoaderToDisappear() {       // Added the method to validate the spinner on the UI and reused on all the test suite

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                List<WebElement> loader = driver.findElements(By.id("loading-container-for-tab"));

                if (loader.size() > 0) {
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-container-for-tab")));
                    log.info("Loading spinner disappeared");
                } else {
                    log.info("No loading spinner present");
                }
            }

    @AfterClass // This method runs onces after the @Test method (TestNG-only; skipped when Cucumber manages lifecycle)
    public void tearDown() throws InterruptedException {

        if (TestContext.isCucumberManaged()) {
            return;
        }

    @AfterClass // This method runs onces after the @Test method (TestNG-only; skipped when Cucumber manages lifecycle)
    public void tearDown() throws InterruptedException {

        if (TestContext.isCucumberManaged()) {
            return;
        }

        Thread.sleep(2000); // Wait for 5 seconds before closing browser

        if (driver != null) { // Check if driver is not null
            driver.quit(); // Close browser completely
            Thread.sleep(3000); // Wait for 3 seconds before next test starts
        }
    }
}