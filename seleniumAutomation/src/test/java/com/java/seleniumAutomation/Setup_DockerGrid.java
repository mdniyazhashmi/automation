package com.java.seleniumAutomation;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Setup_DockerGrid {
	
	@BeforeTest
	public void startDockerGrid() throws Exception {
		
		Runtime.getRuntime().exec("cmd /c start start_dockergrid.bat");
		Thread.sleep(30000);
		Runtime.getRuntime().exec("cmd /c start docker-compose_scale.bat");
		Thread.sleep(30000);
	}
	
	@AfterTest
	public void stopDockerGrid() throws Exception{
		
		Runtime.getRuntime().exec("cmd /c start stop_dockergrid.bat");
		Thread.sleep(5000);
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
		
	}

}
