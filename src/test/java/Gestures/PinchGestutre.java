package Gestures;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class PinchGestutre {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiautomator2");
		dc.setCapability("deviceName", "Galaxy A22 5G");
		dc.setCapability("UDID", "R9ZR80GM0RP");
		
		dc.setCapability( "appPackage", "com.davemorrissey.labs.subscaleview.sample");
		dc.setCapability("appActivity", ".MainActivity");
		
		URL u = new URL("http://127.0.0.1:4723");
		
		AppiumDriver driver = new AppiumDriver(u,dc);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/continue_button")).click();
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		driver.findElement(AppiumBy.id("com.davemorrissey.labs.subscaleview.sample:id/configuration")).click();
		WebElement element=driver.findElement(AppiumBy.className("android.view.View"));
		
		((JavascriptExecutor)driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"percent",0.75));//zoom in
		
		Thread.sleep(3000);
		
		((JavascriptExecutor)driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"percent",0.50));//zoom out
	}
}
