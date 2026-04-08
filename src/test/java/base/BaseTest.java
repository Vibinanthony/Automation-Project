package base; // Package name

import org.openqa.selenium.WebDriver; // Import Selenium WebDriver

import org.testng.annotations.AfterMethod; // Import AfterMethod annotation
import org.testng.annotations.BeforeMethod; // Import BeforeMethod annotation

import pages.LoginPage; // Import LoginPage class
import utils.ConfigReader; // Import ConfigReader class

public class BaseTest { // Parent class for all test classes

    public WebDriver driver; // WebDriver variable declaration

    public ConfigReader configReader; // ConfigReader object declaration

    public LoginPage loginPage; // LoginPage object declaration

    @BeforeMethod // This method runs before every @Test method
    public void setUp() {

        driver = DriverFactory.initializeDriver(); // Launch browser and store driver object

        configReader = new ConfigReader(); // Create object of ConfigReader class

        driver.get(configReader.getUrl()); // Open application URL from config.properties

        loginPage = new LoginPage(driver); // Create LoginPage object and pass driver

        loginPage.login( // Call login method from LoginPage class
                configReader.getUsername(), // Read username from config.properties
                configReader.getPassword() // Read password from config.properties
        );

        loginPage.clickherebutton(); // Click "Click Here" button after login

        loginPage.verifyLogin(); // Verify login is successful
    }

    @AfterMethod // This method runs after every @Test method
    public void tearDown() {

        if (driver != null) { // Check if driver is not null

            driver.quit(); // Close browser completely
        }
    }
}