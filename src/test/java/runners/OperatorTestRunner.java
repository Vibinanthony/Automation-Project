package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Runs only @operator-tagged scenarios (Operator user flows).
 * Mapping: tests using loginAsOperatorUser() / config OperatorUsername & OperatorPassword.
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"hooks", "stepdefinitions"},
        tags = "@operator",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/operator-cucumber.html",
                "json:target/cucumber-reports/operator-cucumber.json"
        },
        monochrome = true
)
public class OperatorTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
