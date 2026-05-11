package tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static base.DriverFactory.driver;

public class TC10_Report extends BaseTest {

    private static final Logger log = LogManager.getLogger(TC09_Campaign.class);

    @Test(priority = 0)
    public void Report() throws InterruptedException, IOException {

        log.info("############### Starting the 1st validation ################");
        loginAsOperatorUser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));   // Explicit Wait
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"hamburger\"]/div"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div[2]/section/div[1]/div/div[1]/ul/li[8]/div/span"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("report"))).click();

        String currentUrlOfPage = driver.getCurrentUrl();
        if (currentUrlOfPage.equals("https://pwa.devconnecthq.live/home/reporting/report")) {
            System.out.println("Report Button has been clicked");
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"hamburger\"]/div"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div[2]/section/div[1]/div/div[1]/ul/li[8]/div/span"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("report"))).click();
            System.out.println("The button was not clicked properly, clicked again");
        }


        // Type report name
        WebElement reportInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("basic_reportId")));
        reportInput.sendKeys("Kiosk Sales Cancellation Report");

// Click matching option
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'ant-select-item-option-content') and text()='Kiosk Sales Cancellation Report']")
        )).click();

        System.out.println("Report selected successfully");


        // Named Period

        WebElement namedPeriodDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@id='namedPeriodId']/ancestor::div[contains(@class,'ant-select-selector')]")
                ));

        namedPeriodDropdown.click();
        log.info("The first is done");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='Days']"))).click();

        log.info("Days option selected successfully");



        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("select-btn"))).click();


    }
}
