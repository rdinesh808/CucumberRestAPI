package com.cucumber.common;

import java.io.*;
import java.util.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CucumberCommon {

	public static WebDriver driver;
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static ExtentReports report;
	public static ExtentTest test;


	public static void wait(int n) {
		try {
			Thread.sleep(n*(1000));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public ExtentReports commoninitialize(String s1,String description) {
		try {
			book = new XSSFWorkbook(new File("./Datas/DataFile.xlsx"));
			sheet = book.getSheetAt(1);

			Date date = new Date();
			String reportname = s1.replaceAll(" ", "") + "_" + date.toString().replaceAll(":", "-").replaceAll("_", "-") + ".html";
			report = new ExtentReports(System.getProperty("user.dir")+"/ExtendsReport/"+reportname,true,DisplayOrder.NEWEST_FIRST);
			test = report.startTest(s1,"<font color=blue><h5><b>"+description+"</b></h5></font>");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return report;
	}
	public void finilizereport() {
		report.endTest(test);
		report.flush();
		driver.close();
		driver.quit();
	}
	public WebDriver driverInitalize(String browser) {
		WebDriverManager.chromedriver().arch32().setup();
		ChromeOptions option = new ChromeOptions();
		switch(browser) {
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "headless":
			option.addArguments("--headless");
			driver = new ChromeDriver(option);
			break;
		case "incognito":
			option.addArguments("--incognito");
			driver = new ChromeDriver(option);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
			driver = new FirefoxDriver();
			break;
		}
		return driver;
	}
	public String randomvalue() {
		String name[] = {"Selenium","TestNG","Appium","Cucumber","Jenkins","RestAPI","UiPath"};
		int a = new Random().nextInt(name.length);
		return name[a];
	}
	public String phonenumber() {
		String s1 = "1234567890";
		String s2 = "";
		char ch[] = s1.toCharArray();
		for(int i=0;i<10;i++) {
			int a = new Random().nextInt(s1.length());
			s2 += ch[a];
		}
		return s2;
	}
	public JavascriptExecutor scroll() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,450)");
		return js;
	}
}