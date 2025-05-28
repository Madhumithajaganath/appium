package browserStack;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class WebAutomationBstack {

	@Test
	public void web() throws MalformedURLException {
		
		String username = "madhumithajagana_K7Q9xH";
		String accesskey = "p5YjWDgqySz6mj4jMe8z";
		String url = "https://"+username+":"+accesskey+"@hub-cloud.browserstack.com/wd/hub";
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium:os", "windows");
		capabilities.setCapability("appium:osVersion", "11");
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("browserVersion", "134");
		
		WebDriver driver = new RemoteWebDriver( new URL(url),capabilities);
		
		driver.get("https://www.wikipedia.org/");
		System.out.println(driver.getTitle());
	}
}
