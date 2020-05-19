package com.zerobank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue= "com/zerobank/stepdefinitions",
        features="src/test/resources/features",
        dryRun=false,
        strict=false,
        tags="@smoke_test",
        plugin={  "pretty",
                "html:target/default_report",
                "json:target/zerobank_cucumber.json",
                "rerun:target/rerun.txt"
        }
)
public class SmokeTestRunner {

}
