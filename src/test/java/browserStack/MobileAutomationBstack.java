package browserStack;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class MobileAutomationBstack {

	public static final String username = "madhumitha_wcvrZx";
	public static final String accesskey = "jFWiXTp9vBEH75fpXtSq";
	public static final String url = "https://"+username+":"+accesskey+"@hub-cloud.browserstack.com/wd/hub";
	
	@Test
	public void mobileApp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
		bstackOptions.put("projectName", "General-store");
		bstackOptions.put("buildName", "1.1.1");
		bstackOptions.put("sessionName", "LoginTest");
		bstackOptions.put("debug", "true");
		bstackOptions.put("networkLogs", "true");
		bstackOptions.put("appProfiling", "true");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("appium:platformVersion", "15.0");
		capabilities.setCapability("appium:deviceName", "Samsung Galaxy S25");
		capabilities.setCapability("appium:app", "bs://a919dec4ee08f3ce9cdf69119a1e245b28deea49");
		capabilities.setCapability("bstack:options", bstackOptions);
		
		AndroidDriver driver = new AndroidDriver(new URL(url),capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Algeria\")")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("madhumitha");
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

	}
	
	@Test
	public void mobileWeb() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap< String, Object> bstackOptions = new HashMap<String, Object>();
		bstackOptions.put("browserName", "chrome");
		bstackOptions.put("realMobile", true);
		bstackOptions.put("deviceName", "Samsung Galaxy S25");
		bstackOptions.put("osVersion", "15.0");
		capabilities.setCapability("bstack:options", bstackOptions);
		
		WebDriver driver = new RemoteWebDriver(new URL(url),capabilities);
		
		driver.get("https://www.wikipedia.org/");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("searchInput")).sendKeys("Wild animals"+Keys.ENTER);
		System.out.println(driver.getCurrentUrl());
	}
}
