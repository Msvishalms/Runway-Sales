package com.crm.GenericUtility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpclass implements ITestListener {

	ExtentTest test;
	ExtentReports report;
	
	public void onStart(ITestContext context) {
		
		//create html report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./extentReport/report.html");
		htmlreport.config().setDocumentTitle("CRM");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Runwaysales");

		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-url", "http://localhost:8888/");
		report.setSystemInfo("Reporter Name", "Vishal M");
	}
	
	public void onTestStart(ITestResult result) {
		//Execution starts from here
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log(methodName+"--->"+"Testscript execution started");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"--> passed");
		Reporter.log(methodName+"---> Testscript passed");
	}

	public void onTestFailure(ITestResult result) {
		String Fscript = result.getMethod().getMethodName();
		String FailedScript = Fscript+new JavaUtility().getsimpleSystemDateFormat();
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.driver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshot/"+FailedScript+".png");
		try 
		{
			FileUtils.copyFile(src, dst);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(dst.getAbsolutePath());
		test.log(Status.FAIL, Fscript+"--->  failed");
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log(FailedScript+"-->  Testscript failed");	
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"----> skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName+"--->  Testscript skipped");
	}

	public void onFinish(ITestContext context) {
		//consolidate report
		report.flush();
	}
}
