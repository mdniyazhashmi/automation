package com.java.seleniumAutomation;


import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DockerIntegrationTest {
	
	public RemoteWebDriver driver = null;
	public DesiredCapabilities dc = null;
	
	
	@Test
	public void googleSearchTest() throws Exception {
		
		dc = DesiredCapabilities.chrome();
		URL url = new URL("http://localhost:4444/wd/hub");
		
		WebDriverManager.chromedriver().setup();
		driver = new RemoteWebDriver(url, dc);
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("docker");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='sbl1']/span")).click();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "docker - Google Search");
		
		driver.quit();
	}
	
	
}
