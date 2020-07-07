package com.java.seleniumAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DockerIntegrationTest {
	
	public WebDriver driver = null;
	
	@BeforeSuite
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void googleSearchTest() throws Exception {
		
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("docker");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='sbl1']/span")).click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "docker - Google Search");
	}
	
	@AfterSuite
	public void tearDown() {
		
		driver.close();
	}
}
