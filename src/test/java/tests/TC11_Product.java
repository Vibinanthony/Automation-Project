package tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static base.DriverFactory.driver;

public class TC11_Product extends BaseTest {

    private static final Logger log = LogManager.getLogger(TC09_Campaign.class);

    @Test(priority = 0)
    public void Product() throws InterruptedException, IOException {

        loginAsOperatorUser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));   // Explicit Wait
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"hamburger\"]/div"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div[2]/section/div[1]/div/div[1]/ul/li[3]/div/span"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Products"))).click();

        String currentUrlOfPage = driver.getCurrentUrl();
        if (currentUrlOfPage.equals("https://pwa.devconnecthq.live/home/product/products")) {
            System.out.println("Product Button has been clicked");
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"hamburger\"]/div"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div[2]/section/div[1]/div/div[1]/ul/li[3]/div/span"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Products"))).click();
            System.out.println("The button was not clicked properly, clicked again");
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Name']"))).sendKeys("12 oz Bowls");
        log.info("The 12 oz Bowls has been sent to the search box");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'ant-btn-link') and .//span[contains(.,'12 oz Bowls')]]"))).click();
        log.info("The 12 oz Bowls has been clicked");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'ant-tabs-tab-btn') and contains(.,'Units of Measure')]"))).click();
        log.info("Unit of Measures has been clicked");

        String barcodeValue = "098764834";

// Check whether barcode exists
        List<WebElement> barcodePresent = driver.findElements(By.xpath("//tr[.//td[contains(text(),'" + barcodeValue + "')]]"));

        if (barcodePresent.size() > 0) {

            log.info("Barcode already exists");

            // Delete existing barcode
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[.//td[contains(text(),'" + barcodeValue + "')]]//button[contains(@id,'delete-barcode-btn')]"))).click();
            log.info("Delete barcode button clicked");

            // Click Yes button
            WebElement yesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'ant-btn-primary')]//span[text()='Yes']")));

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", yesButton);
            log.info("Yes button clicked");

            // Wait until popup closes
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'ant-modal-wrap')]")));
            log.info("Popup closed successfully");
        }

       // Add barcode
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-barcode-btn"))).click();
        log.info("Add Barcode button clicked");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("basic_barcode"))).sendKeys(barcodeValue);
        log.info("Barcode value entered");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-barcode-save-button"))).click();
        log.info("Save button clicked");


        // Success validation
        WebElement successPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Barcode Added Successfully')]")));
        log.info(successPopup.getText());

    }
}
