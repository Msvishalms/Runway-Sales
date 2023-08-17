package com.practice_package;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyfileTest {

	public static void main(String[] args) throws Throwable {
		
		// create object for file input stream 
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Common_Data.propeties");
		
		//create object for property class
		Properties pObj = new Properties();
	
		//load the file
		pObj.load(fis);
		
		//get the property 
		String url = pObj.getProperty("url");
		String browser = pObj.getProperty("browser");
		String username = pObj.getProperty("username");
		String password = pObj.getProperty("password");
		
		System.out.println(url);
		System.out.println(browser);
		System.out.println(username);
		System.out.println(password);
	}
}
