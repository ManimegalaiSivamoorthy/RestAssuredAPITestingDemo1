package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = "src/test/java/features",
                glue = "steps",
                dryRun = false,
                monochrome = true,
                plugin = {"pretty", "html: test-output"}
        )

public class TestRunner {
}
