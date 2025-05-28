package Gestures;

import java.awt.dnd.DragSource;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class ClickGesture {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiautomator2");
		dc.setCapability("deviceName", "Galaxy A22 5G");
		dc.setCapability("UDID", "R9ZR80GM0RP");
		
		dc.setCapability("app", "C:\\Users\\User\\OneDrive\\Desktop\\Appium\\apk files\\ApiDemos-debug.apk");
		
		URL u = new URL("http://127.0.0.1:4723");
		
		AppiumDriver driver = new AppiumDriver(u,dc);
		
		WebElement element = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
		
		((JavascriptExecutor)driver).executeScript("mobile: clickGesture", 
		ImmutableMap.of("elementId",((RemoteWebElement)element).getId()));
		
		((JavascriptExecutor)driver).executeScript("mobile: clickGesture",
				ImmutableMap.of("x",215, "y",720));
	}
}
