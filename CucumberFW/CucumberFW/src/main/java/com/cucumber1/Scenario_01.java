package com.cucumber1;

import java.util.*;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.cucumber.common.CucumberCommon;
import com.cucumber.pages.CucumberPage;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.DataTable;
import cucumber.api.java.en.*;

public class Scenario_01 extends CucumberCommon {
	
	CucumberPage page = PageFactory.initElements(driver, CucumberPage.class);
	
	@Given("^Navigate to the URL \"([^\"]*)\"$")
	public void Navigate_to_the_URL(String url) {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Navigate to the URL : '" + url +"'");
			wait(3);
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to Navigate to the URL");
		}
	}
	@Then("^Enter the Firstname$")
	public void Enter_the_Firstname(DataTable table) {
		try {
			List<List<String>> data = table.raw();
			String s1 = data.get(1).get(0);
			page.enter_firstname(s1);
			wait(2);
			test.log(LogStatus.INFO, "The Firstname Value is : '" + s1 +"'");
			wait(2);
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to Enter Firstname");
		}
	}
	@And("^Enter the LastName$")
	public void And_Enter_the_LastName() {
		try {
			String s1 = randomvalue();
			page.enter_lastname(s1);
			wait(2);
			test.log(LogStatus.INFO, "The Lastname Value is : '" + s1 +"'");
			wait(2);
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to Enter Lastname");
		}
	}
	@Then("^Enter email address$")
	public void Enter_email_address() {
		try {
			String mail = sheet.getRow(1).getCell(4).getStringCellValue();
			page.enter_email(mail);
			wait(2);
			test.log(LogStatus.INFO, "The E-mail Value is : '" + mail +"'");
			wait(2);
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to Enter E-mail Address");
		}
	}
	@And("^Enter the phonenumber$")
	public void Enter_the_phonenumber() {
		try {
			String s1 = phonenumber();
			page.enter_phone_no(s1);
			test.log(LogStatus.INFO, "The Phone No. is : " + s1);
			wait(2);
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to Enter Phone Number");
		}
	}
	@Then("^Enter the Address$")
	public void Enter_the_Address() {
		try {
			scroll();
			wait(3);
			XSSFCell addr = sheet.getRow(1).getCell(0);
			String addr_value = addr.toString();
			page.enter_address(addr_value);
			wait(2);
			test.log(LogStatus.INFO, "The Address Field Value is : '" + addr_value +"'");
			wait(3);
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to Enter Address");
		}
	}
	@And("^Enter the City$")
	public void Enter_the_City() {
		try {
			String s1 = sheet.getRow(1).getCell(1).getStringCellValue();
			page.enter_city(s1);
			wait(2);
			test.log(LogStatus.INFO, "The City Field Value is : '" + s1 +"'");
			wait(3);
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to Enter City");
		}
	}
	@When("^Select the state$")
	public void Select_the_state() {
		try {
			page.enter_state();
			wait(2);
			String s1 = sheet.getRow(1).getCell(2).toString();
		    driver.findElement(By.xpath("//select[@name='state']/option[text()='"+s1.trim()+"']")).click();
		    wait(3);
			test.log(LogStatus.INFO, "The Selected State  is : '" + s1 +"'");
			wait(3);
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to Select State");
		}
	}
	@Then("^Enter ZipCode$")
	public void Enter_ZipCode() {
		try {
			String s1 = "123456";
			page.enter_zipcode(s1);
			wait(2);
			test.log(LogStatus.INFO, "The Zip Code Value is : '" + s1 +"'");
			wait(3);
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to Enter ZipCode");
		}
	}
	@And("^Enter domine name$")
	public void Enter_domine_name() {
		try {
			String s1 = sheet.getRow(1).getCell(3).toString();
			page.enter_domain(s1);
			wait(2);
			test.log(LogStatus.INFO, "The Domain name is : '" + s1 +"'");
			wait(3);
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to Enter Domain name");
		}
	}
	@Then("^Select hosting or not$")
	public void Select_hosting_or_not() {
		try {
		page.select_hosting();
		test.log(LogStatus.INFO, "Successfully Selected Check box");
		wait(3);
	}catch (Exception e) {
		test.log(LogStatus.FAIL, "Unable to select the Check box");
	}
	}
	@And("^Enter the description$")
	public void Enter_the_description() {
		try {
			String s1 = "Selenium with Cucumber BDD";
			page.enter_description(s1);
			wait(2);
			test.log(LogStatus.INFO, "The Description value is : '" + s1 +"'");
			wait(3);
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to Enter Description");
		}
	}
	@But("^Click send button$")
	public void Click_send_button() {
		try {
			page.click_sendbutton();
			test.log(LogStatus.PASS, "Successfully Click Send Button");
			wait(5);
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable Click Send Button");
		}
	}
}