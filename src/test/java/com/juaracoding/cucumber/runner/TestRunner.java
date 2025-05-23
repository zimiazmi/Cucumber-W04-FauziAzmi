package com.juaracoding.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
        (features = {"src/test/resources/features"},
        glue = {"com/juaracoding/cucumber/stepdefinitions", "com/juaracoding/cucumber/hooks"},
        plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber.json"})


public class TestRunner extends AbstractTestNGCucumberTests {
}