package sales_order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericUtility.BaseClass;
import com.crm.GenericUtility.ExcelUtility;
import com.crm.GenericUtility.FileUtility;
import com.crm.GenericUtility.WebdriverUtility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.SalesOrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifySearchsalesOrderUsingSubjectTest extends BaseClass {

	@Test(groups="system")
	public void verifySearchsalesOrderUsingSubjectTest() throws Throwable {

		/*//created object for generic utilities 
		/*JavaUtility jLib = new JavaUtility();
		DatabaseUtility dLib= new DatabaseUtility();
		ExcelUtility eLib= new ExcelUtility();
		FileUtility fLib = new FileUtility();
		WebdriverUtility wLib= new WebdriverUtility();

		//Fetching common data from property file
		String Url = fLib.getPropertyFile("url");
		String Browser = fLib.getPropertyFile("browser");
		String Username = fLib.getPropertyFile("username");
		String Password = fLib.getPropertyFile("password");*/
		
		//Fetching Data from Excel
		String subjectName = eLib.readDataFromExcel("Salesorder", 1, 1);
		String searchValue = eLib.readDataFromExcel("Salesorder", 3, 1);
		String expData= eLib.readDataFromExcel("Salesorder", 4, 1);
		/*WebDriver driver;
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}

		wLib.maximize(driver);

		//launch browser
		driver.get(Url);

		wLib.waitForPageLoad(driver);

		//login to application 
		LoginPage lp = new LoginPage(driver);
		lp.login(Username, Password);*/

		//click on sales order link
		HomePage hp= new HomePage(driver);
		hp.clickOnMore(driver);
		hp.clickOnSaleslink();

		//search existing by using sales subject name
		SalesOrderPage sop= new SalesOrderPage(driver);
		sop.searchSalesOrder(searchValue, subjectName);
		
		//verify sales order 
		sop.verifyUpdatedSalesOrder(expData);
		
		/*//logout From Application
		hp.clickOnAdminImg(driver);
		hp.clickOnsignOutBTN();
		
		driver.close();*/
	}
}
