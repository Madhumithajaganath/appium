package drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class context {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
//		UiAutomator2Options op = new UiAutomator2Options();
//		op.setPlatformName("android");
//		op.setAutomationName("uiautomator2");
////		op.setDeviceName("Galaxy A22 5G");
//		op.setUdid("R9ZR80GM0RP");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiautomator2");
		dc.setCapability("udid", "R9ZR80GM0RP");
		URL u = new URL("http://localhost:4723");
		
		AndroidDriver driver = new AndroidDriver(u,dc);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.activateApp("com.androidsample.generalstore");
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("madhumitha");
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Air Jordan 4 Retro']/..//android.widget.TextView[@text='ADD TO CART']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(2000);
		Set<String> con = driver.getContextHandles();
		int count = con.size();
		System.out.println(count);
		
		for (String ch : con) {
			System.out.println(ch);
			driver.context("WEBVIEW_com.androidsample.generalstore");
		}
		String title = driver.getTitle();
		System.out.println(title);
		
	}
}
