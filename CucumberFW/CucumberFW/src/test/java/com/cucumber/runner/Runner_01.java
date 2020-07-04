package com.cucumber.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

// @RunWith(Cucumber.class)
@CucumberOptions(monochrome=true,
dryRun = false,
features = {"./FeatureFile/CucumberFrameWork.feature"},
glue = {"com.cucumber.common","com.cucumber1","com.cucumber2"},
plugin = {"pretty",
		"html:CucumberReport/cucumber-framework-report",
		"json:CucumberReport/cucumber-framework-json-report.json"})

public class Runner_01 extends AbstractTestNGCucumberTests {

}
