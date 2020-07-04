package com.drop.down;

import java.io.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class DropDownValues {
	XSSFWorkbook book;
	XSSFSheet sheet;
	public WebDriver driver;

	@BeforeTest
	public void dataread() throws InvalidFormatException, IOException {
		book = new XSSFWorkbook(new File("./Datas/DataFile.xlsx"));
		sheet = book.getSheetAt(0);

		System.getProperty("user.dir");
		WebDriverManager.chromedriver().arch32().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	@Test(priority = 1)
	public void login() throws InterruptedException {
		driver.get(sheet.getRow(1).getCell(0).toString());
		Thread.sleep(5000);
		driver.findElement(By.name("UserID")).sendKeys(sheet.getRow(1).getCell(1).toString());
		Thread.sleep(3000);
		driver.findElement(By.name("Password")).sendKeys(sheet.getRow(1).getCell(2).toString());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Got it']")).click();
		Thread.sleep(3000);
	}
	@Test(priority = 2)
	public void demographic_app() throws InterruptedException {
		driver.findElement(By.id("appEnrollment_menu")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[text()='Add Patient']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[text()='State'])[2]//following::img")).click();
		Thread.sleep(4000);
		WebElement dropdownsize = driver.findElement(By.xpath("(//label[text()='State'])[2]//following::tr[@role='option']"));
		String s1 = dropdownsize.getAttribute("aria-setsize");
		int a = Integer.parseInt(s1);
		for(int i=0;i<a;i++) {
			if(i==0) {
				continue;
			}
			WebElement selectdropdown = driver.findElement(By.xpath("(//label[text()='State'])[2]//following::tr[@aria-posinset='"+i+"']/td/div"));
			Actions action = new Actions(driver);
			action.moveToElement(selectdropdown).build().perform();
			String s2 = selectdropdown.getText().trim();
			System.out.println(s2);
			Thread.sleep(1500);
			if(s2.equals("WA")) {
				action.click(selectdropdown).build().perform();
				Thread.sleep(3000);
				break;
			}
		}
	}
	@AfterTest
	public void finish() {
		driver.close();
		driver.quit();
	}
}