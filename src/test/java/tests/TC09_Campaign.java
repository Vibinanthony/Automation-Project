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

public class TC09_Campaign extends BaseTest {

    private static final Logger log = LogManager.getLogger(TC09_Campaign.class);

    @Test(priority = 0)
    public void Campaign() throws InterruptedException, IOException {

        log.info("############### Starting the validation of Campaign ################");
        loginAsOperatorUser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));   // Explicit Wait

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div[2]/section/header/div[3]/div[2]/button"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Input search text']"))).sendKeys("Vibin Testing market");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div/div/ul/li/div/div"))).click();
        log.info("The Vibin Testing market has been opened");
        WebElement campaignTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ant-tabs-tab-btn' and text()='B2G Campaign']")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});", campaignTab);

        // ### handling the window switch functionality
        wait.until(ExpectedConditions.elementToBeClickable(campaignTab)).click();
        log.info("The campaign tab has been opened");

        String parent = driver.getWindowHandle();
        log.info("Parent window stored");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ant-tabs-tab-btn' and text()='B2G Campaign']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("attach-campaign-btn"))).click();
        log.info("The Attach Campaign button has been clicked");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("b2gCampaign-create-btn"))).click();
        log.info("Create B2G Campaign button is clicked");
        Thread.sleep(3000);

        Set<String> allWindows = driver.getWindowHandles();
        List<String> windows = new ArrayList<>(allWindows);

        driver.switchTo().window(windows.get(1));
        log.info("Switched to child window");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("basic_name"))).sendKeys("QA Testing");
        log.info("The Title has been sent");

        // ##### Calender Functionality #####

        // Click the calendar field
        String date = "2026-04-20";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='basic_startDate']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@title='" + date + "']"))).click();
        log.info("The start date has been selected");
        Thread.sleep(3000);

//        // To move to next month
//        driver.findElement(By.xpath("//span[contains(@class,'ant-picker-next-icon')]")).click();
//        // To move to previous month
//        driver.findElement(By.xpath("//span[contains(@class,'ant-picker-prev-icon')]")).click();
//        // To change the year
//        driver.findElement(By.xpath("//button[contains(@class,'ant-picker-year-btn')]")).click();
//        // Select required year
//        driver.findElement(By.xpath("//div[text()='2027']")).click();

        // Click the calendar field for end date
//        String endDate = "2026-04-30";
//
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("basic_endDate"))).click();
//        log.info("The end date button has been clicked");
//
//        WebElement endDateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//td[@title='" + endDate + "']//div[contains(@class,'ant-picker-cell-inner')]")
//        ));
//
//        JavascriptExecutor js_1 = (JavascriptExecutor) driver;
//        js_1.executeScript("arguments[0].scrollIntoView(true);", endDateElement);
//        js_1.executeScript("arguments[0].click();", endDateElement);
//
//        log.info("The End date has been selected");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("basic_endDate"))).click();
          log.info("The end date button has been clicked");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"basic\"]/div/div[3]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div[2]/a"))).click();
        log.info("The End date has been selected");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'ant-btn ant-btn-dashed ant-btn-block') and .//span[contains(.,'Add')]]"))).click();
        log.info("The Add button has been clicked");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("basic_productBarcodes_0_productName"))).sendKeys("Vibin testing");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("basic_productBarcodes_0_barcode"))).sendKeys("543789893");
        log.info("The barcode name & value has been sent");

        // ## Image upload functionality
        WebElement uploadInput = driver.findElement(By.xpath("//input[@type='file' and @accept='.jpg,.jpeg,.png']"));
        String filePath = "C:\\Users\\Vibin\\Pictures\\Images\\Icecream_image_for_campaign.jpg";
        uploadInput.sendKeys(filePath);
        Thread.sleep(10000);
        log.info("Image uploaded successfully");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("create-b2g-campaign-save-btn"))).click();
        log.info("The save button has been clicked successfully");


    }
}
