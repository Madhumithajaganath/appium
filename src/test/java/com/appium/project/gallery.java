package com.appium.project;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class gallery {

	@Test
	public void testName() throws Exception {
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiautomator2");
		dc.setCapability("deviceName", "Galaxy A22 5G");
		dc.setCapability("UDID", "R9ZR80GM0RP");
		
		dc.setCapability("ignoreHiddenApiPolicyError", true);
		dc.setCapability("autoGrantPermissions", true);
//		dc.setCapability("noReset", true);
		
		URL u = new URL("http://127.0.0.1:4723");
		
		AndroidDriver driver = new AndroidDriver(u,dc);
		
		driver.activateApp("com.simplemobiletools.gallery");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Screenshots\")")).click();
		
		Thread.sleep(30000);
		
	}
}
