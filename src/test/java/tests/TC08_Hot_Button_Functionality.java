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

public class TC08_Hot_Button_Functionality extends BaseTest {

    private static final Logger log = LogManager.getLogger(TC08_Hot_Button_Functionality.class);

    @Test(priority = 0)
    public void IoT_Commands() throws InterruptedException, IOException {

        log.info("############### Starting the validation of Hot Button ################");
        loginAsOperatorUser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));   // Explicit Wait

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div[2]/section/header/div[3]/div[2]/button"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Input search text']"))).sendKeys("Vibin Testing market");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'ant-select-item-option-content') and normalize-space()='Vibin Testing market']"))).click();
        log.info("The Vibin Testing market has been opened");
        WebElement hotItemsTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ant-tabs-tab-btn' and text()='Hot Items']")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});", hotItemsTab);
        wait.until(ExpectedConditions.elementToBeClickable(hotItemsTab)).click();
        log.info("The Hot Items tab has been clicked");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-tabs-tab-btn' and text()='Hot Items']"))).click();
        log.info("The hot Button tab has been opened");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'ant-btn-link') and .//span[contains(.,'New Item')]]"))).click();
        log.info("The New Item button is being clicked");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("product-search-input"))).sendKeys("Aquafina 1L");
        log.info("The product name has been sent on the box");
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("select-btn"))).click();
        log.info("The Select Product button has been clicked");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'ant-btn ant-btn-link box-name') and .//span[contains(.,'Aquafina 1L')]]"))).click();
        log.info("The hot button box has been clicked and ready to import the file");

        // Handling the Check Box
        WebElement showPrice = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Show Price']")));
        showPrice.click();
        WebElement showText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Show Text']")));
        showText.click();
        log.info("The Show Price and Show Text button has been clicked");
        Thread.sleep(3000);

        // handling the import of import from File Manager
        WebElement uploadInput = driver.findElement(By.xpath("//input[@type='file' and @accept='image/*']"));
        String filePath = "C:\\Users\\Vibin\\Pictures\\Images\\Mountain_Dew__Soft_Drink_-_Mountain_Dew_Bottle__600_ML_.jpg";
        uploadInput.sendKeys(filePath);
        Thread.sleep(10000);
        log.info("Image uploaded successfully");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("product-data-modal-save-button"))).click();
        log.info("The save button has been clicked successfully");
    }
}