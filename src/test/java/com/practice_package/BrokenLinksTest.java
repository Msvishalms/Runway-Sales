package com.practice_package;

import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrokenLinksTest {

	public static void main(String[] args) throws MalformedURLException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.vtiger.com/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		//get all broken links 
		List<WebElement> linklist = driver.findElements(By.xpath("//a"));
		System.out.println(linklist.size());

		//create array list
		ArrayList<String> links= new ArrayList<String>();

		for(int i=0; i<linklist.size(); i++)
		{
			String eachlink=linklist.get(i).getAttribute("href");

			URL url= null;
			int statusCode=0;

			try{

				url= new URL(eachlink);  //load the url

				HttpURLConnection HttpURLConnection = (HttpURLConnection) url.openConnection();  //open the url connection 

				statusCode = HttpURLConnection.getResponseCode();

				if(statusCode<=400)    //check the status code 
				{
					links.add(eachlink+"----->"+statusCode);
				}
			}
			catch(Exception e)
			{
				links.add(eachlink+"----->"+statusCode);
			}
		}
		System.out.println(links);
	}
}
