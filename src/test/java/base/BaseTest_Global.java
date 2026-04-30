package base; // Package for base classes

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; // Selenium WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.LoginPage; // Import LoginPage
import utils.ConfigReader; // Import ConfigReader

import java.time.Duration;

public class BaseTest_Global {

    public WebDriver driver; // WebDriver instance
    public LoginPage loginPage; // Page object for login
    public ConfigReader configReader; // Read config values

    @BeforeTest// Runs once for ALL classes inside <test> tag
    public void setUp() {

        driver = DriverFactory.initializeDriver(); // Launch browser

        configReader = new ConfigReader(); // Read config file

        driver.get(configReader.getUrl()); // Open application URL

        loginPage = new LoginPage(driver); // Initialize login page

        // Global login using existing config fields
        loginPage.login(
                configReader.getUsername(),   // username from config.properties
                configReader.getPassword()    // password from config.properties
        );

        loginPage.clickherebutton(); // Click Here button

        loginPage.verifyLogin(); // Verify login success
    }

    @BeforeMethod // Runs before each test method
    public void resetToHome() {

        // 🏠 Always start from HOME page
        driver.navigate().to("https://pwa.devconnecthq.live/home");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait until page is ready (hamburger visible)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hamburger")));

        System.out.println("Reset to Home page");
    }

    @AfterMethod // Runs after each test method
    public void waitBetweenTests() throws InterruptedException {

        System.out.println("Waiting before next test...");

        Thread.sleep(5000); // Wait 5 seconds between tests
    }

    @AfterTest // Runs once after ALL classes
    public void tearDown() throws InterruptedException {

        System.out.println("Waiting before closing browser...");

        Thread.sleep(5000); // Wait before closing browser

        if (driver != null) {
            driver.quit(); // Close browser
        }
    }
}
