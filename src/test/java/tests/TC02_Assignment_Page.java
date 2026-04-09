package tests;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

public class TC02_Assignment_Page extends BaseTest {

    @Test(priority = 0)
    public void Assigning_operator() throws InterruptedException, IOException {

        System.out.println("############### Starting the 1st validation ################");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));   // Explicit Wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hamburger\"]/div"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Setup']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kioskAssignment"))).click();
        System.out.println("Kiosk Assignment Button is clicked");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("assign-operator-btn"))).click();
        System.out.println("The Assign Operator button has been clicked");

        // Click operator dropdown
        WebElement operatorDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("oprId")));
        operatorDropdown.click();
        System.out.println("Operator dropdown clicked");
        // Wait for second search box
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("zone-search-input")));
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys("Food Express Caro");
        System.out.println("The value has been passed to the box");
        // Wait for result row and click it
        WebElement operatorRow = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//td[normalize-space()='Food Express']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", operatorRow);
        System.out.println("The Food Express row has been selected");
        // Click Select Operator
        WebElement selectOperatorButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'Select Operator')]")));
        js.executeScript("arguments[0].click();", selectOperatorButton);
        System.out.println("The Select Operator button has been clicked");
        // Save
        wait.until(ExpectedConditions.elementToBeClickable(By.id("save-assignment-btn"))).click();
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Operator assigned successfully')]")));
        String popupMessage = successMessage.getText();
        System.out.println("Popup message is: " + popupMessage);
        Assert.assertEquals(popupMessage, "Operator assigned successfully");
        Thread.sleep(5000);
    }


    @Test(priority = 1, dependsOnMethods = {"Assigning_operator"})
    public void Validate_Assigned_Operator(){

        System.out.println("############### Starting the 2nd validation #################");
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(30));   // Explicit Wait
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Manufacturer Serial Number"))).sendKeys("GCKDTYH59OY");
        System.out.println("The S/N has been passed on the Search Box ");
        String branch_name = mywait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div[1]/div/div/div/main/div[2]/div[2]/section/div[2]/div/div/div[2]/div/main/div[2]/div/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[6]/span")))
                .getText();
        System.out.println("The Assigned Branch name is " + branch_name);
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/main/div[2]/div[2]/section/div[2]/div/div/div[2]/div/main/div[2]/div/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]/button/span"))).click();
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rc-tabs-0-tab-placementHistory"))).click();
        System.out.println("The History tab has been clicked");

    }

}
