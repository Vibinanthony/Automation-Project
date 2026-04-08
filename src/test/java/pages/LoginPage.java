package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void login(String username, String password)
    {
        driver.findElement(By.id("Input_Username")).sendKeys(username);
        driver.findElement(By.id("Input_Password")).sendKeys(password);
        driver.findElement(By.id("login-submit")).click();
    }

    public void verifyLogin()
    {
        String actualText = driver.getCurrentUrl();
        Assert.assertEquals(actualText, "https://pwa.devconnecthq.live/home");
        System.out.println("The login is successful");
    }



}
