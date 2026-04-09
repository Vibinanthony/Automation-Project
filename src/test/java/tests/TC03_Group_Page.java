package tests;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static base.DriverFactory.driver;

public class TC03_Group_Page extends BaseTest {

    @Test
    public void TC03_Group_page() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));   // Explicit Wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hamburger\"]/div"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Setup']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kioskGroup"))).click();
        System.out.println("Kiosk Group Button is clicked");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Name"))).sendKeys("Vibin");
        System.out.println("The Grouping page is opened and the Name is searched");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dropdown-opan-style\"]/div/div/div[2]/div/div/div/main/div[3]/div/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[1]/button/span"))).click();
        System.out.println("The Vibin link has been clicked");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Manufacturer Serial Number"))).sendKeys("GCKDTYH59OY");
        // ===== getting the installed mm version from the table and print on console
        String installedMMVersion = driver.findElement(By.xpath("//*[@id=\"dropdown-opan-style\"]/div/div/div[2]/div/main/form/div[3]/div/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[6]/span")).getText();
        System.out.println("Installed MM Version is: " + installedMMVersion);

    }
}
