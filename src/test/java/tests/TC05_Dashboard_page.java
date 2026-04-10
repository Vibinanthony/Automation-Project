package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC05_Dashboard_page extends BaseTest {

    @Test
    public void TC05_Dashboard_page() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hamburger\"]/div"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Setup']"))).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kioskDashboard"))).click();
        System.out.println("Kiosk Dashboard Button is clicked");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-input"))).sendKeys("GCKDTYH59OY");
        System.out.println("The S/N is passed on the box");

//        WebElement refreshButton = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//*[@id='dropdown-opan-style']/div/div/div[2]/div/main/div[1]/div[2]/button[1]")));
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", refreshButton);
//        Thread.sleep(1000);
//        js.executeScript("arguments[0].click();", refreshButton);
//
//        System.out.println("The Refresh button is clicked");
//        Thread.sleep(6000);   // we need to add this because the UI will take more time to refresh

        System.out.println(" ############# Getting the Field Data from the table and Printing on console ###############");
        String Operator_name = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[1]"))).getText();
        System.out.println("Operator Name: " + Operator_name);

        String Branch_name = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[2]"))).getText();
        System.out.println("Branch Name: " + Branch_name);

        String Customer_name = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[3]"))).getText();
        System.out.println("Customer Name: " + Customer_name);

        String Point_of_sale = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[4]"))).getText();
        System.out.println("Point Of Sale: " + Point_of_sale);

        String Loyalty_SN = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[5]"))).getText();
        System.out.println("Loyalty S/N: " + Loyalty_SN);

        String Loyalty_MSN = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[6]"))).getText();
        System.out.println("Manufacturing S/N: " + Loyalty_MSN);

        String LYNK_SN = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[7]"))).getText();
        System.out.println("LYNK S/N: " + LYNK_SN);

        String Installed_mm = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[8]"))).getText();
        System.out.println("Installed MM Version: " + Installed_mm);

        String Bill_Acceptor_v = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[9]"))).getText();
        System.out.println("Bill Acceptor Version: " + Bill_Acceptor_v);

        String InHand_SN = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[10]"))).getText();
        System.out.println("InHand S/N: " + InHand_SN);

        String InHand_Data_Usage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[11]"))).getText();
        System.out.println("InHand Data Usage: " + InHand_Data_Usage);

        String Signal_Strength = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[12]"))).getText();
        System.out.println("Signal Strength: " + Signal_Strength);

        String VDI_Slave = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[13]"))).getText();
        System.out.println("VDI Salve Mode: " + VDI_Slave);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement horizontalScrollBar_1 = driver.findElement(
                By.xpath("//div[contains(@class,'ant-table-body')]"));
        js.executeScript("arguments[0].scrollLeft = 2000", horizontalScrollBar_1);
        System.out.println("The table is scrolled 500px to the right");

        String Total_reboots = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[14]"))).getText();
        System.out.println("Total Reboot: " + Total_reboots);

        String Discount_Type = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[15]"))).getText();
        System.out.println("Discount Type: " + Discount_Type);

        String Discount = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[16]"))).getText();
        System.out.println("Discount: " + Discount);

        String Last_product_sync = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[17]"))).getText();
        System.out.println("Last product Sync: " + Last_product_sync);

        String Last_Heartbeat = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[18]"))).getText();
        System.out.println("Last HeartBeat: " + VDI_Slave);

        String Last_Rebooted = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[19]"))).getText();
        System.out.println("Last HeartBeat: " + Last_Rebooted);

        WebElement horizontalScrollBar_2 = driver.findElement(
                By.xpath("//div[contains(@class,'ant-table-body')]"));
        js.executeScript("arguments[0].scrollLeft = 2000", horizontalScrollBar_2);
        System.out.println("The table is scrolled 500px to the right by second time");

        String Last_Sale_Amount = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[20]"))).getText();
        System.out.println("Last Sale Amount: " + Last_Sale_Amount);

        String Last_Command = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[21]"))).getText();
        System.out.println("Last Command Sent: " + Last_Command);

        String Last_Sale_Datetime = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[22]"))).getText();
        System.out.println("Last Sale DateTime: " + Last_Sale_Datetime);

        String Last_collect_amount = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[23]"))).getText();
        System.out.println("last Collected Amount: " + Last_collect_amount);

        WebElement horizontalScrollBar_3 = driver.findElement(
                By.xpath("//div[contains(@class,'ant-table-body')]"));
        js.executeScript("arguments[0].scrollLeft = 1500", horizontalScrollBar_3);
        System.out.println("The table is scrolled 1500px to the right by third time");

        String Last_collect_datetime = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[24]"))).getText();
        System.out.println("Last Collected Date: " + Last_collect_datetime);

        String Daily_sales = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[25]"))).getText();
        System.out.println("Daily sales Amount: " + Daily_sales);

        String Weekly_sales = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[26]"))).getText();
        System.out.println("Weekly sales: " + Weekly_sales);

        String Average_daily_sales = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table/tbody/tr[contains(@class,'ant-table-row')][1]/td[27]"))).getText();
        System.out.println("Average Daily Sales: " + Average_daily_sales);



    }

}
