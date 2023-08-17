package sales_order;

import static org.testng.Assert.fail;

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


public class UpdateExistingSalesNameTest extends BaseClass{

	@Test(groups="integration")
	public void updateExistingSalesNameTest() throws Throwable {
		
		/*//DatabaseUtility dLib = new DatabaseUtility();
		ExcelUtility eLib= new ExcelUtility();
		FileUtility fLib= new FileUtility();
		WebdriverUtility wLib= new WebdriverUtility();
		
		String Url = fLib.getPropertyFile("url");
		String Browser = fLib.getPropertyFile("browser");
		String Username = fLib.getPropertyFile("username");
		String Password = fLib.getPropertyFile("password");*/
		
		String existValue = eLib.readDataFromExcel("Salesorder", 0, 1);
		String subjectName = eLib.readDataFromExcel("Salesorder", 1, 1);
		String updateValue = eLib.readDataFromExcel("Salesorder", 2, 1);
		String expData=eLib.readDataFromExcel("Salesorder", 4, 1);
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
		
		driver.get(Url);
		
		wLib.waitForPageLoad(driver);
	
		//login to application 
		LoginPage lp= new LoginPage(driver);
		lp.login(Username, Password);*/

		//click on sales order link
		HomePage hp= new HomePage(driver);
		hp.clickOnMore(driver);
		hp.clickOnSaleslink();
		
		fail();
		//search sales order by using subject 
		SalesOrderPage sop= new SalesOrderPage(driver);
		sop.searchSalesOrder(existValue, subjectName);
			
		//update the sales order subject
		sop.editSalesOrder(updateValue);
		
		//verify updated sales order 
		sop.verifyUpdatedSalesOrder(expData);
		
		/*//Sign-Out
		hp.clickOnAdminImg(driver);
		hp.clickOnsignOutBTN();
		
		driver.quit();*/
		}
}
