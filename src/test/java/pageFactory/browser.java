package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class browser {
	static WebDriver driver;
	@Test
	public WebDriver browsing() {

		System.setProperty("webdriver.chrome.driver", "c://Chrome//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		return driver;

	}

}
