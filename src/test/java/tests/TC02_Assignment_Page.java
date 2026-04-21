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

public class TC02_Assignment_Page extends BaseTest {

    private static final Logger log = LogManager.getLogger(TC02_Assignment_Page.class);

    @Test(priority = 0)
    public void Assigning_operator() throws InterruptedException, IOException {

        log.info("############### Starting the 1st validation ################");
        loginAsGlobalUser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));   // Explicit Wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hamburger\"]/div"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Setup']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kioskAssignment"))).click();

        String currentUrlOfPage = driver.getCurrentUrl();
        if (currentUrlOfPage.equals("https://pwa.devconnecthq.live/home/operator-setup/kiosk-assignment")) {
            log.info("Kiosk Assignment Button has been clicked");
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kioskAssignment"))).click();
            log.info("The button was not clicked properly, clicked again");
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.id("assign-operator-btn"))).click();
        log.info("The Assign Operator button has been clicked");

        // Click operator dropdown
        WebElement operatorDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("oprId")));
        operatorDropdown.click();
        log.info("Operator dropdown clicked");
        // Wait for second search box
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("zone-search-input")));
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys("Food Express Caro");
        log.info("The value has been passed to the box");
        // Wait for result row and click it
        WebElement operatorRow = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//td[normalize-space()='Food Express']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", operatorRow);
        log.info("The Food Express row has been selected");
        // Click Select Operator
        WebElement selectOperatorButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'Select Operator')]")));
        js.executeScript("arguments[0].click();", selectOperatorButton);
        log.info("The Select Operator button has been clicked");
        // Save
        wait.until(ExpectedConditions.elementToBeClickable(By.id("save-assignment-btn"))).click();
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Operator assigned successfully')]")));
        String popupMessage = successMessage.getText();
        log.info("Popup message is: " + popupMessage);
        Assert.assertEquals(popupMessage, "Operator assigned successfully");
        Thread.sleep(5000);
    }


    @Test(priority = 1, dependsOnMethods = {"Assigning_operator"})
    public void Validate_Assigned_Operator(){

        log.info("############### Starting the 2nd validation #################");
       // loginAsGlobalUser();
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(30));   // Explicit Wait
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Manufacturer Serial Number"))).sendKeys("GCKDTYH59OY");
        log.info("The S/N has been passed on the Search Box ");
        String branch_name = mywait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div[1]/div/div/div/main/div[2]/div[2]/section/div[2]/div/div/div[2]/div/main/div[2]/div/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[6]/span")))
                .getText();
        log.info("The Assigned Branch name is " + branch_name);
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/main/div[2]/div[2]/section/div[2]/div/div/div[2]/div/main/div[2]/div/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]/button/span"))).click();
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rc-tabs-0-tab-placementHistory"))).click();
        log.info("The History tab has been clicked");

    }

}
