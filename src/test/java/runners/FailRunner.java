package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failed.txt"
        , glue = "steps"
        //with dry run we check if there are any compilation errors(not actual execution happens)
        , dryRun = false
        // when monochrome is true console output is more readable
        ,monochrome = true
        //if strict set to true then at the time of execution if cucumber encounters any unimplemented steps
        //it will fail the execution and unimplemented steps will mark as fail
        //, strict = true
        //, tags = "@dashboardTabs"

        , plugin = {"pretty"}
)

public class FailRunner {
}
