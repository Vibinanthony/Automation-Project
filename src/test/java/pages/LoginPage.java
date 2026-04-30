package pages; // Package name

import org.openqa.selenium.By; // Import By class to locate elements
import org.openqa.selenium.WebDriver; // Import WebDriver interface
import org.openqa.selenium.support.ui.ExpectedConditions; // Import ExpectedConditions for explicit wait
import org.openqa.selenium.support.ui.WebDriverWait; // Import WebDriverWait class
import org.testng.Assert; // Import Assert class for validation

import java.time.Duration; // Import Duration class

public class LoginPage { // LoginPage class for handling login related actions
    WebDriver driver; // Declare WebDriver variable

    public LoginPage(WebDriver driver) { // Constructor to initialize driver
        this.driver = driver; // Assign driver value
    }

    public void login(String username, String password) { // Method for login action
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Create explicit wait object
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Input_Username"))).sendKeys(username); // Enter username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Input_Password"))).sendKeys(password); // Enter password
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-submit"))).click(); // Click login button
    }

    public void clickherebutton() { // Method to click "Here" button after login

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Create explicit wait object
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Here"))).click(); // Wait until Here link is clickable and click
        System.out.println("The Here button is clicked"); // Print message in console
    }

    public void verifyLogin() { // Method to verify login is successful

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Create explicit wait object
        wait.until(ExpectedConditions.urlContains("https://pwa.devconnecthq.live/home")); // Wait until URL contains home page URL
        String actualText = driver.getCurrentUrl(); // Get current URL after login
        Assert.assertEquals(actualText, "https://pwa.devconnecthq.live/home"); // Verify actual URL matches expected URL
        System.out.println("The login is successful"); // Print message in console
    }
}