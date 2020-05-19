package com.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
        "html:target/cucumber-reports","io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"},
        features = { "src\\test\\resources\\featureFile" }, tags = {"@Android"},
        glue = {"com.stepdefination"})
public class TestRunner  {


}
