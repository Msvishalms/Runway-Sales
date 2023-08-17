package com.practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPopupTest {

	public static void main(String[] args) throws InterruptedException{

		String MonthandYear="September 2023";
		int date=24;
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();

		String actualdate="//div[text()='"+MonthandYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";

		String nextarrow ="//span[@aria-label='Next Month']";
		for(;;)
			try
		{
				driver.findElement(By.xpath(actualdate)).click();
				break;
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath(nextarrow)).click();
		}

		driver.findElement(By.xpath("//span[text()='Done']")).click();
	}
}

