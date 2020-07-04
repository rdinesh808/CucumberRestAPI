package com.cucumber2;

import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.cucumber.common.CucumberCommon;
import com.cucumber.pages.WindowsHandlePage;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.en.*;

public class Scenario_02 extends CucumberCommon {
	
	WindowsHandlePage window = PageFactory.initElements(driver, WindowsHandlePage.class);
	
	List<String> al1;
	@Given("^Navigate to the URL$")
	public void Navigate_to_the_URL() {
		try {
			String url = "http://www.leafground.com/pages/Window.html";
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Navigate to the URL : '" + url +"'");
			wait(3);
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to Navigate to the URL");
		}
	}
	@When("^Click multiple windows button$")
	public void Click_multiple_windows_button() {
		try {
			window.click_multiple_window_button();
			wait(5);
			test.log(LogStatus.INFO, "Successfully Clicked Multiple window button");
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to clicked Multiple window button");
		}
	}
	@Then("^Navigate to child window$")
	public void Navigate_to_child_window() {
		try {
			al1 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(al1.get(2));
			driver.manage().window().maximize();
			wait(5);
			test.log(LogStatus.INFO, "Successfully Navigate to Child window");
		}
		catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to Navigate to Child window");
		}
	}
	@And("^get position of button$")
	public void get_position_of_button() {
		try {
			WebElement location = driver.findElement(By.xpath("//button[text()='Get Position']"));
			int x = location.getLocation().getX();
			int y = location.getLocation().getY();
			test.log(LogStatus.INFO, "The Location of X is :" + x);
			test.log(LogStatus.INFO, "The Location of Y is :" + y);
			wait(3);
			driver.close();
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to Find Location");
		}
	}
	@But("^go to parent window$")
	public void go_to_parent_window() {
		try {
			driver.switchTo().window(al1.get(0));
			driver.switchTo().defaultContent();
			test.log(LogStatus.PASS, "Successfully Navigate to Parent Window");
			wait(5);
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable Navigate to Parent Window");
		}
	}
}