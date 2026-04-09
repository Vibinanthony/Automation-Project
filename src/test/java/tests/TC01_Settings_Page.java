package tests;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC01_Settings_Page extends BaseTest {

    @Test
    public void TC1_Operator_Settings() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));   // Explicit Wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hamburger\"]/div"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Setup']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kioskSettings"))).click();
        System.out.println("Kiosk Settings Button is clicked");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Manufacturer Serial Number"))).sendKeys("GCKDTYH59OY");
        // using dropdown am selecting the options
        WebElement dropdowElement = driver.findElement(By.id("rc_select_301"));
        Select select = new Select(dropdowElement);
        select.selectByVisibleText("UPLOAD-VITAL-INFO");

        // Alert will be displayed and click on "Yes"
        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println("The Alert box is displayed and Ok button is clicked");


    }
}