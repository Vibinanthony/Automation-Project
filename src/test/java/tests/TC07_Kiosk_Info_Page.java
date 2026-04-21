package tests;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
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

import static base.DriverFactory.driver;

public class TC07_Kiosk_Info_Page extends BaseTest {

    private static final Logger log = LogManager.getLogger(TC07_Kiosk_Info_Page.class);

    @Test(priority = 0)
    public void BrandingSettings() throws InterruptedException, IOException {

        //  log.info("############### Starting the validation of Branding ################");
        loginAsOperatorUser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));   // Explicit Wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hamburger\"]/div"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div[2]/section/div[1]/div/div[1]/ul/li[2]/div/span"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("assets"))).click();
        String currentUrlOfPage = driver.getCurrentUrl();

        if (currentUrlOfPage.equals("https://pwa.devconnecthq.live/home/assets/assets")) {
            System.out.println("Kiosk Asset Button has been clicked");
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("assets"))).click();
            System.out.println("The button was not clicked properly, clicked again");
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Manufacturer Serial Number"))).sendKeys("GCKDTYH59OY");
        log.info("The Manufacturer S/N is passed on the box");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-link ant-btn-link']//span[text()='GCFOODEXPRNC000916']"))).click();
        log.info("The Kiosk Info tab has been opened");

        String currentBranding = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"rc-tabs-0-panel-kioskInfo\"]/div/main/div[2]/div[1]/div[2]/div[7]/form/div/div/div[2]/div/div/span"))).getText();
        log.info("Brand Name : " + currentBranding);

        if (currentBranding.equals("InReach")){

            // Click the dropdown container first
            WebElement brandingDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@id='brandName']/ancestor::div[contains(@class,'ant-select-selector')]")));brandingDropdown.click();

            // Send value into hidden search input
            WebElement brandingInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("brandName")));
            Actions actions = new Actions(driver);
            actions.moveToElement(brandingInput).click().sendKeys("BistroToGo").perform();

            // Select matching option
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'ant-select-item-option-content') and text()='BistroToGo']"))).click();
            System.out.println("Branding selected successfully (if condition)");
        } else {

            // Click the dropdown container first
            WebElement brandingDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@id='brandName']/ancestor::div[contains(@class,'ant-select-selector')]")));brandingDropdown.click();

            // Send value into hidden search input
            WebElement brandingInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("brandName")));
            Actions actions = new Actions(driver);
            actions.moveToElement(brandingInput).click().sendKeys("InReach").perform();

            // Select matching option
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'ant-select-item-option-content') and text()='InReach']"))).click();
            System.out.println("Branding selected successfully");
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='gc-kiosk-info-save-button']"))).click();
        log.info("The save button has been clicked");

        String AfterBranding = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//label[contains(text(),'Branding')]/ancestor::div[contains(@class,'ant-form-item')]//span[contains(@class,'ant-select-selection-item')])[1]")
        )).getAttribute("title");

        System.out.println("Current Branding is: " + AfterBranding);

        // Validation of the popup message
        WebElement popup_validation = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'GC Kisosk updated successfully')]")));
        String popupMessage = popup_validation.getText();
        log.info("Popup message is: " + popupMessage);
        Assert.assertEquals(popupMessage, "GC Kisosk updated successfully");

        Assert.assertNotEquals(currentBranding, AfterBranding, "Branding value did not change");

    }

    @Test(priority = 1)
    public void SecurityPin() throws InterruptedException, IOException {

        Thread.sleep(3000);
        log.info("############### Starting the validation of Security Pin ################");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));   // Explicit Wait

        WebElement securityPinField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("securityPin")));

        String currentSecurityPin = securityPinField.getAttribute("value");
        log.info("Current Security pin : " + currentSecurityPin);

        securityPinField.click();
        securityPinField.sendKeys(Keys.CONTROL + "a");
        securityPinField.sendKeys(Keys.BACK_SPACE);

        if (currentSecurityPin.equals("1234")) {
            securityPinField.sendKeys("9821");
        } else {
            securityPinField.sendKeys("1234");
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='gc-kiosk-info-save-button']"))).click();
        log.info("The save button has been clicked");

        // Validation of the popup message
        WebElement popup_validation_security = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'GC Kisosk updated successfully')]")));
        String popupMessage = popup_validation_security.getText();
        log.info("Popup message is: " + popupMessage);
        Assert.assertEquals(popupMessage, "GC Kisosk updated successfully");

        String AfterSecurityPin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("securityPin"))).getAttribute("value");
        log.info("Updated Security pin : " + AfterSecurityPin);

        Assert.assertNotEquals(currentSecurityPin, AfterSecurityPin, "Security Pin value did not change");

    }


    @Test(priority = 2)
    public void TDSettings() throws InterruptedException, IOException {

        Thread.sleep(3000);
        log.info("############### Starting the validation of TD Setup ################");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));   // Explicit Wait

        String currentTDsettings = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='tdSupport']/ancestor::div[contains(@class,'ant-select')]//span[contains(@class,'ant-select-selection-item')]")
        )).getAttribute("title");

        log.info("Current TD Settings: " + currentTDsettings);


        if (currentTDsettings.equals("Enable")){

            // Click the dropdown container first
            WebElement TDDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@id='tdSupport']/ancestor::div[contains(@class,'ant-select')]//span[contains(@class,'ant-select-selection-item')]")));TDDropdown.click();

            // Send value into hidden search input
            WebElement brandingInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tdSupport")));
            Actions actions = new Actions(driver);
            actions.moveToElement(brandingInput).click().sendKeys("Disable").perform();

            // Select matching option
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'ant-select-item-option-content') and text()='Disable']"))).click();
            System.out.println("The Enable button has been updated");
        } else {

            // Click the dropdown container first
            WebElement TDDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@id='tdSupport']/ancestor::div[contains(@class,'ant-select')]//span[contains(@class,'ant-select-selection-item')]")));TDDropdown.click();

            // Send value into hidden search input
            WebElement brandingInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tdSupport")));
            Actions actions = new Actions(driver);
            actions.moveToElement(brandingInput).click().sendKeys("Enable").perform();

            // Select matching option
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'ant-select-item-option-content') and text()='Enable']"))).click();
            System.out.println("The Disable Button has been updated");
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='gc-kiosk-info-save-button']"))).click();
        log.info("The save button has been clicked");

        String AfterTDsettings = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='tdSupport']/ancestor::div[contains(@class,'ant-select')]//span[contains(@class,'ant-select-selection-item')]")
        )).getAttribute("title");

        log.info("Current TD Settings: " + AfterTDsettings);

        // Validation of the popup message
        WebElement popup_validation = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'GC Kisosk updated successfully')]")));
        String popupMessage = popup_validation.getText();
        log.info("Popup message is: " + popupMessage);
        Assert.assertEquals(popupMessage, "GC Kisosk updated successfully");

        Assert.assertNotEquals(currentTDsettings, AfterTDsettings, "TD Setting value did not change");

    }


}