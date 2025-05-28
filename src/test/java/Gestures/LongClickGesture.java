package Gestures;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class LongClickGesture {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiautomator2");
		dc.setCapability("deviceName", "Galaxy A22 5G");
		dc.setCapability("UDID", "R9ZR80GM0RP");
		
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");
		
		URL u = new URL("http://127.0.0.1:4723");
		
		AppiumDriver driver = new AppiumDriver(u,dc);
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"People Names\")"));
		
		((JavascriptExecutor)driver).executeScript(
		"mobile: longClickGesture", ImmutableMap.of
		("elementId",((RemoteWebElement)element).getId()));

		String actText=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sample menu\")")).getText();
		System.out.println(actText);
	}
}
