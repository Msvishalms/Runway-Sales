package testNG_Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestAnnotaionsExecution {

	@BeforeSuite
	public void config_BS()
	{
		System.out.println("--connect to DB--");
	}

	@BeforeClass
	public void config_BC()
	{
		System.out.println("--launch the browser--");
	}

	@BeforeMethod
	public void config_BM()
	{
		System.out.println("--login to application--");
	}

	@Test
	public void testscript()
	{
		System.out.println("--Execute to testscript--");
	}

	@AfterMethod
	public void config_AM()
	{
		System.out.println("--logout from application--");
	}

	@AfterClass
	public void config_AC()
	{
		System.out.println("--close the browser--");
	}

	@AfterSuite
	public void config_AS()
	{
		System.out.println("--Disconnect from database--");
	}

}