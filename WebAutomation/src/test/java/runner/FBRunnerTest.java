package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features/Login.Feature"},
        glue = {"steps"},
        format = {"json:target/cucumber-reports/CucumberTestReport.json", "html:target/cucumber-reports/cucumber-pretty"},
        plugin = {"pretty", "html:target/cucumber-html-report"})
public class FBRunnerTest {

}
