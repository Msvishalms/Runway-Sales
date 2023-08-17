package testNG_Practice;

import org.testng.annotations.Test;

public class DataProviderClassTest {

	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "data")
	public void getData(String from, String To)
	{
		System.out.println("from---"+from+"  To---"+To);
	}

	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "data1")
	public void getData1(String OrgName, String place)
	{
		System.out.println("from---"+OrgName+"  Location---"+place);
	}
}
