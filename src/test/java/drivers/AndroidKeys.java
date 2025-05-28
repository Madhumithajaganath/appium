package drivers;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidKeys {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		UiAutomator2Options op = new UiAutomator2Options();
		op.setPlatformName("android");
		op.setAutomationName("uiautomator2");
		op.setDeviceName("Galaxy A22 5G");
		op.setUdid("R9ZR80GM0RP");

		URL u = new URL("http://localhost:4723");
		
		AndroidDriver driver = new AndroidDriver(u,op);
		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	}
}
