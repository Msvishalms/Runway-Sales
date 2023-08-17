package testNG_Practice;

import org.testng.annotations.Test;

import com.crm.GenericUtility.BaseClass;

public class Test1GroupExecutionTest extends BaseClass{

	@Test(groups = "smoke")
	public void createOpp()
	{
		System.out.println("--created opportunity--");
	}
	
	@Test(groups = "Regression")
	public void modifyOpp()
	{
		System.out.println("--modified opportunity--");
	}
}
