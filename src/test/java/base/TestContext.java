package base;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.ConfigReader;

/**
 * Shared session state for Cucumber BDD execution.
 *
 * What changed: Centralizes driver/config/login objects that were previously owned only by BaseTest @BeforeClass.
 * Why: Cucumber Hooks run per scenario instead of TestNG @BeforeClass; step definitions and legacy test classes
 *      both need the same WebDriver without duplicating setup logic.
 * Mapping: BaseTest.setUp() / tearDown() → TestContext.initialize() / TestContext.tearDown()
 */
public final class TestContext {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    private static final ThreadLocal<ConfigReader> CONFIG = new ThreadLocal<>();
    private static final ThreadLocal<LoginPage> LOGIN_PAGE = new ThreadLocal<>();
    private static final ThreadLocal<Boolean> CUCUMBER_MANAGED = ThreadLocal.withInitial(() -> Boolean.FALSE);

    public static final String HOME_URL = "https://pwa.devconnecthq.live/home";

    private TestContext() {
    }

    public static boolean isCucumberManaged() {
        return Boolean.TRUE.equals(CUCUMBER_MANAGED.get());
    }

    public static void setCucumberManaged(boolean managed) {
        CUCUMBER_MANAGED.set(managed);
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }

    public static ConfigReader getConfigReader() {
        return CONFIG.get();
    }

    public static LoginPage getLoginPage() {
        return LOGIN_PAGE.get();
    }

    /**
     * Mirrors legacy BaseTest @BeforeClass setUp when running under Cucumber.
     */
    public static void initializeIfNeeded() {
        if (getDriver() != null) {
            return;
        }
        WebDriver webDriver = DriverFactory.initializeDriver();
        ConfigReader configReader = new ConfigReader();
        webDriver.get(configReader.getUrl());
        DRIVER.set(webDriver);
        CONFIG.set(configReader);
        LOGIN_PAGE.set(new LoginPage(webDriver));
        DriverFactory.driver = webDriver;
    }

    /**
     * Reset to home between scenarios in the same JVM run (session preserved, no re-login).
     * Mapping: manual navigation previously implicit when each @Test called login again.
     */
    public static void navigateToHomeIfLoggedIn() {
        WebDriver webDriver = getDriver();
        if (webDriver == null) {
            return;
        }
        String currentUrl = webDriver.getCurrentUrl();
        if (currentUrl != null && currentUrl.startsWith(HOME_URL) && !HOME_URL.equals(currentUrl)) {
            webDriver.get(HOME_URL);
        } else if (currentUrl != null && currentUrl.contains("/home") && !HOME_URL.equals(currentUrl)) {
            webDriver.get(HOME_URL);
        }
    }

    /**
     * Mirrors legacy BaseTest @AfterClass tearDown when running under Cucumber.
     */
    public static void tearDown() throws InterruptedException {
        WebDriver webDriver = getDriver();
        if (webDriver == null) {
            return;
        }
        Thread.sleep(2000);
        webDriver.quit();
        DRIVER.remove();
        CONFIG.remove();
        LOGIN_PAGE.remove();
        DriverFactory.driver = null;
        Thread.sleep(3000);
    }
}
