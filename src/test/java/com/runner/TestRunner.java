package com.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
        "html:target/cucumber-reports"},
        features = { "src\\test\\resources\\featureFile" },
    glue = {"com.stepdefination"})
public class TestRunner {


}
