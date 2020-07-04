package com.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.cucumber.common.CucumberCommon;

public class CucumberPage extends CucumberCommon {
	
	public WebDriver driver;

	public  CucumberPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(name = "first_name")
	WebElement firstname;

	@FindBy(name = "last_name")
	WebElement lastname;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "phone")
	WebElement phoneno;

	@FindBy(name = "address")
	WebElement addr;

	@FindBy(name = "city")
	WebElement city_val;

	@FindBy(name = "state")
	WebElement state_val;

	@FindBy(name = "zip")
	WebElement zipcode;
	
	@FindBy(name = "website")
	WebElement domain;

	@FindBy(xpath = "//input[@value='yes']")
	WebElement host;

	@FindBy(name = "comment")
	WebElement desc;
	
	@FindBy(xpath = "//button[text()='Send ']")
	WebElement sendbutton;
	

	public void enter_firstname(String fname) {
		firstname.sendKeys(fname);
	}

	public void enter_lastname(String lname) {
		lastname.sendKeys(lname);
	}

	public void enter_email(String mail) {
		email.sendKeys(mail);
	}

	public void enter_phone_no(String phonenum) {
		phoneno.sendKeys(phonenum);
	}

	public void enter_address(String address) {
		addr.sendKeys(address);
	}

	public void enter_city(String city) {
		city_val.sendKeys(city);
	}

	public void enter_state() {
		city_val.click();
	}

	public void enter_zipcode(String zip) {
		zipcode.sendKeys(zip);
	}
	
	public void enter_domain(String domainname) {
		domain.sendKeys(domainname);
	}

	public void  select_hosting(){
		host.click();
	}

	public void enter_description(String description) {
		desc.sendKeys(description);
	}

	public void click_sendbutton() {
		sendbutton.click();
	}
}