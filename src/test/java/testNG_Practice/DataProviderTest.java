package testNG_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	@Test(dataProvider = "data")
	public void getData(String from, String To, int price)
	{
		System.out.println("from---"+from+"  To---"+To+"  price---"+price);
	}
	
	@DataProvider
	public Object[][] data()
	{
		Object[][] obj=new Object[2][3];
		
		obj[0][0]= "Hubballi";
		obj[0][1]= "Bangalore";
		obj[0][2]= 1000;
		
		obj[1][0]= "Hubballi";
		obj[1][1]= "Badami";
		obj[1][2]= 200;
		return obj;
	}
	
	@DataProvider
	public Object[][] data1()
	{
		Object[][] obj= new Object[2][2];
		
		obj[0][0]= "Qspider";
		obj[0][1]= "Rajajinagar";
	
		obj[1][0]= "TestYantra";
		obj[1][1]= "Bangalore";
		return obj;
	}
}
