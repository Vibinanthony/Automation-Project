package tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class TC01_Settings_Page extends BaseTest {

    private static final Logger log = LogManager.getLogger(TC01_Settings_Page.class);

    @Test
    public void Kiosk_Settings() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));   // Explicit Wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hamburger\"]/div"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Setup']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kioskSettings"))).click();
        log.info("Kiosk Settings Button is clicked");

        WebElement serialNumberInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("Manufacturer Serial Number")));
        serialNumberInput.clear();
        serialNumberInput.sendKeys("GCKDTYH59OY");

        log.info("The S/N is passed");

        By commandDropdownBy = By.xpath("//tr[contains(@class,'ant-table-row') and .//td[normalize-space()='GCKDTYH59OY']]//td[last()]//div[contains(@class,'ant-select-selector')]");
        By commandInputBy = By.xpath("//tr[contains(@class,'ant-table-row') and .//td[normalize-space()='GCKDTYH59OY']]//td[last()]//input[@role='combobox']");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean dropdownOpened = false;
        for (int attempt = 1; attempt <= 4; attempt++) {
            try {
                WebElement commandDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(commandDropdownBy));
                WebElement commandInput = wait.until(ExpectedConditions.presenceOfElementLocated(commandInputBy));
                log.info("Command dropdown displayed: " + commandDropdown.isDisplayed());
                log.info("Command dropdown enabled: " + commandDropdown.isEnabled());
                js.executeScript("arguments[0].scrollIntoView({block:'center'});", commandDropdown);
                try {
                    commandDropdown.click();
                } catch (Exception ignored) {
                }

                if (!"true".equalsIgnoreCase(commandInput.getDomAttribute("aria-expanded"))) {
                    new Actions(driver).moveToElement(commandDropdown).click().perform();
                }
                if (!"true".equalsIgnoreCase(commandInput.getDomAttribute("aria-expanded"))) {
                    js.executeScript("arguments[0].click();", commandInput);
                }
                if (!"true".equalsIgnoreCase(commandInput.getDomAttribute("aria-expanded"))) {
                    commandInput.sendKeys(Keys.ARROW_DOWN);
                }

                dropdownOpened = wait.until(d -> {
                    WebElement refreshedInput = d.findElement(commandInputBy);
                    return "true".equalsIgnoreCase(refreshedInput.getDomAttribute("aria-expanded"));
                });
                if (dropdownOpened) {
                    break;
                }
            } catch (StaleElementReferenceException staleEx) {
                log.info("Dropdown became stale, retrying... attempt " + attempt);
            } catch (TimeoutException timeoutEx) {
                log.info("Dropdown did not open, retrying... attempt " + attempt);
            }
        }
        Assert.assertTrue(dropdownOpened, "Could not open Command dropdown.");

        log.info("Command dropdown opened");

        // Exact option text from UI (see screenshot). Do not type in the combobox first — filtering can break selection.
        By uploadLogsBy = By.xpath("//div[contains(@class,'ant-select-dropdown') and not(contains(@class,'hidden'))]"
                + "//div[contains(@class,'ant-select-item-option-content') and normalize-space()='UPLOAD-LOGS']");

        WebElement uploadLogsOption = wait.until(ExpectedConditions.elementToBeClickable(uploadLogsBy));
        try {
            new Actions(driver).moveToElement(uploadLogsOption).pause(Duration.ofMillis(100)).click().perform();
        } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
            WebElement again = wait.until(ExpectedConditions.elementToBeClickable(uploadLogsBy));
            js.executeScript("arguments[0].click();", again);
        }
        log.info("Upload logs option selected");

        WebElement yesButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'ant-modal-footer')]//button[1]//span[normalize-space()='Yes']")));
        yesButton.click();
        log.info("Yes button clicked");
        
        // Validation of the popup message
        WebElement popup_validation = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'UPLOAD-LOGS command sent successfully')]")));
        String popupMessage = popup_validation.getText();
        log.info("Popup message is: " + popupMessage);
        Assert.assertEquals(popupMessage, "UPLOAD-LOGS command sent successfully");


    }
}