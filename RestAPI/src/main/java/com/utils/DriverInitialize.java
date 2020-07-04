package com.utils;

import java.io.IOException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class DriverInitialize {
	
	public  RemoteWebDriver driver;
	public  ExtentReports extent;
	public  ExtentTest test;
	public String testcaseName, testcaseDec, author, category;
	public String EnvironmentName;
	public String CurrentSuiteName;
	//public  EnvPatientID EnvBulkDats;
	public static String classname;
	String defaulttestsuitename="testng-customsuite";
	
	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return DataLibrary.ReadTestData(EnvironmentName);
	}

}
