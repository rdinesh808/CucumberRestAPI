package com.cucumber.pages;

import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.cucumber.common.CucumberCommon;

public class WindowsHandlePage extends CucumberCommon {
	
	public WebDriver driver;

      public WindowsHandlePage(WebDriver driver) {
		this.driver = driver;
	}
      
      @FindBy(xpath = "//button[text()='Open Multiple Windows']")
      WebElement multiplewindow;
      
      @FindBy(xpath = "//button[text()='Get Position']")
      WebElement clickbutton;
      
      public void click_multiple_window_button() {
    	  multiplewindow.click();
      }
      
      public void click_getposition_button() {
    	  clickbutton.click();
      }
}
