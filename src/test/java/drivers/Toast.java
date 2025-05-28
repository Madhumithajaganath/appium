package drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Toast {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		UiAutomator2Options op = new UiAutomator2Options();
		op.setPlatformName("android");
		op.setAutomationName("uiautomator2");
		op.setDeviceName("Galaxy A22 5G");
//		op.setUdid("R9ZR80GM0RP");
		op.ignoreHiddenApiPolicyError();
		op.autoGrantPermissions();

		URL u = new URL("http://localhost:4723");
		
		AndroidDriver driver = new AndroidDriver(u,op);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.activateApp("com.androidsample.generalstore");
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toast =driver.findElement(AppiumBy.xpath("//android.widget.Toast[1]")).getText();
		String actualToast = "Please enter your name";
		if(toast.equals(actualToast)) {
			System.out.println("verified");
		}
		else {
			System.out.println("not verified");
		}

	}
}
