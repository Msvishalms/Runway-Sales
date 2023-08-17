package com.practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReaddatafromcommandLine {
	
	@Test
	public void readDataFromCommandline()
	{
		String Browser = System.getProperty("browser");
		String Url = System.getProperty("url");
		String Username = System.getProperty("username");
		String Password = System.getProperty("password");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(Url);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
	}
}
