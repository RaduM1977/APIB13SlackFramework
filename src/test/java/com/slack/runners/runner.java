package com.slack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Slackfeatures"},
        glue = "com/slack/stepDefs",
        dryRun = false,
        tags = "@post or @get or @put or @delete ",
        //tags = "",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt",
        "json:target/cucumber-reports/cucumber.json"}
)

public class runner {
}
