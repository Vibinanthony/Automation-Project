package stepdefinitions;

import org.testng.Assert;
import base.BaseTest_Operator;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.time.Duration;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Migrated from tests.TC07_Kiosk_Info_Page_Settings — full Selenium logic lives here (no delegation).
 */
public class TC07_Kiosk_Info_Page_SettingsSteps extends BaseTest_Operator {
    private static final Logger log = LogManager.getLogger(TC07_Kiosk_Info_Page_SettingsSteps.class);

    @When("the low data mode flow is executed")
    public void LowDataMode() throws Exception {
        syncFromTestContext();


        log.info("############### Starting the validation of Low Data Mode ################");
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

        waitForLoaderToDisappear();  // waiting for spinner to disappear from the UI
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Manufacturer Serial Number"))).sendKeys("GCKDTYH59OY");
        log.info("The Manufacturer S/N is passed on the box");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button//span[starts-with(text(),'GCFOODEXAL00')])[1]"))).click();
        log.info("The Kiosk Info tab has been opened");

        String currentLowDataMode = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='lowData']/ancestor::div[contains(@class,'ant-select')]//span[contains(@class,'ant-select-selection-item')]")
        )).getAttribute("title");

        log.info("Current Low Data Mode : " + currentLowDataMode);

        if (currentLowDataMode.equals("No")) {

            WebElement lowDataDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@id='lowData']/ancestor::div[contains(@class,'ant-select-selector')]")
            ));
            lowDataDropdown.click();

            WebElement lowDataInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lowData")));
            Actions actions = new Actions(driver);
            actions.moveToElement(lowDataInput).click().sendKeys("Yes").perform();

            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'ant-select-item-option-content') and text()='Yes']")
            )).click();

            System.out.println("Low Data Mode changed from No to Yes");

        } else {

            WebElement lowDataDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@id='lowData']/ancestor::div[contains(@class,'ant-select-selector')]")
            ));
            lowDataDropdown.click();

            WebElement lowDataInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lowData")));
            Actions actions = new Actions(driver);
            actions.moveToElement(lowDataInput).click().sendKeys("No").perform();

            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'ant-select-item-option-content') and text()='No']")
            )).click();

            System.out.println("Low Data Mode changed from Yes to No");
        }

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("gc-kiosk-info-save-button")
        )).click();

        log.info("The save button has been clicked");

        String afterLowDataMode = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='lowData']/ancestor::div[contains(@class,'ant-select')]//span[contains(@class,'ant-select-selection-item')]")
        )).getAttribute("title");

        log.info("After Low Data Mode : " + afterLowDataMode);

        // Validation of the popup message
        WebElement popup_validation = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'GC Kisosk updated successfully')]")));
        String popupMessage = popup_validation.getText();
        log.info("Popup message is: " + popupMessage);
        Assert.assertEquals(popupMessage, "GC Kisosk updated successfully");

        Assert.assertNotEquals(currentLowDataMode, afterLowDataMode, "Low Data Mode value did not change");

    
    }
    @When("the QR code visibility flow is executed")
    public void QRCodeVisibility() throws Exception {
        syncFromTestContext();


        Thread.sleep(3000);
        log.info("############### Starting the validation of QR Code Visibility ################");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));   // Explicit Wait



        WebElement QR_Code_Field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("qrCodesVisible")));

        String current_qr_code = QR_Code_Field.getAttribute("aria-checked");
        log.info("Current QR code visibility is : " + current_qr_code);

        if (current_qr_code.equals("false")) {
            QR_Code_Field.click();
            log.info("QR code visibility changed from false to true");
        } else {
            QR_Code_Field.click();
            log.info("The Qr code visiblity was true to false");
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            // Interact with it
            alert.accept();
            log.info("The Alert is box is accepted");
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='gc-kiosk-info-save-button']"))).click();
        log.info("The save button has been clicked");


        // Validation of the popup message
        WebElement popup_validation_security = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'GC Kisosk updated successfully')]")));
        String popupMessage = popup_validation_security.getText();
        log.info("Popup message is: " + popupMessage);
        Assert.assertEquals(popupMessage, "GC Kisosk updated successfully");

        String after_qr_code = QR_Code_Field.getAttribute("aria-checked");
        log.info("Current QR code visibility is : " + after_qr_code);

        Assert.assertNotEquals(current_qr_code, after_qr_code, "QR Code Visibility did not change");

    
    }
}
