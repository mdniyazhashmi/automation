package com.java.seleniumAutomation;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DockerIntegrationTest3 {
	
	public RemoteWebDriver driver = null;
	public DesiredCapabilities dc = null;
	

	@Test
	public void amazonTest() throws Exception {
		
		dc = DesiredCapabilities.chrome();
		URL url = new URL("http://localhost:4444/wd/hub");
		
		WebDriverManager.chromedriver().setup();
		driver = new RemoteWebDriver(url, dc);
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		
		driver.quit();
	}
	
}
