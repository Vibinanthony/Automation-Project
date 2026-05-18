package stepdefinitions;

import org.testng.Assert;
import base.BaseTest_Operator;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Migrated from tests.TC10_Adding_the_asset — full Selenium logic lives here (no delegation).
 */
public class TC10_Adding_the_assetSteps extends BaseTest_Operator {
    private static final Logger log = LogManager.getLogger(TC10_Adding_the_assetSteps.class);

    @When("the non-vending asset is added")
    public void Adding_the_Asset() throws Exception {
        syncFromTestContext();


        log.info("############### Starting the validation of Addition of the asset ################");
        loginAsOperatorUser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));   // Explicit Wait

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div[2]/section/header/div[3]/div[2]/button"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Input search text']"))).sendKeys("Vibin Testing market");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div/div/ul/li/div/div"))).click();
        log.info("The Vibin Testing market has been opened");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'ant-tabs-tab-btn') and text()='Asset']"))).click();
        log.info("The Asset tab has been opened");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-non-vending-equipment-btn"))).click();
        log.info("The Add Non-Vending Asset button is clicked");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='Manufacturer Serial Number']"))).sendKeys("GCK2JF2VT98");
        log.info("The S/N has been passed");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='add-equipment-btn']"))).click();
        log.info("The Save button has been clicked");
        // Validation of the popup message
        WebElement popup_validation_on_assetpage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Non-Vending Asset added successfully')]")));
        String popupMessage = popup_validation_on_assetpage.getText();
        log.info("Popup message is: " + popupMessage);
        Assert.assertEquals(popupMessage, "Non-Vending Asset added successfully");

    
    }
    @When("the non-vending asset is removed")
    public void Removing_the_Asset() throws Exception {
        syncFromTestContext();


        Thread.sleep(3000);
        log.info("############### Starting the validation of Addition of the asset ################");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));   // Explicit Wait
        log.info("The Asset tab is already opened");
        Thread.sleep(5000);

        String expectedSerialNumber = "GCK3UBB5A65";

        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

        boolean isAssetFound = false;

        for (WebElement row : rows) {

            String rowText = row.getText();

            if (rowText.contains(expectedSerialNumber)) {

                WebElement removeButton = row.findElement(By.xpath(".//*[contains(text(),'Remove')]"));
                wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();

                log.info("Remove clicked for S/N: " + expectedSerialNumber);
                isAssetFound = true;
                break;
            }
        }

        Assert.assertTrue(isAssetFound, "Asset with S/N not found: " + expectedSerialNumber);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'ant-modal-content')]")));
        log.info("The Remove popup is displayed");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("basic_zoneId"))).click();
        log.info("The Dropdown box has been clicked");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='dialog']//button[contains(text(),'Save')]"))).click();
        log.info("The Save button has been clicked");

        //Validation of the popup message
        WebElement popup_validation_on_assetpage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Non-Vending Asset removed successfully')]")));
        String popupMessage = popup_validation_on_assetpage.getText();
        log.info("Popup message is: " + popupMessage);
        Assert.assertEquals(popupMessage, "Non-Vending Asset removed successfully");

    
    }
}
