package com.practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectTest {

	public static void main(String[] args) throws SQLException {
		
		String expdata="RUNWAY";
		Connection con=null;
		try {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//sign in 
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//creating project
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		driver.findElement(By.name("projectName")).sendKeys("RunWay");
		driver.findElement(By.name("createdBy")).sendKeys("Vishal");
		
		//handling Drop-down 
		WebElement ele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select s=new Select(ele);
		s.selectByVisibleText("Created");
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		
		con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		
		Statement state = con.createStatement();
		String query="select* from project;";
		ResultSet result = state.executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String actual= result.getString(4);
			if(actual.equalsIgnoreCase(expdata))
			{
				flag=true;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println("project successfully created");
			
		}
		else
		{
			System.out.println("project not created");
		}
		}
		catch(Exception e)
		{
			
		}
		finally {
			con.close();
		}
	}
}
