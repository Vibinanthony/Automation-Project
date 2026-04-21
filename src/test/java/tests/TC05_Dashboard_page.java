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

import java.time.Duration;

public class TC05_Dashboard_page extends BaseTest {

    private static final Logger log = LogManager.getLogger(TC05_Dashboard_page.class);

    @Test
    public void TC05_Dashboard_page() throws InterruptedException {

        loginAsGlobalUser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hamburger\"]/div"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Setup']"))).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kioskDashboard"))).click();

        String currentUrlOfPage = driver.getCurrentUrl();
        if (currentUrlOfPage.equals("https://pwa.devconnecthq.live/home/operator-setup/kiosk-dashboard")) {
            log.info("Kiosk Dashboard Button has been clicked");
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kioskDashboard"))).click();
            log.info("The button was not clicked properly, clicked again");
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-input"))).sendKeys("GCKDTYH59OY");
        log.info("The S/N is passed on the box");

//        WebElement refreshButton = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//*[@id='dropdown-opan-style']/div/div/div[2]/div/main/div[1]/div[2]/button[1]")));
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", refreshButton);
//        Thread.sleep(1000);
//        js.executeScript("arguments[0].click();", refreshButton);
//
//        log.info("The Refresh button is clicked");
//        Thread.sleep(6000);   // we need to add this because the UI will take more time to refresh

        log.info(" ############# Getting the Field Data from the table and Printing on console ###############");
        String Operator_name = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[1]"))).getText();
        log.info("Operator Name: " + Operator_name);

        String Branch_name = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[2]"))).getText();
        log.info("Branch Name: " + Branch_name);

        String Customer_name = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[3]"))).getText();
        log.info("Customer Name: " + Customer_name);

        String Point_of_sale = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[4]"))).getText();
        log.info("Point Of Sale: " + Point_of_sale);

        String Loyalty_SN = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[5]"))).getText();
        log.info("Loyalty S/N: " + Loyalty_SN);

        String Loyalty_MSN = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[6]"))).getText();
        log.info("Manufacturing S/N: " + Loyalty_MSN);

        String LYNK_SN = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[7]"))).getText();
        log.info("LYNK S/N: " + LYNK_SN);

        String Installed_mm = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[8]"))).getText();
        log.info("Installed MM Version: " + Installed_mm);

        String Bill_Acceptor_v = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[9]"))).getText();
        log.info("Bill Acceptor Version: " + Bill_Acceptor_v);

        String InHand_SN = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[10]"))).getText();
        log.info("InHand S/N: " + InHand_SN);

        String InHand_Data_Usage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[11]"))).getText();
        log.info("InHand Data Usage: " + InHand_Data_Usage);

        String Signal_Strength = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[12]"))).getText();
        log.info("Signal Strength: " + Signal_Strength);

        String VDI_Slave = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[13]"))).getText();
        log.info("VDI Salve Mode: " + VDI_Slave);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement horizontalScrollBar_1 = driver.findElement(
                By.xpath("//div[contains(@class,'ant-table-body')]"));
        js.executeScript("arguments[0].scrollLeft = 2000", horizontalScrollBar_1);
        log.info("The table is scrolled 500px to the right");

        String Total_reboots = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[14]"))).getText();
        log.info("Total Reboot: " + Total_reboots);

        String Discount_Type = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[15]"))).getText();
        log.info("Discount Type: " + Discount_Type);

        String Discount = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[16]"))).getText();
        log.info("Discount: " + Discount);

        String Last_product_sync = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[17]"))).getText();
        log.info("Last product Sync: " + Last_product_sync);

        String Last_Heartbeat = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[18]"))).getText();
        log.info("Last HeartBeat: " + VDI_Slave);

        String Last_Rebooted = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[19]"))).getText();
        log.info("Last HeartBeat: " + Last_Rebooted);

        WebElement horizontalScrollBar_2 = driver.findElement(
                By.xpath("//div[contains(@class,'ant-table-body')]"));
        js.executeScript("arguments[0].scrollLeft = 2000", horizontalScrollBar_2);
        log.info("The table is scrolled 500px to the right by second time");

        String Last_Sale_Amount = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[20]"))).getText();
        log.info("Last Sale Amount: " + Last_Sale_Amount);

        String Last_Command = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[21]"))).getText();
        log.info("Last Command Sent: " + Last_Command);

        String Last_Sale_Datetime = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[22]"))).getText();
        log.info("Last Sale DateTime: " + Last_Sale_Datetime);

        String Last_collect_amount = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[23]"))).getText();
        log.info("last Collected Amount: " + Last_collect_amount);

        WebElement horizontalScrollBar_3 = driver.findElement(
                By.xpath("//div[contains(@class,'ant-table-body')]"));
        js.executeScript("arguments[0].scrollLeft = 1500", horizontalScrollBar_3);
        log.info("The table is scrolled 1500px to the right by third time");

        String Last_collect_datetime = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[24]"))).getText();
        log.info("Last Collected Date: " + Last_collect_datetime);

        String Daily_sales = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[25]"))).getText();
        log.info("Daily sales Amount: " + Daily_sales);

        String Weekly_sales = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[26]"))).getText();
        log.info("Weekly sales: " + Weekly_sales);

        String Average_daily_sales = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[27]"))).getText();
        log.info("Average Daily Sales: " + Average_daily_sales);



    }

}
