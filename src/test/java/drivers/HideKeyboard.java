package drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class HideKeyboard {

public static void main(String[] args) throws MalformedURLException{
		
		UiAutomator2Options op = new UiAutomator2Options();
		op.setPlatformName("android");
		op.setAutomationName("uiautomator2");
		op.setDeviceName("Galaxy A22 5G");
		op.setUdid("R9ZR80GM0RP");
		URL u = new URL("http://localhost:4723");
		
		AndroidDriver driver = new AndroidDriver(u,op);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.activateApp("com.androidsample.generalstore");
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).click();
		driver.hideKeyboard();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	}

}
