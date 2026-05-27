package stepdefinitions;

import base.BaseTest_Global;
import io.cucumber.java.en.When;
import java.time.Duration;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

/**
 * Migrated from tests.TC04_Branding_Page — full Selenium logic lives here (no delegation).
 */
public class TC04_Branding_PageSteps extends BaseTest_Global {
    private static final Logger log = LogManager.getLogger(TC04_Branding_PageSteps.class);

    @When("the kiosk branding change flow is executed")
    public void TC04_Branding_page() {
        syncFromTestContext();


            loginAsGlobalUser();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"hamburger\"]/div"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Setup']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("branding"))).click();

            String currentUrlOfPage = driver.getCurrentUrl();
            if (currentUrlOfPage.equals("https://pwa.devconnecthq.live/home/operator-setup/branding")) {
                log.info("Kiosk Branding Button has been clicked");
            } else {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"hamburger\"]/div"))).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Setup']"))).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.id("branding"))).click();
                log.info("The button was not clicked properly, clicked again");
            }

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Manufacturer Serial Number"))).sendKeys("GCKDTYH59OY");

           // ===== getting the Branding name from the table and print on console
            String beforebrandingname = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("(//tr[contains(@class,'ant-table-row')])[1]//td[7]//span"))).getText();
            log.info("The Current Branding is: " + beforebrandingname);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='change-branding-btn']/div"))).click();
            log.info("The Change Branding link has been clicked");

            if (beforebrandingname.equals("BistroToGo")) {

                // Changing the branding from UI
                WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//td[.//span[contains(text(),'BistroToGo')]]//div[contains(@class,'ant-select-selector')]")));
                dropdown.click();

                WebElement cokeOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class,'ant-select-item-option-content') and text()='Coke']")));

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", cokeOption);

                log.info("The Branding has been changed to Coke");

            } else {

                // Changing the branding from UI
                WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//td[.//span[contains(text(),'Coke')]]//div[contains(@class,'ant-select-selector')]")));
                dropdown.click();

                WebElement bistroOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class,'ant-select-item-option-content') and text()='BistroToGo']")));

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", bistroOption);

                log.info("The Branding has been changed to BistroToGo");
            }


            wait.until(ExpectedConditions.elementToBeClickable(By.id("save-branding-btn"))).click();
            log.info("The Save Button has been Clicked");

            // ===== getting the Branding name from the table and print on console
            String afterbrandingname = driver.findElement(By.xpath("//*[@id=\"rc-tabs-0-panel-branding\"]/main/div/div/main/div[2]/div/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[7]/span")).getText();
            log.info("The Current Branding is: " + afterbrandingname);

        
    }
}
