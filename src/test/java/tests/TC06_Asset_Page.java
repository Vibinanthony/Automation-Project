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

public class TC06_Asset_Page extends BaseTest {

    private static final Logger log = LogManager.getLogger(TC06_Asset_Page.class);

    @Test(priority = 0)
    public void Opening_Asset_Tab() throws InterruptedException, IOException {

        log.info("############### Starting the 1st validation ################");
        loginAsOperatorUser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));   // Explicit Wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hamburger\"]/div"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div/main/div[2]/div[2]/section/div[1]/div/div[1]/ul/li[2]/div/span"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("assets"))).click();
        log.info("Kiosk Asset Button is clicked");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Manufacturer Serial Number"))).sendKeys("GCKDTYH59OY");
        log.info("The Manufacturer S/N is passed on the box");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-link ant-btn-link']//span[text()='GCFOODEXPRNC000916']"))).click();
        log.info("The Kiosk Info tab has been opened");
    }

    @Test(priority = 1)
    public void Validate_Asset_Tab() throws InterruptedException, IOException {

        log.info("############### Starting the 2nd validation & Getting the Field Data from the table and Printing ################");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));   // Explicit Wait

        String Kiosk_status = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"rc-tabs-0-panel-kioskInfo\"]/div/main/div[2]/div[1]/div[2]/div[1]/form/div/div/div[2]/div/div"))).getText();
        log.info("Kiosk Status Active : " + Kiosk_status);

        String Loyalty_SN = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"rc-tabs-0-panel-kioskInfo\"]/div/main/div[2]/div[1]/div[2]/div[4]/form/div/div/div[2]/div/div/span"))).getText();
        log.info("Loyalty S/N : " + Loyalty_SN);

        String BrandName = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"rc-tabs-0-panel-kioskInfo\"]/div/main/div[2]/div[1]/div[2]/div[7]/form/div/div/div[2]/div/div/span"))).getText();
        log.info("Brand Name : " + BrandName);

        String Kiosk_Group_name = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"rc-tabs-0-panel-kioskInfo\"]/div/main/div[2]/div[1]/div[2]/div[10]/form/div/div/div[2]/div/div/span"))).getText();
        log.info("Kiosk Group Name : " + Kiosk_Group_name);

        String InHand_Data_Usage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"rc-tabs-0-panel-kioskInfo\"]/div/main/div[2]/div[1]/div[2]/div[13]/form/div/div/div[2]/div/div"))).getText();
        log.info("InHand Data Usage : " + InHand_Data_Usage);

        String Kiosk_name = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"rc-tabs-0-panel-kioskInfo\"]/div/main/div[2]/div[1]/div[2]/div[2]/form/div/div/div[2]/div/div/span"))).getText();
        log.info("Kiosk Name : " + Kiosk_name);

        String Mac = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"rc-tabs-0-panel-kioskInfo\"]/div/main/div[2]/div[1]/div[2]/div[5]/form/div/div/div[2]/div/div/span"))).getText();
        log.info("Mac Address : " + Mac);

        String mm_version = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"rc-tabs-0-panel-kioskInfo\"]/div/main/div[2]/div[1]/div[2]/div[8]/form/div/div/div[2]/div/div/span"))).getText();
        log.info("Installed MM version : " + mm_version);

        String InHand_sn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"rc-tabs-0-panel-kioskInfo\"]/div/main/div[2]/div[1]/div[2]/div[11]/form/div/div/div[2]/div/div"))).getText();
        log.info("InHand S/N : " + InHand_sn);

        String timezone = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"rc-tabs-0-panel-kioskInfo\"]/div/main/div[2]/div[1]/div[2]/div[14]/form/div/div/div[2]/div/div/span"))).getText();
        log.info("Time Zone : " + timezone);

        String Manufacturer_sn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"rc-tabs-0-panel-kioskInfo\"]/div/main/div[2]/div[1]/div[2]/div[3]/form/div/div/div[2]/div/div/span"))).getText();
        log.info("Kiosk S/N : " + Manufacturer_sn);

        String pi_model = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"rc-tabs-0-panel-kioskInfo\"]/div/main/div[2]/div[1]/div[2]/div[6]/form/div/div/div[2]/div/div/span"))).getText();
        log.info("Pi Model : " + pi_model);

        String Os_version = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"rc-tabs-0-panel-kioskInfo\"]/div/main/div[2]/div[1]/div[2]/div[9]/form/div/div/div[2]/div/div/span"))).getText();
        log.info("Installed OS Version : " + Os_version);

        String Signal_strength = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"rc-tabs-0-panel-kioskInfo\"]/div/main/div[2]/div[1]/div[2]/div[12]/form/div/div/div[2]/div/div"))).getText();
        log.info("Signal Strength : " + Signal_strength);
    }

    @Test(priority = 2)
    public void Validate_Misc_Info() throws InterruptedException, IOException {

        log.info("############### Starting the 3rd validation & Getting the Misc Info Data from the table and Printing ################");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));   // Explicit Wait

        String Collection = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"rc-tabs-0-panel-kioskInfo\"]/div/main/div[2]/div[4]/div[2]/div[1]/form/div/div/div[2]/div/div"))).getText();
        log.info("Collection Time : " + Collection);

        String Total_reboot = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"rc-tabs-0-panel-kioskInfo\"]/div/main/div[2]/div[4]/div[2]/div[4]/form/div/div/div[2]/div/div"))).getText();
        log.info("Total reboot count : " + Total_reboot);

        String Service_flag = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"rc-tabs-0-panel-kioskInfo\"]/div/main/div[2]/div[4]/div[2]/div[2]/form/div/div/div[2]/div/div"))).getText();
        log.info("Service Flag Status : " + Service_flag);

        String Heartbeat = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"rc-tabs-0-panel-kioskInfo\"]/div/main/div[2]/div[4]/div[2]/div[4]/form/div/div/div[2]/div/div"))).getText();
        log.info("Heartbeat Timestamp : " + Heartbeat);

        String Market_Provider = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"rc-tabs-0-panel-kioskInfo\"]/div/main/div[2]/div[4]/div[2]/div[3]/form/div/div/div[2]/div/div/button/span"))).getText();
        log.info("Market Provider : " + Market_Provider);


    }
}




