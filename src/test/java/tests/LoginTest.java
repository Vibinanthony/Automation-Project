package tests; // Package name

import base.DriverFactory; // Import DriverFactory class
import org.openqa.selenium.WebDriver; // Import WebDriver interface
import org.testng.annotations.AfterMethod; // Import AfterMethod annotation
import org.testng.annotations.BeforeMethod; // Import BeforeMethod annotation
import org.testng.annotations.Test; // Import Test annotation
import pages.LoginPage; // Import LoginPage class
import utils.ConfigReader; // Import ConfigReader class

public class LoginTest { // Login test class

    WebDriver driver; // Declare WebDriver variable
    ConfigReader configReader; // Declare ConfigReader object
    LoginPage loginPage; // Declare LoginPage object

    @BeforeMethod // This method runs before every test method
    public void setUp() {

        driver = DriverFactory.initializeDriver(); // Launch browser and get driver object
        configReader = new ConfigReader(); // Create ConfigReader object
        driver.get(configReader.getUrl()); // Open URL from config.properties
        loginPage = new LoginPage(driver); // Create LoginPage object and pass driver
    }

    @Test // Actual test case
    public void verifyValidLogin() {

        loginPage.login( // Call login method from LoginPage class
                configReader.getUsername(), // Read username from config.properties
                configReader.getPassword() // Read password from config.properties
        );

        loginPage.clickherebutton(); // Click Here button after login
        loginPage.verifyLogin(); // Verify login is successful
        System.out.println("Login Test Executed Successfully"); // Print message in console
    }

    @AfterMethod // This method runs after every test method
    public void tearDown() {

        if (driver != null) { // Check if driver is not null
            driver.quit(); // Close browser completely
        }
    }
}