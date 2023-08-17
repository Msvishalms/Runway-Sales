package testNG_Practice;

import org.testng.annotations.Test;

import com.crm.GenericUtility.BaseClass;

public class TestBatchExecutionTest1 extends BaseClass{

	@Test()
	public void createOpp()
	{
		System.out.println("--data1--");
	}
	
	@Test()
	public void modifyOpp()
	{
		System.out.println("--data2--");
	}
}
