package com.homeoffice.assessment.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        plugin = { "pretty", "html:target/cucumber-reports" },
        features={"src/test/resources/features/"},
        glue = {"com.homeoffice.assessment.stepdefinitions"}
)
public class TestRunner {



}