package campaigns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericUtility.BaseClass;
import com.crm.GenericUtility.DatabaseUtility;
import com.crm.GenericUtility.ExcelUtility;
import com.crm.GenericUtility.FileUtility;
import com.crm.GenericUtility.JavaUtility;
import com.crm.GenericUtility.WebdriverUtility;
import com.crm.ObjectRepository.CampaignsPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.CreateCampaignPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigate_To_CampaignspageTest extends BaseClass {

	@Test(groups= {"smoke","regression"} )
	public void navigate_To_CampaignspageTest() throws Throwable 
	{
		//navigate to campaigns link
		HomePage hp= new HomePage(driver);
		hp.clickOnMore(driver);
		hp.clickOnCampgnLink();

		//verify campaigns
		CreateCampaignPage ccp= new CreateCampaignPage(driver);
		ccp.verifyCampaign("Campaigns");
	
		/*DatabaseUtility dLib = new DatabaseUtility();
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
		FileUtility fLib= new FileUtility();
		WebdriverUtility wLib= new WebdriverUtility();*/

		/*String Url = fLib.getPropertyFile("url");
		String Browser = fLib.getPropertyFile("browser");
		String Username = fLib.getPropertyFile("username");
		String Password = fLib.getPropertyFile("password");*/
		
		//WebDriver driver;
		/*if(Browser.equalsIgnoreCase("chrome"))
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
		
		wLib.waitForPageLoad(driver);*/

		//login to application 
		/*LoginPage lp= new LoginPage(driver);
		lp.login(Username, Password);*/
	}
}
