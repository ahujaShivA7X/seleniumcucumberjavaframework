package Runner;

/**
 * @author Shivansh Ahuja
 *
 *	29-Aug-2019
 */

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber-reports",
                "com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
        monochrome = true,
        glue = "StepDef"
)

public class RunnerTest {

    @AfterClass
    public static void extReport() {
        Reporter.loadXMLConfig(new File("src/test/java/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("OS", "Windows 10");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }
}
