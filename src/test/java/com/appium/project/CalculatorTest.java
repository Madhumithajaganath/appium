package com.appium.project;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class CalculatorTest {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiautomator2");
		dc.setCapability("deviceName", "Galaxy A22 5G");
		dc.setCapability("UDID", "R9ZR80GM0RP");
		
		dc.setCapability("ignoreHiddenApiPolicyError", true);
		dc.setCapability("autoGrantPermissions", true);
		dc.setCapability("noReset", true);
		
		dc.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		dc.setCapability("appActivity", ".Calculator");
		
		URL u = new URL("http://127.0.0.1:4723");
		
		AppiumDriver driver = new AppiumDriver(u,dc);
		
		System.out.println("App Opened");
		
		driver.findElement(AppiumBy.accessibilityId("2")).click();
		driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.sec.android.app.popupcalculator:id/calc_keypad_btn_04\")")).click();
		System.out.print(driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.sec.android.app.popupcalculator:id/calc_edt_formula\"]")).getText()+"=");
		System.out.print(driver.findElement(AppiumBy.className("android.widget.TextView")).getText());
		
		
		
	}
}
