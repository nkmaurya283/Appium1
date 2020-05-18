package com.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
        "html:target/cucumber-reports","io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"},
        features = { "src\\test\\resources\\featureFile" },tags = {"@Android"},
        glue = {"com.stepdefination"})
public class TestRunner {

}
