package drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class UnistallApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		UiAutomator2Options op = new UiAutomator2Options();
		op.setPlatformName("android");
		op.setAutomationName("uiautomator2");
		op.setDeviceName("Galaxy A22 5G");
		op.setUdid("R9ZR80GM0RP");

		URL u = new URL("http://localhost:4723");
		
		AndroidDriver driver = new AndroidDriver(u,op);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.installApp("C:\\Users\\User\\OneDrive\\Desktop\\Appium\\apk files\\ApiDemos-debug.apk");
		Thread.sleep(2000);
		driver.terminateApp("io.appium.android.apis");
		driver.removeApp("io.appium.android.apis");
		
		boolean result = driver.isAppInstalled("io.appium.android.apis");
		System.out.println(result);
	}
}
