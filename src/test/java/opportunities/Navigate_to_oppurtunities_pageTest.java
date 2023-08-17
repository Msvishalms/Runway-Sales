package opportunities;

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
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.CreateOpportunitiesPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigate_to_oppurtunities_pageTest extends BaseClass {

	@Test(groups = {"smoke","regression"})
	public void navigate_to_oppurtunities_pageTest()throws Throwable 
	{
		// click on to opportunities link
		HomePage hp = new HomePage(driver);
		hp.clickOnOpplink();
				
		//verify opportunities
		CreateOpportunitiesPage op = new CreateOpportunitiesPage(driver);
		op.verifyOpportunities("Opportunities");
				
		//driver.quit();
		
		/*DatabaseUtility dLib= new DatabaseUtility();
		JavaUtility jLib= new JavaUtility();
		ExcelUtility eLib= new ExcelUtility();
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
		/*LoginPage lp = new LoginPage(driver);
		lp.login(Username, Password);*/	
	}
}
