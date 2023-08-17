package testNG_Practice;

import org.testng.annotations.Test;

import com.crm.GenericUtility.BaseClass;

public class TestBatchExecutionTest2 extends BaseClass {

	@Test()
	public void createCampaign()
	{
		System.out.println("--data3--");
	}
	
	@Test()
	public void modifyCampaign()
	{
		System.out.println("--data4--");
	}
}
