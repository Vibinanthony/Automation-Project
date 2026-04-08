package base; // Package name

import io.github.bonigarcia.wdm.WebDriverManager; // Import WebDriverManager
import org.openqa.selenium.WebDriver; // Import WebDriver interface
import org.openqa.selenium.chrome.ChromeDriver; // Import ChromeDriver class
import utils.ConfigReader; // Import ConfigReader class

import java.time.Duration; // Import Duration class for waits

public class DriverFactory { // Class used for browser setup

    public static WebDriver driver; // Declare static WebDriver variable

    public static WebDriver initializeDriver() { // Method to launch browser and return driver

        ConfigReader configReader = new ConfigReader(); // Create object of ConfigReader

        String browser = configReader.getBrowser(); // Read browser value from config.properties

        if (browser.equalsIgnoreCase("chrome")) { // Check if browser value is chrome
            WebDriverManager.chromedriver().setup(); // Automatically download and setup ChromeDriver
            driver = new ChromeDriver(); // Launch Chrome browser
        }

        driver.manage().window().maximize(); // Maximize browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Add implicit wait of 10 seconds
        return driver; // Return driver object
    }
}