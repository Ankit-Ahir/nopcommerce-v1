package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {".\\features\\"},
        glue = "stepDefinitions",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty", "html:test-output"},
        tags = {"@sanity"}
//        tags = {"@sanity, @regression"} //OR
//        tags = {"@sanity", "@regression"} //AND
)
public class TestRunner {
}
