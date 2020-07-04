package com.testng.api.base;

import org.openqa.selenium.remote.RemoteWebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.seleniumbase.SeleniumBase;

public class ProjectSpecify extends SeleniumBase {
	
	public ProjectSpecify(RemoteWebDriver driver,ExtentTest test) {
		super(driver,test);
	}

}
