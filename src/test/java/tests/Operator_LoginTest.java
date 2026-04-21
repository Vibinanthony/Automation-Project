package tests;

import base.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

public class Operator_LoginTest {

    WebDriver driver;
    ConfigReader configReader;
    LoginPage operatorLoginPage;

    private static final Logger log = LogManager.getLogger(Operator_LoginTest.class);

    @BeforeMethod
    public void setUp() {

        driver = DriverFactory.initializeDriver();
        configReader = new ConfigReader();

        driver.get(configReader.getUrl());

        operatorLoginPage = new LoginPage(driver);

        log.info("Browser launched successfully");
    }

    @Test
    public void verifyOperatorLogin() {

        System.out.println(configReader.getOperatorUsername());
        System.out.println(configReader.getOperatorPassword());

        operatorLoginPage.login(
                configReader.getOperatorUsername(),
                configReader.getOperatorPassword()
        );

        operatorLoginPage.clickherebutton();
        operatorLoginPage.verifyLogin();

        log.info("Operator Login Test Executed Successfully");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
            log.info("Browser closed successfully");
        }
    }
}