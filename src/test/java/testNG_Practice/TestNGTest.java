package testNG_Practice;

import org.testng.annotations.Test;

public class TestNGTest {

	@Test(dependsOnMethods="editData")
	public void createData()
	{
		System.out.println("---Data is created---");
	}

	@Test(dependsOnMethods = "deleteData")
	public void editData()
	{	
		System.out.println("---Data is edited---");
	}

	@Test(priority=1, invocationCount = 2)
	public void deleteData()
	{
		System.out.println("---Data is deleted---");
	}
	
	@Test(enabled=false)
	public void skipData()
	{
		System.out.println("---skip data---");
	}
}
