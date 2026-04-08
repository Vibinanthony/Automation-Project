package tests;

import base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest {

    WebDriver driver;
    ConfigReader configReader;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {

        driver = DriverFactory.initializeDriver();

        configReader = new ConfigReader();
        driver.get(configReader.getUrl());

        loginPage = new LoginPage(driver);
    }

    @Test
    public void verifyValidLogin() {

        loginPage.login(
                configReader.getUsername(),
                configReader.getPassword()
        );

        System.out.println("Login Test Executed Successfully");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}