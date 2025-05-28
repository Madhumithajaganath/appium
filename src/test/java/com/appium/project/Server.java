package com.appium.project;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Server {

	public static void main(String[] args) throws MalformedURLException {
		
		File f = new File
		("C:\\Users\\User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		AppiumDriverLocalService service = new AppiumServiceBuilder().
		withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).
		withTimeout(Duration.ofSeconds(300)).build();
		
		service.start();
		
		System.out.println("server started");
		
		UiAutomator2Options op = new UiAutomator2Options();
		op.setPlatformName("android");
		op.setAutomationName("uiautomator2");
		op.setDeviceName("Galaxy A22 5G");
		op.setUdid("R9ZR80GM0RP");
		
		URL u = new URL("http://localhost:4723");
		AndroidDriver driver = new AndroidDriver(u,op);
		
		service.stop();
		System.out.println("server stopped");
	}
}
