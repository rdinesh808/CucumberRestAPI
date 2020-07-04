package com.drop.down;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableValueGet {
	
	@Test
	public void gotopage() {
		WebDriverManager.chromedriver().arch32().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--incognito");
		ChromeDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/11654/mlr-vs-mls-1st-match-big-bash-league-2012-13");
		
		List<WebElement> table = driver
		.findElements(By.xpath("(//div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr'])[1]//following::div[@class='cb-col cb-col-8 text-right text-bold']"));
		
		List<String> s1 = new ArrayList<String>();
		for(WebElement s : table) {
			s1.add(s.getText());
		}
        for(int i=0;i<s1.size();i++) {
        	if(s1.get(i).toString().equals("R")) {
        		s1.remove(i);
        	}
        }
		System.out.println(s1);
		driver.close();
	}

}
