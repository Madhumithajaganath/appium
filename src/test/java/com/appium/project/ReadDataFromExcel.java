package com.appium.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ReadDataFromExcel {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", p.getProperty("platformName"));
		dc.setCapability("automationName", p.getProperty("automationName"));
		dc.setCapability("deviceName", p.getProperty("deviceName"));
		dc.setCapability("Udid", p.getProperty("udid"));
		dc.setCapability("appPackage", p.getProperty("appPackage"));
		dc.setCapability("appActivity", p.getProperty("appActivity"));
		
		URL u = new URL("http://localhost:4723");
		AndroidDriver driver = new AndroidDriver(u,dc);
		
		FileInputStream fisE = new FileInputStream("./testData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fisE);
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(1);
		String cell = row.getCell(1).getStringCellValue();
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+cell+"\"));")).click();
		
		String name = row.getCell(2).getStringCellValue();
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys(name);
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
	}
}
