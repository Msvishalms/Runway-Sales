package com.crm.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public DatabaseUtility dLib= new DatabaseUtility();
	public ExcelUtility eLib= new ExcelUtility();
	public FileUtility fLib= new FileUtility();
	public WebdriverUtility wLib= new WebdriverUtility();
	public JavaUtility jLib= new JavaUtility();
	public static WebDriver driver;
	//public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void config_BS() throws Throwable
	{
		dLib.getconnectToDB();
		System.out.println("--connect to DB--");
	}

	
	@BeforeClass(alwaysRun = true)
	public void config_BC() throws Throwable
	{
		String Browser = fLib.getPropertyFile("browser");
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else 
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		System.out.println("--launch the browser--");
		wLib.maximize(driver);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void config_BM() throws Throwable
	{
		String Username = fLib.getPropertyFile("username");
		String Password = fLib.getPropertyFile("password");
		String Url = fLib.getPropertyFile("url");
		driver.get(Url);
		wLib.waitForPageLoad(driver);
	
		LoginPage lp= new LoginPage(driver);
		lp.login(Username, Password);
		System.out.println("--Login to application--");
	}
	
	@AfterMethod(alwaysRun = true)
	public void config_AM()
	{
		HomePage Hp= new HomePage(driver);
		Hp.clickOnAdminImg(driver);
		Hp.clickOnsignOutBTN();
		System.out.println("--logout from application--");
	}
	
	@AfterClass(alwaysRun = true)
	public void config_AC()
	{
		driver.quit();
		System.out.println("--close the browser--");
	}
	
	@AfterSuite(alwaysRun = true)
	public void config_AS() throws Throwable
	{
		dLib.closeConnection();
		System.out.println("--disconnect database--");
	}
}