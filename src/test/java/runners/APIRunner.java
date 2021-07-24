package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/APIWorkflow.feature"
        , glue = "APISteps"
        //with dry run we check if there are any compilation errors(not actual execution happens)
        , dryRun = false
        // when monochrome is true console output is more readable
        , monochrome = true
        //if strict set to true then at the time of execution if cucumber encounters any unimplemented steps
        //it will fail the execution and unimplemented steps will mark as fail
        , strict = true
        , tags = "@Random"

        , plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json", "rerun:target/failed.txt"}
)
public class APIRunner {
}
