package testNG_Practice;

import org.testng.annotations.Test;

import com.crm.GenericUtility.BaseClass;

public class TestAnnotationUsingBaseclass extends BaseClass{
	
	@Test
	public void runTest()
	{
		System.out.println("--application launch--");
	}
	
}
