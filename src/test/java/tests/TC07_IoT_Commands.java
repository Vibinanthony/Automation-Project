package tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

public class TC07_IoT_Commands extends BaseTest {

    private static final Logger log = LogManager.getLogger(TC07_IoT_Commands.class);

    @Test(priority = 0)
    public void IoT_Commands() throws InterruptedException, IOException {

        log.info("############### Starting the validation of IoT Commands ################");
        loginAsOperatorUser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));   // Explicit Wait
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"hamburger\"]/div"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div[2]/section/div[1]/div/div[1]/ul/li[2]/div/span"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("assets"))).click();
        String currentUrlOfPage = driver.getCurrentUrl();

        if (currentUrlOfPage.equals("https://pwa.devconnecthq.live/home/assets/assets")) {
            System.out.println("Kiosk Asset Button has been clicked");
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"hamburger\"]/div"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div[2]/section/div[1]/div/div[1]/ul/li[2]/div/span"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("assets"))).click();
            System.out.println("The button was not clicked properly, clicked again");
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Manufacturer Serial Number"))).sendKeys("GCKDTYH59OY");
        log.info("The Manufacturer S/N is passed on the box");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button//span[starts-with(text(),'GCFOODEXPRNC')])[1]"))).click();
        log.info("The Kiosk Info tab has been opened");

        // ############ Update Catalog IoT command ##############

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='update-catalog-btn']"))).click();
        log.info("The Update Catalog button has been clicked");
        Thread.sleep(3000);
        // Validation of the popup message for Catalog download
        String  popup_validation_catalog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Success')]"))).getText();
        log.info("Popup message is: " + popup_validation_catalog);
        Assert.assertEquals(popup_validation_catalog, "Success");

        // ############ LYNK reboot IoT command ##############

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='reboot-kiosk-btn']"))).click();
        log.info("The Reboot LYNK button has been clicked");
        Thread.sleep(3000);
        // Validation of the popup message for LYNK Reboot
        String  popup_validation_rebootLYNK = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Success')]"))).getText();
        log.info("Popup message is: " + popup_validation_rebootLYNK);
        Assert.assertEquals(popup_validation_rebootLYNK, "Success");

        // ############ Kisok reboot IoT command ##############

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='reboot-lynk-btn']"))).click();
        log.info("The Reboot KIOSK button has been clicked");
        Thread.sleep(3000);
        // Validation of the popup message for Kiosk Reboot
        String  popup_validation_rebootkiosk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Success')]"))).getText();
        log.info("Popup message is: " + popup_validation_rebootkiosk);
        Assert.assertEquals(popup_validation_rebootkiosk, "Success");





    }
}