package stepdefinitions;

import base.BaseTest_Global;
import io.cucumber.java.en.When;
import java.time.Duration;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import static base.DriverFactory.driver;

/**
 * Migrated from tests.TC03_Group_Page — full Selenium logic lives here (no delegation).
 */
public class TC03_Group_PageSteps extends BaseTest_Global {
    private static final Logger log = LogManager.getLogger(TC03_Group_PageSteps.class);

    @When("the kiosk group page flow is executed")
    public void TC03_Group_page() {
        syncFromTestContext();


        loginAsGlobalUser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));   // Explicit Wait
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"hamburger\"]/div"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Setup']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("kioskGroup"))).click();

        String currentUrlOfPage = driver.getCurrentUrl();
        if (currentUrlOfPage.equals("https://pwa.devconnecthq.live/home/operator-setup/kiosk-group")) {
            log.info("Kiosk Group Button has been clicked");
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("kioskGroup"))).click();
            log.info("The button was not clicked properly, clicked again");
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Name"))).sendKeys("Vibin");
        log.info("The Grouping page is opened and the Name is searched");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dropdown-opan-style\"]/div/div/div[2]/div/div/div/main/div[3]/div/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[1]/button/span"))).click();
        log.info("The Vibin link has been clicked");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Manufacturer Serial Number"))).sendKeys("GCKDTYH59OY");
        // ===== getting the installed mm version from the table and print on console
        String installedMMVersion = driver.findElement(By.xpath("//*[@id=\"dropdown-opan-style\"]/div/div/div[2]/div/main/form/div[3]/div/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[6]/span")).getText();
        log.info("Installed MM Version is: " + installedMMVersion);

    
    }
}
