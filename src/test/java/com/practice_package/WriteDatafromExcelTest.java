package com.practice_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDatafromExcelTest {

	public static void main(String[] args) throws Throwable, IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		book.getSheet("Sheet1").createRow(2).createCell(2).setCellValue("username");
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\Testdata.xlsx");
		book.write(fos);
		book.close();
	}
}
