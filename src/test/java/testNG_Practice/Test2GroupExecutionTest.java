package testNG_Practice;

import org.testng.annotations.Test;

import com.crm.GenericUtility.BaseClass;

public class Test2GroupExecutionTest extends BaseClass {

	@Test()
	public void createCampaign()
	{
		System.out.println("--created campaign--");
	}
	
	@Test()
	public void modifyCampaign()
	{
		System.out.println("--modified campaign--");
	}
}
