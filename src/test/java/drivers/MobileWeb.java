package drivers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class MobileWeb {
	public static void main(String[] args) throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("uiautomator2");
		options.setDeviceName("Galaxy A22 5G");
//		options.setUdid("R9ZR80GM0RP");
		options.setIgnoreHiddenApiPolicyError(true);
		options.setAutoGrantPermissions(true);
		options.setCapability("browserName", "chrome");
		
		URL u = new URL("http://localhost:4723");
		
		AndroidDriver driver = new AndroidDriver(u,options);
		
		driver.get("https://www.wikipedia.org/");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("searchInput")).sendKeys("Wild animals"+Keys.ENTER);
		System.out.println(driver.getCurrentUrl());
		
		
	}
}
