package com.cucumber.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

// @RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
dryRun = false,
features = {"./FeatureFile/WindowsHandling.feature"},
glue = {"com.cucumber.common","com.cucumber2"},
plugin = {"pretty",
		"html:CucumberReport/windows-handling-report",
		"json:CucumberReport/windows-handling-json-report.json"})

public class Runner_02 extends AbstractTestNGCucumberTests {

}
