package testNG_Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestAnnotaionswithTwoTest {

	@BeforeSuite
	public void config_BS()
	{
		System.out.println("--Connect to DB--");
	}
	
	@BeforeClass
	public void config_BC()
	{
		System.out.println("---Launch the browser--");
	}

	@BeforeMethod
	public void config_BM()
	{
		System.out.println("--Login to application--");
	}
	
	@Test
	public void navigate_Opportunity()
	{
		System.out.println("--Navigated to Opportunity--");
	}

	@AfterMethod
	public void config_AM()
	{
		System.out.println("--Logout from application--");
	}

	@Test
	public void navigate_Campaigns()
	{
		System.out.println("--Navigate to campaigns--");
	}
	
	@AfterMethod
	public void configu_AM()
	{
		System.out.println("--close the application");
	}
	@AfterClass
	public void config_AC()
	{
		System.out.println("--close the browser--");
	}

	@AfterSuite
	public void config_AS()
	{
		System.out.println("--Close the database--");
	}
}

