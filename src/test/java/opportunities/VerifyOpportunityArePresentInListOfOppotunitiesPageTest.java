package opportunities;

import static org.testng.Assert.*;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenericUtility.BaseClass;
import com.crm.GenericUtility.DatabaseUtility;
import com.crm.GenericUtility.ExcelUtility;
import com.crm.GenericUtility.FileUtility;
import com.crm.GenericUtility.JavaUtility;
import com.crm.GenericUtility.WebdriverUtility;
import com.crm.ObjectRepository.OpportunitiesPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.CreateOpportunitiesPage;

import io.github.bonigarcia.wdm.WebDriverManager;
public class VerifyOpportunityArePresentInListOfOppotunitiesPageTest extends BaseClass{

	@Test(groups= "integration", retryAnalyzer = com.crm.GenericUtility.IRetryAnalyzerImpClass.class)
	public void verifyOpportunityArePresentInListOfOppotunitiesPageTest()  throws Throwable {
		
		/*DatabaseUtility dLib = new DatabaseUtility();
		ExcelUtility eLib= new ExcelUtility();
		FileUtility fLib= new FileUtility();
		JavaUtility jLib= new JavaUtility();
		WebdriverUtility wLib= new WebdriverUtility();
		
		String Url = fLib.getPropertyFile("url");
		String Browser = fLib.getPropertyFile("browser");
		String Username = fLib.getPropertyFile("username");
		String Password = fLib.getPropertyFile("password");*/
		
		String opportunityName = eLib.readDataFromExcel("opportunity", 0, 1);
		String salesStage= eLib.readDataFromExcel("opportunity", 1, 1);
		String OrgName=eLib.readDataFromExcel("opportunity", 2, 1);
		String date=eLib.readDataFromExcel("opportunity", 3, 1);
		
		/*WebDriver driver;
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		wLib.maximize(driver);
		
		driver.get(Url);
		
		wLib.waitForPageLoad(driver);
		
		// login to application
		LoginPage lp= new LoginPage(driver);
		lp.login(Username, Password);*/
	
		//click on opportunity link
		HomePage hp= new HomePage(driver);
		hp.clickOnOpplink();
		
		//click on create opportunity lookup Image
		OpportunitiesPage op= new OpportunitiesPage(driver);
		op.clickOnOpportunityImg();
		
		fail();
		//create opportunity with mandatory fields
		CreateOpportunitiesPage cop = new CreateOpportunitiesPage(driver);
		cop.createOpportunity(driver, OrgName, opportunityName, date, salesStage);
		
		//verify opportunity
		cop.verifyOpportunities("Opportunities");
				
		/*WebElement ele = driver.findElement(By.name("closingdate"));
		ele.clear();
		ele.sendKeys("2023-07-28"); 
		
		WebElement ele1 = driver.findElement(By.xpath("//select[@name='sales_stage']"));
		wLib.select(ele1, value1);
		
		driver.findElement(By.name("button")).click();*/
		
		/*//click on sign-out
		hp.clickOnAdminImg(driver);
		hp.clickOnsignOutBTN();
		
		driver.quit();*/
	}
}
