package com.practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakemytripTest {

	public static void main(String[] args) {

		String Monandyear="September 2023";
		int date=22;
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.get("https://www.makemytrip.com/");

			//move and click action on Make-My-Trip web page 
			Actions act=new Actions(driver);
			act.moveByOffset(50, 50).click().perform();

			//driver.findElement(By.xpath("//body[@class='desktop in']")).click();
			driver.findElement(By.xpath("//span[text()='Departure']")).click();

			//ancestor and descendant X-path usage
			String actdate="//div[text()='"+Monandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";

			String nextarrow="//span[@aria-label='Next Month']";

			for(;;) // Infinite loop 
				try{

					driver.findElement(By.xpath(actdate)).click();
					break;
				}
			catch(Exception e)
			{
				driver.findElement(By.xpath(nextarrow)).click();
			}
		}
	}
}

