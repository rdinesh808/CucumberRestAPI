package com.cucumber.common;

import cucumber.api.Scenario;
import cucumber.api.java.*;

public class CucumberHooks extends CucumberCommon {
	
	@Before(order = 1)
	public void reportInitialize(Scenario feature) {
		commoninitialize(feature.getName().replaceAll(" ", "_"),"Input form with validations");
	}
	@Before(order = 2)
	public void browserInitialize() {
		driverInitalize("chrome");
	}
	@After
	public void two() {
		finilizereport();
	}
	
	

}
