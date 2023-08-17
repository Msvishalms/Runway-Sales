package com.practice_package;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginappbyPropertyfileTest {

	public static void main(String[] args) throws Throwable {
		
		// create object for file input stream 
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Common_Data.propeties");
		
		//create object for property class
		Properties pObj = new Properties();
	
		//load the file
		pObj.load(fis);
		
		//get the property 
		String URL = pObj.getProperty("url");
		String Browser = pObj.getProperty("browser");
		String Username = pObj.getProperty("username");
		String Password = pObj.getProperty("password");
		
		WebDriver driver;
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		
		//launch url
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
	}
}
