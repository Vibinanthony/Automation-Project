package tests;

import base.BaseTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogoutTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(LoginTest.class);

    @Test
    public void LogoutTest(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String current_url = driver.getCurrentUrl();

        if (current_url.equals("https://pwa.devconnecthq.live/home")){

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"profile\"]/button/div[1]/div[1]/span"))).click();
            log.info("User Profile has been clicked");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"logout\"]/button/span"))).click();
            log.info("The Logout has been Done");
        } else {
            log.info("The URL is invalid, Skipping the logout.....................");
        }
    }
}

