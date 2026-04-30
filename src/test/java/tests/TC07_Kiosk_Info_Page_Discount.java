package tests;

import base.BaseTest;
import base.BaseTest_Operator;
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

public class TC07_Kiosk_Info_Page_Discount extends BaseTest_Operator {

    private static final Logger log = LogManager.getLogger(TC07_Kiosk_Info_Page_Discount.class);

    @Test(priority = 0)
    public void Discount() throws InterruptedException, IOException {

        log.info("############### Starting the validation of Discount Type ################");
       // loginAsOperatorUser();
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

        String currentDiscountType = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='discountType']/ancestor::div[contains(@class,'ant-select')]//span[contains(@class,'ant-select-selection-item')]")
        )).getAttribute("title");

        log.info("Current Discount Type : " + currentDiscountType);

        if (currentDiscountType.equals("Amount")) {

            WebElement discountTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@id='discountType']/ancestor::div[contains(@class,'ant-select-selector')]")
            ));
            discountTypeDropdown.click();

            WebElement discountTypeInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("discountType")));
            Actions actions = new Actions(driver);
            actions.moveToElement(discountTypeInput).click().sendKeys("Rate").perform();

            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'ant-select-item-option-content') and text()='Rate']")
            )).click();

            System.out.println("Discount Type changed from Amount to Rate");

            WebElement discountValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("discount")));
            discountValue.clear();
            discountValue.sendKeys("5");

            log.info("The rate has been passed");

        } else {

            WebElement discountTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@id='discountType']/ancestor::div[contains(@class,'ant-select-selector')]")
            ));
            discountTypeDropdown.click();

            WebElement discountTypeInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("discountType")));
            Actions actions = new Actions(driver);
            actions.moveToElement(discountTypeInput).click().sendKeys("Amount").perform();

            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'ant-select-item-option-content') and text()='Amount']")
            )).click();

            System.out.println("Discount Type changed from Rate to Amount");

            WebElement discountValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("discount")));
            discountValue.clear();
            discountValue.sendKeys("1");
            log.info("The amount has been passed");
        }

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("gc-kiosk-info-save-button")
        )).click();

        log.info("The save button has been clicked");

        Thread.sleep(3000);

        String afterDiscountType = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='discountType']/ancestor::div[contains(@class,'ant-select')]//span[contains(@class,'ant-select-selection-item')]")
        )).getAttribute("title");

        log.info("After Discount Type : " + afterDiscountType);

        Assert.assertNotEquals(currentDiscountType, afterDiscountType,
                "Discount Type value did not change");
    }


}