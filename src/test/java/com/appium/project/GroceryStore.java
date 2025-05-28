package com.appium.project;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class GroceryStore {

	
	@Test
	public void testName() throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiautomator2");
		dc.setCapability("deviceName", "Galaxy A22 5G");
		dc.setCapability("UDID", "R9ZR80GM0RP");
		
		dc.setCapability("ignoreHiddenApiPolicyError", true);
		dc.setCapability("autoGrantPermissions", true);
		dc.setCapability("noReset", true);
		
		dc.setCapability("appPackage", "com.frontendsource.grocerystore");
		dc.setCapability("appActivity", ".activity.WelcomeActivity");
		
		URL u = new URL("http://127.0.0.1:4723");
		
		AppiumDriver driver = new AppiumDriver(u,dc);
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Skip']")).click();
		driver.findElement(AppiumBy.id("com.frontendsource.grocerystore:id/login_mobile")).sendKeys("1234567890");
		driver.findElement(AppiumBy.id("com.frontendsource.grocerystore:id/login_password")).sendKeys("21345");
		driver.findElement(AppiumBy.id("com.frontendsource.grocerystore:id/loginBtn")).click();
	
	}
}
