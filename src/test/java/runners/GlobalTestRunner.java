package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Runs only @global-tagged scenarios (Global user flows).
 * Mapping: tests using loginAsGlobalUser() / config username & password.
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"hooks", "stepdefinitions"},
        tags = "@global",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/global-cucumber.html",
                "json:target/cucumber-reports/global-cucumber.json"
        },
        monochrome = true
)
public class GlobalTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
