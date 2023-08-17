package campaigns;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericUtility.BaseClass;
import com.crm.GenericUtility.ExcelUtility;
import com.crm.GenericUtility.FileUtility;
import com.crm.GenericUtility.JavaUtility;
import com.crm.GenericUtility.WebdriverUtility;
import com.crm.ObjectRepository.CampaignsPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.CreateCampaignPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.crm.GenericUtility.ListenerImpclass.class)
public class CreateCampaignUsingTheMandatoryFieldTest extends BaseClass {

	@Test(groups="system")
	public void createCampaignUsingTheMandatoryFieldTest() throws Throwable {

		/*//DatabaseUtility dLib = new DatabaseUtility();
		ExcelUtility eLib= new ExcelUtility();
		FileUtility fLib= new FileUtility();
		JavaUtility jLib= new JavaUtility();
		WebdriverUtility wLib= new WebdriverUtility();*/
		
		//int random = jLib.getRandomNum();
		
		/*String Url = fLib.getPropertyFile("url");
		String Password = fLib.getPropertyFile("password");
		String Username = fLib.getPropertyFile("username");
		String Browser = fLib.getPropertyFile("browser");*/
		
		String campaignName = eLib.readDataFromExcel("campaign", 0, 1);
		String date = eLib.readDataFromExcel("campaign", 1, 1);

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
		LoginPage lp=new LoginPage(driver);
		lp.login(Username, Password);*/

		//navigate to campaigns link
		HomePage hp= new HomePage(driver);
		hp.clickOnMore(driver);
		hp.clickOnCampgnLink();
		
		fail();
		//click on campaign lookup image
		CampaignsPage cp= new CampaignsPage(driver);
		cp.clickOnCampaign();

		//enter all campaign details
		CreateCampaignPage ccp= new CreateCampaignPage(driver);
		ccp.clickOnCampaignImg(campaignName, date);

		//verify campaign details
		ccp.verifyCampaign("Campaigns");

		/*//Sign-Out
		hp.clickOnAdminImg(driver);
		hp.clickOnsignOutBTN();
		
		driver.quit();*/
	}
}
