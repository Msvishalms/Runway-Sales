package testNG_Practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericUtility.IPathConstants;

public class DataProviderFromExcel {
	
	@Test(dataProvider = "getDatafromExcel")
	public void getData(String Productname, String PID) 
	{
		System.out.println("productName---"+Productname+" price---"+PID);
	}
	
	@DataProvider
	public Object[][] getDatafromExcel() throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("DP");
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(1).getLastCellNum();
		
		Object[][] obj = new Object[lastRowNum+1][lastCellNum];
		for(int i=0; i<=lastRowNum ; i++)
		{
			for(int j=0; j<lastCellNum; j++)
			{
				obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
