package drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.ScreenOrientation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Orientation {

public static void main(String[] args) throws MalformedURLException, InterruptedException {
	UiAutomator2Options op = new UiAutomator2Options();
	op.setPlatformName("android");
	op.setAutomationName("uiautomator2");
	op.setDeviceName("Galaxy A22 5G");
	op.setUdid("R9ZR80GM0RP");
	op.setAppPackage("io.appium.android.apis");
	op.setAppActivity(".ApiDemos");
	
	URL u = new URL("http://localhost:4723");
	
	AndroidDriver driver = new AndroidDriver(u,op);
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	Thread.sleep(2000);
	ScreenOrientation screen = driver.getOrientation();
	driver.rotate(screen.LANDSCAPE);
	Thread.sleep(2000);
	driver.rotate(screen.PORTRAIT);
}
}
