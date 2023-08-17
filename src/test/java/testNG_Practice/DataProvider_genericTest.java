package testNG_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericUtility.ExcelUtility;

public class DataProvider_genericTest {

	@Test(dataProvider = "getData")
	public void fetchData(String p, String pID)
	{
		System.out.println("name---"+p+" pid--"+pID);
	}

	@DataProvider
	public Object[][] getData() throws Throwable
	{
		ExcelUtility eLib= new ExcelUtility();
		Object[][] value = eLib.getMultipleDataFromDP("DP");
		return value;
	}
}
