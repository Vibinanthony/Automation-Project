package base; // Package name

import org.openqa.selenium.WebDriver; // Import Selenium WebDriver
import org.testng.annotations.*;
import pages.LoginPage; // Import LoginPage class
import utils.ConfigReader; // Import ConfigReader class

public class BaseTest { // Parent class for all test classes

    public WebDriver driver; // WebDriver variable declaration
    public ConfigReader configReader; // ConfigReader object declaration
    public LoginPage loginPage; // LoginPage object declaration

    @BeforeClass // This method runs before the test
    public void setUp() {

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

    @AfterClass // This method runs onces after the @Test method
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000); // Wait for 5 seconds before closing browser

        if (driver != null) { // Check if driver is not null
            driver.quit(); // Close browser completely
            Thread.sleep(3000); // Wait for 3 seconds before next test starts
        }
    }
}