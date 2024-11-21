package com.soar.mobileautomation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.soar.mobileautomation.stepdefinitions", "com.soar.mobileautomation.configs"} 
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
