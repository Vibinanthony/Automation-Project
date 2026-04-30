package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.ConfigReader;

import java.time.Duration;

public class BaseTest_Operator {

    public WebDriver driver;
    public LoginPage loginPage;
    public ConfigReader configReader;

    @BeforeTest// Runs once for ALL classes inside <test> tag
    public void setUp() {

        driver = DriverFactory.initializeDriver(); // Launch browser

        configReader = new ConfigReader(); // Load config

        driver.get(configReader.getUrl()); // Open URL

        loginPage = new LoginPage(driver); // Initialize login page

        // Operator login using your existing fields
        loginPage.login(
                configReader.getOperatorUsername(),  // OperatorUsername
                configReader.getOperatorPassword()   // OperatorPassword
        );

        loginPage.clickherebutton(); // Click Here button

        loginPage.verifyLogin(); // Verify login success
    }

    @BeforeMethod // Runs before each test
    public void resetToHome() {

        // 🏠 Reset to HOME page before each test
        driver.navigate().to("https://pwa.devconnecthq.live/home");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hamburger")));

        System.out.println("Reset to Home page");
    }

    @AfterMethod
    public void waitBetweenTests() throws InterruptedException {

        Thread.sleep(5000); // Delay between test methods
    }

    @AfterTest // Runs once after ALL classes
    @AfterClass
    public void tearDown() throws InterruptedException {

        Thread.sleep(5000); // Delay before closing browser

        driver.quit(); // Close browser
    }
}
