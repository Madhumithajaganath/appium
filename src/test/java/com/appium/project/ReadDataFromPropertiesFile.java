package com.appium.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class ReadDataFromPropertiesFile {

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
		System.out.println("--------App Opened----------");
		
		
		
	}
}
