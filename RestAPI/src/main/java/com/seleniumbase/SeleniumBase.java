package com.seleniumbase;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.ExtentTest;

public class SeleniumBase {

	public RemoteWebDriver driver;
	public ExtentTest test;

	SoftAssert softAssertion= new SoftAssert();
	static Random rand = new Random();
	public WebDriverWait wait;

	public SeleniumBase(RemoteWebDriver driver,ExtentTest test) {
		this.driver = driver;
	}


	public String randomzip() {
		String s1 = "1234567890";
		String s2 = "";
		char[] ch = s1.toCharArray();
		for(int i=1;i<=6;i++) {
			int a = new Random().nextInt(s1.length());
			s2 += ch[a];
		}
		return s2;
	}
	public String randommajordob() {
		int minDay = (int) LocalDate.of(1990, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2000, 1, 1).toEpochDay();
		long randomDay = minDay + rand.nextInt(maxDay - minDay);
		LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("LL/dd/yyyy");
		String RandomDob = randomBirthDate.format(formatter);
		System.out.println(RandomDob);
		return RandomDob;
	}
	public String randomphonenumber() {
		int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
		int num2 = rand.nextInt(743);
		int num3 = rand.nextInt(10000);
		DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
		DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros
		String phoneNumber = df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);
		return phoneNumber;
	}
	public boolean verifyelementpresent() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""))) != null) {
			return true;
		}
		return true;
	}
	public void clearelementusingkeys(String ele) {
		Actions navigator = new Actions(driver);
		navigator.click(driver.findElementByXPath(ele))
		.sendKeys(Keys.END)
		.keyDown(Keys.SHIFT)
		.sendKeys(Keys.HOME)
		.keyUp(Keys.SHIFT)
		.sendKeys(Keys.BACK_SPACE)
		.perform();
	}
	public void switchToWindow(int index) {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			List<String> allhandles = new ArrayList<String>(allWindows);
			String exWindow = allhandles.get(index);
			driver.switchTo().window(exWindow);
			System.out.println("The Window With index: "+index+
					" switched successfully");
		} catch (NoSuchWindowException e) {
			System.err.println("The Window With index: "+index+
					" not found");	
		}
	}
}