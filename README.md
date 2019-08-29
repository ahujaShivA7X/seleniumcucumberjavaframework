### Selenium Framework with Cucumber

BDD framework for automation using Selenium Cucumber

The framework has following features 

2. Maven based framework
4. Report Generation (Extent Reports) 
5. Utilities class to handle web component such as (Button,Link etc) and drivers
6. Centralized Configuration (Using Properties file)
7. POM
8. Hooks 



Use the browser from the `config.properties` file to run between Chrome or Firefox

### Create the Runner

```java
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
``` 

### Use the mvn commands to run the tests
Make sure you have installed Java 8 version 8, Maven version 3.3.1 or higher.

Clone this repo and verify compile
```xml
git clone  
cd path  
mvn clean compile test 
```



