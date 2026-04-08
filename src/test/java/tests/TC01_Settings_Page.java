package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kioskAssignment"))).click();
        System.out.println("Kiosk Settings Button is clicked");
    }
}