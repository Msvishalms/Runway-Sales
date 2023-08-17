package com.practice_package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadmultipleTest {

	public static void main(String[] args) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		int r = sheet.getLastRowNum(); // traverse till last row in sheet
		for(int i=0; i<=r; i++)
		{
			String key =sheet.getRow(i).getCell(0).getStringCellValue();
			String value = sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println(key);
			System.out.println(value);
		}
		book.close();	
	}
}
